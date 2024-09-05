<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/css/community/comu-write.css" />
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