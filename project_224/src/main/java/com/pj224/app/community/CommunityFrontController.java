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
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
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

		// 로그로 요청 경로와 URI 확인
		System.out.println(request.getContextPath());
		System.out.println(request.getRequestURI());

		String target = request.getRequestURI().substring(request.getContextPath().length());
		System.out.println("타겟들어옴?: " + target);

		Result result = null;
		boolean isForwarded = false;

		switch (target) {
		case "/community/comu-main.cm":
			System.out.println("프컨 들어옴");
			new CommunityListOkController().execute(request, response);
			request.getRequestDispatcher("/app/community/comu-main.jsp").forward(request, response);
			isForwarded = true;
			break;

		case "/community/comu-write.cm":
			System.out.println("글 작성 들어옴?");
			request.getRequestDispatcher("/app/community/comu-write.jsp").forward(request, response);
			break;
		case "/community/comu-writeOk.cm":
			System.out.println("Ok로들어왔냐??!!!");
			result = new CommunityWriteOkController().MemExecute(request, response);
			break;
		case "/community/comu-detail.cm":
			System.out.println("디테일 들어옴");
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