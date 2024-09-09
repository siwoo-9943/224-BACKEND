<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/member/mem-idfine-result.css" />
</head>
<%@ include file="/header.jsp"%>
<body>
<div class="wrapper">
    <div class="head">
      <h1>아이디 찾기</h1>
    </div>

    <div class="info-text">
      <p>고객님의 정보와 일치하는 아이디 목록입니다.</p>
    </div>

    <div class="result-wrapper">
      <label>
        <span>아이디 : ${member2}</span><br>
      </label>
    </div>

    <div class="buttons">
      <a href="http://localhost:9999/app/member/mem-login.jsp" ><button type="submit">로그인하기</button></a>
      <a href="http://localhost:9999/app/member/mem-pw-find.jsp" ><button type="submit">비밀번호 찾기</button></a>
    </div>
  </div>

</body>
<%@ include file="/footer.jsp"%>
</html>