<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/css/mypage/my-update.css" />
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
</head>
<%@ include file="../../header.jsp"%>
<body>
	<main>
		<!-- 목록 -->
		<div class="my-updateBox">
			<div class="my-leftbox">
				<div class="my-hello">
					<div class="my-wellcome">반가워요!</div>
					<div class="my-nickname">"${sessionScope.member.memberName}"님</div>
				</div>
				<div class="my-category">
					<div class="my-category-menu">메뉴</div>
					<div class="my-line"></div>
					<a
						href="${pageContext.request.contextPath}/app/mypage/my-passcheck.jsp">
						<div class="my-category-menu">개인정보수정</div>
					</a> <a
						href="${pageContext.request.contextPath}/app/mypage/my-comunity.jsp">
						<div class="my-category-menu">내가 작성한 글</div>
					</a> <a
						href="${pageContext.request.contextPath}/app/mypage/my-pick.jsp">
						<div class="my-category-menu">찜목록</div>
					</a> <a
						href="${pageContext.request.contextPath}/app/mypage/my-quit.jsp">
						<div class="my-category-menu">회원탈퇴</div>
					</a>
				</div>
			</div>

			<!-- 회원정보수정 -->
			<div class="my-rightbox">
				<form action="${pageContext.request.contextPath}/app/mypage/mypageupdate.my" method="post">
					<div class="my-update">
						<div class="my-update-title">개인정보수정</div>
						<div class="my-line"></div>

						<div class="my-update-center">
						<!-- 닉네임 수정하기 위한 form -->
							<form
								action="${pageContext.request.contextPath}/app/mypage/updateNickname.my"
								method="post">
								<div class="my-update-menu">
									<div class="my-update-value">닉네임</div>
									<input type="text" class="my-update-input"
										value="${sessionScope.member.memberNickname}"
										name="memberNickname" id="my-newNikename">
									<button type="button" class="my-update-value-check">중복확인</button>
								</div>
								<div class="checkBox">
									<div class="mypage-nickname-ch"></div>
									<!-- 닉네임 js -->
									<div class="checkNickname-result"
										id="mypagecheckNicknameResult"></div>
								</div>

								<div class="my-update-menu">
									<div class="my-update-value">새비밀번호</div>
									<input type="password" class="my-update-input" id="my-newPW"
										value="${sessionScope.member.memberPw}" name="memberPw">
								</div>

								<div class="my-update-menu">
									<div class="my-update-value">비밀번호확인</div>
									<input type="password" class="my-update-input" id="my-newPWC"
										value="${sessionScope.member.memberPw}">
								</div>

								<div class="my-update-passCheck"></div>

								<div class="my-update-menu">
									<div class="my-update-value">이름</div>
									<input type="text" class="my-update-input"
										value="${sessionScope.member.memberName}" name="memberName">
								</div>

								<div class="my-update-menu">
									<div class="my-update-value">휴대폰</div>
									<input type="text" class="my-update-input"
										value="${sessionScope.member.memberPhone}" name="memberPhone">
									<button type="button" class="my-update-value-check2">휴대폰번호인증</button>
								</div>

								<div class="my-update-menu-check">
									<div class="my-update-menu">
										<div class="my-update-value"></div>
										<input type="text" class="my-update-input"
											placeholder="인증번호를 입력하세요" name="memberPhoneInput">
										<button type="button" class="my-update-value-Recheck">인증확인</button>
									</div>
								</div>

								<div class="my-update-menu">
									<div class="my-update-value">성별</div>
									<input type="radio" name="memberGender" value="M">남자 <input
										type="radio" name="memberGender" value="F">여자 <input
										type="radio" name="memberGender" value="N" checked>선택안함
								</div>

								<div class="my-update-menu">
									<div class="my-update-value">생년월일</div>
									<input type="date" class="my-update-input"
										value="${sessionScope.member.memberBirth}" name="memberBirth">
								</div>

								<div class="my-line"></div>
								
								<form action="/updateProfile" method="post">
								<input type="hidden" name="memberNumber" value="${sessionScope.member.memberNumber}">

								<!-- 이벤트 수신 동의 -->
								<div class="my-update-event">
									<div class="my-update-evnetSelect-up">
										<div class="my-update-value">선택약관동의</div>
										<div class="my-update-evnetSelect-sub">
											<input type="checkbox" name="memberTerms" value="c">이벤트
											등 혜택/정보 수신 동의(선택)
										</div>
									</div>
								</div>

								<button type="submit" class="my-update-button">개인정보수정</button>
						</div>
				</form>
			</div>
	</main>
	<script
		src="${pageContext.request.contextPath}/assets/js/mypage/my-update.js"></script>
</body>
<%@ include file="../../footer.jsp"%>
</html>