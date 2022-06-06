package com.day18;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class TalkServer extends JFrame implements Runnable {
	// 서버에 접속한 사용자를 관리하는 그림자가 있어야 한다
	List<TalkServerThread> globalList = null; // 여러 사람을 담으려고 List 생성
	ServerSocket server = null;
	Socket 		   client = null;
	JTextArea jta_log = new JTextArea(10, 30); // (row, col)
	JScrollPane jsp_log = new JScrollPane(jta_log, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED // 스크롤 바만 지원
			, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
	
	
	public TalkServer() {

	}
	@Override
	public void run() {
		globalList = new Vector<>(); // Vector생성
		boolean isStop = false;
		// 서버측 커터에 서버를 가동하기 위한 객체 생성하기 - 클라이언트의 접속만 받아준다
		// 동시에 많은 유저가 접속하더라도 튕기지 않고 모두 안전하게 접속을 허용하기 위해서
		// 그일만 전담하는 서버소켓이 있는 것임 - 클라이언트 측에는 필요없다
		try {
			server = new ServerSocket(3005); // 서버 소켓은 받기만 해준다. 인사해주는 역할로 쓴다. (접대 받는 역할)
			jta_log.append("Server Ready.................................\n");
			while(!isStop) {
				client = server.accept(); // 클라이언트에서 넘어온 정보를 소켓에 담는다 (소켓은 일하는 역할). 서버소켓에서 accept해서 소켓에 담는다는 것.
				// 192.168.40.35 들어온 정보
				jta_log.append(client.getInetAddress() + "에서 접속하였습니다\n");
				TalkServerThread tst = new TalkServerThread(this);  // this는 talkServer를 가리킨다
				// 스레드의 start() 호출하여 run()실행
				tst.start(); 
			}
		} catch (Exception e) {
		}
		
	}

	public void initDisplay() {
		this.add("Center", jsp_log); // JFrame에 JText붙이기
		this.setTitle("서버 로그창");
		this.setSize(500, 400);
		this.setVisible(true);

	}

	public static void main(String[] args) {
		// 톡서버의 인스턴스화
		TalkServer ts = new TalkServer();
		ts.initDisplay();
		Thread th = new Thread(ts); // Runnable을 구현한 객체를 넣어준다
		th.start(); 
		
	}// main은 창 띄우고 쓰레드 생성하고 종료된다.

}
