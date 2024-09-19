package com.pj224.app.hotplace;

import java.io.IOException;
import java.rmi.ServerException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.pj224.app.MemExecute;
import com.pj224.app.Result;
import com.pj224.app.dao.HotplaceDAO;
import com.pj224.app.dto.HotplaceDTO;
import com.pj224.app.dto.LikeDTO;
import com.pj224.app.dto.MemberDTO;

public class HotplaceListController implements MemExecute {

    @Override
    public Result MemExecute(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServerException, ServletException {
        request.setCharacterEncoding("UTF-8");
        Result result = new Result();
        
        HttpSession session = request.getSession();
        HotplaceDAO hotplaceDAO = new HotplaceDAO();
        
        // 세션에서 MemberDTO 객체 가져오기
        MemberDTO member = (MemberDTO) session.getAttribute("member");
        System.out.println(member); // MemberDTO의 전체 정보 출력

        int memberNumber;
        if (member != null) {
            // MemberDTO에서 memberNumber 가져오기
            memberNumber = member.getMemberNumber(); // memberNumber를 가져오는 메서드를 호출
            System.out.println("memberNumber: " + memberNumber);
        } else {
            memberNumber = 0; // 세션에 MemberDTO가 없을 때 기본값 설정
            System.out.println("세션에 member가 없음");
        }
        
        String target = (String) request.getAttribute("target");
        List<HotplaceDTO> hotplaceList = null;
        String forwardPath = "";

        switch (target) {
            case "/hotplace/hotplace-euljiro.hp":
                hotplaceList = hotplaceDAO.showInfo("을지로입구역");
                forwardPath = "/app/hotplace/hotplace-euljiro.jsp";
                break;
            case "/hotplace/hotplace-gangnam.hp":
                hotplaceList = hotplaceDAO.showInfo("강남역");
                forwardPath = "/app/hotplace/hotplace-gangnam.jsp";
                break;
            case "/hotplace/hotplace-hongdae.hp":
                hotplaceList = hotplaceDAO.showInfo("홍대입구역");
                forwardPath = "/app/hotplace/hotplace-hongdae.jsp";
                break;
            case "/hotplace/hotplace-jamsil.hp":
                hotplaceList = hotplaceDAO.showInfo("잠실역");
                forwardPath = "/app/hotplace/hotplace-jamsil.jsp";
                break;
            case "/hotplace/hotplace-moonrae.hp":
                hotplaceList = hotplaceDAO.showInfo("문래역");
                forwardPath = "/app/hotplace/hotplace-moonrae.jsp";
                break;
            case "/hotplace/hotplace-seongsu.hp":
                hotplaceList = hotplaceDAO.showInfo("성수역");
                forwardPath = "/app/hotplace/hotplace-seongsu.jsp";
                break;
            default:
                result.setRedirect(false);
                result.setPath(request.getContextPath() + "/app/hotplace/hotplace.jsp");
                return result;
        }

        List<LikeDTO> likeList = hotplaceDAO.checkLike(memberNumber);
        
        request.setAttribute("hotplaceList", hotplaceList);
        request.setAttribute("likeList", likeList);
        
        result.setRedirect(false);
        result.setPath(request.getContextPath() + forwardPath);
        return result;
    }
}
