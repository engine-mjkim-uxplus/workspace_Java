package com.day18;

import java.util.StringTokenizer;

public class TalkClientThread extends Thread {
	TalkClient tc = null; // 화면
	
	public TalkClientThread(TalkClient tc) {
		this.tc = tc; //화면정보를 가지고 있는 주소번지를 넘겨준다
	}
			
	@Override
	public void run() { // 호출시
		boolean isStop = false;
		while(!isStop) {
			try {
				String msg = "";
				msg = (String)tc.ois.readObject();
				StringTokenizer st = null;
				int protocol = 0;
				if(msg !=null) {
					st = new StringTokenizer(msg, "#");
					protocol = Integer.parseInt(st.nextToken());
				}
				switch(protocol) {
				case 100: {
							String nickName = st.nextToken();
							tc.jta_display.append(nickName+ "님이 입장 하였습니다\n");
				}
				// 200#토마토#스터디할거야? (3개 잘라야한다)
				case 200:{
					String nickName = st.nextToken();
				 	String message = st.nextToken();
				 	tc.jta_display.append("[" +nickName+"]" + message+"\n");
				}
				}// end of switch
				
			} catch (Exception e) {
			
			}
		} 
	} // end of run()
	
}
