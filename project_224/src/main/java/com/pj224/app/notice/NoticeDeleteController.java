package com.pj224.app.notice;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.pj224.app.MemExecute;
import com.pj224.app.Result;
import com.pj224.app.dao.NoticeDAO;
import com.pj224.app.dto.MemberDTO;

public class NoticeDeleteController implements MemExecute {

	 @Override
	    public Result MemExecute(HttpServletRequest request, HttpServletResponse response) throws IOException {
	        HttpSession session = request.getSession();
	        Result result = new Result();
	        
	        System.out.println("공지 삭제 컨트롤러 들어옴");
	        
	        String noticeNumberStr = request.getParameter("noticeNumber");
	       
	        System.out.println("NoticeDeleteController 실행됨. noticeNumber: " + noticeNumberStr);

	        // 입력값 검증
	        if (noticeNumberStr != null && !noticeNumberStr.isEmpty()) {
	            int noticeNumber = Integer.parseInt(noticeNumberStr);
	            NoticeDAO noticeDAO = new NoticeDAO();
	            
	            // 공지사항 삭제 실행
	            noticeDAO.delete(noticeNumber);
	            System.out.println("공지사항 삭제 성공. noticeNumber: " + noticeNumber);
	            
	            result.setRedirect(true);
	            result.setPath(request.getContextPath() + "/notice/notice-admain.no");
	        } else {
	            System.out.println("noticeNumber가 제공되지 않음");
	            result.setRedirect(true);
	            result.setPath(request.getContextPath() + "/notice/notice-admain.no?error=noNumber");
	        }

	        return result;  
	    }

}
