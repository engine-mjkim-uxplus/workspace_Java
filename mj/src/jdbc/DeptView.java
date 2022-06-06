package jdbc;

import java.sql.SQLException;
import java.util.List;
// 결과 출력 클래스
public class DeptView {
	private DeptDAO service;
	
	public DeptView() {
		service = new DeptDAO();
	
	}
	
	public void printDeptList() throws SQLException {
		List<DeptVO> list = service.getList(); // DeptService의 getList실행하여 list반환받는다 
		
		System.out.println("부서번호 | 부서이름 | 지역");
		for(DeptVO d : list) {
		System.out.printf("%d     %s / %s \n",
				d.getDeptno(),
				d.getDname(),
				d.getLoc());
		}
		
	}
		
		
	}


