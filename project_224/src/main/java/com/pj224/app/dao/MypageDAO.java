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
	   public boolean pwOk(String memberEmail, String memberPw) {
		    System.out.println("아이디, 비밀번호 확인 페이지 다오 실행");

		    // MypageDTO 객체 생성 및 설정
		    MypageDTO mypageDTO = new MypageDTO();
		    mypageDTO.setMemberEmail(memberEmail);
		    mypageDTO.setMemberPw(memberPw);

		    // SQL 쿼리 실행 및 결과 확인
		    // 쿼리에서 비밀번호를 확인하여 사용자 정보를 반환하거나, 비밀번호가 일치하지 않으면 null 반환
		    MypageDTO result = sqlSession.selectOne("mypage.myprofile", mypageDTO);

		    // 결과가 null이 아니면 비밀번호가 일치하는 것으로 간주
		    return result != null;
		}
}
