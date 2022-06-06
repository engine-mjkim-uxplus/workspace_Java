package com.day10;

import javax.swing.JButton;

// 가능하면 main메서드에 코딩을 하지 않는다
public class SonataSimulation {
	public static void main(String[] args) {
		Sonata myCar = new Sonata(65, "자주색", 4);
		Sonata herCar = new Sonata("핑크");
		System.out.println(herCar.carColor);
		System.out.println(myCar+ ", \n" + herCar);
		JButton jbtn = new JButton("전송");
		System.out.println(jbtn);
	}

	
}
