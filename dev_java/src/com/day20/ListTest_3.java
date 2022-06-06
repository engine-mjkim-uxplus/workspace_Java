package com.day20;

import java.util.ArrayList;
import java.util.List;

public class ListTest_3 {

	public static void main(String[] args) {
		List nameList = new ArrayList();
		nameList.add("나신입");
		System.out.println("size : " + nameList.size()); // 0 -> 1
		String name = (String)nameList.get(0);
		List<String> nameList2 = new ArrayList<>();
		nameList2.add("나초보");
		// 제네릭에서 String타입을 명시 하였으므로 형변환연산자 생략가능
		String name2 = nameList2.get(0);
		System.out.println(name2);
	}

}
