package com.pj224.app.hotplace;

import java.io.IOException;
import java.rmi.ServerException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.pj224.app.MemExecute;
import com.pj224.app.Result;
import com.pj224.app.dao.HotplaceDAO;
import com.pj224.app.dto.LikeDTO;
import com.pj224.app.dto.MemberDTO;

public class HotplaceUnPickController implements MemExecute{

	@Override
	public Result MemExecute(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServerException, ServletException {
		
		HttpSession session = request.getSession(false); // 새 세션을 만들지 않음
        MemberDTO member = (MemberDTO) session.getAttribute("member");
        System.out.println(member); // MemberDTO의 전체 정보 출력
        
		HotplaceDAO hotplaceDAO = new HotplaceDAO();
        Result result = new Result();
        
        int memberNumber;
        if (member != null) {
            // MemberDTO에서 memberNumber 가져오기
            memberNumber = member.getMemberNumber(); // memberNumber를 가져오는 메서드를 호출
            System.out.println("memberNumber: " + memberNumber);
        } else {
            memberNumber = 0; // 세션에 MemberDTO가 없을 때 기본값 설정
            System.out.println("세션에 member가 없음");
        }
        
		int hotplaceNumber;
		int page;
		String returnUrl;
		
		hotplaceNumber = Integer.parseInt(request.getParameter("hotplaceNumber"));
		page = Integer.parseInt(request.getParameter("page"));
		String[] str1 = request.getParameter("returnUrl").split("/");
		returnUrl = str1[str1.length - 1].replace("jsp", "hp") + "?page=" + page;
		hotplaceDAO.unpickHotplace(new LikeDTO(hotplaceNumber, memberNumber));

		
        result.setRedirect(true);
        result.setPath(request.getContextPath() + returnUrl + "&memberNumber=" + memberNumber);
        
		return result;
	}

}
