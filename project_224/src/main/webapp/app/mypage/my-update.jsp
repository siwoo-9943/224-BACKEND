<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/mypage/my-update.css" />

</head>
<body>
	  <main>
    <!-- 목록 -->
    <div class="my-updateBox">
      <div class="my-leftbox">
        <div class="my-hello">
          <div class="my-wellcome">반가워요!</div>
          <div class="my-nickname">"금쪽이"님</div>
        </div>
        <div class="my-category">
          <div class="my-category-menu">메뉴</div>
          <div class="my-line"></div>
          <a href="${pageContext.request.contextPath}/app/mypage/my-passcheck.jsp">
          <div class="my-category-menu">개인정보수정</div></a>
          <a href="${pageContext.request.contextPath}/app/mypage/my-comunity.jsp">
          <div class="my-category-menu">내가 작성한 글</div></a>
          <a href="${pageContext.request.contextPath}/app/mypage/my-pick.jsp">
          <div class="my-category-menu">찜목록</div></a>
          <a href="${pageContext.request.contextPath}/app/mypage/my-quit.jsp">
          <div class="my-category-menu">회원탈퇴</div></a>
        </div>
      </div>

    <!-- 회원정보수정 -->
    <div class="my-rightbox">
      <form action="" method="">
        <div class="my-update">
          <div class="my-update-title">개인정보수정</div>
          <div class="my-line"></div>

          <div class="my-update-center">

            <div class="my-update-menu">
              <div class="my-update-value">닉네임</div>
              <input type="text" class="my-update-input">
              <button type="button" class="my-update-value-check">중복확인</button>
            </div>

            <div class="my-update-menu">
              <div class="my-update-value">새비밀번호</div>
              <input type="password" class="my-update-input" id="my-newPW">
            </div>

            <div class="my-update-menu">
              <div class="my-update-value">비밀번호확인</div>
              <input type="password" class="my-update-input" id="my-newPWC">
            </div>

            <div class="my-update-passCheck"></div>

            <div class="my-update-menu">
              <div class="my-update-value">이름</div>
              <input type="text" class="my-update-input">
            </div>

            <div class="my-update-menu">
              <div class="my-update-value">휴대폰</div>
              <input type="text" class="my-update-input">
              <button type="button" class="my-update-value-check2">휴대폰번호인증</button>
            </div>
            
            <div class="my-update-menu-check">
              <div class="my-update-menu">
                <div class="my-update-value"></div>
                <input type="text" class="my-update-input" placeholder="인증번호를 입력하세요">
                <button type="button" class="my-update-value-Recheck">인증확인</button>
              </div>
            </div>

            <div class="my-update-menu">
              <div class="my-update-value">성별</div>
              <input type="radio" name="userGender" value="남자">남자
              <input type="radio" name="userGender" value="여자">여자
              <input type="radio" name="userGender" value="선택안함">선택안함
            </div>

            <div class="my-update-menu">
              <div class="my-update-value">생년월일</div>
              <input type="text" class="my-update-input">
            </div>

            <div class="my-line"></div>

            <!-- 이벤트 수신 동의 -->
            <div class="my-update-event">
              <div class="my-update-evnetSelect-up">
                <div class="my-update-value">선택약관동의</div>
                <div class="my-update-evnetSelect-sub"><input type="checkbox" name="userEvent" value="">이벤트 등 혜택/정보 수신 동의(선택)</div>
              </div>
            </div>

          <a href="${pageContext.request.contextPath}/app/mypage/my-profile.jsp"><button type="button" class="my-update-button">개인정보수정</button></a>

        </div>
      </form>
    </div>
  </main>
  <script src="${pageContext.request.contextPath}/assets/js/mypage/my-update.js"></script>
</body>
</html>