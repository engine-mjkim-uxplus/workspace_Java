package com.day17;

import java.util.Scanner;

public class BaseBallGameDemo4 {
	// 사용자가 입력한 숫자를 받는 코드
	int my[] = new int[3];
	public String account(String input) {
		System.out.println("사용자가 입력한 값 받아오기 : " + input);
		// length : 배열의 원소 갯수
		// length() : 문자열의 갯수
		if(input.length() != 3) {
			// 반복문을 탈출할 때는 break;
			// 조건문을 탈출할 때는 return
			return "세자리 숫자를 입력하세요.";
		}
		int tmp = 0;
		try {
			tmp = Integer.parseInt(input);
		} catch (Exception ex) {
			return "숫자만 입력하세요";
		}
		my[0] = tmp/100; // 백의 자리 
		my[1] = (tmp%100)/10; // 십의 자리
		my[2] = tmp%10; // 일의 자리
		
		for(int val : my){
			System.out.println(val);
		}
		return "1스 0볼";
	}

	public static void main(String[] args) {
		BaseBallGameDemo4 bbg = new BaseBallGameDemo4();
		Scanner sc = new Scanner(System.in);
		System.out.println("0부터 9까지 세자리 숫자를 입력하세요.");
		String result = bbg.account(sc.next());
		System.out.println("판정 결과 : " + result);

	}

}
