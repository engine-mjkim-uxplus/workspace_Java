package com.day4;

public class Variable_8 {
	// boolean타입의 디폴트 값은 false이다
		// 변수 선언시 타입 앞에 static을 붙일 수 있다.
		// 인스턴스화 없이도 사용이 가능하다
		// boolean타입은 선택할 때 결정해야 할 때 사용 한다. - if, switch
	
	public Variable_8(){
		isOk = true;
		System.out.println("생성자 호출 성공");
	}
	
	public static boolean isOk ;// 전역변수의 범위를 갖는다
	
	public static void main(String[] args) { //이 클래스를 호출할 때 main메서드가 실행된다.
		System.out.println(isOk);
		isOk = true;
		System.out.println(Variable_8.isOk);
	}

}

// 지역변수는 인스턴스화를 통해서 호출이 불가하다.
