package com.pj224.app.notice;

import java.io.IOException;
import java.rmi.ServerException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pj224.app.Execute;
import com.pj224.app.dao.CommunityDAO;
import com.pj224.app.dao.NoticeDAO;
import com.pj224.app.dto.CommunityDTO;

public class NoticeWriteController implements Execute  {

		@Override
		public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServerException {
			System.out.println("컨드롤러 들어옴");
			request.setCharacterEncoding("UTF-8");

			
	        NoticeDAO noticeDAO = new NoticeDAO();
	        
	        
//	        List<NoticeDAO> noticeList = noticeDAO.list();	        
//	        request.setAttribute("noticeList", noticeList);
	        
			
		}
}
