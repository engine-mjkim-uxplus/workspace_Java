package com.day17;

public class BaseBallGameDemo3 {
	// 사용자가 입력한 숫자를 받는 코드

	public String userInput(String input) {
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
		return "1스 0볼";
	}

	public static void main(String[] args) {

		BaseBallGameDemo3 bbg = new BaseBallGameDemo3();
		String result = bbg.userInput("2");
		System.out.println("판정 결과 : " + result);

	}

}
