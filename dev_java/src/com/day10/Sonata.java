package com.day10;

public class Sonata {
	// 너는 지금 몇 km 로 달리고 있니?
	int speed;
	// 자동차 마다 대표 색상
	String carColor;
	// 4
	int wheelNum;
	
	public Sonata() {}
	public Sonata(String carColor) {
		System.out.println(carColor);
		// carColor = "검정색"; 매개변수와 멤버변수의 carColor로 이름이 같아도 this 써주지 않으면 지변이다
		this.carColor = "검정색"; // 전역변수와 지역변수의 변수명이 같으면 this로 구분해 줘야한다. 변수명 같을 때 this 안쓰면 지역변수로 간주
		System.out.println(carColor);
	}
	public Sonata(int speed, String carColor, int wheelNum) {
		this.speed = speed;
		this.carColor = carColor;
		this.wheelNum = wheelNum;
	}
	public String toString() {
		return "내 자동차는 현재 " + speed + "로 달리고 있고 바퀴수는 " + wheelNum + "이고, 자동차 색상은 " + carColor + "입니다.";
	}
	
}
