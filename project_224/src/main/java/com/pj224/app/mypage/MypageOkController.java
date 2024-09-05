package com.pj224.app.mypage;

import java.io.IOException;
import java.rmi.ServerException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pj224.app.dao.MypageDAO;
import com.pj224.app.dto.MypageDTO;



public class MypageOkController {

	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServerException {
		MypageDTO mypageDTO = new MypageDTO();
		MypageDAO mypageDAO = new MypageDAO();
		
		request.setCharacterEncoding("UTF-8");
		
		
		mypageDTO.setMemberNumber(Integer.valueOf("memberNumber"));
		mypageDTO.setMemberEmail(request.getParameter("memberEmail"));
		mypageDTO.setMemberPw(request.getParameter("memberPw"));
		mypageDTO.setMemberName(request.getParameter("memberName"));
	      // valueOf()는 문자열을 Integer로 바꿔준다
	      // parseInt()와 차이는 문자열이 숫자가 아닐경우 numberFormatException을 발생시키지만
	      // valueOf()는 null을 반환한다(즉, 예외발생안함)
		mypageDTO.setMemberNickName(request.getParameter("memberNickName"));
		mypageDTO.setMemberPhone(request.getParameter("memberPhone"));
		mypageDTO.setMemberPhoneInput(request.getParameter("memberPhoneInput"));
		mypageDTO.setMemberGender(request.getParameter("memberGender"));
		mypageDTO.setMemberBirth(request.getParameter("memberBirth"));
		mypageDTO.setMemberTerms(request.getParameter("memberTerms"));
		
		
		mypageDAO.profile(mypageDTO);
		
		//회원가입 성공 후 로그인 페이지로 리다이렉트
//		response.sendRedirect(request.getContextPath()+"/member/login.me");
		
		
	}

}
