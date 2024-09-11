package com.pj224.app.member;

import java.io.IOException;
import java.rmi.ServerException;
import java.sql.Date;
import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pj224.app.MemExecute;
import com.pj224.app.Result;
import com.pj224.app.dao.MemberDAO;
import com.pj224.app.dto.MemberDTO;

public class JoinOkController implements MemExecute {

	@Override
	public Result MemExecute(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServerException {
		//컨트롤러 실행확인
		System.out.println("회원가입 컨트롤러 실행");
		
		// 인코딩 설정확인
		request.setCharacterEncoding("UTF-8");

		// MemberDTO와 DAO 객체 생성
		MemberDTO memberDTO = new MemberDTO();
		MemberDAO memberDAO = new MemberDAO();
		Result result = new Result();

		// 폼데이터 받아오기/
		memberDTO.setMemberEmail(request.getParameter("memberEmail"));
		memberDTO.setMemberPw(request.getParameter("memberPw"));
		memberDTO.setMemberName(request.getParameter("memberName"));
		memberDTO.setMemberNickname(request.getParameter("memberNickname"));
		memberDTO.setMemberPhone(request.getParameter("memberPhone"));
		memberDTO.setMemberPhoneInput(request.getParameter("memberPhoneInput"));
		memberDTO.setMemberGender(request.getParameter("memberGender"));
		memberDTO.setMemberBirth(request.getParameter("memberBirth"));
		memberDTO.setMemberTerms(request.getParameter("memberTerms"));
		
		

		// 디버깅용 로그 출력
		System.out.println("디버깅용 로그 MemberDTO : " + memberDTO);

		// 데이터베이스에 회원 정보 저장
		memberDAO.join(memberDTO);
		System.out.println("저장완료");
		
		//
		

		// 결과처리
		result.setRedirect(true);
		//회원가입완료 후 메인페이지로 이동 왜 안될까
//		response.sendRedirect(request.getContextPath() + "/main.jsp");
		
		
	    
		return result;
	}

}
