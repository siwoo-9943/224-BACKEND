package com.pj224.app.main;

import java.io.IOException;
import java.rmi.ServerException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pj224.app.MemExecute;
import com.pj224.app.Result;
import com.pj224.app.dao.MainDAO;
import com.pj224.app.dto.MainDTO;

public class MainComuListController implements MemExecute{

	@Override
	public Result MemExecute(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServerException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
	    MainDAO mainDAO = new MainDAO();
	    
	    Result result = new Result();
	    
	    List<MainDTO> comuListResults;
	    comuListResults = mainDAO.maincomuList();
	    System.out.println("목록 \n" + comuListResults);
		
	    request.setAttribute("comuListResults", comuListResults);

		return result;
	}
	

}
