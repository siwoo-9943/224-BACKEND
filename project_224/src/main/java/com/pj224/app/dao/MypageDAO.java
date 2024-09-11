package com.pj224.app.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.mybatis.config.MyBatisConfig;
import com.pj224.app.dto.MemberDTO;
import com.pj224.app.dto.MypageDTO;

public class MypageDAO {
	private static SqlSession sqlSession;

	public MypageDAO() {
		sqlSession = MyBatisConfig.getSqlSessionFactory().openSession(true);
	}

	// 내 프로필
	public String myprofile(String memberEmail, String memberName, String memberNickName, String memberPhone,
			String memberGender, String memberBirth) {
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
		boolean result = (Integer) sqlSession.selectOne("mypage.pwOk", mypageDTO) <= 0;

		// 결과가 null이 아니면 비밀번호가 일치하는 것으로 간주
		return result;
	}
	
	//닉네임 중복값 확인
	public boolean MycheckNicknameOk(String memberNickname) {
		System.out.println("닉네임 중복체크 메소드 확인");
		return (Integer) sqlSession.selectOne("mypage.MycheckNicknameOk", memberNickname) <= 0;
	}
	

	//개인정보 업데이트
	public int MypageUpdate(String memberNumber,String memberNickName, String memberPw, String memberName, String memberPhone,
			String memberGender, String memberBirth, String memberTerms) {
		
		System.out.println("업데이트 다오 확인");
		
		MypageDTO mypageDTO = new MypageDTO();
		
		 try {
		        if (memberNumber != null && !memberNumber.isEmpty()) {
		            int memberNumber2 = Integer.parseInt(memberNumber);
		            mypageDTO.setMemberNumber(memberNumber2);
		        } else {
		            throw new IllegalArgumentException("memberNumber는 null 또는 빈 문자열일 수 없습니다.");
		        }
		    } catch (NumberFormatException e) {
		        System.err.println("memberNumber 형변환 실패: " + e.getMessage());
		        return 0; // 적절한 에러 처리
		    }

//		int memberNumber2 = Integer.parseInt(memberNumber);
//		System.out.println(memberNumber2);
//		mypageDTO.setMemberNumber(memberNumber2);
        mypageDTO.setMemberNickName(memberNickName);
        mypageDTO.setMemberPw(memberPw);
        mypageDTO.setMemberName(memberName);
        mypageDTO.setMemberPhone(memberPhone);
        mypageDTO.setMemberGender(memberGender);
        mypageDTO.setMemberBirth(memberBirth);
        mypageDTO.setMemberTerms(memberTerms);
		
		return sqlSession.update("mypage.MypageUpdate", mypageDTO);
	}
	
	//쿠키 세션(로그인시 사용)
		public int  UpdateOk(String memberNumber) {
			MypageDTO mypageDTO = new MypageDTO();
			
			 try {
			        if (memberNumber != null && !memberNumber.isEmpty()) {
			            int memberNumber2 = Integer.parseInt(memberNumber);
			            System.out.println(memberNumber2);
			            mypageDTO.setMemberNumber(memberNumber2);
			        } else {
			            throw new IllegalArgumentException("memberNumber는 null 또는 빈 문자열일 수 없습니다.");
			        }
			    } catch (NumberFormatException e) {
			        System.err.println("memberNumber 형변환 실패: " + e.getMessage());
			        return 0; // 적절한 에러 처리
			    }
			 
			 mypageDTO.setMemberNumber(memberNumber2);
		      
			 return 1;
		}


	}

