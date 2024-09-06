<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

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
						<c:if test="${not empty searchResults}">
							<c:forEach var="item" items="${searchResults}">
								<span class="title"> <a href="#">${item.boardTitle} </a>
									<font class="comment-cnt">${item.commentCount} </font>
								</span>
								<p>
									<a href="#">${item.boardContent} &nbsp;</a>
								</p>
								<p class="desc">${item.boardRegistDate}
									<span>${item.boardCate } </span> | <span id="">${item.boardRegistDate}
									</span> | <span class="like">추천 ${item.recommendCount} </span>
								</p>
							</c:forEach>
						</c:if>
					</div>
					<!-- 더보기 버튼 -->
					<a href="#" class="more-button">핫플 더보기!</a>
					<c:if test="${empty searchResults}">
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

</html>