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
import com.pj224.app.dto.CommunityDTO;
import com.pj224.app.dto.HotplaceDTO;
import com.pj224.app.dto.MemberDTO;
import com.pj224.app.dto.MypageDTO;

public class MycomunityController implements MemExecute{

	@Override
	public Result MemExecute(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServerException, ServletException {
		System.out.println("커뮤니티 컨트롤러 실행");
		HttpSession session = request.getSession(false);
		
		MypageDTO mypageDTO = new MypageDTO();
		MypageDAO mypageDAO = new MypageDAO();
		Result result = new Result();
		
		MemberDTO memberDTO = new MemberDTO();
		
		MemberDTO member = (MemberDTO) session.getAttribute("member");
		System.out.println(member + "확인=========");
		int membersessionNum = member.getMemberNumber();
//		MemberDTO member = (MemberDTO) session.getAttribute("membersessionNum");
//		int membersessionNum = memberDTO.getMemberNumber();
		System.out.println(membersessionNum + "membernumber 들어왔니");
		
		mypageDTO.setMemberNumber(membersessionNum);
		System.out.println(mypageDTO);
		
		List<MypageDTO> mywritepage = mypageDAO.mywritelist(membersessionNum);
		System.out.println(mywritepage + "확인=========");
		
		System.out.println("mywritelist 들어왔니");
		System.out.println("Community 값 들어왔니");
		System.out.println(mywritepage);
		
		request.setAttribute("mywritepage", mywritepage);
		
		return result;
	}

}
