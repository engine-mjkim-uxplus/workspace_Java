package ajdbc.member;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import jdbc.oracle.DBConnectionMgr;
import oracle.vo.MemberVO;

public class MemberShip extends JFrame implements ActionListener, MouseListener {
	// 선언부
	JPanel			jp_center		= new JPanel(); // 기본레이아웃 FlowLayout(중앙 -> 양쪽)
	JLabel 			jlb_id 			= new JLabel("아이디 ");
	JTextField 		jtf_id 			= new JTextField("", 20);
	JButton 		jbtn_idcheck 	= new JButton("아이디중복체크");
	JLabel 			jlb_pw			= new JLabel("비밀번호 ");
	JTextField		jtf_pw			= new JTextField("", 20);
	JLabel 			jlb_name		= new JLabel("이름 ");
	JTextField		jtf_name		= new JTextField("", 20);
	JLabel 			jlb_zipcode		= new JLabel("우편번호 ");
	JTextField		jtf_zipcode		= new JTextField("", 20);
	JButton 		jbtn_zipcode 	= new JButton("우편번호검색");
	JLabel 			jlb_address		= new JLabel("주소");
	JTextField		jtf_address		= new JTextField("", 35);
	
	JScrollPane     jsp				= new JScrollPane(jp_center);
	JPanel			jp_south		= new JPanel();
	JButton 		jbtn_signup 	= new JButton("회원가입");
	JButton 		jbtn_cancel 	= new JButton("취소");
	////////////////// DB연동 ///////////////////
	DBConnectionMgr 	dbMgr 	= new DBConnectionMgr();
	Connection 			con 	= null;// 연결통로
	PreparedStatement 	pstmt 	= null;// DML구문 전달하고 오라클에게 요청
	ResultSet 			rs		= null;// 조회경우 커서를 조작 필요
	////////////////// DB연동 ///////////////////	
	MemberApp memberApp = null;
	// 생성자
	public MemberShip() {
		
	}
	
	public MemberShip(MemberApp memberapp) {
    //initDisplay(); 호출 위치에 대해 고민할 것
		this.memberApp = memberapp;
	}
	
	public int memberInsert(MemberVO pmVO) {
		int result= 0;
		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO MEMBER (mem_no,MEM_ID,MEM_PW,MEM_NAME,mem_zipcode,mem_address)");
		sql.append("VALUES(seq_member_no.nextval,?,?,?,?,?)");
		try {
			con = dbMgr.getConnection();
			pstmt = con.prepareStatement(sql.toString());
			int i = 0;
			pstmt.setString(++i, pmVO.getMem_id());
			pstmt.setString(++i, pmVO.getMem_pw());
			pstmt.setString(++i, pmVO.getMem_name());
			pstmt.setString(++i, pmVO.getMem_zipcode());
			pstmt.setString(++i, pmVO.getMem_address());
			result = pstmt.executeUpdate();
			System.out.println("result : " + result);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConnectionMgr.freeConnection(pstmt, con);
		}
		
		return result;
		
	}
	
	/************************************************************
	 * 아이디 중복체크 구현하기
	 * @param 사용자가 입력한 아이디
	 * @return boolean
	 * 만일 boolean을 선택했다면 false이면 사용할 수 없다. true이면 사용할 수 있다.
	SELECT 1 
    FROM DUAL
   WHERE EXISTS (SELECT MEM_NAME
		   		   FROM MEMBER
                  WHERE MEM_ID = 'tomato')
	질문 1 : tomato가 존재하는데 false가 뜹니다. 뭐가 문제인가? --> DB에서 TOMATO 공백있는지 확인
	질문 2 : java.sql.SQLException : 인덱스에서 누락된 IN 또는 OUT 매개변수 :: 1일때
			 ?자리에 들어갈 값을 치환하지 않은 경우
	질문 3 : 토드에서 사용한 변수를 그대로 사용한 경우 반드시 ?로 치환
	************************************************************/
	public boolean idCheck(String user_id) {
		boolean isOk = false;
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT 1                                   ");
	    sql.append("	FROM DUAL                              ");
	    sql.append("	WHERE EXISTS (SELECT MEM_NAME          ");
		sql.append("	   		 		FROM MEMBER            ");
		sql.append("	   		 	  WHERE MEM_ID =   ?     ) ");
		try {
			con = dbMgr.getConnection();
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setString(1, user_id);
			rs = pstmt.executeQuery();
		// 읽어올 컬럼이 있으면 true, 읽어올 컬럼이 없으면 false
		if(rs.next()) {
			isOk = true;
		}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConnectionMgr.freeConnection(rs, pstmt, con);
		}
		
		return isOk;
		
	}///////////////////////////////end of idCheck
	
	public boolean idCheck2(String user_id) {
		boolean isOk = false;
		return isOk;
		
	}
	// 화면 처리부
	public void initDisplay() {
		// 처음 화면이 열렸을 때는 아이디 중복검사가 되지 않았으니까 회원가입 버튼 비활성화
		jbtn_signup.setEnabled(false);
		// 이벤트 소스와 이벤트처리 핸들러 클래스 연결하기
		jbtn_zipcode.addActionListener(this);
		jbtn_idcheck.addActionListener(this);
		jbtn_signup.addActionListener(this);
		jp_center.setLayout(null); // 레이아웃이 반영되지 않음(컴포넌트위치 setBounds로 직접 설정)
		jlb_id.setBounds(20, 20, 100, 20);
		jtf_id.setBounds(120, 20, 100, 20);
		jbtn_idcheck.setBounds(230, 20, 130, 20);
		jlb_pw.setBounds(20, 45, 100, 20);
		jtf_pw.setBounds(120, 45, 100, 20);
		jlb_name.setBounds(20, 70, 100, 20);
		jtf_name.setBounds(120, 70, 100, 20);
		jlb_zipcode.setBounds(20, 95, 100, 20);
		jtf_zipcode.setBounds(120, 95, 100, 20);
		jbtn_zipcode.setBounds(230, 95, 120, 20);
		jlb_address.setBounds(20, 129, 100, 20);
		jtf_address.setBounds(120,129, 200, 20);

		
		jp_center.add(jlb_id);
		jp_center.add(jtf_id);
		jp_center.add(jlb_pw);
		jp_center.add(jtf_pw);
		jp_center.add(jlb_name);
		jp_center.add(jtf_name);
		jp_center.add(jlb_zipcode);
		jp_center.add(jtf_zipcode);
		jp_center.add(jlb_address);
		jp_center.add(jtf_address);
		jp_south.add(jbtn_signup);
		jp_south.add(jbtn_cancel);
		jp_center.add(jbtn_idcheck);
		jp_center.add(jbtn_zipcode);
		this.add("Center", jsp);
		this.add("South",jp_south);
		this.setTitle("회원가입 하기");
		this.setSize(430,380);
		this.setVisible(true);
	
		
	}
	
	
	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		// 회원가입 
		if(obj == jbtn_zipcode) {
			ZipcodeSearch zs = new ZipcodeSearch(this); // 원본을 넘겨 줘야한다.
			zs.initDisplay();
			
		}
		else if(obj == jbtn_signup) {
			MemberVO pmVO = new MemberVO();
			pmVO.setMem_id(getId());
			pmVO.setMem_pw(getPw());
			pmVO.setMem_name(getName());
			pmVO.setMem_zipcode(getZipcode());
			pmVO.setMem_address(getAddress());
			int result = memberInsert(pmVO);
			if(result == 1) {
				System.out.println("result ===> " + result);
				// insert here - 회원가입 성공 후 MemberApp 클래스의 새로고침 메소드 호출하기
				// 가입성공이 되면 가입화면은 닫아주세요
				this.dispose();
				// 새로 추가된 데이터 반영하여 조회
				memberApp.refreshData();
			}
			
		}
		// 아이디 중복 체크
		else if(obj == jbtn_idcheck) {
			boolean isOk = idCheck(getId());
			System.out.println("ID중복체크 호출");
			if(isOk) {
				JOptionPane.showMessageDialog(this, "사용할 수 없는 아이디 입니다.","ERROR",JOptionPane.ERROR_MESSAGE);
				return;
			}else {
				JOptionPane.showMessageDialog(this, "사용할 수 있는 아이디 입니다.","INFO",JOptionPane.INFORMATION_MESSAGE);
				isOk = true; 				  // 값의 변경
				jbtn_signup.setEnabled(isOk); // isOk로 재사용성 up
			}
			
		} 
	}
	public String getId() { return jtf_id.getText(); }
	public void setId(String mem_id) { jtf_id.setText(mem_id); }
	public String getPw() { return jtf_pw.getText(); }
	public void setPw(String mem_pw) { jtf_pw.setText(mem_pw); }
	public String getName() { return jtf_name.getText(); }
	public void setName(String mem_name) { jtf_name.setText(mem_name); }
	public String getZipcode() { return jtf_zipcode.getText(); }
	public void setZipcode(String mem_zipcode) { jtf_zipcode.setText(mem_zipcode); }
	public String getAddress() { return jtf_address.getText(); }
	public void setAddress(String mem_address) { jtf_address.setText(mem_address); }
	public static void main(String[] args) {
		new MemberShip();
	}

}
