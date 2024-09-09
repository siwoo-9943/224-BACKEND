package com.pj224.app.community;

import java.io.IOException;
import java.rmi.ServerException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;

import com.pj224.app.Execute;
import com.pj224.app.MemExecute;
import com.pj224.app.Result;
import com.pj224.app.dao.CommunityDAO;
import com.pj224.app.dto.CommunityDTO;
import java.util.List;

public class CommunityListOkController implements MemExecute {

	@Override
	public Result MemExecute(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServerException {
		System.out.println("컨드롤러 들어옴");
		request.setCharacterEncoding("UTF-8");
		Result result = new Result();

		CommunityDAO communityDAO = new CommunityDAO();

		List<CommunityDTO> communityList = communityDAO.selectAll();

		request.setAttribute("communityList", communityList);

		result.setRedirect(false);
		result.setPath(request.getContextPath() + "/app/community/comu-main.jsp");

		return result;
	}

}