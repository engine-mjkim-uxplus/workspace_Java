package com.basic;

public class JFrameTest {
	// 선언부

	// 화면그리기 - non-static의 메소드이다
	public void iniDisplay() {

	}

	public static void methodA() {
		System.out.println("methodA 호출 성공");
	}

	// 메인메서드 - static 메서드이다
	// 메서드 선언시 static있을 때, 없을 때가 다르다

	public static void main(String[] args) {
		// 인스턴스화를 통해서 선언된 변수명을 인스턴스변수라고 부른다
		JFrameTest jft = new JFrameTest();
		methodA(); // 인스턴스변수 없이 호출이 가능하다

		// 내안에 있는 (선언된) 메서드라 하더라도 static영역안에서 non-static메소드를
		// 호출할 수 없다.
		// 본래 내안에 선언된 메서드는 내 안에서는 호출이 가능하다

		jft.iniDisplay(); // 인스턴스화하면 non-static메서드 접근이 가능하다. 참조변수.메서드()로 접근

	}

} // end of JFrameTest

/*
 * non-static 타입의 변수나 메서드를 사용할 때는 인스턴스화를 하면 접근이 가능함
 * 
 */
