<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/member/mem-id-find.css" />
</head>
<%@ include file="/header.jsp"%>
<body>
 <main>
    <div class="login-find">
      <h3>아이디찾기</h3>
      <form action="" method="">
        <div class="container">
          <!-- 이름 -->
          <div class="name">이름
          <input type="text" id="username"></div>
          <!-- 전화번호 -->
          <div class="p-number">전화번호
          <input type="text" id="user-p-number" placeholder="&nbsp;&nbsp;-없이 숫자만 입력">
          <!-- 인증번호 버튼 -->
          <button class="p-number-button"> 인증번호 받기</button></div>
          <!-- 인증번호 입력 칸 -->
          <div class="p-number-ok">
            <input type="text" id="p-number-ok-box" placeholder="&nbsp;&nbsp;인증번호를 입력하세요"></div>
          <button class="login-ok">확인</a></button>
          
          
        </div>
        
      </form>
    </div>

</body>
<%@ include file="/footer.jsp"%>
</html>