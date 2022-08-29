package com.mvc.step3;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.log4j.Logger;

import com.util.MyBatisCommonFactory;

public class MemberDao {
	Logger logger = Logger.getLogger(Board3MDao.class);
	// 물리적인 DB서버와 연결
	SqlSessionFactory sqlSessionFactory = null;
	// 쿼리문 요청과 커밋 그리고 롤백 처리
	SqlSession sqlSession = null;
	
	public MemberDao() {
		// 초기화 먼저 하고 싶을 때
		// 아래 객체(SqlSessionFactory)는 언제 객체주입(인스턴스화)이 일어날까?
		// MemberDao의 메소드를 호출할 때 - MemberLogic에서
		// 조회번튼이 눌렸거나 트리에서 회원목록을 선택하면 
		sqlSessionFactory = MyBatisCommonFactory.getSqlSessionFactory();
	}
	
	public List<Map<String, Object>> memberList(Map<String, Object> pMap) {
		logger.info("memberList 호출 성공");
		List<Map<String, Object>> memberList = null;
		try {
			sqlSession = sqlSessionFactory.openSession();
			memberList = sqlSession.selectList("memberList", pMap);
			// insert here
			logger.info(memberList);
		} catch (Exception e) {
			logger.info("Exception : "+e.toString());
		} finally {
			sqlSession.close();
		}
		return memberList;
	}
}
