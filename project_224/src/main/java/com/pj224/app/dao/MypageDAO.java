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
	   

	   //"mypage.my-profile"이라는 id를 가진 sql문 실행,dto를 데이터베이스에 삽입
//	   public void profile(MypageDTO mypageDTO) {
//	      sqlSession.insert("mypage.my-profile", mypageDTO);
//	      System.out.println("값 확인" + mypageDTO);
//	   }
//	   
//	   //memberNumber를 기준으로 사용자 정보 조회하고 반환
//	   public MypageDTO mypage(int memberNumber) {
//	        return sqlSession.selectOne("mypage.getprofile", memberNumber);
//	    }
//	   
//	   public MypageDTO getprofile(String memberEmail, String memberPw) {
//		   MypageDTO mypageDTO = new MypageDTO();
//		   mypageDTO.setMemberEmail(memberEmail);
//		   mypageDTO.setMemberPw(memberPw);
//		   //
//		   return sqlSession.selectOne("mypage.profile", mypageDTO);
//	   }
//
//	public static MemberDTO getProfile(String memberEmail, String memberPw) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
	   //로그인을 위한 메서드
	   public void passcheck(MypageDTO mypageDTO) { 
		      sqlSession.insert("mypage.my-passcheck", mypageDTO);
		      System.out.println("확인 + mypageDTO");
		   }
		   
		   public boolean checkId(String memberId) {
		      //selectOne() 반환타입 Object 타입이라 비교를 위해 Interger로 형 변환
		      //DB에서 memberId가 존재하는지 확인하는 쿼리를 실행하고
		      //존재하면 true, 존재하지 않으면 false를 반환하도록 한다      
		      return (Integer)sqlSession.selectOne("mypage.checkId", memberId) <= 0;
		      //값이 0이하면 아이디가 존재하지 않음 => true 반환
		      //아이디가 존재하면 false 반환
		   }
		   
		   //쿠키/세션 
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
