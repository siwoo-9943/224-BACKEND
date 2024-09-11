<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0" />
  <title>수정 상세페이지</title>
  <script>var contextPath = '${pageContext.request.contextPath}';
</script>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/notice/notice-admodify.css" />
  <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/modal/notice-modal.css" />
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
    
    <!-- 하나의 form으로 통합 -->
    <form action="${pageContext.request.contextPath}/notice/modifyOk.no" method="post">
    	<input type="hidden" name="noticeNumber" value="${notice.noticeNumber}"> 
      <div class="notice-board-write-wrap">
        <div class="notice-board-write">
          <div class="notice-title">
            <input id="notice-board-title" name="noticeTitle" type="text" value="${notice.noticeTitle}" placeholder="제목을 입력해 주세요" />
          </div>
          	<div class="notice-category">
				<label for="notice-category-select">카테고리 선택:</label> 
					<select	id="notice-category-select" name="noticeCate">
					   <option value="안내" <c:if test="${notice.noticeCate == '안내'}">selected</c:if>>안내</option>
   					   <option value="이벤트" <c:if test="${notice.noticeCate == '이벤트'}">selected</c:if>>이벤트</option>
					</select>
			</div>
          <div class="notice-cont">
            <textarea id="summernote" name="noticeContent">${notice.noticeContent}</textarea>
 <!--            <p id="letter-length" style="display: inline;"></p>/1000 -->
          </div>
        </div>
      </div>
      <div class="notice-button-container">
        <button class="notice-action-button" type="button" onclick="location.href='${pageContext.request.contextPath}/notice/notice-admain.no'">
          이전
        </button>
		<button class="notice-action-button" type="submit" id="submitButton">수정</button>
      </div>
    </form>
  </div>
  
  
  
  <!-- 
      <div class="notice-modi-button-container">
        <button class="notice-modi-action-button" type="button" onclick="openModal()">
          이전
        </button>
        <button class="notice-modi-action-button" type="button" onclick="goToPage()">수정</button>
      </div>
 -->
      <!-- 모달 HTML 
      <div id="notice-myModal" class="notice-modal">
        <div class="notice-modal-content">
          <span class="notice-close" onclick="closeModal()">&times;</span>
          <h2>이전 페이지로 돌아가시겠습니까?</h2>
          <p>확인 버튼을 클릭하면 이전 페이지로 이동합니다.</p>
          <button onclick="goToPage()">확인</button>
          <button class="notice-cancel-btn" onclick="closeModal()">취소</button>
        </div>
      </div>
    </form>
  </div> -->
</body>
<%@ include file="../../footer.jsp"%>
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.js"></script>
<script src="${pageContext.request.contextPath}/assets/js/notice/notice-adwrite.js"></script>


</html>