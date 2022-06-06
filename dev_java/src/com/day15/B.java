package com.day15;

import javax.swing.JDialog;

public class B extends JDialog {
	// 생성자 안에서도 메소드를 호출 할 수 있다.
	// 이때는 메인메소드에서와 다르게 인스턴스화 없이도 호출이 가능하다.
	// 화면을 그려주는 메소드 구현
	public B() {
		System.out.println("B 디폴트 생성자 호출 성공: 전변초기화: 선언시 초기화 생략가능");
		// 실행문 (변수선언, 제어문, 조건문과 반복문, 연산자, 산술식)
		initDisplay();
	}

	public void initDisplay() {
		this.setTitle("자손창-다이얼로그");
		this.setSize(300, 500);
		this.setVisible(true);
	}

	// main메소드가 있어야 실행 파일로 만들 수 있다.
	// 가장 먼저 실행되는 코드 이다.
	// 코딩 할 때 JVM순서대로 코딩을 전개하는 것이 맞는 방법이다.
	// 절차지향적인 코딩이 아니라 구조지향적인 코딩을 해야하는 자바 언어의 특징 때문이다.
	public static void main(String[] args) {
		// 내안에 있는 메소드라 하더라도 static이 있는 메인 메소드안에서
		// non-static메소드를 호출하려면 인스턴스화를 해야한다.
		B b = new B();
		b.initDisplay();
	}

}
