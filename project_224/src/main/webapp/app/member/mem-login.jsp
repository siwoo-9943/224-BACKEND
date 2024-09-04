<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/member/mem-login.css" />
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
</head>
<body>
 <main>
    <div class="login">
      <h3>로그인</h3>
      <form>
        <div class="container">
          <div class="id">아이디</div>
          <div class="input-field">
            <input type="text" id="username" placeholder="&nbsp;&nbsp;224@gmail.com">
            <div class="login-input-border"></div>
          </div>
          <div class="error-message" id="error-message"></div>

          <div class="pw">비밀번호</div>
          <div class="input-field">
            <input type="password" id="password" placeholder="&nbsp;&nbsp;비밀번호를 입력하세요">
            <div class="login-input-border"></div>
          </div>
          <div class="error-message" id="error-message-pw"></div>
          <button type="submit" class="login-bt">로그인</button>

          <ul class="find-id">
            <li><a href="../../html/member/mem-id-find.html">아이디 찾기</a></li>
            <li><a href="../../html/member/mem-pw-find.html">비밀번호 찾기</a></li>
          </ul>

          <button class="login-join"><a href="">회원가입</a></button>
        </div>
      </form>
    </div>
  </main>
<script src="${pageContext.request.contextPath}/assets/js/member/mem-login.js"></script>
</body>
</html>