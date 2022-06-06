package jdbc.oracle;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class JDBCTest {
	
	
	public static void main(String[] args) {
		// 물리적으로 떨어져 있는 오라클 서버와 연결통로를 만든다.
		// 메소드 호출로 객체생성 가능하다.
		//getConnection(URL, username, pw)
		Connection 			con 	= 	null; // Interface - 단독으로 인스턴스 불가 / A a = new A();불가
		// 오라클 서버에 sql문을 전달할 때 사용함
		PreparedStatement 	pst		= 	null;
		// 조회결과를 받아서 자바에서 출력할 때 오라클에 커서를 조작해야 함	
		ResultSet			rs 		= 	null;
		String sql = " SELECT DEPTNO, DNAME, LOC FROM DEPT";
		try {
			// 오라클 제조사가 제공하는 드라이버 클래스가 있어야함
			// 있는 위치 D:\app\MJ\product\11.1.0\db_1\jdbc\lib
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@192.168.0.102:1522:orcl11","scott","tiger");
			// 파라미터로 받은 select문을 전달
			pst = con.prepareStatement(sql);
			// 전달된 select문에 대한 처리를 요청하고 커서 받아내기
			rs = pst.executeQuery();
			while(rs.next()) {
				System.out.println(rs.getInt("deptno")+ "," + rs.getString("dname")+ ", "+ rs.getString("LOC"));
			}
			
			System.out.println(con+"생성 되었나요?");
		} catch (Exception e) {
			System.out.println("오라클 서버와 연결 통로 확보 실패");
			e.printStackTrace();
		}
	}

}
