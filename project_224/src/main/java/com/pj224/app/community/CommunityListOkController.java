package com.pj224.app.community;
import java.io.IOException;
import java.rmi.ServerException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pj224.app.MemExecute;
import com.pj224.app.Result;
import com.pj224.app.dao.CommunityDAO;
import com.pj224.app.dto.CommunityDTO;

public class CommunityListOkController implements MemExecute {
    @Override
    public Result MemExecute(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServerException {
        System.out.println("컨트롤러 들어옴");
        request.setCharacterEncoding("UTF-8");
<<<<<<< HEAD

        int itemsPerPage = 10;
=======
        
        // 페이지 처리 관련 변수
        int itemsPerPage = 7;  
>>>>>>> main
        int currentPage = request.getParameter("page") == null ? 1 : Integer.parseInt(request.getParameter("page"));
        String category = request.getParameter("category");
        if (category == null || category.isEmpty()) {
            category = "전체";
        }

        CommunityDAO communityDAO = new CommunityDAO();
        int totalItems = communityDAO.getTotalCount();
        int maxPages = (int) Math.ceil((double) totalItems / itemsPerPage);

        List<CommunityDTO> communityList = communityDAO.selectAllPagedAndFiltered(currentPage, itemsPerPage, category);

        int pageBlockSize = 5;
        int startPage = ((currentPage - 1) / pageBlockSize) * pageBlockSize + 1;
        int endPage = Math.min(startPage + pageBlockSize - 1, maxPages);

        request.setAttribute("communityList", communityList);
        request.setAttribute("currentPage", currentPage);
        request.setAttribute("maxPages", maxPages);
        request.setAttribute("startPage", startPage);
        request.setAttribute("endPage", endPage);
        request.setAttribute("totalItems", totalItems);
        request.setAttribute("selectedCategory", category);

        Result result = new Result();
        result.setRedirect(false);
        result.setPath(request.getContextPath() + "/app/community/comu-main.jsp");
        return result;
    }
}