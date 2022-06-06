package com.day12;

public class FizzBuzzGame {
		
	public void quiz() {
		
		for(int i = 1; i <= 100 ; i++) {
			if(i % 5 == 0 && i % 7 == 0) {
				System.out.println("fizzbuzz"); // 이문장 뒤로 빠지면 실행 안됨
			}else if(i % 7 == 0) {
				System.out.println("buzz");
			}else if(i % 5 == 0) {
				System.out.println("fizz");
			}else
				System.out.println(i);
		}
		
		
	}
	public void quiz1() {
		int i = 0;
		while(i<100) {
			++i;
			if(i % 5 == 0 && i % 7 == 0) {
				System.out.println("fizzbuzz"); // 이문장 뒤로 빠지면 실행 안됨
			}else if(i % 7 == 0) {
				System.out.println("buzz");
			}else if(i % 5 == 0) {
				System.out.println("fizz");
			}else
				System.out.println(i);
		}
		
	}
	public static void main(String[] args) {
		FizzBuzzGame f = new FizzBuzzGame();
		f.quiz1();
		
	}

}
