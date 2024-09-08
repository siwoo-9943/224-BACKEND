package com.pj224.app.member;

import java.io.IOException;
import java.io.PrintWriter;
import java.rmi.ServerException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pj224.app.MemExecute;
import com.pj224.app.Result;
import com.pj224.app.dao.MemberDAO;

public class CheckEmailController implements MemExecute {

	@Override
	public Result MemExecute(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServerException {
		
		MemberDAO memberDAO = new MemberDAO();
		boolean isTrue = memberDAO.checkEmail(request.getParameter("email"));
		String result = null;
		
		System.out.println("checkEmailController");

		// PrintWriter 가져오기 전에 설정해야함
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();

		System.out.println(request.getParameter("email"));

		if (isTrue) {
			result = "사용가능";
		} else {
			result = "중복된 아이디";
		}

		out.print(result);
		out.close();

		return null;
	}

}
