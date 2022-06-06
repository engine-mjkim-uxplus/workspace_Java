package com.day18;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.List;
import java.util.StringTokenizer;
// 서버는 듣고 말하기, 들은 것을 말하는 거다
// 서버가 대화내용을 정해서 말하지 않는다
//!!!!!!!!!!!! 토크서버 쓰레드에서 말하기와 듣기를 구현한다 (중요)!!!!!!!!!!!!!
public class TalkServerThread extends Thread {   
	// 이 소켓은 null 인데 oos, ois 인스턴스화 할 수 있나요? 아니오
	Socket client = null;
	ObjectOutputStream oos = null;
	ObjectInputStream ois = null;
	String                  nickName = "";
	TalkServer			  ts = null;
	// 파라미터에 선언된 객체는 TalkServer객체 주소번지를 갖는다
	public TalkServerThread(TalkServer ts) {
		this.client = ts.client; // 서버와 클라이언트가 연결되어 있는 소켓의 주소를 가지고 옴
		this.ts = ts;
		try {
			oos = new ObjectOutputStream(client.getOutputStream());
			ois = new ObjectInputStream(client.getInputStream());
			// 100#nickName(클라이언트에서 이렇게 넘어온다)
			String msg = (String)ois.readObject();
			oos.writeObject(msg); // 내보내기
			StringTokenizer st = new StringTokenizer(msg, "#");
			st.nextToken();// 100
			nickName = st.nextToken();
			ts.jta_log.append(nickName + "님 입장하였습니다. \n");
			
			// 이전에 입장해 있는 친구들에게 보내기
			for(TalkServerThread tst:ts.globalList) {
				this.send(msg);
			}
			ts.globalList.add(this); // 현재 동작하는 쓰레드 - this  - 나는 누구? 쓰레드. 쓰레드를 상속받았으니까
			// 현재 대화방에 있는 모든 사람에게 메세지 보내기
			this.broadCasting(msg);
		} catch (Exception e) {
		}
	}
	// 현재 입장해 있는 친구들 모두에게 메시지 전송하기 구현
	public void broadCasting(String msg) {
		for(TalkServerThread tst : ts.globalList) { //globalList는 백터 new Vector<>;
			tst.send(msg);
		}
	}
	//한친구에게만 보내기 구현
	public void send(String msg) { 
		try {
				oos.writeObject(msg);
		} catch (Exception e) {
				e.printStackTrace();
		
		}
	}
	
	@Override
	public void run() { 
		String msg = "";
		boolean isStop = false;
		while(!isStop) {
			try {
				msg = (String)ois.readObject(); //ois앞에 ts가 이미 있음
				ts.jta_log.append(msg+ "\n");
				StringTokenizer st = null;
				int protocol = 0;
				if(msg !=null) {
					st = new StringTokenizer(msg, "#");
					protocol = Integer.parseInt(st.nextToken());
				}
				switch(protocol) {
				// 200#토마토#스터디할거야? (3개 잘라야한다)
				case 200:{
					 	String nickName = st.nextToken();
					 	String message = st.nextToken();
					 	broadCasting(200 + "#" + nickName + "#" + message);
				}break;
				}// end of switch
				
			} catch (Exception e) {
			
			}
		} 
	} // end of run()
	
}
