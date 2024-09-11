package com.pj224.app.member;

import java.io.IOException;
import java.rmi.ServerException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pj224.app.MemExecute;
import com.pj224.app.Result;
import com.pj224.app.dao.MemberDAO;

public class PwFindOkController implements MemExecute {

	@Override
	public Result MemExecute(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServerException, ServletException {

		// 컨트롤러 실행확인
		System.out.println("비밀번호 찾기 확인 컨트롤러 실행");

		// 인코딩 설정확인
		request.setCharacterEncoding("UTF-8");

		// MemberDTO와 DAO 객체 생성
		MemberDAO memberDAO = new MemberDAO();
		String memberName = request.getParameter("memberName");
		String memberEmail = request.getParameter("memberEmail");
		String memberPhone = request.getParameter("memberPhone");
		String memberPhoneInput = request.getParameter("memberPhoneInput");
		boolean member = memberDAO.pwFind(memberEmail, memberName, memberPhone, memberPhoneInput);
		Result result = new Result();
		
		System.out.println(member + " 값 확인");

		// 입력값이 디비에 존재하는지 확인
		if (member != true) {
			System.out.println("비밀번호 찾기 성공");
			
			//비밀번호 찾기 전 인증할때 사용한 이메일 보내주기
			request.setAttribute("memberEmail", memberEmail);
			System.out.println(memberEmail);
			

			request.getRequestDispatcher(request.getContextPath() + "/app/member/mem-pwfine-result.jsp").forward(request, response);
			result.setRedirect(true);
		} else {
			System.out.println("비밀번호 찾기 실패");
			response.sendRedirect(request.getContextPath() + "/app/member/mem-p w-find.jsp"); // 비밀번호찾기 값 없을시 재입력
			result.setRedirect(true);
		}

		return result;

	}

}
