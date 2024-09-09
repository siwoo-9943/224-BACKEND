package com.pj224.app.community;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.pj224.app.MemExecute;
import com.pj224.app.Result;
import com.pj224.app.dao.CommunityDAO;
import com.pj224.app.dto.CommentDTO;
import com.pj224.app.dto.CommunityDTO;
import com.pj224.app.dto.MemberDTO;

public class CommunityCommentWriteOkController implements MemExecute {

	@Override
	public Result MemExecute(HttpServletRequest request, HttpServletResponse response) throws IOException {

		System.out.println("댓글작성 컨트롤러 들어왔냐??");
		request.setCharacterEncoding("UTF-8");

		System.out.println(request.getAttribute("commentContent"));
		System.out.println(request.getAttribute("memberNumber"));
		System.out.println(request.getAttribute("boardNumber"));

		String commentContent = (String) request.getAttribute("commentContent");
		int memberNum = Integer.parseInt((String) request.getAttribute("memberNumber"));
		int boardNum = Integer.parseInt((String) request.getAttribute("boardNumber"));

		System.out.println(commentContent);
		System.out.println(memberNum);
		System.out.println(boardNum);

		CommunityDAO communityDAO = new CommunityDAO();
		CommentDTO commentDTO = new CommentDTO();
		Result result = new Result();

		commentDTO.setCommentContent(commentContent);
		commentDTO.setMemberNumber(memberNum);
		commentDTO.setBoardNumber(boardNum);

		request.setAttribute("commentContent", commentDTO.getCommentContent());
		request.setAttribute("memberNumber", commentDTO.getMemberNumber());
		request.setAttribute("boardNumber", commentDTO.getBoardNumber());

		// 데이터베이스에 저장
		communityDAO.insertComment(commentDTO);

		// 결과 설정
		result.setRedirect(true);
		result.setPath(request.getContextPath() + "/community/comu-detail.cm?boardNumber=" + boardNum);

		return result;
	}
}