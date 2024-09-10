package com.pj224.app.mypage;

import java.io.IOException;
import java.io.PrintWriter;
import java.rmi.ServerException;

import javax.servlet.ServletException;
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
			throws IOException, ServletException {
		
			System.out.println("비밀번호 확인 실행");
		
	      // 인코딩 설정확인
	      request.setCharacterEncoding("UTF-8");

	      // MypageDTO와 DAO 객체 생성
	      MypageDAO mypageDAO = new MypageDAO();
	      String memberEmail = request.getParameter("memberEmail");
	      String memberPw = request.getParameter("memberPw");
	      boolean isPasswordCorrect = mypageDAO.pwOk(memberEmail, memberPw);
	      Result result =  new Result();
	      
	      System.out.println(isPasswordCorrect + "값 확인");
	      
	      if(isPasswordCorrect) {
			 
			 System.out.println("비밀번호 확인 성공");
			 request.getRequestDispatcher("/app/mypage/my-update.jsp").forward(request, response);
	            result.setRedirect(false); // 포워딩이므로 false
	        } else {
	            System.out.println("비밀번호 확인 실패");
	            // 실패 페이지로 리다이렉트
	            response.sendRedirect(request.getContextPath() + "/app/mypage/my-passcheck.jsp");
	            result.setRedirect(true); // 리다이렉트이므로 true
			}
	      
	      
	      return result;
	}
	

}
