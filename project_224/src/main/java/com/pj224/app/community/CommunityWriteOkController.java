package com.pj224.app.community;

import java.io.IOException;
import java.rmi.ServerException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pj224.app.Execute;
import com.pj224.app.dao.CommunityDAO;
import com.pj224.app.dto.CommunityDTO;

public class CommunityWriteOkController implements Execute{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServerException {
		System.out.println("글작성 컨트롤러까지 들어왔니??!!");
		request.setCharacterEncoding("UTF-8");
		
		CommunityDAO communityDAO = new CommunityDAO();
		CommunityDTO communityDTO = new CommunityDTO();
		
//		board_number, board_cate, board_title, board_content, board_regist_date, 
//		board_update_date, member_number
		
		communityDTO.setBoardCate(request.getParameter("communityCate"));
		communityDTO.setBoardTitle(request.getParameter("communityTitle"));
		communityDTO.setBoardContent(request.getParameter("communityContent"));
		communityDTO.setBoardRegistDate(request.getParameter("communityRegistDate"));
		
	}

}
