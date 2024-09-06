package com.pj224.app.community;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pj224.app.Result;

/**
 * Servlet implementation class CommunityFrontController
 */

public class CommunityFrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CommunityFrontController() {
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
		doProcess(request, response);

	}

	protected void doProcess(HttpServletRequest request, HttpServletResponse response)
	        throws ServletException, IOException {
		
		
		
		System.out.println(request.getContextPath());
		
		System.out.println(request.getRequestURI());

	    String target = request.getRequestURI().substring(request.getContextPath().length());
	    System.out.println(target);

	    Result result = null;
	    boolean isForwarded = false;

	    switch (target) {
	        case "/community/comu-main.cm":
	            System.out.println("프컨들어옴");
	            new CommunityListOkController().execute(request, response);
	            request.getRequestDispatcher("/app/community/comu-main.jsp").forward(request, response);
	            isForwarded = true;
	            break;
	        case "/community/comu-write.cm":
	            System.out.println("글작성들어옴?");
	            result = new CommunityWriteOkController().MemExecute(request, response);
	            break;
	        case "/community/comu-detail.cm":
	            System.out.println("디테일 들어왔니?");
	            request.getRequestDispatcher("/app/community/comu-detail.jsp").forward(request, response);
	            isForwarded = true;
	            break;
	    }

	    if (!isForwarded && result != null) {
	        if (result.isRedirect()) {
	            response.sendRedirect(result.getPath());
	        } else {
	            request.getRequestDispatcher(result.getPath()).forward(request, response);
	        }
	    }
	}
}