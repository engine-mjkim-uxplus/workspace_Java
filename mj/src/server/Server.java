package server;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	
	
	public static void main(String[] args) {
		ServerSocket server =null;
		
		try {
			server = new ServerSocket(); // ip랑 포트번호를 바인드 시켜야한다
			server.bind(new InetSocketAddress("localHost", 5003));
			
			while(true) { 
				System.out.println();
				Socket socket = server.accept();
				InetSocketAddress isa = (InetSocketAddress) socket.getRemoteSocketAddress(); // ip랑 이름
				
			}
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}

}
