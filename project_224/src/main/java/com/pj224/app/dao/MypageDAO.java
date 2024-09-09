package com.pj224.app.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.mybatis.config.MyBatisConfig;
import com.pj224.app.dto.MemberDTO;
import com.pj224.app.dto.MypageDTO;

public class MypageDAO {
	private SqlSession sqlSession;

	   public MypageDAO() {
	      sqlSession = MyBatisConfig.getSqlSessionFactory().openSession(true);
	   }
	   
	   public String myprofile(String memberEmail, String memberName,String memberNickName,String memberPhone,String memberGender,String memberBirth) {
			System.out.println("내 프로필 다오 실행");
			MypageDTO mypageDTO = new MypageDTO();
			mypageDTO.setMemberEmail(memberEmail);
			mypageDTO.setMemberName(memberName);
			mypageDTO.setMemberNickName(memberNickName);
			mypageDTO.setMemberPhone(memberPhone);
			mypageDTO.setMemberGender(memberGender);
			mypageDTO.setMemberBirth(memberBirth);
		
			
			System.out.println(mypageDTO + "확인용");
			
			return sqlSession.selectOne("mypage.myprofile", mypageDTO);
			
	   }
	  
//		   //내 프로필
		   public MypageDTO login(String memberId, String memberPassword) {
			 //회원 로그인 기능을 위한 매서드 memverId,memberpassword 매개변수로 받음
			   MypageDTO mypageDTO = new MypageDTO();
		      //memberDTO 객체를 생성
		      mypageDTO.setMemberEmail(memberId);
		      //memberDTO에 회원 ID 설정
		      mypageDTO.setMemberPw(memberPassword);
		      
		      //memberDTO에 회원 pw 설정
		      return sqlSession.selectOne("mypage.login", mypageDTO);
		   }
}
