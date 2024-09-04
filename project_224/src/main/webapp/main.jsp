<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>



<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/css/main.css" />
</head>
<body>
	<%@ include file="header.jsp"%>
	<main>

		<!--역 둘러보기 선택 영역-->
		<section class="main-section-first">
			<div class="main-station">
				<ul id="main-slider-list">
					<li id="main-slider-one"><img src="../../images/1.png">
						<div class="main-station-frame">
							<h2>강남역</h2>
						</div> <a href="../../html/hotplace/hotplace-gangnam.html">
							<div id="main-station-hot">핫플</div>
					</a> <a href="../../html/convenience/conv-storage-gangnam.html">
							<div id="main-station-con">편의</div>
					</a></li>
					<li id="main-slider-two"><img src="../../images/2.png">
						<div class="main-station-frame">
							<h2>잠실역</h2>
						</div> <a href="../../html/hotplace/hotplace-jamsil.html">
							<div id="main-station-hot">핫플</div>
					</a> <a href="../../html/convenience/conv-storage-jamsil.html">
							<div id="main-station-con">편의</div>
					</a></li>
					<li id="main-slider-three"><img src="../../images/3.png">
						<div class="main-station-frame">
							<h2>홍대입구역</h2>
						</div> <a href="../../html/hotplace/hotplace-hongdae.html">
							<div id="main-station-hot">핫플</div>
					</a> <a href="../../html/convenience/conv-storage-hongdae.html">
							<div id="main-station-con">편의</div>
					</a></li>
					<li id="main-slider-four"><img src="../../images/4.png">
						<div class="main-station-frame">
							<h2>성수역</h2>
						</div> <a href="../../html/hotplace/hotplace-seongsu.html">
							<div id="main-station-hot">핫플</div>
					</a> <a href="../../html/convenience/conv-storage-seongsu.html">
							<div id="main-station-con">편의</div>
					</a></li>
					<li id="main-slider-five"><img src="../../images/5.png">
						<div class="main-station-frame">
							<h2>문래역</h2>
						</div> <a href="../../html/hotplace/hotplace-moonrae.html">
							<div id="main-station-hot">핫플</div>
					</a> <a href="../../html/convenience/conv-storage-moonrae.html">
							<div id="main-station-con">편의</div>
					</a></li>
					<li id="main-slider-six"><img src="../../images/6.png">
						<div class="main-station-frame">
							<h2>을지로입구역</h2>
						</div> <a href="../../html/hotplace/hotplace-euljiro.html">
							<div id="main-station-hot">핫플</div>
					</a> <a href="../../html/convenience/conv-storage-euljiro.html">
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
					<li class="main-slide"><img src="../../images/main-1.jpg"
						alt="Image 1"></li>
					<li class="main-slide"><img src="../../images/main-2.jpg"
						alt="Image 2"></li>
					<li class="main-slide"><img src="../../images/main-3.jpg"
						alt="Image 3"></li>
					<li class="main-slide"><img src="../../images/main-4.png"
						alt="Image 4"></li>
					<li class="main-slide"><img src="../../images/main-5.jpg"
						alt="Image 5"></li>
				</ul>
			</div>
		</section>

		<!-- 핫플콕콕 -->
		<section class="main-section-third">
			<div id="main-third-title">
				<img id="main-body-hot-icon" src="../../images/hotplace-icon.png">핫플콕콕!
			</div>
			<section class="main-section-third-top">
				<div class="main-section-btn">
					<button id="main-section-left" onclick="prevContent()"><</button>
					<button id="main-section-right" onclick="nextContent()">></button>
				</div>
				<ul id="main-hot">
					<li id="main-hot-list">
						<div id="main-hot-list-img"
							style="background-image: url(../../images/main-1.jpg);">
							<img id="main-picked" src="../../images/picked.png">
						</div> <a href="../../html/hotplace/hotplace-jamsil.html">
							<div class="main-hot-list-txt">
								<span id="main-hot-title">asd1</span> <span id="main-hot-txt">asdasdadadasdas<br>asdasdadadasdas
								</span>
							</div>
					</a>
					</li>
					<li id="main-hot-list">
						<div id="main-hot-list-img"
							style="background-image: url(../../images/main-5.jpg);">
							<img id="main-picked" src="../../images/picked.png">
						</div> <a href="../../html/hotplace/hotplace-jamsil.html">
							<div class="main-hot-list-txt">
								<span id="main-hot-title">asd2</span> <span id="main-hot-txt">asdasdadadasdas<br>asdasdadadasdas
								</span>
							</div>
					</a>
					</li>
					<li id="main-hot-list">
						<div id="main-hot-list-img"
							style="background-image: url(../../images/main-2.jpg);">
							<img id="main-picked" src="../../images/picked.png">
						</div> <a href="../../html/hotplace/hotplace-jamsil.html">
							<div class="main-hot-list-txt">
								<span id="main-hot-title">asd3</span> <span id="main-hot-txt">asdasdadadasdas<br>asdasdadadasdas
								</span>
							</div>
					</a>
					</li>
					<li id="main-hot-list">
						<div id="main-hot-list-img"
							style="background-image: url(../../images/main-3.jpg);">
							<img id="main-picked" src="../../images/picked.png">
						</div> <a href="../../html/hotplace/hotplace-jamsil.html">
							<div class="main-hot-list-txt">
								<span id="main-hot-title">asd4</span> <span id="main-hot-txt">asdasdadadasdas<br>asdasdadadasdas
								</span>
							</div>
					</a>
					</li>
					<li id="main-hot-list">
						<div id="main-hot-list-img"
							style="background-image: url(../../images/main-1.jpg);">
							<img id="main-picked" src="../../images/picked.png">
						</div> <a href="../../html/hotplace/hotplace-jamsil.html">
							<div class="main-hot-list-txt">
								<span id="main-hot-title">asd5</span> <span id="main-hot-txt">asdasdadadasdas<br>asdasdadadasdas
								</span>
							</div>
					</a>
					</li>
				</ul>
			</section>
		</section>

		<!-- 커뮤톡톡 -->
		<section class="main-section-fourth">
			<div id="main-third-title">
				<img id="main-body-hot-icon" src="../../images/community-icon.png">커뮤톡톡!
			</div>
			<div class="main-community">
				<div class="main-section-btn">
					<button id="main-section-left" onclick="prevItem()"><</button>
					<button id="main-section-right" onclick="nextItem()">></button>
				</div>
				<ul class="main-comu">
					<li id="main-comu-list"><a
						href="../../html/community/comu-post-guest.html">
							<div class="main-comu-left">
								<div id="main-comu-title">
									<strong>고속버스 명당자리</strong>
								</div>
								<div id="main-comu-writer">작성자 : 김민채 추천수 : 4</div>
								<hr>
								<div id="main-comu-txt">우끼끼 우끼 우끼끼</div>
							</div>
					</a></li>
					<li id="main-comu-list"><a
						href="../../html/community/comu-post-guest.html">
							<div class="main-comu-left">
								<div id="main-comu-title">
									<strong>고속버스 명당자리</strong>
								</div>
								<div id="main-comu-writer">작성자 : 김민채 추천수 : 3</div>
								<hr>
								<div id="main-comu-txt">우끼끼 우끼 우끼끼 우끼끼 우끼 우끼</div>
							</div>
					</a></li>
					<li id="main-comu-list"><a
						href="../../html/community/comu-post-guest.html">
							<div class="main-comu-left">
								<div id="main-comu-title">
									<strong>고속버스 명당자리</strong>
								</div>
								<div id="main-comu-writer">작성자 : 김민채 추천수 : 2</div>
								<hr>
								<div id="main-comu-txt">우끼끼 우끼 우끼끼 우끼끼 우끼 우끼끼 우끼끼 우끼 우끼끼
									우끼끼 우끼 우끼끼 우끼끼 우끼 우끼끼 우끼끼 우끼 우끼끼</div>
							</div>
					</a></li>
					<li id="main-comu-list"><a
						href="../../html/community/comu-post-guest.html">
							<div class="main-comu-left">
								<div id="main-comu-title">
									<strong>고속버스 명당자리</strong>
								</div>
								<div id="main-comu-writer">작성자 : 김민채 추천수 : 1</div>
								<hr>
								<div id="main-comu-txt">우끼끼 ..</div>
							</div>
					</a></li>
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
<%@ include file="footer.jsp" %>
</body>
</html>