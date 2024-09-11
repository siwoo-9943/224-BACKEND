<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>지하철 도착 시간표</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/css/subway/subway-schedule.css" />
</head>

<body>
	<%@ include file="../../header.jsp"%>
	<main>
		<div>
			<div class="sub-form-box">
				<form action="" method="get">
					<div class="sub-form-box-title">
						<h1 id="station"></h1>
						<h1>배차시간표</h1>
					</div>
					<div class="sub-form-box-area">
						<nav>
							<ul class="sub-nav-list">
								<li><button type="button" class="location-btn" data-value="강남" onclick="onLocationButtonClick('강남',this)">강남</button></li>
								<li><button type="button" class="location-btn" data-value="잠실" onclick="onLocationButtonClick('잠실',this)">잠실</button></li>
								<li><button type="button" class="location-btn" data-value="홍대입구" onclick="onLocationButtonClick('홍대입구',this)">홍대입구</button></li>
								<li><button type="button" class="location-btn" data-value="성수" onclick="onLocationButtonClick('성수',this)">성수</button></li>
								<li><button type="button" class="location-btn" data-value="문래" onclick="onLocationButtonClick('문래',this)">문래</button></li>
								<li><button type="button" class="location-btn" data-value="을지로입구" onclick="onLocationButtonClick('을지로입구',this)">을지로입구</button></li>
							</ul>
						</nav>

						
					</div>
					<div class="mem-info">
						<div class="mem-info-type">
							<h3>상행선</h3>
							<div class="mem-info-box">
								<section id="section1">
								<!-- 배차시간 API 상행선 -->
								</section>
							</div>
						</div>
						<div class="mem-info-type">
							<h3>하행선</h3>
							<div class="mem-info-box">
								<section id="section2">
								<!-- 배차시간 API 하행선 -->
								</section>
							</div>
						</div>
					</div>
				</form>
			</div>
		</div>

	</main>
	<%@ include file="../../footer.jsp"%>
	<script>
</script>
</body>
<script src="${pageContext.request.contextPath}/assets/js/subway/subway-schedule.js"></script>
</html>
