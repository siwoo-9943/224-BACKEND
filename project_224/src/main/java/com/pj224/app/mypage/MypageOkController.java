package com.pj224.app.mypage;

import java.io.IOException;
import java.rmi.ServerException;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.pj224.app.Result;
import com.pj224.app.dao.MypageDAO;
import com.pj224.app.dto.MemberDTO;
import com.pj224.app.dto.MypageDTO;



public class MypageOkController {

	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServerException {
		request.setCharacterEncoding("UTF-8");
		
//		MypageDTO mypageDTO = new MypageDTO();
		MypageDAO mypageDAO = new MypageDAO();
		
		String memberEmail = request.getParameter("memberEmail");
		String memberPw = request.getParameter("memberPw");
		MypageDTO mypage = mypageDAO.login(memberEmail, memberPw);
		Result result =  new Result();
		
		System.out.println(mypage);
		
		

		
		
//		mypageDTO.setMemberNumber(Integer.valueOf("memberNumber"));
//		mypageDTO.setMemberEmail(request.getParameter("memberEmail"));
//		mypageDTO.setMemberPw(request.getParameter("memberPw"));
//		mypageDTO.setMemberName(request.getParameter("memberName"));
//		mypageDTO.setMemberNickName(request.getParameter("memberNickName"));
//		mypageDTO.setMemberPhone(request.getParameter("memberPhone"));
//		mypageDTO.setMemberPhoneInput(request.getParameter("memberPhoneInput"));
//		mypageDTO.setMemberGender(request.getParameter("memberGender"));
//		mypageDTO.setMemberBirth(request.getParameter("memberBirth"));
//		mypageDTO.setMemberTerms(request.getParameter("memberTerms"));
		
		
//		mypageDAO.profile(mypageDTO);
		

		response.sendRedirect(request.getContextPath()+"/mypage/my-passcheck.my");
		
		
		
	}

}
