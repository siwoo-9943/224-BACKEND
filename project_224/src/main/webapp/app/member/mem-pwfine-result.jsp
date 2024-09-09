<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/css/member/mem-pwfine-result.css?v=1.0" />
</head>
<%@ include file="/header.jsp"%>
<body>
	<div class="wrapper">
		<div class="head">
			<h1>비밀번호 변경</h1>
		</div>
		<form action="${pageContext.request.contextPath}/member/pwUpdate.me" method="post">
			<div class="info-text">
				<p>변경할 비밀번호를 입력해주세요.</p>
			</div>

			<div class="result-wrapper">
				<input type="text" id="e-mail"
					placeholder="&nbsp;&nbsp; 영문자 8글자 이상 15글자 이하, 특수문자 필수" name="memberEmail">
			</div>

			<div class="buttons">
				<button type="submit">비밀번호변경</button>
			</div>
		</form>
	</div>

</body>
<%@ include file="/footer.jsp"%>
</html>