package com.pj224.app.community;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.pj224.app.MemExecute;
import com.pj224.app.Result;
import com.pj224.app.dao.CommunityDAO;
import com.pj224.app.dto.CommunityDTO;
import com.pj224.app.dto.MemberDTO;

public class CommunityCommentDeleteOkController implements MemExecute {

    @Override
    public Result MemExecute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();
        
        System.out.println("댓글 삭제 컨트롤러 들어왔냐??");
        
        MemberDTO member = (MemberDTO) session.getAttribute("member");
        String commentNumberStr = request.getParameter("commentNumber");
        Result result = new Result();

        System.out.println("DeleteOkController 실행됨. boardNumber: " + commentNumberStr);

        if (member == null) {
            System.out.println("로그인되지 않은 사용자가 삭제 시도");
            result.setRedirect(true);
            result.setPath(request.getContextPath() + "/member/login.me");
            return result;
        }

        if (commentNumberStr != null && !commentNumberStr.isEmpty()) {
            int commentNumber = Integer.parseInt(commentNumberStr);
            CommunityDAO communityDAO = new CommunityDAO();


            // 댓글 삭제 실행
            communityDAO.deleteByCommentNumber(commentNumber);
            System.out.println("게시글 삭제 성공. commentNumber: " + commentNumber);

            result.setRedirect(true);
            result.setPath(request.getContextPath() + "/community/comu-detail.cm?boardNumber=" + request.getAttribute("boardNumber"));
        }

        return result;
    }
}