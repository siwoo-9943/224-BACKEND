<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="com.pj224.app.dto.MainDTO"%>
<%
List<MainDTO> hpresults1 = (List<MainDTO>) request.getAttribute("hplist1");
List<MainDTO> hpresults2 = (List<MainDTO>) request.getAttribute("hplist2");
List<MainDTO> hplikecheck = (List<MainDTO>) request.getAttribute("memCheckLike");
List<MainDTO> comuresults = (List<MainDTO>) request.getAttribute("comuListResults");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/css/main.css" />
	
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<style type="text/css">
a {
	color: black;
}
</style>

</head>
<%@ include file="header.jsp"%>
<body>
	<main>

		<!--역 둘러보기 선택 영역-->
		<section class="main-section-first">
			<div class="main-station">
				<ul id="main-slider-list">
					<li id="main-slider-one"><img
						src="${pageContext.request.contextPath}/assets/images/1.png">
						<div class="main-station-frame">
							<h2>강남역</h2>
						</div> <a
						href="${pageContext.request.contextPath}/hotplace/hotplace-gangnam.hp">
							<div id="main-station-hot">핫플</div>
					</a> <a
						href="${pageContext.request.contextPath}/convenience/conv-storage-gangnam.cv">
							<div id="main-station-con">편의</div>
					</a></li>
					<li id="main-slider-two"><img
						src="${pageContext.request.contextPath}/assets/images/2.png">
						<div class="main-station-frame">
							<h2>잠실역</h2>
						</div> <a
						href="${pageContext.request.contextPath}/hotplace/hotplace-jamsil.hp">
							<div id="main-station-hot">핫플</div>
					</a> <a
						href="${pageContext.request.contextPath}/convenience/conv-storage-jamsil.cv">
							<div id="main-station-con">편의</div>
					</a></li>
					<li id="main-slider-three"><img
						src="${pageContext.request.contextPath}/assets/images/3.png">
						<div class="main-station-frame">
							<h2>홍대입구역</h2>
						</div> <a
						href="${pageContext.request.contextPath}/hotplace/hotplace-hongdae.hp">
							<div id="main-station-hot">핫플</div>
					</a> <a
						href="${pageContext.request.contextPath}/convenience/conv-storage-hongdae.cv">
							<div id="main-station-con">편의</div>
					</a></li>
					<li id="main-slider-four"><img
						src="${pageContext.request.contextPath}/assets/images/4.png">
						<div class="main-station-frame">
							<h2>성수역</h2>
						</div> <a
						href="${pageContext.request.contextPath}/hotplace/hotplace-seongsu.hp">
							<div id="main-station-hot">핫플</div>
					</a> <a
						href="${pageContext.request.contextPath}/convenience/conv-storage-seongsu.cv">
							<div id="main-station-con">편의</div>
					</a></li>
					<li id="main-slider-five"><img
						src="${pageContext.request.contextPath}/assets/images/5.png">
						<div class="main-station-frame">
							<h2>문래역</h2>
						</div> <a
						href="${pageContext.request.contextPath}/hotplace/hotplace-moonrae.hp">
							<div id="main-station-hot">핫플</div>
					</a> <a
						href="${pageContext.request.contextPath}/convenience/conv-storage-moonrae.cv">
							<div id="main-station-con">편의</div>
					</a></li>
					<li id="main-slider-six"><img
						src="${pageContext.request.contextPath}/assets/images/6.png">
						<div class="main-station-frame">
							<h2>을지로입구역</h2>
						</div> <a
						href="${pageContext.request.contextPath}/hotplace/hotplace-euljiro.hp">
							<div id="main-station-hot">핫플</div>
					</a> <a
						href="${pageContext.request.contextPath}/convenience/conv-storage-euljiro.cv">
							<div id="main-station-con">편의</div>
					</a></li>
				</ul>
			</div>
		</section>
		<!-- 슬라이드 -->
		<section class="main-section-second">
			<div class="main-slidebanner">
				<h1>2호선을 2용하는 4람들</h1>
				<ul class="main-slider">
					<li class="main-slide"><img
						src="${pageContext.request.contextPath}/assets/images/main-1.jpg"
						alt="Image 1"></li>
					<li class="main-slide"><img
						src="${pageContext.request.contextPath}/assets/images/main-2.jpg"
						alt="Image 2"></li>
					<li class="main-slide"><img
						src="${pageContext.request.contextPath}/assets/images/main-3.jpg"
						alt="Image 3"></li>
					<li class="main-slide"><img
						src="${pageContext.request.contextPath}/assets/images/main-4.png"
						alt="Image 4"></li>
					<li class="main-slide"><img
						src="${pageContext.request.contextPath}/assets/images/main-5.jpg"
						alt="Image 5"></li>
				</ul>
			</div>
		</section>

		<!-- 핫플콕콕 -->
		<!-- 1번째 줄 4칸 -->
		<section class="main-section-third">
			<div id="main-third-title">
				<img id="main-body-hot-icon"
					src="${pageContext.request.contextPath}/assets/images/hotplace-icon.png">핫플콕콕!
			</div>
			<section class="main-section-third-top">
				<ul id="main-hot">
					<c:forEach var="item" items="${hplist1}">
						<li id="main-hot-list">
							<div id="main-hot-list-img"
								style="background-image: url(${pageContext.request.contextPath}/assets/images/main-1.jpg);">

								<c:if test="${not empty sessionScope.member.memberNumber}">
									<c:set var="isLiked" value="false" />

									<c:forEach var="like" items="${memCheckLike}">
										<c:if test="${item.hotplaceNumber == like.hotplaceNumber}">
											<c:set var="isLiked" value="true" />
										</c:if>
									</c:forEach>

									<c:choose>
										<c:when test="${isLiked}">
											<form action="${pageContext.request.contextPath}/unpick.mn" method="post">
												<input type="hidden" name="hotplaceNumber"
													value="${item.hotplaceNumber}" /> <input type="hidden"
													name="memberNumber"
													value="${sessionScope.member.memberNumber}" />
												<button type="submit" class="Btn" id="main-picked">
													<img
														src="${pageContext.request.contextPath}/assets/images/pick.png"
														style="width: 30px" alt="찜한 상태" />
												</button>
											</form>
										</c:when>
										<c:otherwise>
											<form action="${pageContext.request.contextPath}/pick.mn" method="post">
												<input type="hidden" name="hotplaceNumber"
													value="${item.hotplaceNumber}" /> <input type="hidden"
													name="memberNumber"
													value="${sessionScope.member.memberNumber}" />
												<button type="submit" class="Btn" id="main-picked">
													<img 
														src="${pageContext.request.contextPath}/assets/images/picked.png"
														style="width: 30px" alt="찜하지 않은 상태" />
												</button>
											</form>
										</c:otherwise>
									</c:choose>
								</c:if>

							</div> <a href="${item.hotplaceLink}">
								<div class="main-hot-list-txt">
									<span id="main-hot-title">${item.hotplaceStation}</span>
								</div>
								<div class="main-hot-list-txt2">
									<span id="main-hot-txt">${item.hotplaceTitle} </span>
								</div>
						</a>
						</li>
					</c:forEach>
				</ul>
			</section>
		</section>
		<!-- 2번째 줄 4칸 -->
		<section class="main-section-third-2">
			
			<section class="main-section-third-top">
				<ul id="main-hot">
					<c:forEach var="item" items="${hplist2}">
						<li id="main-hot-list">
							<div id="main-hot-list-img"
								style="background-image: url(${pageContext.request.contextPath}/assets/images/main-3.jpg);">

								<c:if test="${not empty sessionScope.member.memberNumber}">
									<c:set var="isLiked" value="false" />

									<c:forEach var="like" items="${memCheckLike}">
										<c:if test="${item.hotplaceNumber == like.hotplaceNumber}">
											<c:set var="isLiked" value="true" />
										</c:if>
									</c:forEach>

									<c:choose>
										<c:when test="${isLiked}">
											<form action="${pageContext.request.contextPath}/unpick.mn" method="post">
												<input type="hidden" name="hotplaceNumber"
													value="${item.hotplaceNumber}" /> <input type="hidden"
													name="memberNumber"
													value="${sessionScope.member.memberNumber}" />
												<button type="submit" class="Btn" id="main-picked">
													<img
														src="${pageContext.request.contextPath}/assets/images/pick.png"
														style="width: 30px" alt="찜한 상태" />
												</button>
											</form>
										</c:when>
										<c:otherwise>
											<form action="${pageContext.request.contextPath}/pick.mn" method="post">
												<input type="hidden" name="hotplaceNumber"
													value="${item.hotplaceNumber}" /> <input type="hidden"
													name="memberNumber"
													value="${sessionScope.member.memberNumber}" />
												<button type="submit" class="Btn" id="main-picked">
													<img 
														src="${pageContext.request.contextPath}/assets/images/picked.png"
														style="width: 30px" alt="찜하지 않은 상태" />
												</button>
											</form>
										</c:otherwise>
									</c:choose>
								</c:if>

							</div> <a href="${item.hotplaceLink}">
								<div class="main-hot-list-txt">
									<span id="main-hot-title">${item.hotplaceStation}</span>
								</div>
								<div class="main-hot-list-txt2">
									<span id="main-hot-txt">${item.hotplaceTitle} </span>
								</div>
						</a>
						</li>
					</c:forEach>
				</ul>
			</section>
		</section>

		<!-- 커뮤톡톡 -->
		<section class="main-section-fourth">
			<div id="main-third-title">
				<img id="main-body-hot-icon"
					src="${pageContext.request.contextPath}/assets/images/community-icon.png">커뮤톡톡!
			</div>
			<div class="main-community">
				<div class="main-section-btn">
					<button id="main-section-left" onclick="prevItem()"><</button>
					<button id="main-section-right" onclick="nextItem()">></button>
				</div>
				<ul class="main-comu">

					<c:forEach var="item" items="${comuListResults}">
						<li id="main-comu-list"><a
							href="../../html/community/comu-post-guest.html">
								<div class="main-comu-left">
									<div id="main-comu-title">
										<a
											href="${pageContext.request.contextPath}/community/comu-detail.cm?boardNumber=${item.boardNumber}">
											<strong>${item.boardTitle}</strong>
										</a>
									</div>
									<div id="main-comu-writer">작성자 : ${item.memberNickname} |
										추천수 : ${item.recommendCount}</div>
									<hr>
									<div id="main-comu-txt">${item.boardContent}</div>
								</div>
						</a></li>
					</c:forEach>
				</ul>

			</div>
		</section>

		<!-- 광고 -->
		<section class="main-ad">
			<iframe width="560" height="315"
				src="https://www.youtube.com/embed/UZwA270UALQ?si=sqTRbVZM45v0gRAP"
				title="YouTube video player" frameborder="0"
				allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share"
				referrerpolicy="strict-origin-when-cross-origin" allowfullscreen></iframe>
		</section>
	</main>
</body>
<%@ include file="footer.jsp"%>
<script src="${pageContext.request.contextPath}/assets/js/main.js"></script>
</html>