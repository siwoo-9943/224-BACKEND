package com.pj224.app.community;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.pj224.app.Result;
import com.pj224.app.dao.CommunityDAO;
import com.pj224.app.dto.CommentDTO;
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
		request.setCharacterEncoding("UTF-8");
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

		case "/community/comu-comment-modify.cm":
			// 댓글 수정 요청을 처리하는 부분
			int commentNumber = Integer.parseInt(request.getParameter("commentNumber"));
			String commentContent = request.getParameter("commentContent");

			CommentDTO commentDTO = new CommentDTO();
			commentDTO.setCommentNumber(commentNumber);
			commentDTO.setCommentContent(commentContent);

			CommunityDAO communityDAO = new CommunityDAO(/* SqlSessionFactory 인스턴스 주입 */);
			communityDAO.commentUpdate(commentDTO);
			break;

		case "/community/comu-comment-deleteOk.cm":
			System.out.println("FrontController: 댓글 삭제 요청 받음");

			String boardNum = request.getParameter("boardNumber");
			request.setAttribute("boardNumber", boardNum);
			result = new CommunityCommentDeleteOkController().MemExecute(request, response);
			break;

		case "/community/comu-comment-write.cm":
			System.out.println("댓글 작성 됨?");
			System.out.println(request.getParameter("memberNum"));
			System.out.println(request.getParameter("boardNumber"));
			System.out.println(request.getParameter("commentCont"));
			request.setAttribute("memberNumber", request.getParameter("memberNum"));
			request.setAttribute("boardNumber", request.getParameter("boardNumber"));
			request.setAttribute("commentContent", request.getParameter("commentCont"));
			result = new CommunityCommentWriteOkController().MemExecute(request, response);
			System.out.println(result.getPath());
			isForwarded = false;
			break;
		case "/community/recommendOk.cm":
			System.out.println("추천 됨?");
			result = new CommunityRecommendOkController().MemExecute(request, response);
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