package com.day15;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class A_1 extends JFrame implements ActionListener {
	// 인터페이스는 단독으로 인스턴스화가 불가하다
	// 생성부에는 반드시 구현체 클래스 이름이 와야한다.
	// 위의 이유로 인터페이스 안에는 추상메소드만 올 수 있다.
	// 추상메소드란 선언부 뒤에 세미콜론으로 끝나는 경우를 말한다.
	// 인스턴스화는 초기화와 생성하기를 나누어 작성할 수 도 있다
	B_1 b = new B_1(); // <--- 초기화와 생성을 한번에 한 경우// 선언부에서는 선언부와 초기화를 나누어서 할 수 없다   
	JButton jbtn_insert = new JButton("입력");         // 그러나 메소드 안이나 생성자 안에서는 가능하다 
	public void initDisplay() {
		System.out.println("initDisplay 호출 성공");
		// 입력버튼이 눌러졌을 때 이벤트를 감지하고 콜백메소드를 호출하는 코드추가
		// FlowLayout API를 이룔해서 배치할 때 동,서,남,북 중앙 배치 불가하다
		// BorderLayout은 기본(디폴트)이라서 버튼add("North",jbtn_insert)가 가능하다
		this.setLayout(new FlowLayout()); // 기본 레이아웃 설정 변경
		jbtn_insert.addActionListener(this);
		// this는 A_1클래스를 의미하고 add메소드는 JFrame창에 버튼을 붙이는 기능
		// this 에 무엇을 붙일 것인가는 파라밀터를 통해서 결정할 수 없다
		this.add(jbtn_insert);
		this.setSize(400, 500);
		this.setVisible(true);
		
	} // end of initDisplay
	public static void main(String[] args) {
		// A_1 a = new A_1();
		A_1 a  = null;; // 타입만 정해졌다
		a = new A_1();
		// A_1클래스에 대해서 선언만 되어 있고 생성이 되지 않은 상태에서 메소드 호출이 일어났다
		a.initDisplay(); // NullpointerException이 발생하면 그 뒤에 어떤 코드도 실행기회를 갖지 못함
	}

	// 아래 메소드는 ActionListener라는 인터페이스에 선언되어 있는 추상메소드이다
	@Override
	public void actionPerformed(ActionEvent e) {
		
	}
}
