package com.pj224.app.notice;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pj224.app.Result;
import com.pj224.app.community.CommunityListOkController;
import com.pj224.app.community.CommunityWriteOkController;
import com.pj224.app.main.MainLoginController;
import com.pj224.app.main.MainLogoutController;
import com.pj224.app.member.LoginOkController;

/**
 * Servlet implementation class NoticeFrontController
 */
public class NoticeFrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public NoticeFrontController() {
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
		String target = request.getRequestURI().substring(request.getContextPath().length());
		Result result = null;
		System.out.println(target);

		switch (target) {
		case "/notice/notice-admain.no":
			System.out.println("글목록");
			result = new NoticeListController().MemExecute(request, response);
			request.getRequestDispatcher("/app/notice/notice-admain.jsp").forward(request, response);
			break;
		case "/notice/notice-addetail.no":
			System.out.println("글상세");
			result = new NoticeDetailController().MemExecute(request, response);
			request.getRequestDispatcher("/app/notice/notice-addetail.jsp").forward(request, response);
			break;
//		case "/notice/write.no":
//			System.out.println("write");
//			response.sendRedirect(request.getContextPath() + "/app/notice/notice-adwrite.jsp");
//			break;
		case "/notice/write.no":
			System.out.println("write");
			request.getRequestDispatcher("/app/notice/notice-adwrite.jsp").forward(request, response);
			break;
		case "/notice/writeOk.no":
			System.out.println("writeOk");
			result = new NoticeWriteOkController().MemExecute(request, response);
			break;
//		case "/notice/writeOk.no":
//			System.out.println("writeOk");
//			result = new NoticeWriteOkController().MemExecute(request, response);
//			break;
//		case "/notice/notice-admodify.no":
//			System.out.println("글수정");
//			new NoticeModifyController().MemExecute(request, response);
////			result = new MainLoginController().MemExecute(request, response);
//			break;
		}
		
	      // Result 객체가 null이 아닌 경우, 리다이렉트 또는 포워드 처리
	      if (result != null) {
	         if (result.isRedirect()) {
	            response.sendRedirect(result.getPath()); // 리다이렉트 처리
	         } else {
	            request.getRequestDispatcher(result.getPath()).forward(request, response); // 포워드 처리
	         }
	      }


	}
}