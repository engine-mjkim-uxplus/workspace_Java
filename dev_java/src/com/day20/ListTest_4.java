package com.day20;

import java.util.ArrayList;
import java.util.List;

public class ListTest_4 {

	public static void main(String[] args) {
		List<Integer> numberList = new ArrayList<>();
		numberList.add(1);
		// 제네릭에서 String타입을 명시 하였으므로 형변환연산자 생략가능
		int name2 = numberList.get(0);
		System.out.println(name2);
	}

}
