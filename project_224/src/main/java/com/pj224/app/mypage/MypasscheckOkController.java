package com.pj224.app.mypage;

import java.io.IOException;
import java.rmi.ServerException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pj224.app.MemExecute;
import com.pj224.app.Result;
import com.pj224.app.dao.MemberDAO;
import com.pj224.app.dao.MypageDAO;
import com.pj224.app.dto.MemberDTO;
import com.pj224.app.dto.MypageDTO;

public class MypasscheckOkController implements MemExecute{

	@Override
	public Result MemExecute(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServerException {
			
	      // 인코딩 설정확인
	      request.setCharacterEncoding("UTF-8");

	      // MemberDTO와 DAO 객체 생성
	      MypageDAO mypageDAO = new MypageDAO();
	      String memberEmail = request.getParameter("memberEmail");
	      String memberPw = request.getParameter("memberPw");
	      MypageDTO mypage = mypageDAO.login(memberEmail, memberPw);
	      Result result =  new Result();
	      
	      System.out.println(mypage);
	      
	      return result;
	}
	

}
