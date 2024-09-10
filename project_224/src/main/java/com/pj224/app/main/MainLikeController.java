package com.pj224.app.main;

import java.io.IOException;
import java.rmi.ServerException;

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
    	// 세션에서 memberNumber 가져오기 (정수형으로 변환)
        int memberNumber = (int) request.getSession().getAttribute("memberNumber");
        // 요청 파라미터에서 hotplaceNumber 가져오기 (정수형으로 변환)
        int hotplaceNumber = Integer.parseInt(request.getParameter("hotplaceNumber"));
        
        MainDAO mainDAO = new MainDAO();
        MainDTO mainDTO = new MainDTO();
        Result result = new Result();
        mainDTO.setMemberNumber(memberNumber);
        mainDTO.setHotplaceNumber(hotplaceNumber);


		// 찜하기 전 체크
        MainDTO existingLike = mainDAO.likeCheck(memberNumber);
        if (existingLike == null) {
        	mainDAO.pickHotplace(mainDTO);
            sqlSession.commit(); // 변경사항 커밋
        }
        
        
        
        result.setRedirect(false);
	    result.setPath(request.getContextPath() + "/main-search.jsp");
	    return result;
        
    }
}