package com.mvc.step2;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.log4j.Logger;

import com.util.MyBatisCommonFactory;

public class Board2Dao {
	Logger logger = Logger.getLogger(Board2Dao.class);
	SqlSessionFactory sqlSessionFactory = null;
	SqlSession sqlSession = null;
	// sqlSessionFactory 초기화
	public Board2Dao() {
		// MyBatisCommonFactory에서 생성된 sqlSessionFactory를 가지고 온다(싱글톤 패턴)
		sqlSessionFactory = MyBatisCommonFactory.getSqlSessionFactory();
	}
	// 
	public List<Map<String, Object>> boardList() {
		logger.info("boardList 호출 성공");
		List<Map<String,Object>> boardList = null; // board.xml의 i가 boardList인 parameterType이 Map이다
		try {
			sqlSession = sqlSessionFactory.openSession();
			boardList = sqlSession.selectList("boardList"); // board.xml의 id값을 파라미터로 받는다
			logger.info(boardList);
		} catch (Exception e) {
			logger.info("Exception : " + e.toString());
		} finally {
			sqlSession.close();
		}
		return boardList;
		
	}

}
