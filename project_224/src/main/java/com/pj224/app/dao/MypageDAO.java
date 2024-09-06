package com.pj224.app.dao;

import org.apache.ibatis.session.SqlSession;

import com.mybatis.config.MyBatisConfig;
import com.pj224.app.dto.MemberDTO;
import com.pj224.app.dto.MypageDTO;

public class MypageDAO {
	private SqlSession sqlSession;

	   public MypageDAO() {
	      sqlSession = MyBatisConfig.getSqlSessionFactory().openSession(true);
	   }

	   public void profile(MypageDTO mypageDTO) {
	      sqlSession.insert("mypage.my-profile", mypageDTO);
	   }
	   
	   //memberNumber를 기준으로 사용자 정보 조회하고 반환
	   public MypageDTO getProfile(int memberNumber) {
	        return sqlSession.selectOne("mypage.get-profile", memberNumber);
	    }

}
