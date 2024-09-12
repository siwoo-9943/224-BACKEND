package com.pj224.app.member;

import java.io.IOException;
import java.rmi.ServerException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.pj224.app.MemExecute;
import com.pj224.app.Result;

public class JoinSMSController implements MemExecute {
    @Override
    public Result MemExecute(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServerException, ServletException {
        String phoneNumber = request.getParameter("phoneNumber");
        SmsService smsService = new SmsService();
        try {
            String verificationCode = smsService.sendVerificationSms(phoneNumber);
            // 세션에 인증 코드 저장
            HttpSession session = request.getSession();
            session.setAttribute("verificationCode", verificationCode);
            response.setContentType("text/plain");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write("인증번호가 발송되었습니다.");
        } catch (Exception e) {
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            response.getWriter().write("SMS 발송 실패: " + e.getMessage());
        }
        return null; // AJAX 요청을 처리하므로 null을 반환
    }
}