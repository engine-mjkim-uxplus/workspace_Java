package com.day15;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class A_3 extends JFrame implements ActionListener {

	B_3 b = new B_3();
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
			A_3 a = new A_3();
			a.initDisplay();
			
		} catch (Exception e) {
			System.out.println("NullpointerException 발생함");
		}
		System.out.println("initDisplay호출 후....");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if(obj ==jbtn_insert) { 
			System.out.println("입력버튼 눌렸다");
		}
		
	}
}
