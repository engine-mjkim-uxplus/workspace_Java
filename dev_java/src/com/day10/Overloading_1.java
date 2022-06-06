package com.day10;

// 두 개의 클래스가 A is a B관계에 있을 때
// 객체 지향 언어에서는 상속관계로 설계한다
// 전변은 초기화를 생략할 수 있다 | 없다
// 전변의 경우 
class Super {
	
	Super() {  // 기본 생성자
		System.out.println("Super() 호출 성공");
	}
	
	public void methodA() {
		System.out.println("Super - methodA호출 성공");
	}
}

class Sub extends Super {
	Sub(){
			System.out.println("Sub() 호출 성공");
	}
	
	public void methodA() {
		System.out.println("Sub = methodA호출 성공");
	}
}

public class Overloading_1 {

	public static void main(String[] args) {
		//Super sup = new Super();
		//sup.methodA();
		//Sub sub = new Sub();
		//sub.methodA();
		// 선언부의 타입과 생성부의 타입이 다를 수 있다 - 폴리모피즘(다형성)
		Super sup1 = new Sub(); // 부모 클래스의 기본생성자 호출된다.
		// A a = new B("hello");
	}

}

