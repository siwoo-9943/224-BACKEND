package com.pj224.app.community;

import java.io.IOException;
import java.rmi.ServerException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pj224.app.MemExecute;
import com.pj224.app.Result;
import com.pj224.app.dao.CommunityDAO;
import com.pj224.app.dto.CommentDTO;
import com.pj224.app.dto.CommunityDTO;

public class CommunityDetailOkController implements MemExecute {

	@Override
	public Result MemExecute(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServerException {

		request.setCharacterEncoding("UTF-8");

		System.out.println("detail 컨트롤러 들어옴");
		Result result = new Result();

		CommunityDAO communityDAO = new CommunityDAO();

		CommunityDTO communityDTO = communityDAO.comudetail();
		request.setAttribute("communitycomudetail", communityDTO);
		
		CommentDTO commentDTO = communityDAO.commentList(boardNumber);

		System.out.println(communityDTO);

		result.setRedirect(false);
		result.setPath(request.getContextPath() + "app/community/comu-detail.jsp");

		return result;
	}

}
