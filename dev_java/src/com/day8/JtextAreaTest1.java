package com.day8;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class JtextAreaTest1 extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;
	JTextArea jta_display = new JTextArea(); // JFrame안에 들어갈 속지
	// JTextFIeld에 오늘 스터디할까 엔터 쳤을 때 JTextField에는 문자열을 지우고
	// JTextArea에는 방금 입력한 메시지를 출력 해 본다
	JTextField jf_msg = new JTextField(); // 텍스트 입력 받을 수 있게 해준다. JFrame안에 JTexField넣음

	public void initDisplay() {
		jf_msg.addActionListener(this);
		jta_display.setBackground(Color.orange); // import color 써야 쓸수 있음
		jf_msg.setBackground(Color.lightGray);

		this.add("South", jf_msg);
		this.add("Center", jta_display);
		this.setSize(300, 400);
		this.setVisible(true);
	}

	public static void main(String[] args) {
		JtextAreaTest1 jtt = new JtextAreaTest1();
		jtt.initDisplay();
	}

	@Override
	public void actionPerformed(ActionEvent e){
		Object obj = e.getSource();
			if(obj == jf_msg) {
				jta_display.append(jf_msg.getText()+ "%n");
				jf_msg.setText(""); // 지우는 역할
			}
	}
}
/*
 * 이벤트 처리 implements ActionListener actionPerformed 오버라이딩
 */