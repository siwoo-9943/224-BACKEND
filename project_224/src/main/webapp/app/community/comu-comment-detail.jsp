<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/css/community/comu-comment-detail.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/css/modal/comu-modal.css" />
</head>
<body>
	<main>
		<div class="wrapper">
			<div class="contnets">
				<div class="container">


					<div id="form-commentInfo">
						<div id="comment-count">
							댓글 <span id="count">5</span>
						</div>
						<div id="comment-comment-list">
							<ul>
								<li>
									<div>
										<strong>닉네임</strong>
									</div>
									<div>
										<span>감사합니다~!</span><br>
										<button class="comu-member-rewrite-contents-button">수정</button>
										<button class="comu-member-delete-contents-button">삭제</button>
									</div>

									<div>
										<small>2024-08-23 14:30</small>
									</div> <br>
								</li>

								<li>
									<div>
										<strong>닉네임</strong>
									</div>
									<div>
										<span>감사합니다~!</span>
									</div>

									<div>
										<small>2024-08-23 14:30</small>
									</div> <br>
								</li>

								<li>
									<div>
										<strong>닉네임</strong>
									</div>
									<div>
										<span>감사합니다~!</span>
									</div>

									<div>
										<small>2024-08-23 14:30</small>
									</div> <br>
								</li>

								<li>
									<div>
										<strong>닉네임</strong>
									</div>
									<div>
										<span>감사합니다~!</span>
									</div>

									<div>
										<small>2024-08-23 14:30</small>
									</div> <br>
								</li>

								<li>
									<div>
										<strong>닉네임</strong>
									</div>
									<div>
										<span>감사합니다~!</span>
									</div>

									<div>
										<small>2024-08-23 14:30</small>
									</div> <br>
								</li>


							</ul>
						</div>

						<span id="comu-text-red">[알림]</span><span> 욕설,상처 줄 수 있는 악플은
							삼가주세요</span>
						<div class="comu-inputbox-but">
							<input id="comment-input" placeholder="댓글을 입력해 주세요.">
							<button class="comu-submit" id="comu-Null-Modal" type="button"
								onclick="openNullModal()">등록</button>
						</div>
					</div>


				</div>
			</div>
		</div>
		<!-- 입력값 없이 등록버튼 모달 -->
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
</html>