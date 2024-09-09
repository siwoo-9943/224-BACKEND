<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/css/community/comu-modify.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/css/modal/comu-modal.css" />
</head>
<body>
	<main>
		<div class="wrapper">
			<div class="contnets">
				<div class="container">
					<div>
						<div id="header-box">
							<div class="bbs-title">
								<h1 style="font-weight: bold;">커뮤톡톡!</h1>
							</div>
							<div class="desc">2호선 이용에 대한 정보 공유 및 각종 이야기를 나누는 공간입니다.</div>
						</div>

						<form action="${pageContext.request.contextPath}/community/comu-modifyOk.cm" method="post">
							<!-- boardNumber를 히든 필드로 전달 -->
							<input type="hidden" name="boardNumber" value="${community.boardNumber}">
							
							<!-- 제목 입력 필드 -->
							<input class="top-inp title" type="text" name="boardTitle"
								value="${community.boardTitle}" placeholder="제목을 입력해주세요."
								size="100" maxlength="200">

							<div style="padding: 4px; margin-top: 10px; height: 27px;"
								class="cheditor-tb-wrapper"></div>

							<!-- 게시글 내용 입력 필드 -->
							<div class="cheditor-editarea-wrapper">
								<textarea class="cheditor-editarea-text-content"
									name="boardContent" rows="4" cols="50">
            						${community.boardContent}
        						</textarea>
							</div>

							<div style="display: flex; justify-content: space-between;">
								<div>
									<button type="button" class="tempas-bt01" id="comu-back-modal"
										onclick="openBackModal()">
										<span>취소</span>
									</button>
								</div>
								<div>
									<button id="ok-button" type="submit" class="tempas-bt01">작성완료</button>
								</div>
							</div>
						</form>
					</div>
				</div>
			</div>
			<!-- 뒤로가기 모달창 -->
			<div id="comu-backModal" class="comu-modal">
				<div class="comu-modal-content">
					<span class="comu-close" onclick="closeBackModal()">&times;</span>
					<h2>정말로 뒤로가시겠습니까?</h2>
					<p>뒤로가기 버튼을 클릭하면 작성한 내용은 저장되지 않습니다</p>
					<button class="confirm-btn" onclick="confirmBack()">뒤로가기</button>
					<button class="comu-cancel-btn" onclick="closeBackModal()">취소</button>
				</div>
			</div>
	</main>
</body>
<script
	src="${pageContext.request.contextPath}/assets/js/modal/comu-modal.js"></script>
</html>