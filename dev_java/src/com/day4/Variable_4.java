package com.day4;

public class Variable_4 {
	//전역변수 - 선언부에 선언하면 
	int age = 20;
	// 지역변수가 갖는 값을 다른 메서드에서 사용할 때 리턴타입을 사용함
	int methodA(int age) {// age는 지역변수 - 메소드 파라미터이면
		age = 30; // 지역변수
		return age;
		//리턴 타입이 생겼다
	}
	public static void main(String[] args) {
		Variable_4 v1 = new Variable_4();
		System.out.println("before : "+v1.age);
		int age = v1.methodA(50);
		System.out.println("after : "+age);		
	}
}
