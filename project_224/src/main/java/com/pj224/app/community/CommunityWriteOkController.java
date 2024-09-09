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

public class CommunityWriteOkController implements MemExecute {

   @Override
   public Result MemExecute(HttpServletRequest request, HttpServletResponse response) throws IOException {

      System.out.println("글작성 컨트롤러 들어왔냐??");
      request.setCharacterEncoding("UTF-8");
      
      HttpSession session = request.getSession();
      MemberDTO member = (MemberDTO) session.getAttribute("member");
        
      
      System.out.println("cate값 " + request.getParameter("boardCate"));
      
      CommunityDAO communityDAO = new CommunityDAO();
      CommunityDTO communityDTO = new CommunityDTO();
      Result result = new Result();

      communityDTO.setBoardCate(request.getParameter("boardCate"));
      communityDTO.setBoardTitle(request.getParameter("boardTitle"));
      communityDTO.setBoardContent(request.getParameter("editordata"));
      communityDTO.setBoardRegistDate(request.getParameter("boardRegistDate"));
      communityDTO.setBoardUpdateDate(request.getParameter("boardUpdateDate"));
      communityDTO.setMemberNumber(member.getMemberNumber());
      

      request.setAttribute("boardCate", communityDTO.getBoardCate());
      request.setAttribute("boardTile", communityDTO.getBoardTitle());
      request.setAttribute("boardContent", communityDTO.getBoardContent());

      // 데이터베이스에 저장
      communityDAO.insert(communityDTO);

      // 결과 설정
      result.setRedirect(true);
      result.setPath(request.getContextPath() + "/community/comu-main.cm");

      return result;
   }
}