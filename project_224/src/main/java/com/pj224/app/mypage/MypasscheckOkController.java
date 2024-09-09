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
			
	      // 인코딩 설정확인
	      request.setCharacterEncoding("UTF-8");

	      // MypageDTO와 DAO 객체 생성
	      MypageDAO mypageDAO = new MypageDAO();
	      String memberEmail = request.getParameter("memberEmail");
	      String memberPw = request.getParameter("memberPw");
	      MypageDTO mypage = mypageDAO.login(memberEmail, memberPw);
	      Result result =  new Result();
	      
	      System.out.println(mypage);
	      
	      if(mypage != null) {
	    	HttpSession session = request.getSession();
	    	session.setAttribute("mypage", mypage);
	    	
	    	Cookie cookie = new Cookie("memberEmail", memberEmail);
	    	cookie.setMaxAge(60 * 60 * 24); // 쿠키 유효기간 1일
			 response.addCookie(cookie);
			 
			 System.out.println("비밀번호 확인 성공");
//			 result.setPath(request.getContextPath() + "/main.jsp"); // 로그인 성공 후 메인페이지로 이동
			 result.setRedirect(true);
			 } else{
			 System.out.println("비밀번호 확인 실패");
			 result.setPath(request.getContextPath() + "/app/mypage/my-update.jsp"); // 로그인 실패시 로그인 페이지로 이동
			 result.setRedirect(true);
			 
			}
	      
	      
	      return result;
	}
	

}
