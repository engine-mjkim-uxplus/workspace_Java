package com.day5;

public class sungJuk {
	String ko = "국어", en ="영어", mat= "수학";
	int kor = 90;
	int eng = 95;
	int math = 60;
	int total() {
		int hap = 0;
		hap = kor+eng+math;
		return hap;
	}
	/********************************************************************
	 * 평균을 구하는 메소드 구현
	 * @param hap - 새과목에 대한 총점을 복사해온다
	 * @return double - 총점을 국어, 수학, 영어 세 과목으로 나눈다
	 * double/double => double
	 *********************************************************************/
	
	
	
	double average(int hap) {
		double avg = hap/3.0;
		return avg;
		
	}
	
	public static void main(String[] args) {
		// sj는 참조형 변수이다. sj는 참조형 변수로 호출하면 주소번지가 출력됨
		// 언제 사용하지? 클래스 안에 선언된 변수나 메서드를 사용할 때 사용함
		sungJuk sj = new sungJuk();
		int hap = sj.total();
		System.out.println("총점은 " + hap);
		
		double avg = sj.average(hap);
		System.out.println("평균은 " + Math.round(avg*10)/10.0);
		System.out.print("국어: " + sj.kor);
		System.out.print(" 영어: " + sj.eng);
		System.out.print(" 수학: " + sj.math);
		
	}

}
