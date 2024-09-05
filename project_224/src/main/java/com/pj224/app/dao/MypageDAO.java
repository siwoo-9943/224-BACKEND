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
	   //여기서 email 중복 확인이 필요한지
	   public boolean checkEmail(String memberEmail) {
	      return (Integer) sqlSession.selectOne("member.checkEmail", memberEmail) <= 0;

	   }




}
