package com.day4;

public class Variable_6 {
	// 전역변수는 초기화를 생략할 수 있다.
	// 지역변수는 초기화를 생략하면 안된다.
	int i ;
	void methodA(int i) { // 100이 복사됨
		System.out.println(i);
	}
	
	public static void main(String[] args) {
		int i; // 변수 선언 
		i = 10; // 변수의 초기화
		// 메서드 안에서 선언했으므로 지역변수이다!!
		i= 100; 
		Variable_6 v6 = new Variable_6();
		v6.methodA(i); // main메서드에 i값 즉 100 이 복사되서 인자로 들어간다. 
		
	}

}
