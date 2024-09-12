<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/css/mypage/my-passcheck.css" />
</head>
<%@ include file="/header.jsp"%>
<body>
	<main>
		<!-- 목록 -->
		<div class="my-passcheckBox">
			<div class="my-leftbox">
				<div class="my-hello">
					<div class="my-wellcome">반가워요!</div>
					<div class="my-nickname">"${sessionScope.member.memberName}"님</div>
				</div>
				<div class="my-category">
					<div class="my-category-menu">메뉴</div>
					<div class="my-line"></div>
					<a
						href="${pageContext.request.contextPath}/app/mypage/mypasscheck.my">
						<div class="my-category-menu">개인정보수정</div>
					</a> <a
						href="${pageContext.request.contextPath}/app/mypage/mycomunity.my">
						<div class="my-category-menu">내가 작성한 글</div>
					</a> <a
						href="${pageContext.request.contextPath}/app/mypage/mypick.my">
						<div class="my-category-menu">찜목록</div>
					</a> <a
						href="${pageContext.request.contextPath}/app/mypage/myquit.my">
						<div class="my-category-menu">회원탈퇴</div>
					</a>
				</div>
			</div>

			<!-- 프로필 -->
			<div class="my-rightbox">
				<div class="my-passcheck">
					<div class="my-passchek-title">개인 정보 수정</div>
					<div class="my-passchek-subtitle">비밀번호 재확인</div>
					<div class="my-passchek-title-info">회원님의 정보를 안전하게 보호하기 위해
						비밀번호를 다시 한번 확인해주세요</div>
					<div class="my-line"></div>
					<form
						action="${pageContext.request.contextPath}/app/mypage/passcheck.my"
						method="post" class="my-passchek-center">
						<div class="my-passchek-category">
							<div class="my-passcheck-menu">아이디</div>
							<input type="text" id="userId" class="my-input-id"
								name="memberEmail">
						</div>
						<div class="my-passchek-category">
							<div class="my-passcheck-menu">비밀번호</div>
							<input type="password" id="userPassword"
								class="my-input-password" name="memberPw">
						</div>
						<div class="my-line"></div>
						<!-- 개인정보수정 이동 버튼 -->
						<button type="submit" class="my-button">확인</button>
					</form>
				</div>
			</div>
	</main>
</body>
<%@ include file="/footer.jsp"%>
</html>