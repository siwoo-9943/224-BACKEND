package com.pj224.app.main;

import java.io.IOException;
import java.rmi.ServerException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pj224.app.MemExecute;
import com.pj224.app.Result;
import com.pj224.app.dao.MainDAO;
import com.pj224.app.dto.MainDTO;

public class MainComuConnController implements MemExecute{

	@Override
	public Result MemExecute(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServerException {
		// TODO Auto-generated method stub
		MainDAO mainDAO = new MainDAO();
	    MainDTO mainDTO = new MainDTO();
	    Result result = new Result();
		
		
		return result;
	}

}
