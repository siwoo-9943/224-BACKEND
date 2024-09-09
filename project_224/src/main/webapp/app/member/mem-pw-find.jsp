<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/member/mem-pw-find.css" />
</head>
<%@ include file="/header.jsp"%>
<body>
<main>
    <div class="pw-find">
      <h3>비밀번호 찾기</h3>
      <form action="${pageContext.request.contextPath}/member/pwFindOk.me" method="post">
        <div class="container">
          <div class="name">이름
            <input type="text" id="name" name="memberName">
          </div>
          <div class="e-mail">이메일
            <input type="text" id="e-mail" placeholder="&nbsp;&nbsp;email@gogle.com" name="memberEmail">
          </div>
          <div class="pw-info">
            <div class="pw-info-cate">
              <div class="pw-name">휴대폰</div>
              <input type="text" id="pw-number" name="memberPhone">
              <button class="numberok"> 인증번호 받기</button>
            </div>
          </div>
            <div class="pw-p-number-ok">
              <input type="text" id="pw-p-number-ok-box" placeholder="&nbsp;&nbsp;인증번호를 입력하세요" name="memberPhoneInput">
            </div>
            <button type="submit" class="pw-ok"> 확인</button>
        </div>
      </form>
    </div>
  </main>

</body>
<%@ include file="/footer.jsp"%>
</html>