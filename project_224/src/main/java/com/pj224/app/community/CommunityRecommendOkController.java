package com.pj224.app.community;

import java.io.IOException;
import java.io.PrintWriter;
import java.rmi.ServerException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.pj224.app.MemExecute;
import com.pj224.app.Result;
import com.pj224.app.dao.CommunityDAO;
import com.pj224.app.dto.MemberDTO;
import com.pj224.app.dto.RecommendDTO;

public class CommunityRecommendOkController implements MemExecute {

    @Override
    public Result MemExecute(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServerException, ServletException {

        System.out.println("추천컨트롤러 들어옴??");
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/plain;charset=UTF-8");
        PrintWriter out = response.getWriter();

        try {
            HttpSession session = request.getSession();
            MemberDTO member = (MemberDTO) session.getAttribute("member");
            System.out.println("추천세션 들어옴??");

            // 회원 정보가 없으면 로그인 페이지로 리다이렉트
            if (member == null) {
                out.print("login_required");
                return null;
            }

            int memberNumber = member.getMemberNumber();
            int boardNumber = Integer.parseInt(request.getParameter("boardNumber"));

            CommunityDAO communityDAO = new CommunityDAO();

            // 이미 추천했는지 확인
            boolean alreadyRecommended = communityDAO.hasAlreadyRecommended(boardNumber, memberNumber);

            if (!alreadyRecommended) {
                // 추천 추가
                RecommendDTO recommendDTO = new RecommendDTO();
                recommendDTO.setMemberNumber(memberNumber);
                recommendDTO.setBoardNumber(boardNumber);
                communityDAO.pickRecommend(recommendDTO);

                out.print("success");
            } else {
                // 이미 추천한 경우
                out.print("already");
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid boardNumber format");
            out.print("error");
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
            e.printStackTrace();
            out.print("error");
        } finally {
            out.close();
        }

        return null; // AJAX 요청이므로 null 반환
    }
}