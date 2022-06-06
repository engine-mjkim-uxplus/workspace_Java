package com.day3;

import javax.swing.JFrame;

public class JFrameTest_2 {
	// 선언부
	JFrame jf = new JFrame();
	int width = 600;
	// 화면처리부 - non-static타입의 메소드 선언
	// 왜냐하면 void앞에 static이 없으니깐....
	// non-static의 메소드는 메인 메서드 안에서 호출 못 한다
	// 그런데 꼭 사용하고 싶다면?? 인스턴스화
	public void initDisplay() {
		System.out.println("initDisplay 호출 성공");
		jf.setSize(500,400);
		jf.setSize(width,400);
		jf.setLayout(null);
		jf.setVisible(true);
	} // end of initDisplay
	// 메인메서드 - 실행할 수 있다 / exe 파일로 만들 수 있다 - 가장 먼저 실행된다
	// entry point - main thread이다 
	// 16-17-18-10-11-12 실행순서
	// static이 붙은 메인메서드 안에서 static이 붙지않은 jf라는 변수명을 사용할 수 없다
	public static void main(String[] args) {
		JFrameTest_2 jft = new JFrameTest_2();
		jft.initDisplay();		
	}

}// end of JFrameTest
