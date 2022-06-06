package com.day3;

import javax.swing.JFrame;

public class JFrameTest_3 {
	// 선언부
	JFrame jf = new JFrame(); //포함관계 
	int width = 600, height = 1000;
	public void initDisplay() {
		System.out.println("initDisplay 호출 성공");
		jf.setTitle("김민준");
		jf.setSize(500,400);
		jf.setSize(width,height);
		jf.setLayout(null);
		jf.setVisible(true);
	} // end of initDisplay
	public static void main(String[] args) {
		JFrameTest_3 jft = new JFrameTest_3();
		jft.initDisplay();		
	}

}// end of JFrameTest
