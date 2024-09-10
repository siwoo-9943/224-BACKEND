package com.pj224.app.main;

import java.io.IOException;
import java.rmi.ServerException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pj224.app.MemExecute;
import com.pj224.app.Result;
import com.pj224.app.dao.MainDAO;
import com.pj224.app.dto.MainDTO;

public class MainLikeController implements MemExecute {

    @Override
    public Result MemExecute(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServerException, ServletException {
    	
    	
    	MainDAO mainDAO = new MainDAO();
		MainDTO mainDTO = new MainDTO();
		Result result = new Result();
		try {
			int membersessionNum = (int) request.getSession().getAttribute("memberNumber");
			System.out.println("1번 세션쿠키" + membersessionNum);

			int hotplaceNumber = Integer.parseInt(request.getParameter("hotplaceNumber"));
			
			mainDTO.setMemberNumber(membersessionNum);
			mainDTO.setHotplaceNumber(hotplaceNumber);

			System.out.println(mainDTO);		
			
			List<MainDTO> memCheckLike = mainDAO.likeCheck(membersessionNum, hotplaceNumber);
			System.out.println(memCheckLike);
			System.out.println(mainDTO);
			
			request.setAttribute("memCheckLike", memCheckLike);
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NullPointerException e) {
			e.printStackTrace();		
		}

        return result;
    }
}