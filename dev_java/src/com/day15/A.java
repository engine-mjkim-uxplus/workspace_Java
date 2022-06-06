package com.day15;

import javax.swing.JFrame;

// 부모보다 자손이 더 많은 변수와 메소드를 누릴 수 있다
public class A extends JFrame {
	B b = new B(); //필드 값으로 있는 것은 메모리에 올라가면서 B객체가 만들어지므로 B()생성자 호출됨
	public void initDisplay() {
		this.setSize(400, 500);
		this.setVisible(true);
	}

	public static void main(String[] args) {
		A a = new A();
		a.initDisplay();
	} 
}
