package com.day19;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MapTest_1 {
	Map<String, Object> map = new HashMap<>();

	public MapTest_1() {
		map.put("mem_id", "scott");
		map.put("mem_pw", "tiger");
		map.put("mem_name", "나신입");
		printMap();
	}

	public void printMap() {
		Set<String> set = map.keySet();
		Object obj[] = set.toArray(); // set을 배열로 전환
		// 배열의 인덱스 사용하여 Key값과 value를 뽑음
		for(int i =0; i<obj.length; i++) {
			String key = (String)obj[i];
			System.out.println(key+ ", " + map.get(key));
		}
		System.out.println(obj[0]);
	}
	
	public static void main(String[] args) {
		new MapTest_1();
		
		
	}

}
