package com.day8;

import javax.swing.JButton;
import javax.swing.JFrame;

public class JButtonTest  {

	JFrame jf = new JFrame();
	JButton jbtn_north = new JButton("조회");
	// 생성자 파라미터에 this는 자기자신을 가리키는 예약어이다
	// JButtonView 클래스를 가리키는 것이다
	// 그런데 아래 코드에서 컴파일 에러가 발생하는 이유는 파라미터가 JButtonTest
	// 타입인 생성자가 선언되어 있지 않아서 발생한 오류이다
	JButtonEventHandler event = new JButtonEventHandler(this); // 원본을 공유하는 것이다. 복사본을 만드는 것이 아니다
	public void initDisplay() {
		System.out.println("initDisplay 호출 성공");
		// 이 코드가 있어야 콜백메서드가 호출된다
		jbtn_north.addActionListener(event); // 이벤트소스와 이벤트 처리를 담당하는 클래스를 매핑할 때 사용, 파라미터의 타입은 ActionListner이다
		jf.add("North",jbtn_north); // add는 버튼을 붙여달라는 메서드
		jf.setSize(400,300);
		jf.setVisible(true);
	}
	
	public static void main(String[] args) {
		JButtonTest jbt = new JButtonTest();
		jbt.initDisplay();
		
		
		
	}

}
