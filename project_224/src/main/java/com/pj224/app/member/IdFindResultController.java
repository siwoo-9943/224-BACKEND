package com.pj224.app.member;

import java.io.IOException;
import java.rmi.ServerException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pj224.app.MemExecute;
import com.pj224.app.Result;
import com.pj224.app.dao.MemberDAO;

public class IdFindResultController implements MemExecute {

	@Override
	public Result MemExecute(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServerException {
		
		//컨트롤러 실행 확인
		System.out.println("아이디 찾기 결과 컨트롤러 실행");
		
		// 인코딩 설정확인
		request.setCharacterEncoding("UTF-8");
		
		// MemberDTO와 DAO 객체 생성
		MemberDAO memberDAO = new MemberDAO();
		String memberName = request.getParameter("memberName");
		String memberPhone = request.getParameter("memberPhone");
		String memberPhoneInput = request.getParameter("memberPhoneInput");
		Result result =  new Result();
		return null;
	}
	
	

}
