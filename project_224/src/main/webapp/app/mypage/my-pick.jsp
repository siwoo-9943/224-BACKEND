<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/mypage/my-pick.css" />
</head>
<%@ include file="../../header.jsp"%>
<body>
	<main>
    <!-- 목록 -->
    <div class="my-pickBox">
      <div class="my-leftbox">
        <div class="my-hello">
          <div class="my-wellcome">반가워요!</div>
          <div class="my-nickname">"${sessionScope.member.memberName}"님</div>
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

      <!-- 찜 목록 -->
      <div class="my-rightbox">
        <div class="my-pick">
          <div class="my-pick-title">찜 목록</div>
          <div class="my-line"></div>

          <div class="my-pick-center">

            <div class="my-pick-box">
              <div class="my-pick-area">
                <div class="my-pick-textArea">
                  <div class="my-pick-name">롯데월드</div>
                  <img src="../../assets/images/picked.png" width="30px" height="30px">
                </div>
                <div class="my-pick-pictureArea">
                  <a href="#" target="_blank"><img src="../../assets/images/main-seoul.jpg" width="190px" height="240px"></a>
                </div>
              </div>
              <div class="my-pick-area">
                <div class="my-pick-textArea">
                  <div class="my-pick-name">롯데월드</div>
                  <img src="../../assets/images/picked.png" width="30px" height="30px">
                </div>
                <div class="my-pick-pictureArea">
                  <img src="../../assets/images/main-seoul.jpg" width="190px" height="240px">
                </div>
              </div>
              <div class="my-pick-area">
                <div class="my-pick-textArea">
                  <div class="my-pick-name">롯데월드</div>
                  <img src="../../assets/images/picked.png" width="30px" height="30px">
                </div>
                <div class="my-pick-pictureArea">
                  <img src="../../assets/images/main-seoul.jpg" width="190px" height="240px">
                </div>
              </div>
            </div>

            <div class="my-pick-box">
              <div class="my-pick-area">
                <div class="my-pick-textArea">
                  <div class="my-pick-name">롯데월드</div>
                  <img src="../../assets/images/picked.png" width="30px" height="30px">
                </div>
                <div class="my-pick-pictureArea">
                  <img src="../../assets/images/main-seoul.jpg" width="190px" height="240px">
                </div>
              </div>
              <div class="my-pick-area">
                <div class="my-pick-textArea">
                  <div class="my-pick-name">롯데월드</div>
                  <img src="../../assets/images/picked.png" width="30px" height="30px">
                </div>
                <div class="my-pick-pictureArea">
                  <img src="../../assets/images/main-seoul.jpg" width="190px" height="240px">
                </div>
              </div>
              <div class="my-pick-area">
                <div class="my-pick-textArea">
                  <div class="my-pick-name">롯데월드</div>
                  <img src="../../assets/images/picked.png" width="30px" height="30px">
                </div>
                <div class="my-pick-pictureArea">
                  <img src="../../assets/images/main-seoul.jpg" width="190px" height="240px">
                </div>
              </div>
            </div>

            <div class="my-pick-box">
              <div class="my-pick-area">
                <div class="my-pick-textArea">
                  <div class="my-pick-name">롯데월드</div>
                  <img src="../../assets/images/picked.png" width="30px" height="30px">
                </div>
                <div class="my-pick-pictureArea">
                  <img src="../../assets/images/main-seoul.jpg" width="190px" height="240px">
                </div>
              </div>
              <div class="my-pick-area">
                <div class="my-pick-textArea">
                  <div class="my-pick-name">롯데월드</div>
                  <img src="../../assets/images/picked.png" width="30px" height="30px">
                </div>
                <div class="my-pick-pictureArea">
                  <img src="../../assets/images/main-seoul.jpg" width="190px" height="240px">
                </div>
              </div>
              <div class="my-pick-area">
                <div class="my-pick-textArea">
                  <div class="my-pick-name">롯데월드</div>
                  <img src="../../assets/images/picked.png" width="30px" height="30px">
                </div>
                <div class="my-pick-pictureArea">
                  <img src="../../assets/images/main-seoul.jpg" width="190px" height="240px">
                </div>
              </div>
            </div>

            <div class="info-bg2">
              <div class="bottom-list">
                <a class="prev" onfocus="blur()" href="#"></a>
                <a class="num on" onfocus="blur()" href="#">1</a>
                <a class="num" onfocus="blur()" href="#">2</a>
                <a class="num" onfocus="blur()" href="#">3</a>
                <a class="num" onfocus="blur()" href="#">4</a>
                <a class="num" onfocus="blur()" href="#">5</a>
                <a class="next" onfocus="blur()" href="#"></a>
              </div>
            </div>

          </div>

        </div>
      </div>
    </div>

  </main>
</body>
<%@ include file="../../footer.jsp"%>
</html>