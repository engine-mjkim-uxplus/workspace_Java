package com.day8;

import java.util.Scanner;

//0~9까지의 숫자 중에서 임의의 수를 정해서 숫자 맞추기 게임. 기회는 5번

public class game1 {
	int num;
	Scanner sc ;
	
	
	game1(){
		this.num = (int)(Math.random()*10);
		this.sc= new Scanner(System.in);
		
	}
	
	public void game_start() {
		
		
		for(int count = 5; count > 0 ; --count) {
			System.out.println("0~9까지의 정수를 입력하세요>");
			String input = sc.nextLine();
			int i = Integer.valueOf(input);
			
			if(num > i ) {
				if(count == 1) {
					System.out.println("틀렸습니다. 프로그램을 종료합니다.");
					break;}
				System.out.println("틀렸습니다. 더 큰 수를 입력하세요.(기회 :" + (count-1) + "번 남음)");
			}else if(num < i) {
				if(count == 1) {
					System.out.println("틀렸습니다. 프로그램을 종료합니다.");
					break;
				}
				System.out.println("틀렸습니다. 더 작은 수 를 입력하세요.(기회 " + (count-1) + "번 남음)");
			}else {
				System.out.println("정답입니다. ");
				break;
			}
		}	
	}
		public static void main(String[] args) {
			game1 g = new game1();
			g.game_start();
			
	}
}
