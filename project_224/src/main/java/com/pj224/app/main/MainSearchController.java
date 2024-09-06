package com.pj224.app.main;

import java.io.IOException;
import java.rmi.ServerException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pj224.app.MemExecute;
import com.pj224.app.Result;
import com.pj224.app.dao.MainDAO;

public class MainSearchController implements MemExecute{

	@Override
	public Result MemExecute(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServerException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		
		String search = request.getParameter("search");
		
		Result result = new Result();
		
		String searchinput = request.getParameter("search"); // 검색어 가져오기
		MainDAO mainDAO = new MainDAO();
        List<String> searchResults = mainDAO.SearchInputResult(searchinput); // 검색 결과

        result.setData(searchResults); // 검색 결과를 Result 객체에 담기

        // 결과에 따라 JSP 경로 설정
        if (searchResults != null && !searchResults.isEmpty()) {
            result.setPath("main-search.jsp");
            result.setRedirect(false);
        } else {
            System.out.println("검색결과 없음");
        }

        return result; // Result 객체 반환
	}
	

}
