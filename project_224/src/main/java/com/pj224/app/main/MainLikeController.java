package com.pj224.app.main;

import java.io.IOException;
import java.rmi.ServerException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pj224.app.MemExecute;
import com.pj224.app.Result;
import com.pj224.app.dao.HotplaceDAO;
import com.pj224.app.dto.LikeDTO;

public class MainLikeController implements MemExecute {

    @Override
    public Result MemExecute(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServerException, ServletException {
        try {
            String memberNumberStr = request.getParameter("memberNumber");
            String hotplaceNumberStr = request.getParameter("hotplaceNumber");
            String pageStr = request.getParameter("page");
            String returnUrlParam = request.getParameter("returnUrl");

            if (memberNumberStr == null || hotplaceNumberStr == null || pageStr == null || returnUrlParam == null) {
                throw new IllegalArgumentException("Required parameters are missing.");
            }

            int memberNumber = Integer.parseInt(memberNumberStr);
            int hotplaceNumber = Integer.parseInt(hotplaceNumberStr);
            int page = Integer.parseInt(pageStr);

            String[] str2 = returnUrlParam.split("/");
            String returnUrl = str2[str2.length - 1].replace("jsp", "hp") + "?page=" + page;

            HotplaceDAO hotplaceDAO = new HotplaceDAO();
            hotplaceDAO.unpickHotplace(new LikeDTO(hotplaceNumber, memberNumber));

            Result result = new Result(); // Result 객체 생성
            result.setPath(returnUrl + "&memberNumber=" + memberNumber); // path 설정
            result.setRedirect(true); // isRedirect 설정

            return result; // 수정된 Result 객체 반환

        } catch (NumberFormatException e) {
            // 로그를 남기거나 적절한 오류 페이지로 리턴
            e.printStackTrace();
            return null; // 오류 페이지로 리턴
        } catch (IllegalArgumentException e) {
            // 로그를 남기거나 적절한 오류 페이지로 리턴
            e.printStackTrace();
            return null; // 오류 페이지로 리턴
        }
    }
}