package com.day20;

public class StringTest {

	public static void main(String[] args) {
		String s = "이순신";
		s= "Hello World";
		System.out.println(s.length());
		System.out.println(s.toUpperCase());
		System.out.println(s.toLowerCase());
		System.out.println(s.substring(0,3));
		System.out.println(s.substring(7,9));
		s = "java";
		s.replace('j', 'h'); // String은 원본이 바뀌지 않는다
		System.out.println(s);// java or hava	
		
	}

}
