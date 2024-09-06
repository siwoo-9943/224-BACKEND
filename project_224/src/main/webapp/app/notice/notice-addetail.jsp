<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0" />
  <title>관리자 상세페이지</title>
  <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/notice/notice-addetail.css" />
  <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/modal/notice-modal.css" />
</head>
<%@ include file="../../header.jsp"%>
<body>
  <!-- 페이지의 메인 부분 -->
  <div class="notice-addetail-all">
    <div class="notice-addetail-top">
      <div class="notice-addetail-txt">공지사항</div>
    </div>
    <div class="notice-addetail-main">
      <div class="notice-addetail-content">
        <div class="notice-addetail-tcontent">제목</div>
        <div class="notice-addetail-ttxt">${notice.noticeTitle}</div>
      </div>
      <div class="notice-addetail-content">
        <div class="notice-addetail-tcontent">작성자</div>
        <div class="notice-addetail-ttxt">${notice.memberNumber}</div>
      </div>
      <div class="notice-addetail-content">
        <div class="notice-addetail-tcontent">작성일</div>
        <div class="notice-addetail-ttxt">${notice.noticeRegistDate}</div>
      </div>
      <div class="notice-addetail-maincont">
         <c:forEach var="notice" items="${noticeshowlist}">
			<li>
            	<a href="${pageContext.request.contextPath}/app/notice/notice-addetail.jsp">
              		<div class="notice-addetail-maincont">
	                	<div class="notice-admain-ul-cate">${notice.noticeCate}</div>
	                	<div class="notice-admain-ul-title">${notice.noticeTitle}</div>
	                	<div class="notice-admain-ul-author">${notice.memberNumber}</div>
	                	<div class="notice-admain-ul-date">${notice.noticeRegistDate}</div>
              		</div>
            	</a>
			</li>
         </c:forEach>
      </div>
      <div class="notice-addetail-btuall">
        <button onclick="location.href='notice-admain.jsp'" class="notice-addetail-btu" type="button">
          <span class="notice-addetail-btu-sp">목록</span>
        </button>
      </div>
      <div class="notice-addetail-btuleft">
        <button onclick="location.href='notice-admodify.jsp'" class="notice-addetail-modi" type="button">
          <span class="notice-addetail-btu-sp">수정</span>
        </button>
      </div>
      <div class="notice-addetail-btuleft">
        <button class="notice-addetail-del" type="button" onclick="openDeleteModal()">
          <span class="notice-addetail-btu-sp">삭제</span>
        </button>
      </div>
      <!-- 삭제 모달 HTML -->
      <div id="notice-deleteModal" class="notice-modal">
        <div class="notice-modal-content">
          <span class="notice-close" onclick="closeDeleteModal()">&times;</span>
          <h2>정말로 삭제하시겠습니까?</h2>
          <p>삭제 버튼을 클릭하면 항목이 영구히 삭제됩니다.</p>
          <button class="confirm-btn" onclick="confirmDelete()">삭제</button>
          <button class="notice-cancel-btn" onclick="closeDeleteModal()">취소</button>
        </div>
      </div>
    </div>
  </div>
</body>
<%@ include file="../../footer.jsp"%>
<script src="../../assets/js/modal/notice-modal.js"></script>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.js"></script>

</html>