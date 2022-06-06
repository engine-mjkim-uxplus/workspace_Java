package com.day10;

public class practice {

	public static void main(String[] args) {
		int i = 1, j = 10;
		do {
			if (i++ > --j) { // 요문장만 계속 반복해서 수행한다.
				continue;
			} // I = 2,3,4,5 j = 9,8,7,6
		} while (i < 5); 
		System.out.println("i=" + i + "andj =" + j);

	}
}