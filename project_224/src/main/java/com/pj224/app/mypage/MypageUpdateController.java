package com.pj224.app.mypage;

import java.io.IOException;
import java.rmi.ServerException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pj224.app.MemExecute;
import com.pj224.app.Result;
import com.pj224.app.dao.MemberDAO;
import com.pj224.app.dao.MypageDAO;

public class MypageUpdateController implements MemExecute {

	@Override
	public Result MemExecute(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServerException, ServletException {

		System.out.println("정보 업데이트 컨트롤러 실행");

		// 인코딩 설정확인
		request.setCharacterEncoding("UTF-8");

		// MemberDTO와 DAO 객체 생성
		MypageDAO mypageDAO = new MypageDAO();
		
		String memberNumber = request.getParameter("memberNumber");
		String memberNickName = request.getParameter("memberNickname");
		String memberPw = request.getParameter("memberPw");
		String memberName = request.getParameter("memberName");
		String memberPhone = request.getParameter("memberPhone");
		String memberGender = request.getParameter("memberGender");
		String memberBirth = request.getParameter("memberBirth");
		String memberTerms = request.getParameter("memberTerms");
		System.out.println(memberNumber +"넘버 값 들어오셈");
		System.out.println(memberNickName + "닉네임 들어오는지 확인");
		System.out.println(memberPw +"비번 값 들어오셈");
		System.out.println(memberName +"이름 값 들어오셈");
		System.out.println(memberPhone +"번호 값 들어오셈");
		System.out.println(memberGender +"성별 값 들어오셈");
		System.out.println(memberBirth + "생일 들어오는지 확인");
		System.out.println(memberTerms + "동의 들어오는지 확인");

		int result = mypageDAO.MypageUpdate(memberNumber, memberNickName, memberPw, memberName, memberPhone, memberGender, memberBirth, memberTerms);

        if (result > 0) {
            System.out.println("정보 업데이트 성공");
            response.sendRedirect(request.getContextPath() + "/app/mypage/my-profile.jsp");
        } else {
            System.out.println("정보 업데이트 실패ㅠ");
            request.setAttribute("error", "정보 업데이트에 실패했습니다.");
            request.getRequestDispatcher("/app/mypage/my-update.jsp").forward(request, response);
        }

        return null;
	}


	}


