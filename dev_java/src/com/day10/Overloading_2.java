package com.day10;

// 두 개의 클래스가 A is a B관계에 있을 때
// 객체 지향 언어에서는 상속관계로 설계한다
// 전변은 초기화를 생략할 수 있다 | 없다
// 전변의 경우 
class Super1 {
	public int i = 0;

	Super1(){}
	Super1(String text) {  // 기본 생성자
		i = 1;
	}
}

class Sub1 extends Super1 {
	int i;
	Sub1(String text){
		i = 2;
	}
}

public class Overloading_2 {

	public static void main(String[] args) {
		// 자녀 클래스를 인스턴스화 하더라도 부모 클래스의 생성자를
		// 먼저 호출하게 되는데 이때 선언된 생성자가 하나라도 존재하면
		// 디폴트 생성자라 하더라도 JVM이 제공하지 않는다.	
		Super1 sub = new Sub1("Hello"); // 부모 클래스의 기본생성자 호출된다.

		// A a = new B("hello");
	}

}


