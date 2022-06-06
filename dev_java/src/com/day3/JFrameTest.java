package com.day3;

public class JFrameTest {
	// 선언부
	
	// 화면처리부 - non-static타입의 메소드 선언
	// 왜냐하면 void앞에 static이 없으니깐....
	// non-static의 메소드는 메인 메서드 안에서 호출 못 한다
	// 그런데 꼭 사용하고 싶다면?? 인스턴스화
	public void initDisplay() {
		System.out.println("initDisplay 호출 성공");
	} // end of initDisplay
	// 메인메서드 - 실행할 수 있다 / exe 파일로 만들 수 있다 - 가장 먼저 실행된다
	// entry point - main thread이다 
	// 16-17-18-10-11-12 실행순서
	public static void main(String[] args) {
	JFrameTest jft = new JFrameTest();
	jft.initDisplay();
			
	}

}// end of JFrameTest
