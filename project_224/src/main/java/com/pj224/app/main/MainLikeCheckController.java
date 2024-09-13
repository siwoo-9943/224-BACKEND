package com.pj224.app.main;

import java.io.IOException;
import java.rmi.ServerException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.pj224.app.MemExecute;
import com.pj224.app.Result;
import com.pj224.app.dao.MainDAO;
import com.pj224.app.dto.MainDTO;
import com.pj224.app.dto.MemberDTO;

public class MainLikeCheckController implements MemExecute {

    @Override
    public Result MemExecute(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServerException, ServletException {
    	
    	
    	MainDAO mainDAO = new MainDAO();
		MainDTO mainDTO = new MainDTO();
		Result result = new Result();
		
		HttpSession session = request.getSession(false); // false로 설정하여 세션이 없으면 null 반환
		
		try {
			MemberDTO memberDTO = (MemberDTO) session.getAttribute("member");
			int membersessionNum = memberDTO.getMemberNumber();
			System.out.println("세션쿠키" + membersessionNum);

			mainDTO.setMemberNumber(membersessionNum);

			System.out.println(mainDTO);		
			
			List<MainDTO> memCheckLike = mainDAO.likeCheck(membersessionNum);
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