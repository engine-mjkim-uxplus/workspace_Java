package com.day3;

import javax.swing.JFrame;

public class JFrameTest_4 {
	// 선언부
	JFrame jf = new JFrame(); //포함관계 
	int width = 600, height = 400;
	// 타입 변수명 (내 마음대로... a,b,c..) = 값
	String name = "김민준";
	
	public void initDisplay() {
		System.out.println("initDisplay 호출 성공");
		jf.setTitle(name);
				
		jf.setSize(width,height);
				
		jf.setLayout(null);
		
		jf.setVisible(true);
		
	} // end of initDisplay
	public static void main(String[] args) {
		JFrameTest_4 jft = new JFrameTest_4();
		jft.initDisplay();		
	}

}// end of JFrameTest
