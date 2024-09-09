<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>관리자 목록</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/css/notice/notice-admain.css">
</head>


<%@ include file="../../header.jsp"%>
<body>
<body>
	<!-- 페이지의 메인 부분 -->
	<div class="wrapper">
		<div class="notice-admain-all">
			<!-- 게시판 부분 -->
			<div class="notice-admain-main">
				<!-- 게시판 상단부 '공지사항' -->
				<div class="notice-admain-toptxt">
					<div class="notice-admain-toptxt-in">
						<h2 class="notice-admain-toptxt-txt">공지사항</h2>
					</div>
				</div>
				<!-- 게시글 칼럼 구분 -->
				<div class="notice-admain-container">
					<div width="50" class="notice-admain-container-cate">분류</div>
					<div class="notice-admain-container-title">제목</div>
					<div width="100" class="notice-admain-container-audate">작성자</div>
					<div width="100" class="notice-admain-container-audate">작성일</div>
				</div>
				
				<!-- 게시글 목록 -->
				<ul class="notice-admain-ul-all">
					<c:forEach var="notice" items="${noticeshowlist}">
						<li><a
							href="${pageContext.request.contextPath}/notice/notice-addetail.no?title=${notice.noticeTitle}">
								<div class="notice-admain-ul-main">
									<div class="notice-admain-ul-cate">${notice.noticeCate}</div>
									<div class="notice-admain-ul-title">${notice.noticeTitle}</div>
									<div class="notice-admain-ul-author">${notice.memberNumber}</div>
									<div class="notice-admain-ul-date">${notice.noticeRegistDate}</div>
								</div>
						</a></li>
					</c:forEach>
				</ul>

					<!-- 페이지네이션 -->
					<div class="pagination-container">
						<ul class="doctorList-ear-pagenation">
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

					<div class="notice-admain-btuall">
						<button class="notice-admain-btu" type="button">
							<a href="${pageContext.request.contextPath}/notice/write.no">
								<span class="notice-admain-btu-sp">글쓰기</span>
							</a>
						</button>
					</div>
</body>
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.js"></script>
</html>