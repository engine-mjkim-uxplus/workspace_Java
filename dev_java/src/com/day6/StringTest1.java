package com.day6;

import javax.swing.JButton;

public class StringTest1 {
	
	
	int value = 1;
	
	
	public boolean equals(Object obj) {
		return this.value==((StringTest1)obj).value;
	}
	

	public static void main(String[] args) {
		StringTest1 st1 = new StringTest1();
		StringTest1 st2 = new StringTest1();
		// 자바에서 제공되는 클래스이다
		// 따라서 개발자의 의도와 상과없이 자기가(JVM) 생각하고 있는
		// 값을 출력하는 경우도 있다. 그래서 결과가 다르게 출력 됨
		// 일관성이 없이 말이 바뀐다
		JButton jbtn = new JButton("북쪽");
		System.out.println("StringTest1 ==> " + st1);// Object클래스의 toString 호출 됨님
		System.out.println("StringTest1 ==> " + st1.toString());// Object클래스의 toString 호출 됨
		String s = new String("좋은 아침입니다.");
		String s1 = new String("String ==> "+ "좋은 아침입니다.");
		System.out.println(s); // println(Object x)호출 -> String valueof(Object obj)호출 -> return obj.toString(String클래스의 toString호출)
		// 주소번지 s와 주소번지 s1이 같니?
		// 너 s와 s1 너희 둘 같은 주소 번지니?
	
		System.out.println(s);
	}
}
