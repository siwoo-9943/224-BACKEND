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

public class MainUnlikeController implements MemExecute{

	@Override
	public Result MemExecute(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServerException, ServletException {
		Integer memberNumber = (Integer) request.getSession().getAttribute("memberNumber");
        if (memberNumber == null) {
            throw new ServletException("회원 정보가 없습니다.");
        }

        int hotplaceNumber = Integer.parseInt(request.getParameter("hotplaceNumber"));
        MainDAO mainDAO = new MainDAO();
        MainDTO mainDTO = new MainDTO();
        mainDTO.setMemberNumber(memberNumber);
        mainDTO.setHotplaceNumber(hotplaceNumber);

        // 찜 해제 로직
        mainDAO.unpickHotplace(mainDTO);

        // 쿼리 실행 후 결과를 DTO에 담아 반환
        return mainDAO.getHotplaceDetails(hotplaceNumber); // 가정: hotplace의 세부 정보를 가져오는 메소드
	}
	

}
