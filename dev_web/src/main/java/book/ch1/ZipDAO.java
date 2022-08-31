package book.ch1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
public class ZipDAO {

	public static final String _DRIVER = "oracle.jdbc.driver.OracleDriver";//ojdbc6.jar  의존관계, 의존성 주입 제조사
	//서버측의 아이피, 서버측의 포트번호, 서버측의 오라클 SID가 필요하다.
	public static final String _URL    = "jdbc:oracle:thin:@localhost:1522:orcl11";
	public static final String _USER   = "scott";
	public static final String _PW     = "tiger";
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	
	public List<Zip> search(String address) {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT ZIPCODE, DONG, UPD_DATE, ADDRESS FROM ZIPCODE_T WHERE ADDRESS LIKE ?");
		List<Zip> zipList = new ArrayList<>();
		try {
			Class.forName(_DRIVER);
			con = DriverManager.getConnection(_URL, _USER, _PW);
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setString(1, "%" + address + "%");
			rs = pstmt.executeQuery();
			Zip zip = null;
			while(rs.next()) {
				zip = new Zip();
				zip.setZipcode(rs.getInt("zipcode"));
				zip.setDong(rs.getString("dong"));
				zip.setUpd_update(rs.getString("upd_update"));
				zip.setAddress(rs.getString("address"));
				zipList.add(zip);
			}		
		} catch (Exception e) {
			System.out.println("Exception : "+e.toString());
		}
		return zipList;
	}
	
}
