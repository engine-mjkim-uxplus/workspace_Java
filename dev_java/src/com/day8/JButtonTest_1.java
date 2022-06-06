package com.day8;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
/*
 * 이벤트 처리 순서
 * 1. 해당 컴퍼넌트(독립적인 클래스) 지원하는 이벤트 리스너 선정하기 - ActionListener - 인터페이스 - 추상메서드 - 메서드 오버라이딩
 * 2. 이벤트 소스와 이벤트 처리 핸들러 클래스를 매핑함
 * 3. 이벤트 처리를 담당하는 메서드 구현하기 // 버튼이 눌러 졌을 때
 */
// ActionListener를 implements하는 클래스를 이벤트 처리를 담당하는 이벤트 핸들러 클래스라고 부른다
// JButtonTest_1은 ActionListener의 구현체 클래스이다
// 인터페이스는 단독으로 인스턴스화 할 수 없다
// 인터페이스를 메모리에 로딩할 때는 선언부와 생성부의 이름이 다르다
// 이것을 가능하게 하는 컨벤션이 메서드 오버라이딩과 메서드 오버로딩이 있다
public class JButtonTest_1 implements ActionListener { // 추상메서드를 오버라이딩 하지 않았기 때문에 에러
	// 선언부
	JFrame jf = new JFrame(); // 창 생성할 인스턴스 생성
	JButton jbtn_north = new JButton("조회"); // 버튼 생성할 인스턴스 생성, "조회"는 버튼의 라벨이다
											 // 프레임에 버튼을 붙이는 것
	JButton jbtn_south = new JButton("처리");
	// 생성자
	// 생성자에는 리턴 타입을 쓰면 안됨
	// 리턴 타입이 있는 것은 메서드이다
	// 생성자가 있어서 전역변수는 초기화를 생략할 수 있다.
	public JButtonTest_1() {
		System.out.println("JButtonTest_1 생성자 호출 성공");
	}
	// 화면처리부 - 사용자 정의 메서드 
	// 사용자 정의 메서드는 자동으로 실행되지 않는다 (개발자가 호출)
	// 콜백메서드 - 시스템에서 자동으로 호출함 - main()  ( 시스템이 호출 )
	public void initDisplay() {
		System.out.println("initDisplay 호출 성공");
		// 이 코드가 있어야 콜백메서드가 호출된다
		jf.add("North",jbtn_north); // add는 버튼을 붙여달라는 메서드
		jbtn_north.addActionListener(this); // 이벤트소스와 이벤트 처리를 담당하는 클래스를 매핑할 때 사용
		jf.add("Center",jbtn_south);
		jbtn_south.addActionListener(this);
		
		jf.setSize(400,300);
		jf.setVisible(true);
	}
	// 메인메서드 - exe파일로 만들때만 필요함
	public static void main(String[] args) {
		// 생성부의 이름으로 객체가 만들어 진다
		// 메모리에 로딩이 일어난다
		// 메서드와 변수를 호출할 수 있게 된다
		// 변수를 호출하면 값이 나온다 - 원시형 타입(기본형 타입)
		// 인스턴스화에서 생성부는 생성자를 호출해주는 코드이다.
		JButtonTest_1 jbt = new JButtonTest_1();
		jbt.initDisplay();		/// 여기까지 실행되고 대기중.  그리고 클릭되면 actionPerformed 메서드가 실행된다.
	}
	@Override
	public void actionPerformed(ActionEvent e) {  // ActionListener의 추상메서드 오버라이딩   // ★이벤트가 발생 했을 때 실행된다( 즉 클릭 되었을 때 )
		// getSource()호출하면 어떤 컴퍼넌트에 감지가 되었는지 알 수 있다                          // ★ actionevent e 에 클릭된 번튼의 객체가 대입된다
		// println메서드는 메서드 오버로딩의 대표적인 예이다
		Object obj = e.getSource();  
		if(obj == jbtn_north) {
			System.out.println("조회 버튼 클릭 성공");
		} else
			System.out.println("처리버튼 클릭 성공");
	}

}


