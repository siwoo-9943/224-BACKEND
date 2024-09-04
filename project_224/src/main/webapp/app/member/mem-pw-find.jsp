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
<body>
<main>
    <div class="pw-find">
      <h3>비밀번호 찾기</h3>
      <form>
        <div class="container">
          <div class="name">이름
            <input type="text" id="name">
          </div>
          <div class="e-mail">이메일
            <input type="text" id="e-mail" placeholder="&nbsp;&nbsp;email@gogle.com">
          </div>
          <div class="pw-info">
            <div class="pw-info-cate">
              <div class="pw-name">휴대폰</div>
              <input type="text" id="pw-number">
              <button class="numberok"> 인증번호 받기</button>
            </div>
          </div>
            <div class="pw-p-number-ok">
              <input type="text" id="pw-p-number-ok-box" placeholder="&nbsp;&nbsp;인증번호를 입력하세요">
            </div>
            <button type="button" class="pw-ok" onclick="openModal()"> 확인</button>
          
          <div id="mem-Modal" class="mem-modal">
            <div class="mem-modal-content">
              <span class="mem-close" onclick="closeDeleteModal()">&times;</span>
              <h2>이메일을 전송되었습니다</h2>
              <p>이메일을 확인해주세요.</p>
              <button class="mem-cancel-btn" onclick="closeDeleteModal()">확인</button>
            </div>
          </div>
        </div>
      </form>
    </div>
  </main>

</body>
</html>