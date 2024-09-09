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
        
        System.out.println("삭제");
        
        MemberDTO member = (MemberDTO) session.getAttribute("member");
        String noticeNumberStr = request.getParameter("noticeNumber");
        Result result = new Result();

        System.out.println("noticeNumber: " + noticeNumberStr);
        
		int noticeNumber = Integer.parseInt(noticeNumberStr);
		NoticeDAO noticeDAO = new NoticeDAO();
        
      noticeDAO.delete(noticeNumber);
      System.out.println("게시글 삭제 성공" + noticeNumber);

      result.setRedirect(true);
      result.setPath(request.getContextPath() + "/notice/notice-admain.no");

//        if (member == null) {
//            System.out.println("로그인되지 않은 사용자가 삭제 시도");
//            result.setRedirect(true);
//            result.setPath(request.getContextPath() + "/member/login.me");
//            return result;
//        }
//
//        if (noticeNumberStr != null && !noticeNumberStr.isEmpty()) {
//            int noticeNumber = Integer.parseInt(noticeNumberStr);
//            NoticeDAO noticeDAO = new NoticeDAO();
//
//            // 게시글 정보 조회
//            NoticeDTO noticeDTO = noticeDAO.getNoitceByNoticeNumber(noticeNumber);
//
//
//            // 게시글 삭제 실행
//            noticeDAO.delete(noticeNumber);
//            System.out.println("게시글 삭제 성공" + noticeNumber);
//
//            result.setRedirect(true);
//            result.setPath(request.getContextPath() + "/notice/notice-admain.no");
//        }

        return result;
	}
}
