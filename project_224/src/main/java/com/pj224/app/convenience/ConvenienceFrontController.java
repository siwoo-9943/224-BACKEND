package com.pj224.app.convenience;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ConvenienceFrontController
 */
@WebServlet("/ConvenienceFrontController")
public class ConvenienceFrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConvenienceFrontController() {
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
	
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println(request.getContextPath());
		System.out.println(request.getRequestURI());
		
		String target = request.getRequestURI().substring(request.getContextPath().length());
		System.out.println("타겟들어옴?: " + target);
		
		switch(target) {
		case "/convenience/conv-main.cv":
			System.out.println("편의쪽 들어옴?");
			request.getRequestDispatcher("/app/convenience/conv-main.jsp").forward(request, response);
			break;
		case "/convenience/conv-storage.cv":
			System.out.println("물품쪽 들어옴?");
			request.getRequestDispatcher("/app/convenience/conv-storage.jsp").forward(request, response);
			break;
		case "/convenience/conv-gangmap.cv":
			System.out.println("강남지도 들어옴?");
			request.getRequestDispatcher("/app/convenience/conv-gangmap.jsp").forward(request, response);
			break;
		case "/convenience/conv-jamsilmap.cv":
			System.out.println("잠실지도 들어옴?");
			request.getRequestDispatcher("/app/convenience/conv-jamsilmap.jsp").forward(request, response);
			break;
		case "/convenience/conv-hongdaemap.cv":
			System.out.println("홍대지도 들어옴?");
			request.getRequestDispatcher("/app/convenience/conv-hongdaemap.jsp").forward(request, response);
			break;
		case "/convenience/conv-seongsumap.cv":
			System.out.println("성수지도 들어옴?");
			request.getRequestDispatcher("/app/convenience/conv-seongsumap.jsp").forward(request, response);
			break;
		case "/convenience/conv-moonraemap.cv":
			System.out.println("문래지도 들어옴?");
			request.getRequestDispatcher("/app/convenience/conv-moonraemap.jsp").forward(request, response);
			break;
		case "/convenience/conv-euljiromap.cv":
			System.out.println("을지로지도 들어옴?");
			request.getRequestDispatcher("/app/convenience/conv-euljiromap.jsp").forward(request, response);
			break;	
		case "/convenience/conv-storage-gangnam.cv":
			System.out.println("강남물품보관 들어옴?");
			request.getRequestDispatcher("/app/convenience/conv-storage-gangnam.jsp").forward(request, response);
			break;
		case "/convenience/conv-storage-jamsil.cv":
			System.out.println("잠실물품보관 들어옴?");
			request.getRequestDispatcher("/app/convenience/conv-storage-jamsil.jsp").forward(request, response);
			break;
		case "/convenience/conv-storage-hongdae.cv":
			System.out.println("홍대물품보관 들어옴?");
			request.getRequestDispatcher("/app/convenience/conv-storage-hongdae.jsp").forward(request, response);
			break;
		case "/convenience/conv-storage-seongsu.cv":
			System.out.println("성수물품보관 들어옴?");
			request.getRequestDispatcher("/app/convenience/conv-storage-seongsu.jsp").forward(request, response);
			break;
		case "/convenience/conv-storage-moonrae.cv":
			System.out.println("문래물품보관 들어옴?");
			request.getRequestDispatcher("/app/convenience/conv-storage-moonrae.jsp").forward(request, response);
			break;
		case "/convenience/conv-storage-euljiro.cv":
			System.out.println("을지로물품보관 들어옴?");
			request.getRequestDispatcher("/app/convenience/conv-storage-euljiro.jsp").forward(request, response);
			break;
		}
		
	}
}
