package com.pj224.app.mypage;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pj224.app.Result;

/**
 * Servlet implementation class MypageFrontController
 */
//@WebServlet("/MypageFrontController")
public class MypageFrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MypageFrontController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doProcess(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doProcess(request, response);
	}
	
	protected void doProcess(HttpServletRequest request, HttpServletResponse response)
	         throws ServletException, IOException {
		System.out.println("Mypage 서블릿 실행");
		
		// request.getContextPath() URL루트경로를 의미
	      System.out.println(request.getContextPath());

	      // request.getRequestURI 현재 요청의 URI를 의미
	      System.out.println(request.getRequestURI());
	      
	   // 전체 URI에서 ContextPath를 제외시킨 부분만 변수에 저장(분기처리할 때 비교할 변수로 사용)
	      String target = request.getRequestURI().substring(request.getContextPath().length());
	      System.out.println(target);

//	      Result result = null; // Result 클래스 객체
	      
	      switch(target) {
	      case"/mypage/my-profile.my" :
	    	  System.out.println("profile");
	    	  request.getRequestDispatcher("/app/mypage/my-profile.jsp").forward(request, response);
	    	  break;
	      case"/mypage/passcheck.my":
	    	  System.out.println("profile");
	    	  request.getRequestDispatcher("/app/mypage/my-passcheck.jsp").forward(request, response);
	          break;
	      case"/mypage/passcheckOk.my" :
	    	  System.out.println("profile 성공");
	    	  break;
	      
	      }
		
		
	}

}
