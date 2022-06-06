package com.day9;

public class Shuffle {
	int i; //0이라는 값으로 초기화가 되어있고 밑의 문장 초기화는 수행되지 않는다. 
	// i = 3 여기서 초기화하면 에러난다. 멤버변수 자리에서는 선언만 하던가 선언 초기화를 같이 해 줘야한다. 선언과 초기화를 따로 하고 싶으면 생성자를 사용한다.
	

	public static void main(String[] args) {
		int i;
		i = 1; // 메서드 안에서는 따로 가능하다.
	
	
	}
	
	void add() {
		int i;
		i= 1; // 메서드 안에서 지역변수로는 선언,초기화 따로 가능하다.
	}

}
