package com.day15;
// 이때 Pride를 MoveBehavior 인터페이스의 구현체 클래스라고 말한다.
public class Pride extends Car implements MoveBehavior{
	// run이라는 메소드는 좌출괄호, 우중괄호가 있는 것 만으로도 구현이다.
	@Override
	public void run() {
		speed = speed +2;
	}
	
	@Override
	public int stop() {
		
		return 0;
	}

	@Override
	public void display() {
		
	}
}
