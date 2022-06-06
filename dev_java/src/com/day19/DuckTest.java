package com.day19;

import com.day16.Duck;
import com.day16.MallardDuck;
import com.day16.RubberDuck;
//생성부와 선언부의 이름이 다르면 안된다 - 상속관계, 인터페이스를 implements
public class DuckTest {
	
	public void methodA(Duck duck) {
		// 파라미터에 더 상위 클래스 타입을 적어주면 다양한 구현체 클래스를 받을 수 있다 - 다형성 기대 가능함
		// 같은 이름의 메소드가 호출되더라도 기능이 서로 다르게 동작된다.
		// 선언부와 생성부의 이름이 다를 때 가능하다.
		// 이것이 가능하려면 상속관계 or 인터페이스의 구현체 클래스라면 가능함
		System.out.println("methodA(Duck)");
		if(duck instanceof RubberDuck) {
			System.out.println("나는 RubberDuck 타입 입니다.");
		}else if(duck instanceof MallardDuck) {
			System.out.println("나는 MallardDuck타입 입니다.");
		}else
			System.out.println("나는 기타Duck 타입 입니다.");
	}
	public void methodA(MallardDuck duck) {
		System.out.println("methodA(MallardDuck)");
		System.out.println(duck);
	}
	public void methodC(int i) {
		System.out.println(i);
	}
	
	public static void main(String[] args) {
		DuckTest dt = new DuckTest();
		RubberDuck myDuck = new RubberDuck(); // pass by valuse(주소번지-원본) <-> call by value(복사본)
		Duck herDuck = new MallardDuck();
		dt.methodA(new RubberDuck());
		dt.methodA(herDuck);
		dt.methodA(myDuck);
		// dt.methodB(new MallardDuck());
		dt.methodC(5);
		
	}

}
