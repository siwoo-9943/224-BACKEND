package com.pj224.app.notice;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pj224.app.MemExecute;
import com.pj224.app.Result;
import com.pj224.app.dao.NoticeDAO;
import com.pj224.app.dto.NoticeDTO;

public class NoticeWriteOkController implements MemExecute {
	
	@Override
	public Result MemExecute(HttpServletRequest request, HttpServletResponse response) throws IOException {

		System.out.println("공지 글 작성");
		request.setCharacterEncoding("UTF-8");
		
		NoticeDAO noticeDAO = new NoticeDAO();
		NoticeDTO noticeDTO = new NoticeDTO();
		Result result = new Result();

		noticeDTO.setNoticeCate(request.getParameter("noticeCate"));
		noticeDTO.setNoticeTitle(request.getParameter("noticeTitle"));
		noticeDTO.setNoticeContent(request.getParameter("noticeContent"));
		noticeDTO.setMemberNumber(1);
//		noticeDTO.setMemberNumber(Integer.valueOf(request.getParameter("memberNumber")));
		
	    request.setAttribute("noticeCate", noticeDTO.getNoticeCate());
	    request.setAttribute("noticeTitle", noticeDTO.getNoticeTitle());
	    request.setAttribute("noticeContent", noticeDTO.getNoticeContent());

		System.out.println(noticeDTO);
		// 데이터베이스에 저장
		noticeDAO.write(noticeDTO);

		// 결과 설정
		result.setRedirect(true);
		result.setPath(request.getContextPath() + "/notice/notice-admain.no");

		return result;
	}
}
