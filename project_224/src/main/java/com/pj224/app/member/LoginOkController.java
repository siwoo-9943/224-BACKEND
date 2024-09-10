package com.pj224.app.member;

import java.io.IOException;
import java.rmi.ServerException;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.pj224.app.MemExecute;
import com.pj224.app.Result;
import com.pj224.app.dao.MemberDAO;
import com.pj224.app.dto.MemberDTO;

public class LoginOkController implements MemExecute {

	@Override
	public Result MemExecute(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServerException {
		//컨트롤러 실행확인
		System.out.println("loginOkController 실행");
		
		// 인코딩 설정확인
		request.setCharacterEncoding("UTF-8");

		// MemberDTO와 DAO 객체 생성
		MemberDAO memberDAO = new MemberDAO();
		String memberEmail = request.getParameter("memberEmail");
		String memberPw = request.getParameter("memberPw");
		Object member = memberDAO.login(memberEmail, memberPw);
		Result result =  new Result();
		
		System.out.println(member);

		 if(member!= null) {
		 // 로그인 성공시 세션에 사용자 정보 저장
		 HttpSession session = request.getSession();
		 session.setAttribute("member", member);

		 // 쿠키에 사용자 ID 저장
		 Cookie cookie = new Cookie("memberEmail", memberEmail);
		 cookie.setMaxAge(60 * 60 * 24); // 쿠키 유효기간 1일
		 response.addCookie(cookie);

		 
		 System.out.println("로그인성공");
		 result.setPath(request.getContextPath() + "/main.mn"); // 로그인 성공 후 메인페이지로 이동
		 result.setRedirect(true);
		 } else{
		 System.out.println("로그인실패");
		 result.setPath(request.getContextPath() + "/app/member/mem-login.jsp"); // 로그인 실패시 로그인 페이지로 이동
		 result.setRedirect(true);
		 
		}

		 return result;
	}
}
