package com.day15;

import javax.swing.JDialog;

public class B_3 extends JDialog {
	public B_3() {
		System.out.println("B 생성자 호출");
		initDisplay();
	}

	public void initDisplay() {
		System.out.println("initDisplay호출");
		this.setTitle("자손창-다이얼로그");
		this.setSize(300, 500);
		this.setVisible(true);
	}

	public static void main(String[] args) {
		B_3 b = new B_3();
		System.out.println("before - " + b);
		b.initDisplay();
		b = new B_3();
		System.out.println("before - " + b);
	}

}
