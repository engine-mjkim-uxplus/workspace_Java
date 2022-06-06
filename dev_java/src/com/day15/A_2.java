package com.day15;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class A_2 extends JFrame implements ActionListener {

	B_2 b = new B_2();
	JButton jbtn_insert = new JButton("입력");

	public void initDisplay() {
		System.out.println("initDisplay 호출 성공");

		this.setLayout(new FlowLayout());
		jbtn_insert.addActionListener(this);

		this.add(jbtn_insert);
		this.setSize(400, 500);
		this.setVisible(true);

	} // end of initDisplay

	public static void main(String[] args) {
		try {
			A_2 a = new A_2();
			a.initDisplay();
			
		} catch (Exception e) {
			System.out.println("NullpointerException 발생함");
		}
		System.out.println("initDisplay호출 후....");
	}
	// JVM이 정의하고 있는 객체 중 JVM이 대신 인스턴스화 해주는 클래스가 있다
	// 의존성 주입이다 - 너가 필요할 때 알아서 해줌
	@Override
	public void actionPerformed(ActionEvent e) {
		// 버튼이 누르는건 사용자이지만 느끼는건 JVM이다
		// JVM이 느낀 버튼의 주소번지를 가져오는 메소드가 있다.
		Object obj = e.getSource();
		if(obj ==jbtn_insert) { // JVM이 감지한 주소번지와 개발자가 선언한 주소번지가 같니?
			System.out.println("입력버튼 눌렸다");
		}
		
	}
}
