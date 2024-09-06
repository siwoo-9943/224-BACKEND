package com.pj224.app.community;

import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pj224.app.MemExecute;
import com.pj224.app.Result;
import com.pj224.app.dao.CommunityDAO;
import com.pj224.app.dto.CommunityDTO;

public class CommunityWriteOkController implements MemExecute {

    @Override
    public Result MemExecute(HttpServletRequest request, HttpServletResponse response)
            throws IOException {

        System.out.println("글작성 컨트롤러 들어왔냐??");
        request.setCharacterEncoding("UTF-8");

        CommunityDAO communityDAO = new CommunityDAO();
        CommunityDTO communityDTO = new CommunityDTO();
        Result result = new Result();

        
            String boardCate = request.getParameter("boardCate");
            System.out.println("카테 값 들어옴? " + boardCate);
            if (boardCate == null || boardCate.trim().isEmpty()) {
                throw new IllegalArgumentException("카테 값이 없다");
            }
            communityDTO.setBoardCate(boardCate);
            
            communityDTO.setBoardTitle(request.getParameter("boardTitle"));
            communityDTO.setBoardContent(request.getParameter("boardContent"));
            communityDTO.setBoardRegistDate(request.getParameter("boardRegistDate"));
            communityDTO.setBoardUpdateDate(request.getParameter("boardUpdateDate"));
            
            String memberNumberStr = request.getParameter("memberNumber");
            if (memberNumberStr != null && !memberNumberStr.isEmpty()) {
                communityDTO.setMemberNumber(Integer.valueOf(memberNumberStr));
            } else {
                throw new IllegalArgumentException("멤버넘버낫널");
            }
            
            request.setAttribute("boardCate", boardCate);
            
            request.setAttribute("communityDTO", communityDTO);
           
            
            // 데이터베이스에 저장
            communityDAO.insert(communityDTO);

            // 결과 설정
            result.setRedirect(true);
            result.setPath(request.getContextPath() + "/community/comu-write.cm");

            

        return result;
    }
}