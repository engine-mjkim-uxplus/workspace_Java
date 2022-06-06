package com.day20;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/*
 * 회원가입
 * 아이디 : 입력하세요
 * <input type ="text" name = "mem_id">
 * 비번 : 입력하세요
 * <input type ="text" name = "mem_pw">
 * 이름 : 입력하세요
 * <input type ="text" name = "mem_name">
 * 이메일 : 입력하세요
 * <input type ="text" name = "mem_email">
 * 
 */
public class MapTest_3 {
	Map<String, String> map = new HashMap<>();

	public MapTest_3() {
		map.put("mem_id", "scott");
		map.put("mem_pw", "tiger");
		map.put("mem_name", "나신입");
		printMap();
	}

	public void printMap() {
		System.out.println(map.size()); // 키값에 대한 원소의 수이다 - 3이 출력된다.
		for (Map.Entry<String, String> et : map.entrySet()) {
			System.out.println("[key]" + et.getKey() + ", [value] :" + et.getValue());
		}

	}

	public static void main(String[] args) {
		new MapTest_3();

	}

}
