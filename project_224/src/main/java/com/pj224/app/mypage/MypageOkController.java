package com.pj224.app.mypage;

import java.io.IOException;
import java.rmi.ServerException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pj224.app.MemExecute;
import com.pj224.app.Result;
import com.pj224.app.dao.MypageDAO;
import com.pj224.app.dto.MypageDTO;

public class MypageOkController implements MemExecute {

	@Override
	public Result MemExecute(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServerException, ServletException {

		request.setCharacterEncoding("UTF-8");

		System.out.println("내프로필 컨트롤러 실행 확인");

		MypageDTO mypageDTO = new MypageDTO();
		MypageDAO mypageDAO = new MypageDAO();

		String memberEmail = request.getParameter("memberEmail");
		String memberName = request.getParameter("memberName");
		String memberNickName = request.getParameter("memberNickName");
		String memberPhone = request.getParameter("memberPhone");
		String memberGender = request.getParameter("memberGender");
		String memberBirth = request.getParameter("memberBirth");
		String myprofile = mypageDAO.myprofile(memberEmail, memberName, memberNickName, memberPhone, memberGender,
				memberBirth);
		Result result = new Result();

		System.out.println(myprofile);

		// 입력값이 디비에 존재하는지 확인

		System.out.println("내 프로필 성공");

		String mypage1 = mypageDAO.myprofile(memberEmail, memberName, memberNickName, memberPhone, memberGender,
				memberBirth);
		System.out.println(mypage1 + "보낼값들어오는지확인");
		request.setAttribute("mypage1", mypage1);

		request.getRequestDispatcher(request.getContextPath() +"/app/mypage/my-profile.jsp").forward(request, response);;
		return result;

	}

}
