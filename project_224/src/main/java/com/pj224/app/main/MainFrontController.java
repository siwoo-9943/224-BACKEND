package com.pj224.app.main;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.pj224.app.Result;

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
		
		HttpSession session = request.getSession();
		Integer memberNumber = (Integer) session.getAttribute("memberNumber");
		System.out.println("세션에 저장된 회원번호 : " + session.getAttribute("memberNumber"));
	      System.out.println("로그인 회원번호 : " + memberNumber);
	      //로그인했을때 세션쿠키에서 memberNumber

		Result result = null; // Result 클래스 객체
		
		switch (target) {
		case "/main.mn":
			System.out.println("핫플 컨텐츠");
			result = new MainHpListController().MemExecute(request, response);
			//아래 실행 안됨
//			if (memberNumber != null) {	
			System.out.println("로그인 일때 찜목록 체크");
				result = new MainLikeController().MemExecute(request, response);
				System.out.println("체크?");
//			}
			System.out.println("커뮤니티 컨텐츠");
			result = new MainComuListController().MemExecute(request, response);
			System.out.println("main페이지이동");
			request.getRequestDispatcher("main.jsp").forward(request, response);
			break;
		case "/main-search.mn":
			System.out.println("검색페이지이동");
			result = new SearchComuController().MemExecute(request, response);
			System.out.println("검색어커뮤결과");
			result = new SearchHotController().MemExecute(request, response);
			System.out.println("검색어핫플결과");
//			response.sendRedirect("main-search.jsp");
		    request.getRequestDispatcher("main-search.jsp").forward(request, response);
		    System.out.println("페이지이동");
			break;
		case "/logout.mn":
			System.out.println("로그아웃");
			result = new MainLogoutController().MemExecute(request, response);
			break;
			
			
//		case "/pick.mn":
//            System.out.println("찜 하기");
//            result = new MainLikeController().MemExecute(request, response);
//            System.out.println("찜 하기 완료");
//            break;
//        case "/unpick.mn":
//            System.out.println("찜 풀기");
//            result = new MainUnlikeController().MemExecute(request, response);
//            System.out.println("찜 풀기 완료");
//            break;

		default:
			System.out.println("페이지 오류 메인으로 이동합니다");
			request.getRequestDispatcher("main.mn").forward(request, response);
			break;
		}
		
		
    
	}

}
