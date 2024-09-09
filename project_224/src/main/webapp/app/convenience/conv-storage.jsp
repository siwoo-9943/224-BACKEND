<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/convenience/conv-storage.css">
</head>
<body>
	<jsp:include page="/header.jsp" />
  <div style="position: relative; height: 350px;">
    <div style="position: absolute; left: 0px; bottom: 0px; right: 0px; z-index: 10;">
      <div style="width: 100%; max-width: 1200px; margin: 0 auto 30px;"><span
          style="font-size: 58px; color: #fff; font-weight: 700;">강남역</span></div>
    </div>
    <div style="background-image: url(${pageContext.request.contextPath}/assets/images/hotplace.png); width: 100%; height: 100%;"></div>
  </div>
  <div class="sub-contents-inner gettingToSeoul" id="container">
    <div class="loction">
      <span class="ar">&gt;</span>
      여행정보<span class="ar">&gt;</span>
      <span><a href="" title="페이지 이동">강남역</a></span>
    </div>
    <div style="position: relative; height: 50px;">
      <div style="height: 100%;"></div>
    </div>
  </div>
  <div>
    <span class="conv-band">
    <a href="${pageContext.request.contextPath}/convenience/conv-storage-gangnam.cv">강남역</a>|
    <a href="${pageContext.request.contextPath}/convenience/conv-storage-jamsil.cv">잠실역</a>|
    <a href="${pageContext.request.contextPath}/convenience/conv-storage-hongdae.cv">홍대입구역</a>|
    <a href="${pageContext.request.contextPath}/convenience/conv-storage-seongsu.cv">성수역</a>|
    <a href="${pageContext.request.contextPath}/convenience/conv-storage-moonrae.cv">문래역</a>|
    <a href="${pageContext.request.contextPath}/convenience/conv-storage-euljiro.cv">을지로입구역</a>
    </span>
  </div>
  <div>
    <div class="conv-storage-contents-wrapper">
      <a href="${pageContext.request.contextPath}/convenience/conv-storage-gangnam.cv">
        <div class="conv-storage-content-left">
          <div class="conv-storage-content-name" style="margin-bottom: 10px;">
            <h1 style="display: inline; margin: 0;">강남역 </h2>
          </div>
          <img src="${pageContext.request.contextPath}/assets/images/1.png" style="height: 256px; width: 256px; border: 1px solid black;">
        </div>
      </a>
      <div class="conv-storage-content-right">
        <div class="conv-storage-content-right-text">
          <h2>&nbsp;이름 : 강남 1 ~ 52 , 강남 53 ~ 78
            <br><br>
            &nbsp;위치 : 강남역 1번 12번 출입구 게이트 주변,<br>
            <br>강남역 1번 12번 출입구 통로 상가 맞은편
            
          </h2>
        </div>
      </div>
    </div>
    <div class="conv-storage-contents-wrapper">
        <a href="${pageContext.request.contextPath}/convenience/conv-storage-jamsil.cv">
        <div class="conv-storage-content-left">
          <div class="conv-storage-content-name" style="margin-bottom: 10px;">
            <h1 style="display: inline; margin: 0;">잠실역 </h2>
          </div>
          <img src="${pageContext.request.contextPath}/assets/images/1.png" style="height: 256px; width: 256px; border: 1px solid black;">
        </div>
      </a>
      <div class="conv-storage-content-right">
        <div class="conv-storage-content-right-text">
          <h2>&nbsp;이름 : 잠실 109 ~ 125
            <br><br>
            &nbsp;위치 : 잠실역 B1층 10, 11번 출구 방면 (통로)
          </h2>
        </div>
      </div>
    </div>
    <div class="conv-storage-contents-wrapper">
      <a href="${pageContext.request.contextPath}/convenience/conv-storage-hongdae.cv">
        <div class="conv-storage-content-left">
          <div class="conv-storage-content-name" style="margin-bottom: 10px;">
            <h1 style="display: inline; margin: 0;">홍대입구역 </h2>
          </div>
          <img src="${pageContext.request.contextPath}/assets/images/1.png" style="height: 256px; width: 256px; border: 1px solid black;">
        </div>
      </a>
      <div class="conv-storage-content-right">
        <div class="conv-storage-content-right-text">
          <h2>&nbsp;이름 : 홍대 입구 1 ~ 33, 홍대 입구 34 ~ 65
            <br><br>
            &nbsp;위치 : 2번 8번 출입구 주변 
          </h2>
        </div>
      </div>
    </div>
    <div class="conv-storage-contents-wrapper">
      <a href="${pageContext.request.contextPath}/convenience/conv-storage-seongsu.cv">
        <div class="conv-storage-content-left">
          <div class="conv-storage-content-name" style="margin-bottom: 10px;">
            <h1 style="display: inline; margin: 0;">성수역 </h2>
          </div>
          <img src="${pageContext.request.contextPath}/assets/images/1.png" style="height: 256px; width: 256px; border: 1px solid black;">
        </div>
      </a>
      <div class="conv-storage-content-right">
        <div class="conv-storage-content-right-text">
          <h2>&nbsp;이름 : 성수 1 ~ 28 , 성수 29 ~ 45
            <br><br>
            &nbsp;위치 : 1번 4번 출입구 주변
          </h2>
        </div>
      </div>
    </div>
    <div class="conv-storage-contents-wrapper">
      <a href="${pageContext.request.contextPath}/convenience/conv-storage-moonrae.cv">
        <div class="conv-storage-content-left">
          <div class="conv-storage-content-name" style="margin-bottom: 10px;">
            <h1 style="display: inline; margin: 0;">문래역 </h2>
          </div>
          <img src="${pageContext.request.contextPath}/assets/images/1.png" style="height: 256px; width: 256px; border: 1px solid black;">
        </div>
      </a>
      <div class="conv-storage-content-right">
        <div class="conv-storage-content-right-text">
          <h2>&nbsp;이름 : 문래
            <br><br>
            &nbsp;위치 : 2번 출입구 통로
          </h2>
        </div>
      </div>
    </div>
    <div class="conv-storage-contents-wrapper">
      <a href="${pageContext.request.contextPath}/convenience/conv-storage-euljiro.cv">
        <div class="conv-storage-content-left">
          <div class="conv-storage-content-name" style="margin-bottom: 10px;">
            <h1 style="display: inline; margin: 0;">을지로입구역 </h2>
          </div>
          <img src="${pageContext.request.contextPath}/assets/images/1.png" style="height: 256px; width: 256px; border: 1px solid black;">
        </div>
      </a>
      <div class="conv-storage-content-right">
        <div class="conv-storage-content-right-text">
           <h2>&nbsp;이름 : 을지로 입구 1 ~ 25, 을지로 입구 26 ~ 50
            <br><br>
            &nbsp;위치 : 중앙게이트주변, 3번 4번 출입구 방향 통로
          </h2>
        </div>
      </div>
    </div>
  </div>
</body>
<jsp:include page="/footer.jsp" />
</html>