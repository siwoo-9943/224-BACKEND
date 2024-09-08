package com.pj224.app.member;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pj224.app.Result;

/**
 * Servlet implementation class MemberFrontController
 */
public class MemberFrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MemberFrontController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doProcess(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doProcess(request, response);
	}

	protected void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// 서블릿 실행
		System.out.println("서블릿실행");

		// 루트경로 출력
		System.out.println(request.getContextPath() + " path");

		System.out.println(request.getRequestURI() + " URI");

		// 전체 URL 중 루트경로(contextPath)제외한 부분을 target에 저장
		String target = request.getRequestURI().substring(request.getContextPath().length());
		System.out.println(target);

		Result result = null;

		switch (target) {
		case "/member/join.me":
			System.out.println("join");
			request.getRequestDispatcher("/app/member/mem-join.jsp").forward(request, response);
			break;
		case "/member/joinOk.me":
			System.out.println("joinOk");
			new JoinOkController().MemExecute(request, response);
			response.sendRedirect(request.getContextPath() + "/main.jsp");
			break;
		case "/member/login.me":
			System.out.println("login");
			response.sendRedirect(request.getContextPath() + "/app/member/mem-login.jsp");
			break;
		case "/member/loginOk.me":
			System.out.println("loginOk");
			result = new LoginOkController().MemExecute(request, response);
			break;
		case "/member/checkEmailOk.me":
			System.out.println("checkEmailOk");
			new CheckEmailController().MemExecute(request, response);
			break;
		case "/member/checkNicknameOk.me":
			System.out.println("checkNicknameOk");
			new CheckNicknameController().MemExecute(request, response);
			break;
		case "/member/idFindOk.me":
			System.out.println("idFindOk");
			new IdFindOkController().MemExecute(request, response);
			break;
		}

		if (result != null) {
			if (result.isRedirect()) {
				response.sendRedirect(result.getPath());
			} else {
				request.getRequestDispatcher(result.getPath()).forward(request, response);
			}
		}
	}

}
