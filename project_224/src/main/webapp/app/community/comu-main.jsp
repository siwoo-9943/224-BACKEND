<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>커뮤톡톡 - 게시판</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/css/community/comu-main.css" />
</head>
<style>
#communityList {
	list-style: none;
	padding: 0;
	margin: 0;
}

#communityList li {
	display: flex;
	align-items: center;
	padding: 10px;
	border-bottom: 1px solid #ddd;
	background-color: #ffffff;
}

.baseList-item:nth-child(odd) {
	background-color: #f9f9f9;
}

.baseList-space {
	flex: 1;
	text-align: center;
	padding: 0px;
	margin: 0;
	margin-right: 100px;
	margin-bottom: 10px;
}

.baseList-sector-title {
	margin-left: 20px;
	font-weight: bold;
}

.baseList-sector-content {
	font-weight: bold;
}

.baseList-sector {
	font-weight: bold;
	display: block;
	margin: 5px 0;
}
</style>
<body>
	<jsp:include page="/header.jsp" />
	<main>
		<div class="wrapper">
			<div class="contents">
				<div class="container"></div>
				<div>
					<div id="header-box">
						<div class="bbs-title">
							<h1 style="font-weight: bold;">커뮤톡톡!</h1>
						</div>
						<div class="desc">2호선 이용에 대한 정보 공유 및 각종 이야기를 나누는 공간입니다.</div>
					</div>



					<div class="navcontainer">
						<ul id="navlist">
							<li><a id="current" href="" onfocus="blur()">전체</a></li>
							<li><a href="" onfocus="blur()">자유</a></li>
							<li><a href="" onfocus="blur()">핫플 자유</a></li>
							<li><a href="" onfocus="blur()">핫플 후기</a></li>
							<li><a href="" onfocus="blur()">편공 자유</a></li>
							<li><a href="" onfocus="blur()">편공 후기</a></li>
						</ul>
						<a class="write-btn" onfocus="blur()"
							href="${pageContext.request.contextPath}/community/comu-write.cm">글쓰기</a>
					</div>
					<div id="revolution-main-table"
						class="title-bg bbs bid-publictransport">
						<div align="center" id="headNotice" style="display: flex;">
							<div class="baseList-space" style="width: 63px;">
								<span class="baseList-sector">분류</span>
							</div>
							<div class="baseList-space" style="width: 100%;">
								<span class="baseList-sector-title">제목</span>
							</div>
							<div class="baseList-space" style="width: 100%;">
								<span class="baseList-sector-content">내용</span>
							</div>
							<div class="baseList-space" style="width: 90px;">
								<span class="baseList-sector">글쓴이</span>
							</div>
							<div class="baseList-space" style="width: 90px;">
								<span class="baseList-sector">등록일</span>
							</div>
							<div class="baseList-space" style="width: 60px;">
								<span class="baseList-sector">추천</span>
							</div>
						</div>
					</div>
					<ul id="communityList">
						<c:forEach var="community" items="${communityList}">
							<li class="baseList-item">
								<!-- 분류 -->
								<div class="baseList-space">
									<span class="baseList-sector">${community.boardCate}</span>
								</div> <!-- 제목 -->
								<div class="baseList-space baseList-title">${community.boardTitle}</div>
								<!-- 내용 -->
								<div class="baseList-space">
									  <a href="${pageContext.request.contextPath}/community/comu-detail.cm?boardNumber=${community.boardNumber}">
									<span
										class="baseList-sector-content">${community.boardContent}</span>
									</a>
								</div> <!-- 글쓴이 -->
								<div class="baseList-space">
									<span class="baseList-sector">${community.memberNumber}</span>
								</div> <!-- 등록일 -->
								<div class="baseList-space">
									<span class="baseList-sector">${community.boardRegistDate}</span>
								</div> <!-- 추천 수 -->
								<div class="baseList-space">
									<span class="baseList-sector">${community.recommendCount}</span>
								</div>
							</li>
						</c:forEach>
					</ul>
					
						<!-- 페이지네이션 -->
				<div class="pagination-container">
					<ul class="notice-pagenation">
						<!-- 이전 페이지 그룹으로 이동 -->
						<c:if test="${startPage > 1}">
							<li><a href="?page=${startPage - 1}">&lt;</a></li>
						</c:if>

						<!-- 페이지 번호 출력 -->
						<c:forEach var="i" begin="${startPage}" end="${endPage}">
							<li><a href="?page=${i}"
								style="${i == currentPage ? 'font-weight:bold;' : ''}">${i}</a></li>
						</c:forEach>

						<!-- 다음 페이지 그룹으로 이동 -->
						<c:if test="${endPage < maxPages}">
							<li><a href="?page=${endPage + 1}">&gt;</a></li>
						</c:if>
					</ul>
				</div>
					
					<div class="bottom-search">
						<form method="get" name="search" action="/zboard/zboard.php">
							<select name="search-type" id="search-type">
								<option value="sub-memo">제목+본문</option>
								<option value="subject">제목</option>
								<option value="contnets">본문</option>
								<option value="name">닉네임</option>
							</select> <span class="default"> <input type="hidden" name="id"
								value="publictransport"> <input type="hidden"
								name="page-num" value="25"> <input type="text"
								name="keyword" id="keyword" value="" placeholder="검색어를 입력하세요..."
								onkeyup="filterFunction()"> <input type="submit"
								onfocus="blur()" value="검색">
							</span>
						</form>
					</div>
					
					
					
				</div>
			</div>
		</div>
	</main>
	<jsp:include page="/footer.jsp" />
</body>
<script
	src="${pageContext.request.contextPath}/assets/js/community/comu-main.js"></script>
</html>
