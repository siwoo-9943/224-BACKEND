package com.pj224.app.main;

import java.io.IOException;
import java.rmi.ServerException;
import java.util.List;

import javax.naming.directory.SearchResult;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pj224.app.MemExecute;
import com.pj224.app.Result;
import com.pj224.app.dao.MainDAO;
import com.pj224.app.dao.MemberDAO;
import com.pj224.app.dto.MainDTO;
import com.pj224.app.dto.MemberDTO;
import com.pj224.app.dto.NoticeDTO;

public class MainSearchController implements MemExecute{

	@Override
	public Result MemExecute(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServerException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		MainDAO mainDAO = new MainDAO();
		MainDTO mainDTO = new MainDTO();
		Result result = new Result();
		String searchInput = request.getParameter("search"); // 검색어 가져오기
		mainDTO.setSearchInput(searchInput);
		System.out.println("검색어 : " + searchInput);
		System.out.println("MainDTO : " + mainDTO);
		
		List<MainDTO> search = MainDAO.select();
        request.setAttribute("mainsearchselectcm", search);
        
        result.setRedirect(false);
        result.setPath(request.getContextPath() + "/main-search.jsp"); 
        return result; // 필요에 따라 다른 값을 반환할 수 있습니다.
	}
	

}
