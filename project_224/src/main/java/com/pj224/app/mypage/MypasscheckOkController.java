package com.pj224.app.mypage;

import java.io.IOException;
import java.io.PrintWriter;
import java.rmi.ServerException;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.pj224.app.MemExecute;
import com.pj224.app.Result;
import com.pj224.app.dao.MypageDAO;
import com.pj224.app.dto.MypageDTO;

public class MypasscheckOkController implements MemExecute{

	@Override
	public Result MemExecute(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServerException {
		
			System.out.println("비밀번호 확인 실행");
		
	      // 인코딩 설정확인
	      request.setCharacterEncoding("UTF-8");

	      // MypageDTO와 DAO 객체 생성
	      MypageDAO mypageDAO = new MypageDAO();
	      String memberEmail = request.getParameter("memberEmail");
	      String memberPw = request.getParameter("memberPw");
	      String mypage = mypageDAO.pwOk(memberEmail, memberPw);
	      Result result =  new Result();
	      
	      System.out.println(mypage + "값 확인");
	      
	      if(mypage != true) {
			 
			 System.out.println("비밀번호 확인 성공");
			 request.getRequestDispatcher(request.getContextPath() + "/app/mypage/my-update.jsp"); // 로그인 성공 후 메인페이지로 이동
			 result.setRedirect(true);
			 } else{
			 System.out.println("비밀번호 확인 실패");
			 response.sendRedirect(request.getContextPath() + "/app/mypage/my-passcheck.jsp"); // 비밀번호찾기 값 없을시 재입력
			 result.setRedirect(true);
			 
			}
	      
	      
	      return result;
	}
	

}
