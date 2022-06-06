import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

public class Timeget {
	private static final String url = "jdbc:oracle:thin:@localhost:1522/ORCL11";
	private static final String sql = "select to_char(sysdate,'HH24:MI:SS') from dual";
	private static final String user = "MJ";
	private static final String pwd = "111111";
	private static final String driver = "oracle.jdbc.driver.OracleDriver";
	Connection con;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	public String currentTime() throws ClassNotFoundException, SQLException {
		Class.forName(driver);
		con = DriverManager.getConnection(url, "MJ", "111111");
		//Statement st = con.createStatement();
		//ResultSet rs = st.executeQuery(sql); // 시퀄에 대한 결과집합이 만들어지고 커서가 top에 있는 상태이다.
		
		pstmt = con.prepareStatement(sql);
		rs = pstmt.executeQuery();
		
		if(rs.next()) { // return boolean t/f
			return rs.getString(1);
		} //f --> 값이 없을 때 
		return "15:09:49"; // next() -> 커서가 1행에 왔는데 값이없어 값이없다는 건 즉 데이터가 아무것도없
		}
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Timeget j = new Timeget();
		String time= j.currentTime();
		System.out.printf("현재 시간은 %s 입니다",time);
	}
} // dao, vo , dbutil
