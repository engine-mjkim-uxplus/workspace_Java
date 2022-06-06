package com.day4;

public class Variable_1 {
	
	// 선언부 - 1. 전역변수(global variable, member variable) 이클립스 내부 어디서든 사용가능. 다른 클래스에서도 사용이 가능하다.
	// 변수는 한번에 여러값을 동시에 기억할 수 없다(기본값)
	// 자바에서는 타입을 체크한다. 타입이 안맞으면 컴파일이 실패한다. 
	// 지변은 클래스 외부에서는 사용할 수가 없다.
	// 전변은 클래스 외부에서도 사용할 수 있다.
	
	double pi = 3.14;
	int age = 20;
	
	void methodA() {
	
		// 2. 지역변수
		age = 30;
	}
	
	public static void main(String[] args) {
		Variable_1 v1 = new Variable_1(); // 인스턴스화 : 메모리에 상주하고 싶을 때 사용, v1찍으면 주소번지(참조변수) 찍힌다.
		System.out.println("before : "+v1.age); // 한문장이 끝났다고 jvm한테 알려주려면 ;세미콜론
		v1.methodA(); // 리턴타입을 표시할 때 :콜론을 사용
		System.out.println("after : "+v1.age);		
	
	}
	
	
}
