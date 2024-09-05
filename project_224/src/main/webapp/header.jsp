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
						<a href="../../html/main/main.html"><img
							src="${pageContext.request.contextPath}/assets/images/logo-224-1.png"
							alt="로고">
					</div>
					<div id="header-img-1">
						<img
							src="${pageContext.request.contextPath}/assets/images/logo-224-0.png"
							alt="로고"></a>
					</div> </a>
				</li>
				<li>
					<!-- 메인 검색창 -->

					<div class="header-search">
						<div id="header-search-frame">
							<div>
								<img
									src="${pageContext.request.contextPath}/assets/images/main-search.png">
							</div>
							<div>
								<input id="search" type="text" placeholder="검색하세요">
							</div>
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
							<h5>마이페이지</h5>
						</div>
					</li>
				</c:if>

				<c:if test="${empty sessionScope.member }">
					<li class="main-login-btn">
						<!-- 로그인 및 회원가입 버튼 -->
						<div id="header-login-join-btn">
							<h5>로그인 및 회원가입</h5>
						</div>
					</li>
				</c:if>

				<c:if test="${ not empty sessionScope.member}">
					<li class="main-login-btn">
						<!-- 로그인일때 로그아웃 버튼 -->
						<div id="header-login-logout-btn">
							<h5>로그아웃</h5>
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
					<a href="../../html/subway/subway-route.html">2호선폭폭</a>
				</div>
				<div class="dropdown-content">
					<ul class="dropdown-subway">
						<li>
							<div class="dropdown-line"></div>
						</li>
						<li><a href="../../html/subway/subway-route.html">2호선 노선도</a></li>
						<li><a href="../../html/subway/subway-schedule.html">2호선
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
					<a href="../../html/hotplace/hotplace.html">핫플콕콕</a>
				</div>
				<div class="dropdown-content">
					<ul class="dropdown-hot">
						<li>
							<div class="dropdown-line"></div>
						</li>
						<li><a href="../../html/hotplace/hotplace.html">핫플콕콕</a></li>
						<li><a href="../../html/hotplace/hotplace-gangnam.html">강남역</a></li>
						<li><a href="../hotplace/hotplace-jamsil.html">잠실역</a></li>
						<li><a href="../hotplace/hotplace-seongsu.html">성수역</a></li>
						<li><a href="../hotplace/hotplace-moonrae.html">문래역</a></li>
						<li><a href="../hotplace/hotplace-hongdae.html">홍대입구역</a></li>
						<li><a href="../hotplace/hotplace-euljiro.html">을지로입구역</a></li>
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
					<a href="../../html/convenience/conv-main.html">편의공공</a>
				</div>
				<div class="dropdown-content">
					<ul class="dropdown-conv">
						<li>
							<div class="dropdown-line"></div>
						</li>
						<li><a href="../../html/convenience/conv-main.html">편의공공</a></li>
						<li><a href="../../html/convenience/conv-storage.html">물품보관함</a></li>
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
						<li>
						<a href="${pageContext.request.contextPath}/community/comu-main.cm">커뮤톡톡</a>
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
					<a href="../../html/notice/notice-admain.html">공지쏙쏙</a>
				</div>
				<div class="dropdown-content">
					<ul class="dropdown-notice">
						<li>
							<div class="dropdown-line"></div>
						</li>
						<li><a href="../../html/notice/notice-admain.html">공지쏙쏙</a></li>
					</ul>
				</div>
			</div>
		</div>
	</section>
</header>

</html>