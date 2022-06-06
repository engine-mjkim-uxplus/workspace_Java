package practice;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Test2 {

	public static void main(String[] args) {

		Map<String,String> map = new HashMap();
		
		map.put("아이디", "ss");
		map.put("비번", "11");
		
		Iterator i = map.entrySet().iterator();
		
		while(i.hasNext()) {
			Map.Entry entry = (Map.Entry)i.next();
			System.out.println(entry.getKey());
			System.out.println(entry.getValue());
		}
		
	}

}

