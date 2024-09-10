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
	   //내 프로필
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
		
		   // 개인정보 수정 전 아이디, 비밀번호 확인 페이지
		public String pwOk(String memberEmail, String memberPw) {
			System.out.println("아이디, 비밀번호 확인 페이지 다오 실행");
			MypageDTO mypageDTO = new MypageDTO();
			mypageDTO.setMemberEmail(memberEmail);
			mypageDTO.setMemberPw(memberPw);
			return sqlSession.selectList("mypage.myprofile", mypageDTO);
			
		}
}
