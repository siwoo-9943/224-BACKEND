<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/css/community/comu-detail.css" />
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
					</div>


					<c:choose>
						<c:when test="${communitycomudetail != null}">
							<!-- 게시글 정보 -->
							<div id="topTitle">
								<h1>${communitycomudetail.boardTitle}
									<span id="comment">[${communitycomudetail.commentCount}]</span>
								</h1>
								<div class="topTitle-box">
									<span class="topTitle-profile"></span>
									<ul class="topTitle-mainbox">
										<li class="topTitle-name"><strong>${communitycomudetail.memberNumber}</strong>
											<small>등록일 ${communitycomudetail.boardRegistDate}</small></li>
									</ul>
								</div>
							</div>

							<!-- 게시글 내용 -->
							<div class="comu-posting-textarea">
								<span>${communitycomudetail.boardContent}</span>
							</div>

							<!-- 추천 영역 -->
							<div class="recommendArea">
								<div id="recommend">
									<span class="up-numb"> <span id="vote-list-btn-txt">${communitycomudetail.recommendCount}</span>
										<div class="up-list">
											<div id="vote-member-list">
												<!-- 추천한 회원 목록이 필요하면 여기에서 추가할 수 있습니다 -->
											</div>
										</div>
									</span> <span class="recommend-up">추천하기</span> <span class="wall">|</span>
								</div>
							</div>

							<div class="comu-div-flex-content">
								<div class="com-div-flex-box-div">
									<a
										href="${pageContext.request.contextPath}/community/comu-main.cm">
										<button type="button" class="comu-submit">이전</button>
									</a>
								</div>
								<c:if test="${isAuthor}">
									<div class="comu-div-flex-box">
										<div class="com-div-flex-box-div">
											<a
												href="${pageContext.request.contextPath}/community/comu-modify.cm?boardNumber=${communitycomudetail.boardNumber}">
												<button type="button" class="comu-submit">수정</button>
											</a>
										</div>
										<div class="com-div-flex-box-div">
											<button type="button" class="comu-submit"
												onclick="openDeletePostModal(${communitycomudetail.boardNumber})">삭제</button>
										</div>
									</div>
								</c:if>
							</div>
						</c:when>
						<c:otherwise>
							<p>게시글을 찾을 수 없습니다.</p>
						</c:otherwise>
					</c:choose>
				</div>
			</div>
		</div>
		<form id="deleteForm"
			action="${pageContext.request.contextPath}/community/comu-deleteOk.cm"
			method="post" style="display: none;">
			<input type="hidden" id="boardNumberInput" name="boardNumber"
				value="">
		</form>
		<!-- 삭제 모달 HTML -->
		<div id="comu-deleteModal" class="comu-modal">
			<div class="comu-modal-content">
				<span class="comu-close" onclick="closeDeletePostModal()">&times;</span>
				<h2>정말로 삭제하시겠습니까?</h2>
				<p>삭제 버튼을 클릭하면 항목이 영구히 삭제됩니다.</p>
				<button class="confirm-btn" onclick="confirmPostDelete()">삭제</button>
				<button class="comu-cancel-btn" onclick="closeDeletePostModal()">취소</button>
			</div>
		</div>
		<div id="comu-NullModal" class="comu-modal">
			<div class="comu-modal-content">
				<span class="comu-close" onclick="closeNullModal()">&times;</span>

				<p>등록할 글이 작성되지 않았습니다</p>

				<button class="comu-cancel-btn" onclick="closeNullModal()">확인</button>
			</div>
		</div>
	</main>
</body>
<script
	src="${pageContext.request.contextPath}/assets/js/modal/comu-modal.js"></script>
<script>
function openDeletePostModal(boardNumber) {
    document.getElementById('boardNumberInput').value = boardNumber;
    document.getElementById('comu-deleteModal').style.display = 'block';
}

function closeDeletePostModal() {
    document.getElementById('comu-deleteModal').style.display = 'none';
}

function confirmPostDelete() {
    document.getElementById('deleteForm').submit();
}

function closeNullModal() {
    document.getElementById('comu-NullModal').style.display = 'none';
}
</script>
</html>