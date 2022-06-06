package com.day10;

public class Super3 {
	public float getNum() {
		return 3.0f;
	}
	public static void main(String[] args) {
		Integer intg = (Integer)1; // Integer.valueOf(1);과 같다
		int i2 = intg.intValue() + 1;
		Integer i = 1;
		
	}
}

class Sub3 extends Super3 {

}

// 오버로딩 관련 문제

//A. public float getNum() {return 4.0f;}
//B. public double getNum() {return 4.0d;}
//C. public float getNum(double d) {return 4.0f;} // 에러. 부모클래스 매개변수 없으므로
//D. public double getNum(float d) {return 4.0d;}

