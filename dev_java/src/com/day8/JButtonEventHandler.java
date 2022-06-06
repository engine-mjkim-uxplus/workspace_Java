package com.day8;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JButtonEventHandler implements ActionListener {  /// 인터페이스 구현 클래스
	// 선언부
	JButtonTest JButtonTest = null;  // 생성자에 의해 jbt의 주소값이 담긴다.
	//생성자
	public JButtonEventHandler(JButtonTest JButtonTest) { // 인스턴스인 jbt가 파라미터로 들어온다
		this.JButtonTest = JButtonTest;
	
	}

	@Override
	public void actionPerformed(ActionEvent e) { // 
		Object obj = e.getSource();  // getSource는 eventObject의 메서드
		String command = e.getActionCommand(); // 라벨을 붙인다
		// if(obj == jBUttonView.jbtn_north){
		if(obj == JButtonTest.jbtn_north) {
			System.out.println("조회 버튼 클릭 성공");
		} else
			System.out.println("처리버튼 클릭 성공");

	}
}
