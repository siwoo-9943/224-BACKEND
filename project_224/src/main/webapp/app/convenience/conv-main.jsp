<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/convenience/conv-main.css">
</head>
<body>
	<jsp:include page="/header.jsp" />
	<div style="position: relative; height: 350px;">
		<div
			style="position: absolute; left: 0px; bottom: 0px; right: 0px; z-index: 10;">
			<div style="width: 100%; max-width: 1200px; margin: 0 auto 30px;">
				<span style="font-size: 58px; color: #fff; font-weight: 700;">편의공공</span>
			</div>
		</div>
		<div
			style="background-image: url(${pageContext.request.contextPath}/assets/images/hotplace.png); width: 1900px; height: 100%;"></div>
	</div>

	<div class="sub-contents-inner gettingToSeoul" id="container">
		<div class="loction">
			<span class="ar">&gt;</span> 여행정보<span class="ar">&gt;</span> <span><a
				href="/getting-to-seoul" title="페이지 이동">편의공공</a></span>
		</div>
		<div class="box-detail-content">
			<div class="group-01">
				<h4 class="heading4 fc-blue">2호선 대표역</h4>
				<div class="thumb-cont" style="display: flex;">
					<div style="position: relative; height: 230px;">
						<div
							style="position: absolute; left: 180px; bottom: 70px; right: 0px; z-index: 10;">
							<a href="conv-map.jsp">
							<div
									style="width: 100%; margin: 0 auto 30px;">
									<span style="font-size: 24px; color: #fff; font-weight: 600;">강남역</span>
								</div>
								</a>
						</div>
						<div
							style="background-image: url(${pageContext.request.contextPath}/assets/images/1.png); width: 400px; height: 100%;"></div>
					</div>
					<div style="position: relative; height: 230px;">
							<div
							style="position: absolute; left: 180px; bottom: 70px; right: 0px; z-index: 10;">
							<a href="conv-map.jsp"><div
									style="width: 100%; margin: 0 auto 30px;">
									<span style="font-size: 24px; color: #fff; font-weight: 600;">잠실역</span>
								</div></a>
						</div>
						<div
							style="background-image: url(${pageContext.request.contextPath}/assets/images/2.png); width: 400px; height: 100%;"></div>
					</div>
					<div style="position: relative; height: 230px;">
						<div
							style="position: absolute; left: 150px; bottom: 70px; right: 0px; z-index: 10;">
							<a href="conv-map.jsp"><div
									style="width: 100%; margin: 0 auto 30px;">
									<span style="font-size: 24px; color: #fff; font-weight: 600;">홍대입구역</span>
								</div></a>
						</div>
						<div
							style="background-image: url(${pageContext.request.contextPath}/assets/images/3.png); width: 400px; height: 100%;"></div>
					</div>
				</div>
				<div class="thumb-cont" style="display: flex;">
					<div style="position: relative; height: 230px;">
						<div
							style="position: absolute; left: 180px; bottom: 70px; right: 0px; z-index: 10;">
							<a href="conv-map.jsp"><div
									style="width: 100%; margin: 0 auto 30px;">
									<span style="font-size: 24px; color: #fff; font-weight: 600;">성수역</span>
								</div></a>
						</div>
						<div
							style="background-image: url(${pageContext.request.contextPath}/assets/images/4.png); width: 400px; height: 100%;"></div>
					</div>
					<div style="position: relative; height: 230px;">
						<div
							style="position: absolute; left: 180px; bottom: 70px; right: 0px; z-index: 10;">
							<a href="conv-map.jsp"><div
									style="width: 100%; margin: 0 auto 30px;">
									<span style="font-size: 24px; color: #fff; font-weight: 600;">문래역</span>
								</div></a>
						</div>
						<div
							style="background-image: url(${pageContext.request.contextPath}/assets/images/3.png); width: 400px; height: 100%;"></div>
					</div>
					<div style="position: relative; height: 230px;">
						<div
							style="position: absolute; left: 150px; bottom: 70px; right: 0px; z-index: 10;">
							<a href="conv-map.jsp"><div
									style="width: 100%; margin: 0 auto 30px;">
									<span style="font-size: 24px; color: #fff; font-weight: 600;">을지로입구역</span>
								</div></a>
						</div>
						<div
							style="background-image: url(${pageContext.request.contextPath}/assets/images/6.png); width: 400px; height: 100%;"></div>
					</div>
				</div>
			</div>
		</div>

	</div>
	<jsp:include page="/footer.jsp" />
</body>
</html>