package com.day21;

import java.util.HashMap;
import java.util.Map;

public class MapTest {

	public static void main(String[] args) {
		Map<String, Object> pmap = new HashMap<>();
		pmap.put("mem_id", "toamato");
		pmap.put("mem_pw", "111");
		pmap.put("mem_name", "토마토");
		Object keys[] = pmap.keySet().toArray();
		for (Object key : keys) {
			System.out.println(key + ", " + pmap.get(key));
		}

	}

}
