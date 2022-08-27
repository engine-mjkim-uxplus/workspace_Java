package ajdbc.zipcode;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import jdbc.oracle.DBConnectionMgr;

public class ZipcodeSearch {
	// 선언부
	DBConnectionMgr dbMgr = new DBConnectionMgr();
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	// 생성자
	
	// 사용자로 부터 동을 입력받는 메소드 구현
	public String userInput() {
		String dong = null;
		//insert here
		Scanner sc = new Scanner(System.in);
		dong = sc.nextLine();
//		System.out.println("동을 입력하세요!!!!!");
		
		return dong;
	}
	// 우편번호 조회 메소드 구현
	public List<Map<String, Object>> getZipCodeList(String userDong){
		System.out.println("getZipCodeList 호출 성공");
		List<Map<String, Object>> zipList = null;
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT                          ");
        sql.append("	   address, zipcode         ");
		sql.append("  FROM ZIPCODE_T                ");
		sql.append(" WHERE dong LIKE '%'||?||'%'");
		try {
			con = dbMgr.getConnection();
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setString(1, userDong);
			rs = pstmt.executeQuery();
			zipList = new ArrayList<>();
			Map<String,Object> rmap = null;
			while(rs.next()) {
				rmap = new HashMap<>();
				rmap.put("address", rs.getString("address"));
				rmap.put("zipcode", rs.getInt("zipcode"));
				zipList.add(rmap);
			}
			// DB의 정보를 불러온다. 
			System.out.println(zipList);
		} catch (Exception e) {
			System.out.println(""+e.toString());
		}
		return zipList;
	}
	// 조회된 우편번호 목록 출력하기
	
	public static void main(String[] args) {
		String  userDong =  null;
		ZipcodeSearch zs =  new ZipcodeSearch();
//		userDong = zs.userInput();
		while("1".equals(userDong)||userDong == null) {
			System.out.println("동을 입력해!!!(예: 당산동)");
			userDong = zs.userInput();
			if("그만".equals(userDong)) {
				break;
			}
			System.out.println("사용자가 입력한 동 ====> "+ userDong);
			zs.getZipCodeList(userDong);
			userDong = "1";
		}
		System.out.println("WHILE 탈출하면 출력됨");
	}

}
