<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0" />
  <title>관리자 목록</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/notice/notice-admain.css">
</head>


<%@ include file="../../header.jsp"%>
<body>
 <body>
  <!-- 페이지의 메인 부분 -->
  <div class="wrapper">
    <div class="notice-admain-all">
      <!-- 게시판 부분 -->
      <div class="notice-admain-main">
        <!-- 게시판 상단부 '공지사항' -->
        <div class="notice-admain-toptxt">
          <div class="notice-admain-toptxt-in">
            <h2 class="notice-admain-toptxt-txt">공지사항</h2>
          </div>
        </div>
        <!-- 게시글 칼럼 구분 -->
        <div class="notice-admain-container">
          <div width="50" class="notice-admain-container-cate">분류</div>
          <div class="notice-admain-container-title">제목</div>
          <div width="100" class="notice-admain-container-audate">작성자</div>
          <div width="100" class="notice-admain-container-audate">작성일</div>
        </div>
        <!-- 게시글 목록 -->
        <ul class="notice-admain-ul-all">
         <c:forEach var="notice" items="${noticeshowlist}">
			<li>
            	<a href="${pageContext.request.contextPath}/app/notice/notice-addetail.jsp">
              		<div class="notice-admain-ul-main">
	                	<div class="notice-admain-ul-cate">${notice.noticeCate}</div>
	                	<div class="notice-admain-ul-title">${notice.noticeTitle}</div>
	                	<div class="notice-admain-ul-author">관리자</div>
	                	<div class="notice-admain-ul-date">${notice.noticeRegistDate}</div>
              		</div>
            	</a>
			</li>
         </c:forEach>

          <!-- 추가 게시글 항목 -->
        </ul>
        <!-- 페이지 앞/뒤로 넘기기 버튼 -->
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
        <div class="notice-admain-btuall">
          <button class="notice-admain-btu" type="button" onclick="location.href='../notice/notice-adwrite.jsp'">
            <span class="notice-admain-btu-sp">글쓰기</span>
          </button>
        </div>
      </div>
    </div>

</body>
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.js"></script>
</html>