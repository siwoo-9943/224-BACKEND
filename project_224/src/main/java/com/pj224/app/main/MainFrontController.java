package com.pj224.app.main;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pj224.app.Result;
import com.pj224.app.dto.MainDTO;

/**
 * Servlet implementation class MainFrontController
 */
//@WebServlet("/MainFrontController")
public class MainFrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MainFrontController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		doProcess(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		doGet(request, response);
		doProcess(request, response);
	}
	
	protected void doProcess (HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException{
		System.out.println("Main 서블릿 실행");

		// request.getContextPath() URL루트경로를 의미
		System.out.println(request.getContextPath());

		// request.getRequestURI 현재 요청의 URI를 의미
		System.out.println(request.getRequestURI());

		// 전체 URI에서 ContextPath를 제외시킨 부분만 변수에 저장(분기처리할 때 비교할 변수로 사용)
		String target = request.getRequestURI().substring(request.getContextPath().length());
		System.out.println(target);

		Result result = null; // Result 클래스 객체
		
		switch (target) {
		case "/main.mn":
			System.out.println("main페이지이동");
			request.getRequestDispatcher("main.jsp").forward(request, response);
			break;
		case "/main-search.mn":
			System.out.println("검색페이지이동");
			result = new MainSearchController().MemExecute(request, response);
			System.out.println("검색어결과");
		    request.getRequestDispatcher("main-search.jsp").forward(request, response);
		    System.out.println("페이지이동");
			break;
		case "/member/mem-login.me":
			System.out.println("로그인");
//			request.getRequestDispatcher("/app/member/mem-login.jsp").forward(request, response);
			result = new MainLoginController().MemExecute(request, response);
//			request.getRequestDispatcher("/app/member/mem-login.jsp").forward(request, response);
			System.out.println("로그아웃!");
			break;
		case "/member/main/logout.mn":
			System.out.println("로그아웃");
			result = new MainLogoutController().MemExecute(request, response);
//			request.getRequestDispatcher("main.jsp").forward(request, response);
			break;
		case "":
			System.out.println("?");
			break;

		default:
			break;
		}

		
		
		
		
		
		
	}

}
