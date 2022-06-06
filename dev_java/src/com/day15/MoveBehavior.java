package com.day15;
// 추상클래스와 인터페에스의 공통점
// 단독으로 인스턴스화가 불가하다
public interface MoveBehavior {
	final int i = 0;
	default void app() {};
	public abstract void run();
	// 인터페이스에서 선언된 모든 메소드는 추상메소드이다
	// 인터페이스에서 선언된 모든 메소드가 추상메소드 이므로, abstract예약어는 생약가능하다
	// 선언된 메소드의 리턴타입이 있더라도 좌중괄호와 우중괄호 쓸 수 없으므로 return쓰지 않아도 된다
	public abstract int stop();
	public abstract void display();
}
