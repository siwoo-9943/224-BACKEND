<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>커뮤톡톡 - 글 작성</title>

<!-- External CSS & JS -->
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/css/community/comu-write.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/css/modal/comu-modal.css" />
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<link
	href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css"
	rel="stylesheet">
<link
	href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.css"
	rel="stylesheet">
<style type="text/css">
* {
	margin: 0;
	padding: 0;
	box-sizing: border-box;
}

html {
	font-size: 10px;
	font-family: Arial, sans-serif;
}

h1 {
	font-weight: 600;
	font-size: 3.6rem;
	color: #333;
	text-align: center;
	margin-bottom: 20px;
}

a {
	text-decoration: none;
	color: inherit;
}

.comu-board-wrap {
	max-width: 800px;
	margin: 50px auto;
	padding: 20px;
	background: #f9f9f9;
	border-radius: 8px;
	box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
}

.comu-board-title {
	margin-bottom: 20px;
	text-align: center;
}

.comu-board-write .comu-title {
	margin-bottom: 20px;
}

.comu-board-write input[type='text'] {
	width: 100%;
	padding: 15px;
	font-size: 1.6rem;
	border: 1px solid #ddd;
	border-radius: 4px;
}

.comu-board-write .cont {
	margin-bottom: 20px;
}

.comu-board-write textarea {
	width: 100%;
	height: 200px;
	padding: 15px;
	font-size: 1.6rem;
	border: 1px solid #ddd;
	border-radius: 4px;
	resize: vertical;
}

.comu-button-container {
	display: flex;
	justify-content: flex-end;
	gap: 10px;
}

.comu-action-button {
	padding: 10px 20px;
	font-size: 1.6rem;
	font-weight: 600;
	color: #fff;
	background-color: #2bcf81;
	border: none;
	border-radius: 15px;
	cursor: pointer;
	transition: background-color 0.3s;
}

.comu-category {
	margin: 20px 0; /* 위아래 여백 */
	display: flex; /* 레이블과 선택박스를 가로로 배치 */
	align-items: center; /* 수직 정렬 */
}

.comu-category label {
	margin-right: 10px; /* 레이블과 선택박스 사이의 간격 */
	font-weight: bold; /* 레이블 두껍게 */
	font-size: 16px; /* 레이블 크기 */
}

.comu-category select {
	padding: 10px; /* 선택박스 안의 여백 */
	border: 1px solid #ccc; /* 테두리 색상 */
	border-radius: 5px; /* 둥근 테두리 */
	font-size: 16px; /* 글자 크기 */
	background-color: #f9f9f9; /* 배경 색상 */
	transition: border-color 0.3s; /* 테두리 색상 전환 효과 */
}

.comu-category select:hover {
	border-color: #007bff; /* 마우스 오버 시 테두리 색상 변경 */
}

.comu-category select:focus {
	outline: none; /* 포커스 시 기본 테두리 제거 */
	border-color: #007bff; /* 포커스 시 테두리 색상 변경 */
	box-shadow: 0 0 5px rgba(0, 123, 255, 0.5); /* 포커스 시 그림자 효과 */
}
</style>
<body>
	<%@ include file="../../header.jsp"%>
	<div class="comu-board-wrap">
		<div class="comu-board-title">
			<h1>커뮤니티 글작성</h1>
		</div>
		<form method="get">
			<div class="comu-board-write-wrap">
				<div class="comu-board-write">
					<div class="comu-title">
						<input id="comu-board-title" name="comuTitle" type="text"
							placeholder="제목을 입력해 주세요" />
					</div>
					<div class="comu-category">
						<label for="comu-category-select">카테고리 선택:</label> <select
							id="comu-category-select" name="comuCategory">
							<option value="전체">전체</option>
							<option value="자유">자유</option>
							<option value="핫플 자유">핫플 자유</option>
							<option value="핫플 후기">핫플 후기</option>
							<option value="편공 자유">편공 자유</option>
							<option value="편공 후기">편공 후기</option>
						</select>
					</div>
					<div class="comu-cont">
						<!-- <div id="summernote"></div> -->
						<form method="post">
							<textarea id="summernote" name="editordata"></textarea>
							<p id="letter-length" style="display: inline;"></p>
							/100
						</form>
					</div>
				</div>
			</div>
			<div class="comu-button-container">
				<button class="comu-action-button" type="button"
					onclick="location.href='../community/comu-main.jsp'">이전</button>
				<button class="comu-action-button" type="button" id="submitButton">등록</button>
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


<script
	src="${pageContext.request.contextPath}/assets/js/modal/comu-modal.js"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.js"></script>
<%@ include file="../../footer.jsp"%>


</html>