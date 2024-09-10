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
	<jsp:include page="/header.jsp" />
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
									</span> 
									<span class="recommend-up" role="button"
										data-board-number="${communitycomudetail.boardNumber}">
										추천하기 
									</span> 
									<span class="wall">|</span>
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

				<div id="form-commentInfo">
					<div id="comment-count">
						댓글 <span id="count">${communitycomudetail.commentCount}</span>
					</div>
					<ul>
						<c:forEach var="comment" items="${commentList}">
							<c:forEach var="member" items="${memberList}">
								<c:if
									test="${comment.boardNumber == communitycomudetail.boardNumber}">
									<div id="comment-comment-list">
										<c:if test="${comment.memberNumber == member.memberNumber}">
											<li id="comment-${comment.commentNumber}"
												style="display: block">
												<div>
													<strong>${member.memberNickname}</strong>
												</div>
												<div class="comment-content">
													<span>${comment.commentContent}</span><br>
													<c:if
														test="${comment.memberNumber == sessionScope.member.memberNumber}">
														<button class="comu-member-rewrite-contents-button"
															onclick="openEditForm(${comment.commentNumber})">수정</button>

														<button class="comu-member-delete-contents-button"
															onclick="openDeleteCommentModal(${comment.commentNumber})">삭제</button>
													</c:if>
												</div>
												<div class="comu-member-rewrite-contents"
													id="edit-form-${comment.commentNumber}"
													style="display: none;">
													<div class="comu-comment-inputbox-but">
														<input class="comu-comment-rewrite-input"
															value="${comment.commentContent}">
														<button class="comu-comment-rewrite-submit" type="button"
															onclick="submitCommentEdit(${comment.commentNumber})">등록</button>
														<button class="comu-comment-rewrite-cancel" type="button"
															onclick="closeEditForm(${comment.commentNumber})">취소</button>
													</div>
												</div>

												<div>
													<small>${comment.commentUpdateDate}</small>
												</div> <br>
											</li>

										</c:if>
									</div>
								</c:if>
							</c:forEach>
						</c:forEach>
					</ul>
					<c:if test="${sessionScope.member.memberNumber != null}">
						<div id="comu-comment-insert-area">
							<span id="comu-text-red">[알림]</span><span> 욕설,상처 줄 수 있는
								악플은 삼가주세요</span>
							<form method="post"
								action="${pageContext.request.contextPath}/community/comu-comment-write.cm?boardNumber=${communitycomudetail.boardNumber}&memberNum=${sessionScope.member.memberNumber}">
								<div class="comu-inputbox-but">
									<input id="comment-input" name="commentCont"
										placeholder="댓글을 입력해 주세요." value="">
									<button class="comu-submit" id="comu-insert-comment"
										type="submit">등록</button>

								</div>
							</form>
						</div>
					</c:if>
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

		<form id="deleteCommentForm"
			action="${pageContext.request.contextPath}/community/comu-comment-deleteOk.cm?boardNumber=${communitycomudetail.boardNumber}"
			method="post" style="display: none;">
			<input type="hidden" id="commentNumberInput" name="commentNumber"
				value="">
		</form>
		<!-- 삭제 모달 HTML -->
		<div id="comu-deleteCommentModal" class="comu-modal">
			<div class="comu-modal-content">
				<span class="comu-close" onclick="closeDeleteCommentModal()">&times;</span>
				<h2>정말로 삭제하시겠습니까?</h2>
				<p>삭제 버튼을 클릭하면 댓글이 영구히 삭제됩니다.</p>
				<button class="confirm-btn" onclick="confirmCommentDelete()">삭제</button>
				<button class="comu-cancel-btn" onclick="closeDeleteCommentModal()">취소</button>
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

function openEditForm(commentNumber) {
    document.querySelector('#comment-' + commentNumber + ' .comment-content').style.display = 'none';
    document.getElementById('edit-form-' + commentNumber).style.display = 'block';
}

function submitCommentEdit(commentNumber) {

    const newContent = document.querySelector('#edit-form-' + commentNumber + ' .comu-comment-rewrite-input').value;
    
    if (newContent.trim() === '') {
        alert('댓글 내용을 입력하세요.');
        return;
    }

    $.ajax({
        url: `${pageContext.request.contextPath}/community/comu-comment-modify.cm`,
        type: 'POST',
        data: {
            commentNumber: commentNumber,
            commentContent: newContent
        },
        success: function(response) {
			document.querySelector('#comment-' + commentNumber + ' .comment-content span').innerText = newContent;
			closeEditForm(commentNumber);
        },
        error: function() {
            alert('서버 통신 오류 발생');
        }
    });
}

function closeEditForm(commentNumber) {
    document.querySelector('#comment-' + commentNumber + ' .comment-content').style.display = 'block';
    document.getElementById('edit-form-' + commentNumber).style.display = 'none';
}

function openDeleteCommentModal(commentNumber) {
    document.getElementById('commentNumberInput').value = commentNumber;
    document.getElementById('comu-deleteCommentModal').style.display = 'block';
}

function closeDeleteCommentModal() {
    document.getElementById('comu-deleteCommentModal').style.display = 'none';
}

function confirmCommentDelete() {
    document.getElementById('deleteCommentForm').submit();
}


document.addEventListener('DOMContentLoaded', function() {
    document.querySelector('.recommend-up').addEventListener('click', function() {
        let boardNumber = this.getAttribute('data-board-number');
        recommendPost(boardNumber);
    });
});

/* 추천부분 AJAX */
function recommendPost(boardNumber) {
    console.log("추천 함수 호출됨, 게시글 번호:", boardNumber);  // 디버깅용 로그
    $.ajax({
        url: `${pageContext.request.contextPath}/community/recommendOk.cm`,
        type: "POST",
        data: { boardNumber: boardNumber },
        dataType: 'text',
        success: function(response) {
            console.log("서버 응답:", response);  // 디버깅용 로그
            switch(response.trim()) {
                case "success":
                    alert("추천이 완료되었습니다.");
                    // 추천 수 업데이트 로직
                    let currentCount = parseInt($("#vote-list-btn-txt").text());
                    $("#vote-list-btn-txt").text(currentCount + 1);
                    break;
                case "already":
                    alert("이미 추천한 게시글입니다.");
                    break;
                default:
                    alert("추천은 로그인 후 가능합니다.");
            }
        },
        error: function(jqXHR, textStatus, errorThrown) {
            console.error("AJAX 오류:", textStatus, errorThrown);
            console.log("상세 오류:", jqXHR.responseText);  // 디버깅용 로그
            alert("서버 오류가 발생했습니다.");
        }
    });
}




</script>


</html>