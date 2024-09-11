package com.pj224.app.community;

import java.io.IOException;
import java.rmi.ServerException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.pj224.app.MemExecute;
import com.pj224.app.Result;
import com.pj224.app.dao.CommunityDAO;
import com.pj224.app.dto.CommunityDTO;
import java.util.List;

public class CommunityListOkController implements MemExecute {
    @Override
    public Result MemExecute(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServerException {
        System.out.println("컨트롤러 들어옴");
        request.setCharacterEncoding("UTF-8");
        
        // 페이지 처리 관련 변수
        int itemsPerPage = 10;  
        int currentPage = request.getParameter("page") == null ? 1 : Integer.parseInt(request.getParameter("page"));
        
        CommunityDAO communityDAO = new CommunityDAO();
        int totalItems = communityDAO.getTotalCount();
        int maxPages = (int) Math.ceil((double) totalItems / itemsPerPage);
        
        int start = (currentPage - 1) * itemsPerPage;
        int end = start + itemsPerPage;
        
        List<CommunityDTO> communityList = communityDAO.selectAllPaged(start, end);
        
        int pageBlockSize = 5;
        int startPage = ((currentPage - 1) / pageBlockSize) * pageBlockSize + 1;
        int endPage = Math.min(startPage + pageBlockSize - 1, maxPages);
        
        request.setAttribute("communityList", communityList);
        request.setAttribute("currentPage", currentPage);
        request.setAttribute("maxPages", maxPages);
        request.setAttribute("startPage", startPage);
        request.setAttribute("endPage", endPage);
        request.setAttribute("totalItems", totalItems);
        
        System.out.println("총 항목 수: " + totalItems);
        System.out.println("현재 페이지: " + currentPage);
        System.out.println("시작 페이지: " + startPage);
        System.out.println("끝 페이지: " + endPage);
        
        Result result = new Result();
        result.setRedirect(false);
        result.setPath(request.getContextPath() + "/app/community/comu-main.jsp");
        return result;
    }
}