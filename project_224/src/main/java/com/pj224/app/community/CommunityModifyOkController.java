package com.pj224.app.community;

import java.io.IOException;
import java.rmi.ServerException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pj224.app.MemExecute;
import com.pj224.app.Result;
import com.pj224.app.dao.CommunityDAO;

public class CommunityModifyOkController implements MemExecute{

	@Override
	public Result MemExecute(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServerException {
		
		request.setCharacterEncoding("UTF-8");
		
		System.out.println("수정 컨트롤러 들어왔음?");
		
		Result result = new Result();
		
		CommunityDAO communityDAO = new CommunityDAO(); 
		
		
		
		
		
		return null;
	}

}
