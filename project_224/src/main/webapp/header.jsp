<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>224</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/css/header.css" />
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script defer src="${pageContext.request.contextPath}/js/main/header.js"></script>

</head>

<body>
</body>
<header>
	<section class="header-section">
		<div class="header-fixed">
			<ul class="header-list">
				<li>
					<!-- <a class="main-header-logo" href="../../html/main/main.html"> -->
					<!-- 메인 로고 -->
					<div id="header-img-0">
						<a href="${pageContext.request.contextPath}/main.mn"> <img
							src="${pageContext.request.contextPath}/assets/images/logo-224-1.png"
							alt="로고">
						</a>
					</div>

					<div id="header-img-1">
						<a href="${pageContext.request.contextPath}/main.mn"> <img
							src="${pageContext.request.contextPath}/assets/images/logo-224-0.png"
							alt="로고">
						</a>
					</div>
				</li>
				<li>
					<!-- 메인 검색창 -->

					<div class="header-search">
						<div id="header-search-frame">
							<form action="${pageContext.request.contextPath}/main-search.mn" method="get">
				 				<div>
									<button type="button" id="searchBtn"
										href="${pageContext.request.contextPath}/main-search.mn">
										<img src="${pageContext.request.contextPath}/assets/images/main-search.png">
									</button>
								</div>
								<label> <input id="search" name="search" type="text"
									placeholder="검색하세요">
								</label>
							</form>
						</div>
					</div>
				</li>
				<li>
					<div id="header-weather">
						<a href="#"><img
							src="${pageContext.request.contextPath}/assets/images/weather.jpg"></a>
					</div>
				</li>

				<c:if test="${ not empty sessionScope.member}">
					<li class="main-login-btn">
						<!-- 마이페이지 -->
						<div id="header-login-mypage-btn">
							<a href="${pageContext.request.contextPath }/mypage/mypage.my">
								<h5>마이페이지</h5>
							</a>
						</div>
					</li>
				</c:if>

				<c:if test="${empty sessionScope.member }">
					<li class="main-login-btn">
						<!-- 로그인 및 회원가입 버튼 -->
						<div id="header-login-join-btn">
							<a href="${pageContext.request.contextPath}/member/login.me">
								<h5>로그인 및 회원가입</h5>
							</a>
						</div>
					</li>
				</c:if>

				<c:if test="${ not empty sessionScope.member}">
					<li class="main-login-btn">
						<!-- 로그인일때 로그아웃 버튼 -->
						<div id="header-login-logout-btn">
							<a href="${pageContext.request.contextPath}/logout.mn">
								<h5>로그아웃</h5>
							</a>
						</div>
					</li>
				</c:if>

			</ul>
		</div>
	</section>
	<section class="main-dropdown">
		<!-- 메인 메뉴 드롭다운-->
		<div id="dropdown-container">
			<div class="dropdown">
				<!-- 2호선폭폭 -->
				<div class="dropdown-menu">
					<img
						src="${pageContext.request.contextPath}/assets/images/line-icon.png">
				</div>
				<div class="dropdown-menu-txt">
					<a href="${pageContext.request.contextPath}/subway/subway-route.sw">2호선폭폭</a>
				</div>
				<div class="dropdown-content">
					<ul class="dropdown-subway">
						<li>
							<div class="dropdown-line"></div>
						</li>
						<li><a
							href="${pageContext.request.contextPath}/subway/subway-route.sw">2호선
								노선도</a></li>
						<li><a
							href="${pageContext.request.contextPath}/subway/subway-schedule.sw">2호선
								배차시간표</a></li>
					</ul>
				</div>
			</div>
			<!-- 핫플콕콕 -->
			<div class="dropdown">
				<div class="dropdown-menu">
					<img
						src="${pageContext.request.contextPath}/assets/images/hotplace-icon.png">
				</div>
				<div class="dropdown-menu-txt">
					<a
						href="${pageContext.request.contextPath}/app/hotplace/hotplace.jsp">핫플콕콕</a>
				</div>
				<div class="dropdown-content">
					<ul class="dropdown-hot">
						<li>
							<div class="dropdown-line"></div>
						</li>
						<li><a
							href="${pageContext.request.contextPath}/app/hotplace/hotplace.jsp">핫플콕콕</a></li>
						<li><a
							href="${pageContext.request.contextPath}/hotplace/hotplace-gangnam.hp">강남역</a></li>
						<li><a
							href="${pageContext.request.contextPath}/hotplace/hotplace-jamsil.hp">잠실역</a></li>
						<li><a
							href="${pageContext.request.contextPath}/hotplace/hotplace-seongsu.hp">성수역</a></li>
						<li><a
							href="${pageContext.request.contextPath}/hotplace/hotplace-moonrae.hp">문래역</a></li>
						<li><a
							href="${pageContext.request.contextPath}/hotplace/hotplace-hongdae.hp">홍대입구역</a></li>
						<li><a
							href="${pageContext.request.contextPath}/hotplace/hotplace-euljiro.hp">을지로입구역</a></li>
					</ul>
				</div>
			</div>
			<!-- 편의공공 -->
			<div class="dropdown">
				<div class="dropdown-menu">
					<img
						src="${pageContext.request.contextPath}/assets/images/convenience-icon.png">
				</div>
				<div class="dropdown-menu-txt">
					<a href="${pageContext.request.contextPath}/app/convenience/conv-main.jsp">편의공공</a>
				</div>
				<div class="dropdown-content">
					<ul class="dropdown-conv">
						<li>
							<div class="dropdown-line"></div>
						</li>
						<li><a href="${pageContext.request.contextPath}/app/convenience/conv-main.jsp">편의공공</a></li>
						<li><a href="${pageContext.request.contextPath}/app/convenience/conv-storage.jsp">물품보관함</a></li>
					</ul>
				</div>
			</div>
			<!-- 커뮤톡톡 -->
			<div class="dropdown">
				<div class="dropdown-menu">
					<img
						src="${pageContext.request.contextPath}/assets/images/community-icon.png">
				</div>
				<div class="dropdown-menu-txt">
					<a href="${pageContext.request.contextPath}/community/comu-main.cm">커뮤톡톡</a>
				</div>
				<div class="dropdown-content">
					<ul class="dropdown-comu">
						<li>
							<div class="dropdown-line"></div>
						</li>
						<li><a
							href="${pageContext.request.contextPath}/community/comu-main.cm">커뮤톡톡</a>
						</li>
					</ul>
				</div>
			</div>
			<!-- 공지쏙쏙 -->
			<div class="dropdown">
				<div class="dropdown-menu">
					<img
						src="${pageContext.request.contextPath}/assets/images/notice-icon.png">
				</div>
				<div class="dropdown-menu-txt">
					<a href="${pageContext.request.contextPath}/notice/notice-admain.no">공지쏙쏙</a>
				</div>
				<div class="dropdown-content">
					<ul class="dropdown-notice">
						<li>
							<div class="dropdown-line"></div>
						</li>
						<li><a href="${pageContext.request.contextPath}/notice/notice-admain.no">공지쏙쏙</a></li>
					</ul>
				</div>
			</div>
		</div>
	</section>
</header>
</html>