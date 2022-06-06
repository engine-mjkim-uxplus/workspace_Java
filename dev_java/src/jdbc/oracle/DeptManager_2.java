package jdbc.oracle;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Vector;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class DeptManager_2 extends JFrame implements ActionListener {
	public final String _DRIVER = "oracle.jdbc.driver.OracleDriver";
	public final String _URL = "jdbc:oracle:thin:@localhost:1522:orcl11";
	public final String _USER = "scott";
	public final String _PW = "tiger";
	Connection con = null;// Interface - 단독으로 인스턴스 불가 A a = new A()
	// 오라클 서버에 sql문을 전달할 때 사용함.
	PreparedStatement pstmt = null;
	// 조회결과를 받아서 자바에서 출력할 때 오라클에 커서를 조작해야 함.
	ResultSet rs = null;
	String sql = "SELECT deptno, dname, loc FROM dept";
	JButton jbtn_select = new JButton("조회");
	String cols[] = { "부서번호", "부서명", "지역" };
	String data[][] = new String[0][3];
	DefaultTableModel dtm = new DefaultTableModel(data, cols);
	JTable tb = new JTable(dtm);
	JScrollPane jsp = new JScrollPane(tb);

	public DeptManager_2() {
		// 이벤트 처리를 담당하는 핸들러 클래스의 주소번지
		// 내안에 actionPerformed 메소드가 재정의 되어있다면 this
		jbtn_select.addActionListener(this);
		initDisplay();
	}
		// getDeptList()메서드를 이벤트처리하는 곳에서 호출
	public List<Map<String, Object>> getDeptList() { 
		List<Map<String, Object>> deptList = null;
		try {
			// 오라클 제조사가 제공하는 드라이버 클래스가 있어야 함.
			// 있는 위치는 D:\\app\\user1\\product\\11.1.0\\db_1\\jdbc\\lib 아래에 ojdbc6.jar안에 있어요
			Class.forName(_DRIVER);
			con = DriverManager.getConnection(_URL, _USER, _PW);
			// 파라미터로 받은 select문을 전달
			pstmt = con.prepareStatement(sql);
			// 전달 된 select문에 대한 처리를 요청하고 커서 받아내기
			rs = pstmt.executeQuery();
			deptList = new ArrayList<>(); // 리스트 생성
			Map<String, Object> rmap = null; // 맵 선언
			
			while (rs.next()) { // rs는 커서를 움직이는 부분
				rmap = new HashMap<>(); // 
				rmap.put("deptno", rs.getInt("deptno")); // getIn("컬럼명" 또는 컬럼 인덱스) --- 해당 컬럼의 값을 읽어오는 부분
				rmap.put("dname", rs.getString("dname"));
				rmap.put("loc",rs.getString("loc"));
				deptList.add(rmap); // key, value를 한쌍으로 리스트에 넣는다. add(Object o)니까 가능
			}						// 즉 iterator를 쓰기위해서 변환을 해주어야한다.
			// System.out.println(con+"생성 되어나요?");
			if (deptList == null || deptList.size() < 1) {
				JOptionPane.showMessageDialog(this, "데이터가 없습니다.", "Info", JOptionPane.INFORMATION_MESSAGE);
				return deptList;
			} else {
				Iterator<Map<String, Object>> iter = deptList.iterator();
				Object keys[] = null;
				while (iter.hasNext()) {
					Map<String, Object> data = iter.next();
					System.out.println(data);
					keys = data.keySet().toArray(); // 키를 set으로 얻어서 배열로 저장
					Vector<Object> oneRow = new Vector(); // vector에 다시 담음. dtm데이터를 vector나 objec만 가능 하므로 vector에 담음
					oneRow.addElement(data.get(keys[2]));
					oneRow.addElement(data.get(keys[1]));
					oneRow.addElement(data.get(keys[0]));
					dtm.addRow(oneRow); // dtm 데이터를 붙여야 하는데 vector나 object만 가능 / Defalut TableModel 
				}
			}

		} catch (Exception e) {
			System.out.println("오라클 서버와 연결 통로 확보 실패");
			// stack메모리에 쌓인 에러 메시지에 대한 history정보 출력 해줌
			e.printStackTrace();
		}
		return deptList;
	}

	public void initDisplay() {
		this.add("North", jbtn_select);
		this.add("Center", jsp);
		this.setTitle("DeptManager_2");
		this.setSize(500, 400);
		this.setVisible(true);
	}

	public static void main(String[] args) {
		new DeptManager_2();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == jbtn_select) {
			List<Map<String, Object>> deptList = getDeptList();
			for (int i = 0; i < deptList.size(); i++) {
				Map<String, Object> rmap = deptList.get(i);
				System.out.println(rmap.get("deptno"));
			}
		}

	}
}