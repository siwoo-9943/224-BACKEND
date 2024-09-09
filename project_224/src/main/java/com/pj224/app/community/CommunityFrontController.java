package com.pj224.app.community;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.pj224.app.Result;
import com.pj224.app.dao.CommunityDAO;
import com.pj224.app.dto.CommunityDTO;

public class CommunityFrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private CommunityDAO communityDAO;

	public CommunityFrontController() {
		super();
	}

	@Override
	public void init() throws ServletException {
		super.init();
		communityDAO = new CommunityDAO();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println(request.getContextPath());
		System.out.println(request.getRequestURI());

		String target = request.getRequestURI().substring(request.getContextPath().length());
		System.out.println("타겟들어옴?: " + target);

		Result result = null;
		boolean isForwarded = false;

		HttpSession session = request.getSession();
		Integer memberNumber = (Integer) session.getAttribute("memberNumber");

		switch (target) {
		case "/community/comu-main.cm":
			System.out.println("프컨 들어옴");
			result = new CommunityListOkController().MemExecute(request, response);
			request.getRequestDispatcher("/app/community/comu-main.jsp").forward(request, response);
			isForwarded = true;
			break;

		case "/community/comu-write.cm":
			System.out.println("글 작성 들어옴?");
			request.getRequestDispatcher("/app/community/comu-write.jsp").forward(request, response);
			isForwarded = true;
			break;

		case "/community/comu-writeOk.cm":
			System.out.println("Ok로들어왔냐??!!!");
			result = new CommunityWriteOkController().MemExecute(request, response);
			break;

		case "/community/comu-detail.cm":
			System.out.println("디테일 들어옴");
			result = new CommunityDetailOkController().MemExecute(request, response);
			request.getRequestDispatcher("/app/community/comu-detail.jsp").forward(request, response);
			isForwarded = true;
			break;

		case "/community/comu-modify.cm":
			System.out.println("수정 페이지로 이동");
			String boardNumber = request.getParameter("boardNumber");
			if (boardNumber != null && !boardNumber.isEmpty()) {
				try {
					int boardNum = Integer.parseInt(boardNumber);
					CommunityDTO community = communityDAO.getCommunityByBoardNumber(boardNum);
					if (community != null) {
						request.setAttribute("community", community);
						request.getRequestDispatcher("/app/community/comu-modify.jsp").forward(request, response);
						isForwarded = true;
					} else {
						System.out.println("해당 게시글을 찾을 수 없습니다: " + boardNumber);
						response.sendRedirect(request.getContextPath() + "/community/comu-list.cm?error=notFound");
						isForwarded = true;
					}
				} catch (NumberFormatException e) {
					System.out.println("잘못된 boardNumber 형식: " + boardNumber);
					response.sendRedirect(
							request.getContextPath() + "/community/comu-list.cm?error=invalidBoardNumber");
					isForwarded = true;
				}
			} else {
				System.out.println("boardNumber가 없습니다.");
				response.sendRedirect(request.getContextPath() + "/community/comu-list.cm?error=missingBoardNumber");
				isForwarded = true;
			}
			break;

		case "/community/comu-modifyOk.cm":
			System.out.println("수정완료 들어옴");
			result = new CommunityModifyOkController().MemExecute(request, response);
			break;

		case "/community/comu-deleteOk.cm":
		    System.out.println("FrontController: 게시글 삭제 요청 받음");
		    result = new CommunityDeleteOkController().MemExecute(request, response);
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