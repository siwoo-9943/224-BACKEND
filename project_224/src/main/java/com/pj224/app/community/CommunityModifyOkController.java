package com.pj224.app.community;

import java.io.IOException;
import java.rmi.ServerException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.pj224.app.MemExecute;
import com.pj224.app.Result;
import com.pj224.app.dao.CommunityDAO;
import com.pj224.app.dto.CommunityDTO;
import com.pj224.app.dto.MemberDTO;

public class CommunityModifyOkController implements MemExecute {

	@Override
	public Result MemExecute(HttpServletRequest request, HttpServletResponse response)
	        throws IOException, ServerException {
	    request.setCharacterEncoding("UTF-8");

	    System.out.println("수정 컨트롤러 들어왔음?");

	    HttpSession session = request.getSession();
	    MemberDTO member = (MemberDTO) session.getAttribute("member");

	    Result result = new Result();
	    CommunityDAO communityDAO = new CommunityDAO();
	    CommunityDTO communityDTO = new CommunityDTO();

	    // boardNumber를 request에서 가져오기
	    String boardNumberString = request.getParameter("boardNumber");
	    System.out.println("디버깅 boardNumber: " + boardNumberString); // 디버깅용 로그

	    if (boardNumberString != null && !boardNumberString.isEmpty()) {
	        try {
	            int boardNumber = Integer.parseInt(boardNumberString);
	            communityDTO.setBoardNumber(boardNumber);
	        } catch (NumberFormatException e) {
	            System.out.println("잘못된 boardNumber!! : " + boardNumberString);
	            result.setRedirect(true);
	            result.setPath(request.getContextPath() + "/community/comu-list.cm?error=invalidBoardNumber");
	            return result;
	        }
	    } else {
	        System.out.println("boardNumber 값이 없다!.");
	        result.setRedirect(true);
	        result.setPath(request.getContextPath() + "/community/comu-list.cm?error=missingBoardNumber");
	        return result;
	    }

	    // 나머지 정보 설정
	    communityDTO.setBoardTitle(request.getParameter("boardTitle"));
	    communityDTO.setBoardContent(request.getParameter("boardContent"));
	    communityDTO.setMemberNumber(member.getMemberNumber());

	    // 디버깅을 위한 로그 추가
	    System.out.println("수정할 게시글 정보:");
	    System.out.println("boardNumber: " + communityDTO.getBoardNumber());
	    System.out.println("boardTitle: " + communityDTO.getBoardTitle());
	    System.out.println("boardContent: " + communityDTO.getBoardContent());
	    System.out.println("memberNumber: " + communityDTO.getMemberNumber());

	    communityDAO.update(communityDTO);

	    System.out.println("수정 dao 거치고 여기까지 옴?");

	    result.setRedirect(true);
	    result.setPath(request.getContextPath() + "/community/comu-detail.cm?boardNumber=" + communityDTO.getBoardNumber());

	    return result;
	}

}
