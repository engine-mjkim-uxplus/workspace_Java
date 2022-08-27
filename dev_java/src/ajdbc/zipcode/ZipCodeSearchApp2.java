package ajdbc.zipcode;

import java.awt.Color;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Vector;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import jdbc.oracle.DBConnectionMgr;

public class ZipCodeSearchApp2 extends JFrame implements ItemListener {
	// JPanel은 디폴트 레이아웃이 FlowLayout이다. 가운데서 좌우로 펼쳐지면서 배치가 된다.(순서대로 add하면 됨)
	JPanel jp_north = new JPanel();
	String zdo = null; // 선택한 도 정보 담기
	String sigu = null; // 선택된 시구 정보담기
	String dong = null; // 선택된 동 정보 담기
	String zdos[] = null; // 도 콤보박스에 데이터 초기화 사용
	String sigus[] = null; // 시구 콤보박스에 데이터 초기화 사용
	String dongs[] = null; // 동 콤보박스에 데이터 초기화 사용
	JComboBox jcb_zdo = null; // 도 콤보박스
	JComboBox jcb_sigu = null; // 시구 콤보박스
	JComboBox jcb_dong = null; // 동 콤보박스
	String cols[] = { "주소", "우편번호" };
	String data[][] = new String[0][2];
	DefaultTableModel dtm = new DefaultTableModel(data, cols);
	JTable jtb = new JTable(dtm);
	JScrollPane jsp = new JScrollPane(jtb, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
			JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

	DBConnectionMgr dbMgr = new DBConnectionMgr();
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	// 생성자
	public ZipCodeSearchApp2() {
		zdos = getZDOList(); // 데이터베이스에서 조회하여 가져온다.
		sigus = new String[] { "전체" };
		dongs = new String[] { "전체" };
		jcb_zdo = new JComboBox(zdos);
		jcb_sigu = new JComboBox(sigus);
		jcb_dong = new JComboBox(dongs);
		jcb_zdo.addItemListener(this);
		jcb_sigu.addItemListener(this);
	}
	
	public ArrayList<ZipcodeVO> getList(String dong,String sigu) {
		ArrayList<ZipcodeVO> list = new ArrayList<>();
		String sql = "SELECT * FROM ZIPCODE_T WHERE DONG = ? AND sigu = ?"; 

		if (dong.equals("전체")) {
			System.out.println("전체는 조회 할 수 없습니다.");
		} else {
			try {
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, dong);
				pstmt.setString(2, sigu);
				rs = pstmt.executeQuery();

				while (rs.next()) {
					String address = rs.getString("address");
					String zipcode = rs.getString("zipcode");
					list.add(new ZipcodeVO(address, zipcode));
					}
				} catch (Exception e) {
					System.out.println("존재하지 않는 동 이름입니다.");
					e.printStackTrace();
			}
		}
		return list;
	}
	
	// 콤보박스에 뿌려질 ZDO 컬럼의 정보를 오라클 서버에서 꺼내오기
	public String[] getZDOList() {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT '전체' ZDO FROM DUAL                          ");
		sql.append("UNION ALL                                            ");
		sql.append("SELECT ZDO                                           ");
		sql.append("        FROM(                                        ");
		sql.append("                    SELECT                           ");
		sql.append("                                DISTINCT (ZDO) ZDO   ");
		sql.append("                               FROM ZIPCODE_T        ");
		sql.append("                              ORDER BY ZDO ASC      ) ");
		try {
			con = dbMgr.getConnection();
			pstmt = con.prepareStatement(sql.toString());
			rs = pstmt.executeQuery();
			Vector<String> v = new Vector<>();
			while (rs.next()) {
				String zdo = rs.getString("zdo");
				v.add(zdo);
			}
			zdos = new String[v.size()]; // 백터에 담긴 크기만큼 String배열을 만든다
			v.copyInto(zdos); // copy의 역할을 대신 해준다, vector에 있는 값이 String 배열에 담긴다
		} catch (Exception e) {
			System.out.println("Exception " + e.toString());
		}

		return zdos;
	}

	// 시구 메소드
	public String[] getSIGUList(String zdo) {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT '전체' sigu FROM DUAL                           ");
		sql.append("UNION ALL                                              ");
		sql.append("SELECT sigu                                            ");
		sql.append("        FROM(                                          ");
		sql.append("                    SELECT                             ");
		sql.append("                                DISTINCT (sigu) sigu   ");
		sql.append("                               FROM ZIPCODE_T          ");
		sql.append("                               WHERE ZDO = ?	       ");
		sql.append("                              ORDER BY sigu ASC        ");
		sql.append("                    )								   ");
		try {
			con = dbMgr.getConnection();
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setString(1, zdo);
			rs = pstmt.executeQuery();
			Vector<String> v = new Vector<>();
			while (rs.next()) {
				String sigu = rs.getString("sigu");
				v.add(sigu);
			}
			sigus = new String[v.size()]; // 백터에 담긴 크기만큼 String배열을 만든다
			v.copyInto(sigus); // copy의 역할을 대신 해준다, vector에 있는 값이 String 배열에 담긴다
		} catch (Exception e) {
			System.out.println("Exception " + e.toString());
		}

		return sigus;
	}
	
	
	// 동 메소드
		public String[] getDONGList(String sigu) {
			StringBuilder sql = new StringBuilder();
			sql.append("SELECT '전체' dong FROM DUAL                            ");
			sql.append("UNION ALL                                               ");
			sql.append("SELECT dong                                             ");
			sql.append("        FROM(                                           ");
			sql.append("                    SELECT                              ");
			sql.append("                                DISTINCT (dong) dong    ");
			sql.append("                               FROM ZIPCODE_T           ");
			sql.append("                               WHERE sigu = ?	        ");
			sql.append("                              ORDER BY dong ASC       ) ");
			try {
				con = dbMgr.getConnection();
				pstmt = con.prepareStatement(sql.toString());
				pstmt.setString(1, sigu);
				rs = pstmt.executeQuery();
				Vector<String> v = new Vector<>();
				while (rs.next()) {
					String dong = rs.getString("dong");
					v.add(dong);
				}
				dongs = new String[v.size()]; // 백터에 담긴 크기만큼 String배열을 만든다
				v.copyInto(dongs); // copy의 역할을 대신 해준다, vector에 있는 값이 String 배열에 담긴다
			} catch (Exception e) {
				System.out.println("Exception " + e.toString());
			}

			return dongs;
		}

	@Override
	public void itemStateChanged(ItemEvent e) {
		Object obj = e.getSource();
		// 지역 선택했을 때 해당하는 지역의 시.구 컴포넌트에 붙이기
		if (obj == jcb_zdo) {
			if (e.getStateChange() == ItemEvent.SELECTED) {		
				zdo = zdos[jcb_zdo.getSelectedIndex()]; // 아이템이 선택이 되었을 때 해당 선택된 인덱스를 찾아서 문자열 반환
				jcb_sigu.removeAllItems();
				jcb_dong.removeAllItems();
				sigus = this.getSIGUList(zdo);			// zdo에 해당하는 시.구 배열로 가져오기
				for (int i = 0; i < sigus.length; i++) {
					jcb_sigu.addItem(sigus[i]);         // 시.구 배열 컴포넌트에 붙이기
				}
				System.out.println(Arrays.toString(sigus)); // 테스트용

			} ////////////////////// end of top
		// 시.구 선택했을 때 실행 해당하는 동 컴포넌트에 붙이기
		} else if(obj == jcb_sigu) {
			if (e.getStateChange() == ItemEvent.SELECTED) {			
				sigu = sigus[jcb_sigu.getSelectedIndex()]; // 아이템이 선택이 되었을 때 해당 선택된 인덱스를 찾아서 문자열 반환
				jcb_dong.removeAllItems(); 				   // 다시 선택했을 때 시.구 리셋 시켜준다.
				dongs = this.getDONGList(sigu);            // 시구와 일치하는 동배열 가져오기
				for (int i = 0; i < dongs.length; i++) {   // 동배열 컴포넌트에 붙이기
					jcb_dong.addItem(dongs[i]);
				}
				System.out.println(Arrays.toString(dongs)); // 테스트용

			} 
		}  else if (obj == jcb_dong) {
			if (e.getStateChange() == ItemEvent.SELECTED) {
				dtm.setRowCount(0);
				String select = dongs[jcb_dong.getSelectedIndex()];
				ArrayList<ZipcodeVO> list = getList(select, sigus[jcb_sigu.getSelectedIndex()]);
				if (list != null && !select.equals(" ")) {
					for (int i = 0; i < list.size(); i++) {
						String[] sList = new String[] { list.get(i).getAddress(), list.get(i).getZipcode() };
						dtm.addRow(sList);
					}
				}
			}
		}
	}

	public void initDisplay() {
		this.setTitle("우편번호 검색기 Ver1.0");
		jp_north.setBackground(Color.orange);
		jp_north.add(jcb_zdo);
		jp_north.add(jcb_sigu);
		jp_north.add(jcb_dong);
		this.add("North", jp_north);
		this.add("Center", jsp);
		this.setSize(600, 500);
		this.setVisible(true);
	}

	public static void main(String[] args) {
		ZipCodeSearchApp2 zc = new ZipCodeSearchApp2();
		zc.initDisplay();

	}

}
