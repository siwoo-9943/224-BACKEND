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
        
        MemberDTO member = (MemberDTO) session.getAttribute("member");
        String noticeNumberStr = request.getParameter("noticeNumber");
       
        System.out.println("NoticeDeleteController 실행됨. noticeNumber: " + noticeNumberStr);

        // 로그인 확인
        if (member == null) {
            System.out.println("로그인되지 않은 사용자가 삭제 시도");
            result.setRedirect(true);
            result.setPath(request.getContextPath() + "/member/login.me");
            return result;
        }

        // 입력값 검증
        if (noticeNumberStr != null && !noticeNumberStr.isEmpty()) {
            try {
                int noticeNumber = Integer.parseInt(noticeNumberStr);
                NoticeDAO noticeDAO = new NoticeDAO();
                
                // 공지사항 삭제 실행
                noticeDAO.delete(noticeNumber);
                System.out.println("공지사항 삭제 성공. noticeNumber: " + noticeNumber);
                
                result.setRedirect(true);
                result.setPath(request.getContextPath() + "/notice/notice-admain.no");
            } catch (NumberFormatException e) {
                System.out.println("잘못된 noticeNumber 형식: " + noticeNumberStr);
                result.setRedirect(true);
                result.setPath(request.getContextPath() + "/notice/notice-admain.no?error=invalidNumber");
            } catch (Exception e) {
                System.out.println("삭제 중 예외 발생: " + e.getMessage());
                e.printStackTrace();
                result.setRedirect(true);
                result.setPath(request.getContextPath() + "/notice/notice-admain.no?error=deleteError");
            }
        } else {
            System.out.println("noticeNumber가 제공되지 않음");
            result.setRedirect(true);
            result.setPath(request.getContextPath() + "/notice/notice-admain.no?error=noNumber");
        }

        return result;  
    }

}
