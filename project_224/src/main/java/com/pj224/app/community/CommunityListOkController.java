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
		
		
		// 페이지 처리 관련 변수
	    int itemsPerPage = 5;  // 페이지당 항목 수
	    int currentPage = request.getParameter("page") == null ? 1 : Integer.parseInt(request.getParameter("page"));
		
	    
	    CommunityDAO communityDAO = new CommunityDAO();
	    List<CommunityDTO> communityList = communityDAO.selectAll();
	    int totalItems = communityList.size();  // 전체 항목 수
	    int maxPages = (int) Math.ceil((double) totalItems / itemsPerPage);  // 전체 페이지 수 계산
	    
	    int start = (currentPage - 1) * itemsPerPage;
	    int end = Math.min(start + itemsPerPage, totalItems);
	    
	    int pageBlockSize = 5;
	    int startPage = ((currentPage - 1) / pageBlockSize) * pageBlockSize + 1;
	    int endPage = Math.min(startPage + pageBlockSize - 1, maxPages);
		

		request.setAttribute("communityList", communityList);
		request.setAttribute("currentPage", currentPage);
	    request.setAttribute("maxPages", maxPages);
	    request.setAttribute("startPage", startPage);
	    request.setAttribute("endPage", endPage);
	       
	    System.out.println(communityList);
		
		Result result = new Result();
		result.setRedirect(false);
		result.setPath(request.getContextPath() + "/app/community/comu-main.jsp");

		return result;
	}

}