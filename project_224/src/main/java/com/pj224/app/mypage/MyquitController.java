package com.pj224.app.mypage;

import java.io.IOException;
import java.rmi.ServerException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.pj224.app.MemExecute;
import com.pj224.app.Result;
import com.pj224.app.dao.MypageDAO;
import com.pj224.app.dto.MemberDTO;
import com.pj224.app.dto.MypageDTO;

public class MyquitController implements MemExecute {

   @Override
   public Result MemExecute(HttpServletRequest request, HttpServletResponse response)
         throws IOException, ServerException, ServletException {
      HttpSession session = request.getSession();
      

      System.out.println("탈퇴 컨트롤러 들어옴");
      // 인코딩 설정확인
      request.setCharacterEncoding("UTF-8");
      
      MemberDTO member = (MemberDTO) session.getAttribute("member");
      String memberNumberStr = request.getParameter("memberNumber");
      System.out.println(memberNumberStr);
      
//      // Null 또는 빈 문자열 확인
//       if (memberNumberStr == null || memberNumberStr.trim().isEmpty()) {
//           throw new IllegalArgumentException("memberNumber는 null 또는 빈 문자열일 수 없습니다.");
//       }

      // MemberDTO와 DAO 객체 생성
      MypageDTO mypageDTO = new MypageDTO();
      MypageDAO mypageDAO = new MypageDAO();
      boolean delete = mypageDAO.delete(memberNumberStr);
      Result result = new Result();

      

      System.out.println("탈퇴 컨트롤러 실행됨" + memberNumberStr);

//      String memberNumber = request.getParameter("memberNumber");
//      System.out.println(memberNumber + "넘버 값 들어오셈");
      
      if(delete != true) {
         System.out.println("회원탈퇴 성공");
         response.sendRedirect(request.getContextPath() + "/main.jsp");
      }else {
         System.out.println("회원탈퇴 실패");
         response.sendRedirect(request.getContextPath() + "/app/mypage/my-quit.jsp");
      }
         if (session != null) {
               session.invalidate(); // 세션 무효화
               System.out.println("세션 무효화");
            }
            // 쿠키 삭제
            Cookie cookie = new Cookie("memberNumber", null);
            cookie.setMaxAge(0);
            response.addCookie(cookie);
            System.out.println(cookie);
            System.out.println("쿠키삭제");

      return result;
   }

}
