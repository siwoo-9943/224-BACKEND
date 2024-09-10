package com.pj224.app.notice;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.pj224.app.MemExecute;
import com.pj224.app.Result;
import com.pj224.app.dao.CommunityDAO;
import com.pj224.app.dao.NoticeDAO;
import com.pj224.app.dto.CommunityDTO;
import com.pj224.app.dto.MemberDTO;
import com.pj224.app.dto.NoticeDTO;

public class NoticeDeleteController implements MemExecute {
	   @Override
	    public Result MemExecute(HttpServletRequest request, HttpServletResponse response) throws IOException {
	        HttpSession session = request.getSession();
	        MemberDTO member = (MemberDTO) session.getAttribute("member");

	        // 파라미터로 넘어온 noticeNumber를 받음
	        String noticeNumberStr = request.getParameter("noticeNumber");
	        int noticeNumber = Integer.parseInt(noticeNumberStr);

	        // DAO를 사용하여 해당 공지사항 삭제
	        NoticeDAO noticeDAO = new NoticeDAO();
	        noticeDAO.delete(noticeNumber);

	        // 삭제 완료 후, 목록 페이지로 리다이렉트
	        Result result = new Result();
	        result.setRedirect(true);
	        result.setPath(request.getContextPath() + "/notice/notice-admain.no");

	        return result;

	}
}
