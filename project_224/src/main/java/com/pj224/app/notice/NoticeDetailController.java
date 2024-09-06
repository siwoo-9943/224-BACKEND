package com.pj224.app.notice;

import java.io.IOException;
import java.rmi.ServerException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pj224.app.MemExecute;
import com.pj224.app.Result;
import com.pj224.app.dao.NoticeDAO;
import com.pj224.app.dto.NoticeDTO;

	public class NoticeDetailController implements MemExecute  {

		@Override
		public Result MemExecute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServerException {
			
			System.out.println("컨드롤러 들어옴");
			request.setCharacterEncoding("UTF-8");
			Result result = new Result();
			
	        NoticeDAO noticeDAO = new NoticeDAO();

	        // 리스트를 가져와서 request에 설정
	        List<NoticeDTO> noticeDetail = noticeDAO.showList();
	        request.setAttribute("noticeshowdetail", noticeDetail);
	        
	        result.setRedirect(false);
	        result.setPath(request.getContextPath() + "/app/notice/notice-addetail.jsp");
	        
	        // 포워드 처리는 프론트 컨트롤러에서 담당
	        return result;


	   }



	}

