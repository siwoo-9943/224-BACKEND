package com.pj224.app.notice;

import java.io.IOException;
import java.rmi.ServerException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.pj224.app.MemExecute;
import com.pj224.app.Result;
import com.pj224.app.dao.NoticeDAO;
import com.pj224.app.dto.MemberDTO;
import com.pj224.app.dto.NoticeDTO;

public class NoticeModifyOkController implements MemExecute {
	@Override
	public Result MemExecute(HttpServletRequest request, HttpServletResponse response)
	        throws IOException, ServerException, ServletException {
	    request.setCharacterEncoding("UTF-8");

	    System.out.println("공지 수정 컨트롤러 들어옴");

	    HttpSession session = request.getSession();
	    MemberDTO member = (MemberDTO) session.getAttribute("member");

	    Result result = new Result();
	    NoticeDAO noticeDAO = new NoticeDAO();
	    NoticeDTO noticeDTO = new NoticeDTO();

	    // noticeNumber를 request에서 가져오기
	    System.out.println(request.getAttribute("noticeNumber"));
	    String noticeNumberString = (String) request.getAttribute("noticeNumber");
	    System.out.println("디버깅 noticeNumber: " + noticeNumberString); // 디버깅용 로그
	    

	    if (noticeNumberString != null && !noticeNumberString.isEmpty()) {
	        try {
	            int noticeNumber = Integer.parseInt(noticeNumberString);
	            noticeDTO.setNoticeNumber(noticeNumber);
	            result.setPath(request.getContextPath() + "/notice/notice-admain.no");
	        } catch (NumberFormatException e) {
	            System.out.println("잘못된 noticeNumber : " + noticeNumberString);
	            result.setRedirect(true);
	            result.setPath(request.getContextPath() + "/notice/notice-admain.no?error=invalidNoticeNumber");
	            return result;
	        }
	    } else {
	        System.out.println("noticeNumber 값이 없다!");
	        result.setRedirect(true);
	        result.setPath(request.getContextPath() + "/notice/notice-admain.no?error=invalidNoticeNumber");
	        return result;
	    }
	    
	    // 나머지 정보 설정
	    noticeDTO.setNoticeTitle(request.getParameter("noticeTitle"));
	    noticeDTO.setNoticeContent(request.getParameter("noticeContent"));
        noticeDTO.setNoticeNumber(Integer.parseInt(request.getParameter("noticeNumber")));
        noticeDTO.setNoticeCate(request.getParameter("noticeCate"));


	    // 디버깅을 위한 로그 추가
	    System.out.println("수정할 게시글 정보:");
	    System.out.println("noticeNumber: " + noticeDTO.getNoticeNumber());
	    System.out.println("noticeTitle: " + noticeDTO.getNoticeTitle());
	    System.out.println("noticeContent: " + noticeDTO.getNoticeContent());

	    noticeDAO.update(noticeDTO);

	    System.out.println("수정 dao 거치고 여기까지");
	    
	    request.setAttribute("noticeCate", noticeDTO.getNoticeCate());
	    request.setAttribute("noticeTitle", noticeDTO.getNoticeTitle());
	    request.setAttribute("noticeContent", noticeDTO.getNoticeContent());
	    

	    result.setRedirect(true);
//	    result.setPath(request.getContextPath() + "/notice/notice-addetail.cm?noticeNumber=" + noticeDTO.getNoticeNumber());
	    return result;
	}
}
