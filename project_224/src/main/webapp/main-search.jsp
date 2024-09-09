<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="com.pj224.app.dto.MainDTO"%>
<%
List<MainDTO> cmresults = (List<MainDTO>) request.getAttribute("searchcmResults");
List<MainDTO> hpresults = (List<MainDTO>) request.getAttribute("searchhpResults");
%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Document</title>
<link rel="stylesheet"
	href="${pageContextpath.request.contextPath }/assets/css/main-search.css">
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
</head>
<%@ include file="header.jsp"%>
<body>
	<div>
		<form>
			<div class="results_board">
				<p class="top_title">커뮤톡톡</p>
				<div class="conts">
					<div class="content">
					<!-- 커뮤톡톡 검색결과 -->
						<c:if test="${not empty searchcmResults}">
							<c:forEach var="item" items="${searchcmResults}">
							<div>
								<span class="title">
								<a href="${pageContextpath.request.contextPath }/community/comu-detail.cm?boardNumber=${item.boardNumber}">${item.boardTitle} </a>
									<font class="comment-cnt">${item.commentCount} </font>
								</span>
								<p>
									<a href="${pageContextpath.request.contextPath }/community/comu-detail.cm?boardNumber=${item.boardNumber}">${item.boardContent} &nbsp;</a>
								</p>
								<p class="desc">
									<span>${item.boardCate } </span> | 
									<span id="">${item.boardRegistDate}	</span> |
									<span class="like">추천 ${item.recommendCount} </span>
								</p>
								</div>
							</c:forEach>
							<!-- 더보기 버튼 -->
							<a href="${pageContext.request.contextPath}/app/community/commu-main.cm" class="more-button">커뮤 더보기!</a>
						</c:if>
					</div>
					<c:if test="${empty searchcmResults}">
						<p>검색 결과가 없습니다.</p>
					</c:if>
					<!-- 커뮤톡톡 검색완료 -->
					<!-- 핫플콕콕 검색결과 -->
					<p class="top_title">핫플콕콕</p>
					<div class="content">
					<!-- 커뮤톡톡 검색결과 -->
						<c:if test="${not empty searchhpResults}">
							<c:forEach var="item" items="${searchhpResults}">
							<div>
								<span class="title">
								<a href="#">${item.hotplaceTitle} </a>
									<font class="comment-cnt">${item.hotplaceStation} </font>
								</span>
								<p>
									<a href="#">${item.hotplaceHours} &nbsp;</a>
								</p>
								<p>
									<a href="#">${item.hotplaceAddress} &nbsp;</a>
								</p>
								<p class="desc">
									<span>${item.hotplaceAttractionContent } </span> 
									<span>${item.hotplaceRestCuisine}</span>
									<span>${item.hotplaceRestMenu} </span>
								</p>
								</div>
							</c:forEach>
							<!-- 더보기 버튼 -->
							<a href="${pageContext.request.contextPath}/app/hotplace/hotplace.hp" class="more-button">핫플 더보기!</a>
						</c:if>
					</div>
					<c:if test="${empty searchhpResults}">
						<p>검색 결과가 없습니다.</p>
					</c:if>

					<p class="top_title">편의공공</p>
					<div class="conts">
						<div class="content">
							<span class="title"> <a href="#">내일 모바일게임 대작 2개 출시하네요.
									<font class="comment-cnt">15</font>
							</a>
							</span>
							<p>
								<a href="#"><b>호연</b> 영웅전설은 30대 이상만 아는 추억의 게임 &nbsp;</a>
							</p>
							<p class="desc">
								<span>[자유게시판]</span> | <span>2024.08.27</span> | <span
									class="like">0</span> |
							</p>
						</div>
					</div>
					<div class="conts">
						<div class="content">
							<span class="title"> <a href="#">내일 모바일게임 대작 2개 출시하네요.
									<font class="comment-cnt">15</font>
							</a>
							</span>
							<p>
								<a href="#"><b>호연</b> 영웅전설은 30대 이상만 아는 추억의 게임 &nbsp;</a>
							</p>
							<p class="desc">
								<span>[자유게시판]</span> | <span>2024.08.27</span> | <span
									class="like">0</span> |
							</p>
						</div>
						<div class="conts">
							<div class="content">
								<span class="title"> <a href="#">내일 모바일게임 대작 2개
										출시하네요. <font class="comment-cnt">15</font>
								</a>
								</span>
								<p>
									<a href="#"><b>호연</b> 영웅전설은 30대 이상만 아는 추억의 게임 &nbsp;</a>
								</p>
								<p class="desc">
									<span>[자유게시판]</span> | <span>2024.08.27</span> | <span
										class="like">0</span> |
								</p>
							</div>
						</div>
					</div>
					<!-- 더보기 버튼 -->
					<a href="#" class="more-button">편의 더보기!</a>


					<div class="info-bg2">
						<div class="bottom-list">
							<a class="prev" onfocus="blur()" href="#"></a> <a class="num on"
								onfocus="blur()" href="#">1</a> <a class="num" onfocus="blur()"
								href="#">2</a> <a class="num" onfocus="blur()" href="#">3</a> <a
								class="num" onfocus="blur()" href="#">4</a> <a class="num"
								onfocus="blur()" href="#">5</a> <a class="next" onfocus="blur()"
								href="#"></a>
						</div>
					</div>
				</div>
			</div>
		</form>
	</div>
</body>
<%@ include file="footer.jsp"%>
<script src="${pageContext.request.contextPath}/assets/js/main.js"></script>
</html>