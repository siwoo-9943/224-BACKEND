package com.pj224.app.dao;

import org.apache.ibatis.session.SqlSession;

import com.mybatis.config.MyBatisConfig;
import com.pj224.app.dto.MemberDTO;

public class MemberDAO {
	private SqlSession sqlSession;
	
	public MemberDAO() {
		sqlSession = MyBatisConfig.getSqlSessionFactory().openSession(true);
	}
	
	public void join(MemberDTO memberDTO) {
		sqlSession.insert("member.join", memberDTO);
		System.out.println("값확인" + memberDTO);
	}
	
	public boolean checkId(String memberEmail) {
		return (Integer)sqlSession.selectOne("member.checkId", memberEmail) <= 0;
	}
	
	//쿠키 세션
	public MemberDTO login(String memberEmail, String  memberPw) {
		MemberDTO memberDTO = new MemberDTO();
		memberDTO.setMemberEmail(memberEmail);
		memberDTO.setMemberPw(memberPw);
		return sqlSession.selectOne("member.login", memberDTO);
	}

}
