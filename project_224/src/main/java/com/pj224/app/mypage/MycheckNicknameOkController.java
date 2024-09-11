package com.pj224.app.mypage;

import java.io.IOException;
import java.io.PrintWriter;
import java.rmi.ServerException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pj224.app.MemExecute;
import com.pj224.app.Result;
import com.pj224.app.dao.MypageDAO;

public class MycheckNicknameOkController implements MemExecute{

	@Override
	public Result MemExecute(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServerException, ServletException {
		
		MypageDAO mypageDAO = new MypageDAO();
		boolean isTrue = mypageDAO.MycheckNicknameOk(request.getParameter("Nick"));
		String result = null;
		
		System.out.println("MycheckNicknameOkController");

		// PrintWriter 가져오기 전에 설정해야함
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();

		System.out.println(request.getParameter("Nick"));

		if (isTrue) {
			result = "사용가능";
		} else {
			result = "중복된 닉네임";
		}

		out.print(result);
		out.close();

		return null;
	}

}
