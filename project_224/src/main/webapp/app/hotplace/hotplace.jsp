<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/css/hotplace/hotplace.css">
</head>
<body>

	<div style="position: relative; height: 350px;">
		<div
			style="position: absolute; left: 0px; bottom: 0px; right: 0px; z-index: 10;">
			<div style="width: 100%; max-width: 1200px; margin: 0 auto 30px;">
				<span style="font-size: 58px; color: #fff; font-weight: 700;">핫플콕콕</span>
			</div>
		</div>
		<div
			style="background-image: url(${pageContext.request.contextPath}/assets/images/hotplace.png); width: 1900px; height: 100%;"></div>
	</div>

	<div class="sub-contents-inner gettingToSeoul" id="container">
		<div class="location">
			<span class="ar">&gt;</span><span>핫플콕콕</span>
		</div>
		<form action="" method="post">
			<div class="box-detail-content">
				<div class="group-01">
					<h4 class="heading4 fc-blue">2호선 대표역</h4>
					<div class="thumb-cont" style="display: flex;">
						<div style="position: relative; height: 230px;">
							<div
								style="position: absolute; left: 180px; bottom: 70px; right: 0px; z-index: 10;">
								<a href="${pageContext.request.contextPath}/hotplace/hotplace-gangnam.hp">
									<div style="width: 100%; margin: 0 auto 30px;">
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
								<a href="${pageContext.request.contextPath}/hotplace/hotplace-jamsil.hp">
									<div style="width: 100%; margin: 0 auto 30px;">
										<span style="font-size: 24px; color: #fff; font-weight: 600;">잠실역</span>
									</div>
								</a>
							</div>
							<div
								style="background-image: url(${pageContext.request.contextPath}/assets/images/2.png); width: 400px; height: 100%;"></div>
						</div>
						<div style="position: relative; height: 230px;">
							<div
								style="position: absolute; left: 150px; bottom: 70px; right: 0px; z-index: 10;">
								<a href="${pageContext.request.contextPath}/hotplace/hotplace-hongdae.hp">
									<div style="width: 100%; margin: 0 auto 30px;">
										<span style="font-size: 24px; color: #fff; font-weight: 600;">홍대입구역</span>
									</div>
								</a>
							</div>
							<div
								style="background-image: url(${pageContext.request.contextPath}/assets/images/3.png); width: 400px; height: 100%;"></div>
						</div>
					</div>
					<div class="thumb-cont" style="display: flex;">
						<div style="position: relative; height: 230px;">
							<div
								style="position: absolute; left: 180px; bottom: 70px; right: 0px; z-index: 10;">
								<a href="${pageContext.request.contextPath}/hotplace/hotplace-seongsu.hp">
									<div style="width: 100%; margin: 0 auto 30px;">
										<span style="font-size: 24px; color: #fff; font-weight: 600;">성수역</span>
									</div>
								</a>
							</div>
							<div
								style="background-image: url(${pageContext.request.contextPath}/assets/images/4.png); width: 400px; height: 100%;"></div>
						</div>
						<div style="position: relative; height: 230px;">
							<div
								style="position: absolute; left: 180px; bottom: 70px; right: 0px; z-index: 10;">
								<a href="${pageContext.request.contextPath}/hotplace/hotplace-moonrae.hp">
									<div style="width: 100%; margin: 0 auto 30px;">
										<span style="font-size: 24px; color: #fff; font-weight: 600;">문래역</span>
									</div>
								</a>
							</div>
							<div
								style="background-image: url(${pageContext.request.contextPath}/assets/images/3.png); width: 400px; height: 100%;"></div>
						</div>
						<div style="position: relative; height: 230px;">
							<div
								style="position: absolute; left: 150px; bottom: 70px; right: 0px; z-index: 10;">
								<a href="${pageContext.request.contextPath}/hotplace/hotplace-euljiro.hp">
									<div style="width: 100%; margin: 0 auto 30px;">
										<span style="font-size: 24px; color: #fff; font-weight: 600;">을지로입구역</span>
									</div>
								</a>
							</div>
							<div
								style="background-image: url(${pageContext.request.contextPath}/assets/images/6.png); width: 400px; height: 100%;"></div>
						</div>
					</div>
				</div>
			</div>
		</form>
	</div>

</body>
</html>