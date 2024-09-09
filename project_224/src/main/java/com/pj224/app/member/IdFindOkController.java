package com.pj224.app.member;

import java.io.IOException;
import java.rmi.ServerException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.pj224.app.MemExecute;
import com.pj224.app.Result;
import com.pj224.app.dao.MemberDAO;
import com.pj224.app.dto.MemberDTO;

public class IdFindOkController implements MemExecute {

	@Override
	public Result MemExecute(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServerException, ServletException {

		// 컨트롤러 실행확인
		System.out.println("아이디 찾기 확인 컨트롤러 실행");

		// 인코딩 설정확인
		request.setCharacterEncoding("UTF-8");

		// MemberDTO와 DAO 객체 생성
		MemberDAO memberDAO = new MemberDAO();
		String memberName = request.getParameter("memberName");
		String memberPhone = request.getParameter("memberPhone");
		String memberPhoneInput = request.getParameter("memberPhoneInput");
		boolean member = memberDAO.idFind(memberName, memberPhone, memberPhoneInput);
		Result result = new Result();

		System.out.println(member + " 입력값 확인");

		// 입력값이 디비에 존재하는지 확인
		if (member != true) {
			System.out.println("아이디 찾기 성공");
			
			String member2 = memberDAO.idFindResult(memberName, memberPhone, memberPhoneInput);
			System.out.println(member2 + "보낼값들어오는지확인");
			request.setAttribute("member2", member2);
			
			request.getRequestDispatcher(request.getContextPath() + "/app/member/mem-idfine-result.jsp").forward(request, response); // 아이디 찾기 성공 후 프컨타고 아이디결과페이지로 이동
			result.setRedirect(true);
		} else {
			System.out.println("아이디 찾기 실패");
			response.sendRedirect(request.getContextPath() + "/app/member/mem-id-find.jsp"); // 로그인 실패시 아이디찾기 페이지로 이동
			result.setRedirect(true);
		}

		return result;
	}

}
