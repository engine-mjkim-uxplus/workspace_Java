package com.day17;

public class BaseBallGameDemo1 {
	// 사용자가 입력한 숫자를 받는 코드

	public int userInput(String input) {
		int my = 0;
		// 예외처리를 다중문으로 할 때 반드시 상위 클래스가 맨 나중에 와야함. 범위 넒은 예외처리가 상위에 오면 모든 것을 첫번째에서 처리하기 때문에
		try {
			my = Integer.parseInt(input);
		} catch (NumberFormatException e) { 
			System.out.println("숫자만 입력하세요");
		} catch (Exception ex) {
			System.out.println(ex.toString()); // == getMessage와 같음
		}
		System.out.println("요기");
		return my;
	}

	public static void main(String[] args) {

		BaseBallGameDemo1 bbg = new BaseBallGameDemo1();
		int result = bbg.userInput("안녕");
		System.out.println("사용자가 입력한 값은 " + result);

	}

}
