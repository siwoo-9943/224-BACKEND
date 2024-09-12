package com.pj224.app.mypage;

import java.io.IOException;
import java.rmi.ServerException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.pj224.app.MemExecute;
import com.pj224.app.Result;
import com.pj224.app.dao.MypageDAO;
import com.pj224.app.dto.HotplaceDTO;
import com.pj224.app.dto.MemberDTO;
import com.pj224.app.dto.MypageDTO;

public class MypickController implements MemExecute {

	@Override
	public Result MemExecute(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServerException, ServletException {
		System.out.println("까꿍");
		HttpSession session = request.getSession(false);

		HotplaceDTO hotplaceDTO = new HotplaceDTO();
		MypageDAO mypageDAO = new MypageDAO();
		Result result = new Result();
		// memberdto 가져오기
		MemberDTO memberDTO = (MemberDTO) session.getAttribute("member");

		int membersessionNum = memberDTO.getMemberNumber();
		System.out.println("membernumber 들어왔니");
		System.out.println(membersessionNum);

		hotplaceDTO.setHotplaceNumber(membersessionNum);
		System.out.println(hotplaceDTO);
		
		List<HotplaceDTO> myCheckLike = mypageDAO.mylikelist(membersessionNum);
		System.out.println("mychecklike 들어왔니");
		System.out.println("HotplaceDTO 값 들어왔니");
		System.out.println(myCheckLike);

		request.setAttribute("myCheckLike", myCheckLike);

//		result.setRedirect(true);
//		result.setPath(request.getContextPath() + "/app/mypage/my-pick.jsp");

		request.getRequestDispatcher(request.getContextPath() +"/app/mypage/my-pick.jsp").forward(request, response);
		return result;
	}

}
