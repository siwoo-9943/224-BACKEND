package com.pj224.app.subway;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SubwayFrontController
 */
@WebServlet("/SubwayFrontController")
public class SubwayFrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SubwayFrontController() {
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
	
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Subway 서블릿 실행");

		// request.getContextPath() URL루트경로를 의미
		System.out.println(request.getContextPath());

		// request.getRequestURI 현재 요청의 URI를 의미
		System.out.println(request.getRequestURI());

		// 전체 URI에서 ContextPath를 제외시킨 부분만 변수에 저장(분기처리할 때 비교할 변수로 사용)
		String target = request.getRequestURI().substring(request.getContextPath().length());
		System.out.println(target);
		
		switch (target) {
		case "/subway/subway-route.sw":
			System.out.println("2호선노선도");
			request.getRequestDispatcher("/app/subway/subway-route.jsp").forward(request, response);
			break;
		case "/subway/subway-schedule.sw":
			System.out.println("2호선배차시간");
			request.getRequestDispatcher("/app/subway/subway-schedule.jsp").forward(request, response);
			break;

		default:
			break;
		}
		
		
	}

}
