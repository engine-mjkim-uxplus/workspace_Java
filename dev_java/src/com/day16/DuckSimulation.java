package com.day16;

public class DuckSimulation {

	public static void main(String[] args) {
		Duck myDuck = new MallardDuck();
		// MallardDuck은 FlyBehavior의 구현체 클래스가 아니다
		myDuck.performFly();
		myDuck=null;
		myDuck = new RubberDuck();
		myDuck.display();
		myDuck.performFly();
	}
}