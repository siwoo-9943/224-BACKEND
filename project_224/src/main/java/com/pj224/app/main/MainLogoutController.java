package com.pj224.app.main;

import java.io.IOException;
import java.rmi.ServerException;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.pj224.app.MemExecute;
import com.pj224.app.Result;

public class MainLogoutController implements MemExecute{

	@Override
	public Result MemExecute(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServerException {
		HttpSession session = request.getSession(false);

		if (session != null) {
			session.invalidate(); // 세션 무효화
			System.out.println("세션 무효화");
		}
		// 쿠키 삭제
		Cookie cookie = new Cookie("memberId", null);
		cookie.setMaxAge(0);
		response.addCookie(cookie);
		System.out.println("쿠키삭제");

		Result result = new Result();
		result.setPath(request.getContextPath() + "/main.jsp");
		result.setRedirect(true);
		System.out.println("/main.jsp로 이동");

		return result;
	}
	
	

}
