package com.pj224.app.community;

import java.io.IOException;
import java.rmi.ServerException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;

import com.pj224.app.Execute;
import com.pj224.app.dao.CommunityDAO;
import com.pj224.app.dto.CommunityDTO;
import java.util.List;

public class CommunityListOkController implements Execute {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServerException {
		System.out.println("컨드롤러 들어옴");
		request.setCharacterEncoding("UTF-8");

		
        CommunityDAO communityDAO = new CommunityDAO();
        
        
        List<CommunityDTO> communityList = communityDAO.selectAll();
        
        request.setAttribute("communityList", communityList);
        ;
        
     
		
		
	}

   
}