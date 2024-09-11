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
		// TODO Auto-generated method stub

		// 클라이언트에서 전송된 데이터 받기
		String memberNumberStr = request.getParameter("memberNumber");
	    String hotplaceNumberStr = request.getParameter("hotplaceNumber");
//	    String scrollPositionStr = request.getParameter("scrollPosition");
	    
	    System.out.println(memberNumberStr);
	    System.out.println(hotplaceNumberStr);
//	    System.out.println(scrollPositionStr);

	    // 문자열을 int로 변환
	    int memberNumber = Integer.parseInt(memberNumberStr);
	    int hotplaceNumber = Integer.parseInt(hotplaceNumberStr);
//	    int scrollPosition = Integer.parseInt(scrollPositionStr);
	    
	    // 변환된 데이터 확인
	    System.out.println("Member Number: " + memberNumber);
	    System.out.println("Hotplace Number: " + hotplaceNumber);
//	    System.out.println("Scroll Position: " + scrollPosition);

	    MainDTO mainDTO = new MainDTO();
	    MainDAO mainDAO = new MainDAO();
	    Result result = new Result();
	    
	    mainDTO.setMemberNumber(memberNumber);
	    mainDTO.setHotplaceNumber(hotplaceNumber);
	    
	    request.setAttribute("memberNumber" , memberNumber);
	    request.setAttribute("hotplaceNumber" , hotplaceNumber);
//	    request.setAttribute("scrollPosition", scrollPosition);

		System.out.println(mainDTO);		
		
		mainDAO.pickHotplace(mainDTO);
	    
		result.setRedirect(true);
	    result.setPath(request.getContextPath() + "/main.mn?scrollPosition=\" + scrollPosition");
		return result;
	}

}
