<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="com.pj224.app.dto.HotplaceDTO"%>
<%
List<HotplaceDTO> mylikelist = (List<HotplaceDTO>) request.getAttribute("myCheckLike");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/css/mypage/my-pick.css" />
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
</head>
<%@ include file="../../header.jsp"%>
<body>
	<main>
		<!-- 목록 -->
		<div class="my-pickBox">
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
						href="${pageContext.request.contextPath}/app/mypage/my-comunity.my">
						<div class="my-category-menu">내가 작성한 글</div>
					</a> <a
						href="${pageContext.request.contextPath}/app/mypage/my-pick.my">
						<div class="my-category-menu">찜목록</div>
					</a> <a
						href="${pageContext.request.contextPath}/app/mypage/my-quit.jsp">
						<div class="my-category-menu">회원탈퇴</div>
					</a>
				</div>
			</div>

			<!-- 찜 목록 -->
			<div class="my-rightbox">
				<div class="my-pick">
					<div class="my-pick-title">찜 목록</div>
					<div class="my-line"></div>

					<div class="my-pick-center">


						<div class="my-pick-box">
							<c:forEach var="item" items="${myCheckLike}">
								<div class="my-pick-area">
									<div class="my-pick-textArea">
										<div class="my-pick-name">롯데월드</div>
										<img src="/assets/images/picked.png" width="30px" height="30px">
									</div>
									<div class="my-pick-pictureArea">
										<a href="https://www.naver.com" target="_blank">
											<p>${item.hotplaceStation}</p>
										</a>
									</div>
								</div>
							</c:forEach>

						</div>


					</div>



				</div>

			</div>
		</div>
		</div>

	</main>
</body>
<%@ include file="../../footer.jsp"%>
</html>