package com.pj224.app.member;

import java.io.IOException;
import java.rmi.ServerException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pj224.app.MemExecute;
import com.pj224.app.Result;
import com.pj224.app.dao.MemberDAO;

public class PwUpdateController implements MemExecute {

	@Override
	public Result MemExecute(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServerException, ServletException {

		// 컨트롤러 실행확인
		System.out.println("비밀번호 찾기 확인 컨트롤러 실행");

		// 인코딩 설정확인
		request.setCharacterEncoding("UTF-8");

		// MemberDTO와 DAO 객체 생성
		MemberDAO memberDAO = new MemberDAO();
		String memberEmail = request.getParameter("memberEmail");
		System.out.println(memberEmail + "값 들어오는지 확인");
		String memberPw = request.getParameter("memberPw");
		System.out.println(memberPw + "비밀번호값");
		
		int member = memberDAO.pwUpdate(memberEmail, memberPw);
		System.out.println(member);

		Result result = new Result();

		if (member != 0) {
			System.out.println("비밀번호변경 성공");
			
			response.sendRedirect(request.getContextPath() + "/main.jsp");
			result.setRedirect(true);
		} else {
			System.out.println("비밀번호변경실패ㅠ");
			
			request.getRequestDispatcher("/app/member/mem-pwfine-result.jsp").forward(request, response);
			result.setRedirect(true);
		}

		return result;
	}

}
