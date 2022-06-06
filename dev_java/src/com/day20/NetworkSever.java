package com.day20;

import java.net.ServerSocket;
import java.net.Socket;

public class NetworkSever {
	public void serverUp() {
		int port = 3000;
		ServerSocket server;
		try {
			server = new ServerSocket(port);
			System.out.println("server : " + server);
			while(true) {
				Socket client = server.accept();
				System.out.println("client socket :" + client);
			}
		} catch(Exception e) {
			e.printStackTrace(); // 라인번호와 함께 메시지 출력
		}
		
	}
	
	public static void main(String[] args) {
		NetworkSever ns = new NetworkSever();
		ns.serverUp();
	}

}
