package com.pj224.app.dao;

import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.mybatis.config.MyBatisConfig;
import com.pj224.app.dto.MemberDTO;

public class MemberDAO {
	private SqlSession sqlSession;
	
	public MemberDAO() {
		sqlSession = MyBatisConfig.getSqlSessionFactory().openSession(true);
	}
	
	//회원가입
	public void join(MemberDTO memberDTO) {
		sqlSession.insert("member.join", memberDTO);
		System.out.println("값확인" + memberDTO);
	}
	
	//회원가입 시 이메일 중복값 확인
	public boolean checkEmail(String memberEmail) {
		System.out.println("이메일 중복체크 메소드 실행");
		return (Integer)sqlSession.selectOne("member.checkEmail", memberEmail) <= 0;
	}
	
	//회원가입 시 닉네임 중복값 확인
	public boolean checkNickname(String memberNickname) {
		System.out.println("닉네임 중복체크 메소드 실행");
		return (Integer)sqlSession.selectOne("member.checkNickname", memberNickname) <= 0;
	}
	
	//쿠키 세션(로그인시 사용)
	public MemberDTO login(String memberEmail, String  memberPw) {
		System.out.println("로그인 다오 실행");
		MemberDTO memberDTO = new MemberDTO();
		memberDTO.setMemberEmail(memberEmail);
		memberDTO.setMemberPw(memberPw);
		return sqlSession.selectOne("member.login", memberDTO);
	}
	
	

}
