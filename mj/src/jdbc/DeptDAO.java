package jdbc;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
// DB연동하여 쿼리문 실행 클래스
public class DeptDAO {
	Connection con;
	PreparedStatement pst;
	ResultSet rs;
	List<DeptVO> list;

	public List<DeptVO> getList() throws SQLException {

		String sql = "Select * FROM DEPT";
		con = DButil.getConnection();
		pst = con.prepareStatement(sql);
		rs = pst.executeQuery();

		list = new ArrayList<DeptVO>();

		while (rs.next()) {
			int deptno = rs.getInt("deptno");
			String dname = rs.getString("dname");
			String loc = rs.getString("loc");

			DeptVO dt = new DeptVO(deptno, dname, loc);
			list.add(dt);
		}
		DButil.close(con, pst);
		return list;
	}

}
