package com.pj224.app.main;

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

public class MainLoginController implements MemExecute {

	@Override
	public Result MemExecute(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServerException {
		MemberDAO memberDAO = new MemberDAO();
//		String memberId = request.getParameter("memberId");
//		String memberPassword = request.getParameter("memberPassword");
		String memberId = request.getParameter("ADMIN");
		String memberPassword = request.getParameter("ADMIN");
		MemberDTO member = memberDAO.login(memberId, memberPassword);
		Result result = new Result();

		if (member != null) {
			// 로그인 성공시 세션에 사용자 정보 저장
			HttpSession session = request.getSession();
			session.setAttribute("member", member);

			// 쿠키에 사용자 ID 저장
			Cookie cookie = new Cookie("memberId", memberId);
			cookie.setMaxAge(60 * 60 * 24); // 쿠키 유효기간 1일
			response.addCookie(cookie);

			result.setPath(request.getContextPath() + "/main.jsp"); // 로그인 성공 후 메인페이지로 이동
			result.setRedirect(true);
		} else {
			// 로그인 실패시 로그인 페이지로 이동
			result.setPath(request.getContextPath() + "/main.jsp");
			result.setRedirect(true);
		}

		return result;

	}

}
