package server;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {

	public static void main(String[] args) {
		Socket socket = null;

		try {
			socket = new Socket("localHost", 5003);
		} catch (UnknownHostException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		System.out.println("[연결 요청");

		try {
			socket.connect(new InetSocketAddress("localHost", 5003));
			System.out.println("[연결 성공]");

		} catch (Exception e) {
		}

	}
}
