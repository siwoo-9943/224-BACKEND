<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>커뮤톡톡 - 글 작성</title>

    <!-- External CSS & JS -->
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/community/comu-write.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/modal/comu-modal.css" />
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.css" rel="stylesheet">
    
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
		    <form method="post">
		        <textarea id="summernote" name="editordata"></textarea>
		        <p id="letter-length" style="display: inline;"></p>/100
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
  <!-- 뒤로가기 모달창 -->
    <div id="comu-backModal" class="comu-modal">
        <div class="comu-modal-content">
            <span class="comu-close" onclick="closeBackModal()">&times;</span>
            <h2>정말로 뒤로가시겠습니까?</h2>
            <p>뒤로가기 버튼을 클릭하면 작성한 내용은 저장되지 않습니다.</p>
            <button class="confirm-btn" onclick="confirmBack()">뒤로가기</button>
            <button class="comu-cancel-btn" onclick="closeBackModal()">취소</button>
        </div>
    </div>
</body>
<%@ include file="../../footer.jsp"%>
<!-- External JS -->
<script src="${pageContext.request.contextPath}/assets/js/modal/comu-modal.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.js"></script>

<%@ include file="../../footer.jsp"%>


</html>