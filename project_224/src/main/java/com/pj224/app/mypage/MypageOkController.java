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
