<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="com.pj224.app.dto.MainDTO"%>
<%
List<MainDTO> cmresults = (List<MainDTO>) request.getAttribute("searchcmResults");
List<MainDTO> hpresults = (List<MainDTO>) request.getAttribute("searchhpResults");
List<MainDTO> noresults = (List<MainDTO>) request.getAttribute("searchnoResults");
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

				<!-- 커뮤톡톡 검색결과 -->
				<div class="conts">
					<div class="content">
						<c:if test="${not empty searchcmResults}">
							<c:forEach var="item" items="${searchcmResults}">
								<div>
									<span class="title"> <a
										href="${pageContextpath.request.contextPath }/community/comu-detail.cm?boardNumber=${item.boardNumber}">${item.boardTitle}
									</a> <font class="comment-cnt">${item.commentCount} </font>
									</span>
									<p>
										<a
											href="${pageContextpath.request.contextPath }/community/comu-detail.cm?boardNumber=${item.boardNumber}">${item.boardContent}
											&nbsp;</a>
									</p>
									<p class="desc">
										<span>${item.boardCate } </span> | <span id="">${item.boardRegistDate}
										</span> | <span class="like">추천 ${item.recommendCount} </span>
									</p>
								</div>
							</c:forEach>
							<!-- 더보기 버튼 -->
							<a
								href="${pageContext.request.contextPath}/app/community/commu-main.cm"
								class="more-button">커뮤 더보기!</a>
						</c:if>
					</div>
					<c:if test="${empty searchcmResults}">
						<p>검색 결과가 없습니다.</p>
					</c:if>
					<!-- 커뮤톡톡 검색완료 -->

					<!-- 핫플콕콕 검색결과 -->
					<p class="top_title">핫플콕콕</p>
					<div class="content">
						<c:if test="${not empty searchhpResults}">
							<c:forEach var="item" items="${searchhpResults}">
								<div>
									<span class="title"> <a href="#">${item.hotplaceTitle}
									</a> <font class="comment-cnt">${item.hotplaceStation} </font>
									</span>
									<p>
										<a href="#">${item.hotplaceHours} &nbsp;</a>
									</p>
									<p>
										<a href="#">${item.hotplaceAddress} &nbsp;</a>
									</p>
									<p class="desc">
										<span>${item.hotplaceAttractionContent } </span> <span>${item.hotplaceRestCuisine}</span>
										<span>${item.hotplaceRestMenu} </span>
									</p>
								</div>
							</c:forEach>
							<!-- 더보기 버튼 -->
							<a
								href="${pageContext.request.contextPath}/app/hotplace/hotplace.hp"
								class="more-button">핫플 더보기!</a>
						</c:if>
					</div>
					<c:if test="${empty searchhpResults}">
						<p>검색 결과가 없습니다.</p>
					</c:if>
					<!-- 커뮤톡톡 검색완료 -->

					<!-- 공지쏙쏙 검색결과 -->
					<p class="top_title">공지쏙쏙</p>
					<div class="content">
						<c:if test="${not empty searchnoResults}">
							<c:forEach var="item" items="${searchnoResults}">
								<div>
									<span class="title"> <font class="comment-cnt">[
											${item.noticeCate} ]</font> <a
										href="${pageContextpath.request.contextPath }/notice/notice-detail.no?noticeNumber=${item.noticeNumber}">${item.noticeTitle}
									</a>
									</span>
									<p>
										<a
											href="${pageContextpath.request.contextPath }/notice/notice-detail.no?noticeNumber=${item.noticeNumber}">${item.noticeContent}
											&nbsp;</a>
									</p>
									<p class="desc">
										<span>${item.noticeRegistDate } </span>
									</p>
								</div>
							</c:forEach>
							<!-- 더보기 버튼 -->
							<a
								href="${pageContext.request.contextPath}/notice/notice-admain.no"
								class="more-button">공지 더보기!</a>
						</c:if>
					</div>
					<c:if test="${empty searchnoResults}">
						<p>검색 결과가 없습니다.</p>
					</c:if>

					
				</div>
			</div>
		</form>
	</div>
</body>
<%@ include file="footer.jsp"%>
<script src="${pageContext.request.contextPath}/assets/js/main.js"></script>
</html>