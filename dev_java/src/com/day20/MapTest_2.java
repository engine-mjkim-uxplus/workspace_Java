package com.day20;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MapTest_2 {
	Map<String,Object> map = new HashMap<>();
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

	public MapTest_2() {
		map.put("mem_id", "scott");
		map.put("mem_pw", "tiger");
		map.put("mem_name", "나신입");
		printMap();
	}
	
	public void printMap() {
		for(Map.Entry<String,Object> et : map.entrySet()) {
			System.out.println("[key]" + et.getKey() + ", [value] :" + et.getValue());
		}
		
	}
	
	
	
	public static void main(String[] args) {
		new MapTest_2();
		
		
	}

}
