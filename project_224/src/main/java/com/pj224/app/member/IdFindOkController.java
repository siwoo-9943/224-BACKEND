package com.pj224.app.member;

import java.io.IOException;
import java.rmi.ServerException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pj224.app.MemExecute;
import com.pj224.app.Result;
import com.pj224.app.dao.MemberDAO;
import com.pj224.app.dto.MemberDTO;

public class IdFindOkController implements MemExecute{

	@Override
	public Result MemExecute(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServerException {
		
		//컨트롤러 실행확인
		System.out.println("IdFindOkController 실행");
		
		// 인코딩 설정확인
		request.setCharacterEncoding("UTF-8");
		
		// MemberDTO와 DAO 객체 생성
		MemberDAO memberDAO = new MemberDAO();
		String memberName = request.getParameter("memberName");
		String memberPhone = request.getParameter("memberPhone");
		String memberPhoneInput = request.getParameter("memberPhoneInput");
		MemberDTO member = memberDAO.idFind(memberName, memberPhone, memberPhoneInput);
		Result result =  new Result();
		
		System.out.println(member + " 입력값 확인");

		return null;
	}
	
	

}
