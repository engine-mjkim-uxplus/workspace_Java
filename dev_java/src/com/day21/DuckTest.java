package com.day21;
// 자바 + 스프링 (객체주입, 의존성주입, 제어역전)
import com.day16.MallardDuck;

public class DuckTest {
	MallardDuck myDuck = null;
	//MallardDuck myDuck = new MallardDuck(); 왜 이렇게 안쓰고 getInstance()로 얻을까? 메모리 적인 측면에서 아낄 수 있다.
	// 메소드를 통해서 객체를 주입 받을 수 있다
	MallardDuck getInstance() {
		// 중급으로 가는길 - 싱글톤 패턴 검색 - 도깨비 - 공유
		if (myDuck == null) {
			myDuck = new MallardDuck();
		}
		return new MallardDuck();
	}

	void test() {
		getInstance().display(); // 모든 클라이언트에게 동일한 인스턴스를 반환하는 작업을 수행한다.
		myDuck.display(); // NullpointerException발생함 , getInstance()메소드를 경유하지 않았다
	}

	public static void main(String[] args) {
		DuckTest dt = new DuckTest();
		dt.test();
	}

}
