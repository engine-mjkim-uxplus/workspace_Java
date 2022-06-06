package com.day4;

public class Variable_7 {
	void methodA() {
		
		
	}
	int methodB() {
		int x = 5;
		int y; // 지역변수에서 변수 선언후
		y = x; // 변수사용하여 초기화 가능
		
	return y;
	}
	
	public static void main(String[] args) {
		Variable_7 v7 = new Variable_7();
///		int x = v7.methodA();  void일 때 대입연산자를 이용해서 값을 받을 수 없다.
		v7.methodA();
		int x = v7.methodB();
		x = x + 2;
		System.out.println(x);
		
	}

}
