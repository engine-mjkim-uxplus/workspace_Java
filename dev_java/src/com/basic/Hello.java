package com.basic;
// Ctrl+s 누르면 저장과 동시에 javac Hello.java => Hello.class
// java Hello 엔터
// public > protected > friendly > private 예약어는 변수로 사용할 수 없다.
// class는 클래스 선언시 사용하는 예약어

public class Hello {
		// 선언부 - 변수 선언 및 초기화를 할 수 있다.
		// 클래스 안에는 변수와 메서드를 선얼할 수 있다.
		// 변수 선언을 통해서 데이터를 담을 수 있다.
		// 초기화 : 값을 처음 저장 하는 것
		// 변수타입 변수명 대입연산자 값
		int age = 25;
// 여기는 클래스 영역
// 클래스 안에는 변수와 메소드가 살고 있습니다
	
// 메인 메소드가 있어야 exe파일로 만들 수 있다
// 메인 메소드가 entry point(출발점)이다 - 제일 먼저 실행된다
// 메인 스레드 이다.
// 코드가 많아도 가장 먼저 실행되는 곳이 main메소드 이다.
// 메서드와 변수를 구분하기 : 어떠한 이름 뒤에 괄호가 있으면 메서드이다
// static영역에서는 non-static변수나 메소드는 사용이 불가능하다
		
	public static void main(String[] args) {
		// System이 카리키는 건 내가 사용중인 pc이다
		// out변수는 출력장치를 의미한다
		// println은 메소드이다 - 출력 기능을 담당하는 메소드이다
		// 어디에 출력하지? - 콘솔창 
		// 출력을 해야 소통할 수 있다
		System.out.println("Hello java");
		
	
	} //end of main method - 기능, 처리, event를 담당 

} // end of Hello -- 사용자 정의 클래스 선언 및 구현이 끝나는 것
