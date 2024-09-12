package com.pj224.app.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.mybatis.config.MyBatisConfig;
import com.pj224.app.dto.HotplaceDTO;
import com.pj224.app.dto.MemberDTO;
import com.pj224.app.dto.MypageDTO;

public class MypageDAO {
	private static SqlSession sqlSession;

	public MypageDAO() {
		sqlSession = MyBatisConfig.getSqlSessionFactory().openSession(true);
	}

	// 내 프로필
	public String myprofile(String memberEmail, String memberName, String memberNickname, String memberPhone,
			String memberGender, String memberBirth) {
		System.out.println("내 프로필 다오 실행");
		MypageDTO mypageDTO = new MypageDTO();
		mypageDTO.setMemberEmail(memberEmail);
		mypageDTO.setMemberName(memberName);
		mypageDTO.setmemberNickname(memberNickname);
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

	// 닉네임 중복값 확인
	public boolean MycheckNickNameOk(String memberNickname) {
		System.out.println("닉네임 중복체크 메소드 확인");
		return (Integer) sqlSession.selectOne("mypage.MycheckNicknameOk", memberNickname) <= 0;
	}

//	//개인정보 업데이트
	public int MypageUpdate(String memberNumber, String memberNickname, String memberPw, String memberName,
			String memberPhone, String memberGender, String memberBirth, String memberTerms) {

		System.out.println("업데이트 다오 확인");

		MypageDTO mypageDTO = new MypageDTO();

		try {
			if (memberNumber != null && !memberNumber.isEmpty()) {
				int memberNumber2 = Integer.parseInt(memberNumber);
				mypageDTO.setMemberNumber(memberNumber2);
				System.out.println("업데이트 다오 확인 들어오삼");
			} else {
				throw new IllegalArgumentException("memberNumber는 null 또는 빈 문자열일 수 없습니다.");
			}
		} catch (NumberFormatException e) {
			System.err.println("memberNumber 형변환 실패: " + e.getMessage());
			return 0; // 적절한 에러 처리
		}

		mypageDTO.setmemberNickname(memberNickname);
		mypageDTO.setMemberPw(memberPw);
		mypageDTO.setMemberName(memberName);
		mypageDTO.setMemberPhone(memberPhone);
		mypageDTO.setMemberGender(memberGender);
		mypageDTO.setMemberBirth(memberBirth);
		mypageDTO.setMemberTerms(memberTerms);

		return sqlSession.update("mypage.MypageUpdate", mypageDTO);
	}

	// 쿠키 세션(로그인시 사용)
	public Object UpdateOk(String memberNumber) {
		MypageDTO mypageDTO = new MypageDTO();

		try {
			if (memberNumber != null && !memberNumber.isEmpty()) {
				int memberNumber2 = Integer.parseInt(memberNumber);
				System.out.println(memberNumber2 + "멤버번호 너만 들어오면 돼,,");
				mypageDTO.setMemberNumber(memberNumber2);
			} else {
				throw new IllegalArgumentException("memberNumber는 null 또는 빈 문자열일 수 없습니다.");
			}
		} catch (NumberFormatException e) {
			System.err.println("memberNumber 형변환 실패: " + e.getMessage());
			return null; // 적절한 에러 처리
		}

		// 데이터베이스에서 사용자 정보를 조회
		return sqlSession.selectOne("mypage.MypageUpdateOk", mypageDTO);

	}

	// 회원 번호로 회원 정보 조회 이번에 수정한 거임
	public MypageDTO getMemberByNumber(String memberNumber) {
		System.out.println("회원 번호로 회원 정보 조회");

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
			return null; // 적절한 에러 처리
		}

		// 데이터베이스에서 사용자 정보를 조회
		return sqlSession.selectOne("mypage.MypageUpdateOk", mypageDTO);
	}

	public boolean delete(String memberNumberStr) {
		
			System.out.println("회원탈퇴 조회");
			
			MypageDTO mypageDTO = new MypageDTO();
			try {
				if (memberNumberStr != null && !memberNumberStr.isEmpty()) {
					int memberNumber2 = Integer.parseInt(memberNumberStr);
					mypageDTO.setMemberNumber(memberNumber2);
				} else {
					throw new IllegalArgumentException("memberNumber는 null 또는 빈 문자열일 수 없습니다.");
				}
			} catch (NumberFormatException e) {
				System.err.println("memberNumber 형변환 실패: " + e.getMessage());
			}
			int result2 = sqlSession.delete("mypage.memberDelete", mypageDTO);
			return result2 <= 0;

}
	//내가 찜한 목록
	public List<HotplaceDTO> mylikelist(int memberNumber){
		System.out.println("리스트 잘 들어왔니");
		return sqlSession.selectList("mypage.mypick",memberNumber);
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
