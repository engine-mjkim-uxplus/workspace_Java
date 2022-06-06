package com.day3;

import javax.swing.JFrame;

public class JFrameTest_5 {
	// 선언부
	JFrame jf = new JFrame(); 
	int width = 600, height = 400;
	String name = "김민준";
	
	public void initDisplay() {
		System.out.println("initDisplay 호출 성공");
		jf.setSize(width,height);		
		jf.setTitle(name); 
		jf.setVisible(true);
		
	} // end of initDisplay
	  // javac JFrameTest_5.java -> 컴파일 - Ctrl + s
	  // java JFrameTest_5 "홍길동" "강감찬" "이순신" (배열)
	public static void main(String[] args) { // 사용자 입력 파라미터
		JFrameTest_5 jft = new JFrameTest_5();
		jft.initDisplay();
		for( int i=0; i<3;i=i+1) { 
			System.out.println(args[i]);
		}
	}

}// end of JFrameTest


/*
	변수의 단점: 
	한번에 하나만 담을 수 있다
	같은 타입만 담을 수 있다
	타입이 갖고 있는 크기만큼만 담을 수 있다.
	
	해결 방법은?
	배열을 사용하면 한 번에 여러개를 담을 수 있다.
	
	변수 - 배열 - 객체 배열 - List of Map 자료구조 - 쿠키와 세션
	
	
*/
