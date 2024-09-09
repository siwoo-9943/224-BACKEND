package com.pj224.app.community;

import java.io.IOException;
import java.rmi.ServerException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.pj224.app.MemExecute;
import com.pj224.app.Result;
import com.pj224.app.dao.CommunityDAO;
import com.pj224.app.dto.CommentDTO;
import com.pj224.app.dto.CommunityDTO;
import com.pj224.app.dto.MemberDTO;

public class CommunityDetailOkController implements MemExecute {

	@Override
	public Result MemExecute(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServerException {

		request.setCharacterEncoding("UTF-8");

		System.out.println("detail 컨트롤러 들어옴");
		Result result = new Result();

		HttpSession session = request.getSession();
		MemberDTO member = (MemberDTO) session.getAttribute("member");

		CommunityDAO communityDAO = new CommunityDAO();

		// boardNumber를 요청 파라미터에서 가져오기
		String boardNumberStr = request.getParameter("boardNumber");
		if (boardNumberStr == null || boardNumberStr.isEmpty()) {
			// boardNumber가 없을 경우 처리
			System.out.println("boardNumber가 없습니다.");
			result.setRedirect(true);
			result.setPath("/app/community/comu-main.jsp"); // 메인 페이지로 리다이렉트
			return result;
		}

		System.out.println("boardNumber: " + boardNumberStr);

		CommunityDTO communityDTO = new CommunityDTO();
		try {
			communityDTO.setBoardNumber(Integer.parseInt(boardNumberStr)); // boardNumber 설정
		} catch (NumberFormatException e) {
			System.out.println("boardNumber 형식이 잘못되었습니다: " + boardNumberStr);
			result.setRedirect(true);
			result.setPath("/app/community/comu-main.jsp"); // 메인 페이지로 리다이렉트
			return result;
		}
		
		communityDTO = communityDAO.comudetail(communityDTO); // DAO 메서드 호출
		if (communityDTO == null) {
			// communityDTO가 null일 경우 처리
			System.out.println("communityDTO가 null입니다.");
			result.setRedirect(true);
			result.setPath("/app/community/comu-main.jsp"); // 메인 페이지로 리다이렉트
			return result;
		}

		request.setAttribute("communitycomudetail", communityDTO);
		
		CommentDTO commentDTO = communityDAO.commentList(boardNumber);

		boolean isAuthor = false;
		if (member != null && communityDTO.getMemberNumber() == member.getMemberNumber()) {
			isAuthor = true;
		}
		request.setAttribute("isAuthor", isAuthor);


		result.setRedirect(false);
		result.setPath("/app/community/comu-detail.jsp");

		return result;
	}
}
