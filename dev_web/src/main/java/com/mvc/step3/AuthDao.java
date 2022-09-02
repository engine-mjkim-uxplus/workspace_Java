package com.mvc.step3;

import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.log4j.Logger;

import com.util.MyBatisCommonFactory;
import com.vo.MemberVO;

public class AuthDao {
	Logger logger = Logger.getLogger(AuthDao.class);
	// 물리적인 DB서버와 연결
	SqlSessionFactory sqlSessionFactory = null;
	// 쿼리문 요청과 커밋 그리고 롤백 처리
	SqlSession sqlSession = null;
	public AuthDao() {
		sqlSessionFactory = MyBatisCommonFactory.getSqlSessionFactory();
	}	
	public MemberVO login(Map<String, Object> pMap) {
		logger.info("login 호출 성공 : "+pMap);
		MemberVO mVO= null;
		try {
			sqlSession = sqlSessionFactory.openSession();
			mVO = sqlSession.selectOne("login", pMap);  // selectOne은 Object이다. 한개의 로우만 가지고 올 수 있는 것(마이바티스)
			// insert here								// 여러개를 담으려면 배열로
			logger.info(mVO.getMem_name());
		} catch (Exception e) {
			logger.info("Exception : "+e.toString());
		} finally {
			sqlSession.close();
		}
		return mVO;
	}

}

