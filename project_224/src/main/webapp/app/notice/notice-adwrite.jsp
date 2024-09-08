<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0" />
  <title>공지쏙쏙 글쓰기</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/notice/notice-adwrite.css" />
<!-- 추가부분 -->
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <link href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css" rel="stylesheet">
  <link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.css" rel="stylesheet">

</head>
<%@ include file="../../header.jsp"%>

<body>
  <div class="notice-board-wrap">
    <div class="notice-board-title">
      <h1>공지사항 게시판</h1>
    </div>
    <form method="get">
      <div class="notice-board-write-wrap">
        <div class="notice-board-write">
          <div class="notice-title">
            <input id="notice-board-title" name="notbTitle" type="text" placeholder="제목을 입력해 주세요" />
          </div>
          <div class="notice-cont">
		    <!-- <div id="summernote"></div> -->
		    <form action="${pageContext.request.contextPath}/notice/notice-addetail.no" method="post">
		        <textarea id="summernote" name="editordata"></textarea>
		        <p id="letter-length" style="display: inline;"></p>/1000
		    </form>
          </div>
        </div>
      </div>
      <div class="notice-button-container">
        <button class="notice-action-button" type="button" onclick="location.href='../notice/notice-admain.jsp'">
          이전
        </button>
        <button class="notice-action-button" type="button" onclick="location.href='../notice/notice-addetail.jsp'">
          등록
        </button>
      </div>
    </form>
  </div>
</body>

<%@ include file="../../footer.jsp"%>
<script src="${pageContext.request.contextPath}/assets/js/notice/notice-adwrite.js"></script>
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.js"></script>


</html>

