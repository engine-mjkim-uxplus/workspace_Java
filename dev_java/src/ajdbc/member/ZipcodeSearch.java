package ajdbc.member;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import jdbc.oracle.DBConnectionMgr;

public class ZipcodeSearch extends JFrame implements FocusListener, ActionListener, MouseListener{
	// 선언부
	JPanel jp_north = new JPanel();
	JTextField jtf_dong = new JTextField("동이름을 입력하세요",20);
	JButton jbtn_search = new JButton("찾기");
	String zdos[] = {"전체","서울","경기"};
	JComboBox jcb = new JComboBox(zdos); 
	String cols[] = {"우편번호","주소"}; // header부분
	String data[][] = new String[0][2];  //body부분
	DefaultTableModel dtm = new DefaultTableModel(data,cols);
	JTable			  jtb = new JTable(dtm);
	JScrollPane		  jsp  = new JScrollPane(jtb);
	Font			  font = new Font("돋움체",Font.BOLD,18);
	//////////////////DB연동 ///////////////////
	DBConnectionMgr 	dbMgr 	= new DBConnectionMgr();
	Connection 			con 	= null;
	PreparedStatement 	pstmt 	= null;
	ResultSet 			rs		= null;
	////////////////// DB연동 ///////////////////
	MemberShip 			ms		= null; // 인스턴스 직접하면 복제본이 만들어지므로 절대 안됨. null로 선언
	
	// 생성자
	public ZipcodeSearch() {}
	public ZipcodeSearch(MemberShip ms) {
		this.ms = ms;
	}
	
	// 화면처리부
	
	public void initDisplay() {
		jtb.addMouseListener(this);
		jtf_dong.addFocusListener(this);
		jtf_dong.addActionListener(this);
		jbtn_search.addActionListener(this);
		jp_north.setLayout(new BorderLayout());
		jp_north.add("West",jcb);
		jp_north.add("Center", jtf_dong);
		jp_north.add("East", jbtn_search);
		
		this.add("North",jp_north);
		this.add("Center",jsp);
		this.setTitle("우편번호 검색기");
		this.setSize(430,400);
		this.setVisible(true);			
	}
	public void refreshData (String dong) {
		StringBuilder sql = new StringBuilder();
		List<Map<String,Object>> zipList = new ArrayList<>();
		sql.append("SELECT                              ");
		sql.append("	ZIPCODE, ADDRESS                ");
		sql.append("   FROM ZIPCODE_T                   ");
		sql.append(" WHERE DONG LIKE '%'|| ? ||'%' 		");
		try {
			con =dbMgr.getConnection();
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setString(1, dong);
			rs = pstmt.executeQuery();
			Map<String,Object> rmap = null;
			while(rs.next()) {
				rmap = new HashMap<>();
				rmap.put("zipcode", rs.getString("zipcode"));
				rmap.put("address", rs.getString("address"));
				zipList.add(rmap);
			}
			while(dtm.getRowCount() > 0) {
				dtm.removeRow(0);
			}
			
			// 조회된 결과를 DefaultTableModel에 매핑하기
			for(int i =0; i<zipList.size();i++) {
				Map<String,Object> map = zipList.get(i);
				Vector<Object> oneRow = new Vector();
				oneRow.add(0, map.get("zipcode"));
				oneRow.add(1, map.get("address"));
				dtm.addRow(oneRow);
			}
			
		} catch (SQLException se) {
			
		} catch (Exception e) {
			e.toString();
		} finally {
			DBConnectionMgr.freeConnection(rs, pstmt, con);
		}
	}
	
	
	public static void main(String[] args) {
		ZipcodeSearch zc = new ZipcodeSearch();
		zc.initDisplay();
		
		
	}
	@Override
	public void focusGained(FocusEvent e) {
		if(e.getSource() == jtf_dong) {
			jtf_dong.setText("");
			
			
		}
		
	}
	@Override
	public void focusLost(FocusEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if(jtf_dong == obj || jbtn_search == obj) {
			String user = jtf_dong.getText();
			refreshData(user);
		}
		
		
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		
	}
	@Override
	public void mousePressed(MouseEvent e) {
		if(e.getClickCount() == 2) { // 더블 클릭에 대한 이벤트 처리
			System.out.println("더블 클린 한거야?");
		int index[] = jtb.getSelectedRows();
		if(index.length == 0) {
			JOptionPane.showInternalMessageDialog(this, "조회 데이터를 선택하시오.");
			return;
			}
		else {
			// 사용자가 더블클릭한 로우의 우편번호 가져오기
			String zipcode = (String)dtm.getValueAt(index[0], 0);
			// 사용자가 더블클릭한 로우의 주소 가져오기
			String address = (String)dtm.getValueAt(index[0], 1);
			
			ms.jtf_zipcode.setText(zipcode);
			ms.jtf_address.setText(address);
			this.dispose();
			
			
			System.out.println(zipcode + ", "+ address);
			}
		}
		
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}