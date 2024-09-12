package com.pj224.app.notice;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pj224.app.Result;
import com.pj224.app.dao.NoticeDAO;
import com.pj224.app.dto.NoticeDTO;

/**
 * Servlet implementation class NoticeFrontController
 */
public class NoticeFrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private NoticeDAO noticeDAO;

	public NoticeFrontController() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void init() throws ServletException {
		super.init();
		noticeDAO = new NoticeDAO();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doProcess(request, response);
	}
	
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
			
		case "/notice/write.no":
			System.out.println("write");
			request.getRequestDispatcher("/app/notice/notice-adwrite.jsp").forward(request, response);
			break;
			
		case "/notice/writeOk.no":
			System.out.println("writeOk");
			result = new NoticeWriteOkController().MemExecute(request, response);
			if (result != null) {
				if (result.isRedirect()) {
					response.sendRedirect(result.getPath());
				} else {
					request.getRequestDispatcher(result.getPath()).forward(request, response);
				}
			}
			break;
			
		case "/notice/delete.no":
			System.out.println("delete");
			result = new NoticeDeleteController().MemExecute(request, response);
			if (result != null) {
				if (result.isRedirect()) {
					response.sendRedirect(result.getPath());
				} else {
					request.getRequestDispatcher(result.getPath()).forward(request, response);
				}
			}
			break;

		case "/notice/modify.no":
			System.out.println("modify");
			String noticeNumber = request.getParameter("noticeNumber");
			
			if (noticeNumber != null && !noticeNumber.isEmpty()) {
				try {
					int noticeNum = Integer.parseInt(noticeNumber);
					NoticeDTO notice = noticeDAO.getNoticeByNoticeNumber(noticeNum);
					System.out.println(notice);
					if (notice != null) {
						request.setAttribute("notice", notice);
						request.getRequestDispatcher("/app/notice/notice-admodify.jsp").forward(request, response);
//						result = new NoticeModifyOkController().MemExecute(request, response);
					} else {
						System.out.println("해당 게시글을 찾을 수 없습니다: " + noticeNumber);
						response.sendRedirect(request.getContextPath() + "/notice/notice-admain.no?error=notFound");
					}
				} catch (NumberFormatException e) {
					System.out.println("잘못된 noticeNumber 형식: " + noticeNumber);
					response.sendRedirect(request.getContextPath() + "/notice/notice-admain.no?error=notFound");
				}
			} else {
				System.out.println("noticeNumber가 없습니다.");
				response.sendRedirect(request.getContextPath() + "/notice/notice-admain.no?error=notFound");
			}
			break;
			
		case "/notice/modifyOk.no":
			System.out.println("글 수정 완료");
			request.setAttribute("noticeNumber", request.getParameter("noticeNumber"));
			request.setAttribute("noticeContent", request.getParameter("noticeContent"));
			request.setAttribute("noticeTitle", request.getParameter("noticeTitle"));
			request.setAttribute("noticeCate", request.getParameter("noticeCate"));
			result = new NoticeModifyOkController().MemExecute(request, response);
			
			if (result != null) {
				if (result.isRedirect()) {
					response.sendRedirect(result.getPath());
				} else {
					request.getRequestDispatcher(result.getPath()).forward(request, response);
				}
			}
			break;
		}

	}
}
