package com.basic;

public class JFrameTest2 {
	// 선언부
	
	// 화면그리기 - non-static의 메소드이다
	public void initDisplay() {
		System.out.println("initDisplay 호출 성공");
		
	}
	// main호출 - 14(인스턴스화) - 15(메서드 호출) - 7(메서드 구현이동) - 9(initDisplay 호출 성공출력) -10-16-18(종료)
	
	public static void main(String[] args) {
		
		JFrameTest2 jft = new JFrameTest2();	
		jft.initDisplay(); 
		
		
	}

} // end of JFrameTest

