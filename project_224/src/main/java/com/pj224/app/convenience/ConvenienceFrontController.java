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
		
		
		
		
		}
		
	}
}
