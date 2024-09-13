<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>잠실역 핫플레이스</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/hotplace/hotplace-detail.css">
</head>
<%@ include file="../../header.jsp"%>
<body>
    <div style="position: relative; height: 350px;">
        <div style="position: absolute; left: 0px; bottom: 0px; right: 0px; z-index: 10;">
            <div style="width: 100%; max-width: 1200px; margin: 0 auto 30px;">
                <span style="font-size: 58px; color: #fff; font-weight: 700;">잠실역</span>
            </div>
        </div>
        <div style="background-image: url(${pageContext.request.contextPath}/assets/images/conv-jamsil.png); width: 100%; height: 100%;background-size:cover;background-repeat: no-repeat;"></div>
    </div>
    <div class="sub-contents-inner gettingToSeoul" id="container">
        <div class="location">
            <span class="ar">&gt;</span> 핫플콕콕<span class="ar">&gt;</span> <span>잠실역</span>
        </div>
    </div>

	<c:set var="itemsPerPage" value="4" />
	<c:set var="currentPage" value="${param.page eq null ? 1 : param.page}" />
	<c:set var="totalItems" value="${hotplaceList.size()}" />
	<c:set var="totalPages"
		value="${(totalItems + itemsPerPage - 1) / itemsPerPage}" />
	<c:set var="startIndex" value="${(currentPage - 1) * itemsPerPage}" />
	<c:set var="endIndex" value="${startIndex + itemsPerPage - 1}" />

	<div>
		<c:forEach var="hotplace" items="${hotplaceList}" varStatus="status">
			<c:if
				test="${status.index >= startIndex && status.index <= endIndex}">
				<div class="hotplace-contents-wrapper">
					<div class="hotplace-content-left">
						<!-- 세션에서 memberNumber 가져오기 -->
						<c:set var="memberNumber"
							value="${sessionScope.member.memberNumber != null ? sessionScope.member.memberNumber : 0}" />


						<div class="hotplace-content-name" style="margin-bottom: 10px;">
							<h1 style="display: inline; margin: 0;">${hotplace.hotplaceTitle}</h1>

							<c:if test="${memberNumber != 0}">
								<c:set var="isLiked" value="false" />
								<c:forEach var="like" items="${likeList}">
									<c:if
										test="${like.hotplaceNumber == hotplace.hotplaceNumber && like.memberNumber == memberNumber}">
										<c:set var="isLiked" value="true" />
									</c:if>
								</c:forEach>

								<c:choose>
									<c:when test="${isLiked}">
										<a
											href="${pageContext.request.contextPath}/hotplace/unpick.hp?hotplaceNumber=${hotplace.hotplaceNumber}&memberNumber=${memberNumber}&returnUrl=${pageContext.request.requestURL}&page=${currentPage}">
											<img
											src="${pageContext.request.contextPath}/assets/images/picked.png"
											style="width: 30px;" alt="찜 해제">
										</a>
									</c:when>
									<c:otherwise>
										<a
											href="${pageContext.request.contextPath}/hotplace/pick.hp?hotplaceNumber=${hotplace.hotplaceNumber}&memberNumber=${memberNumber}&returnUrl=${pageContext.request.requestURL}&page=${currentPage}">
											<img
											src="${pageContext.request.contextPath}/assets/images/pick.png"
											style="width: 30px;" alt="찜하기">
										</a>
									</c:otherwise>
								</c:choose>
							</c:if>
						</div>



						<div class="img-wrapper">
							<img src="${pageContext.request.contextPath}/assets/images/1.png"
								style="height: 100%; overflow: hidden; border: 1px solid black;">
						</div>
					</div>
					<div class="hotplace-content-right">
						<div class="hotplace-content-right-text">
							<h2>
								${hotplace.hotplaceHours} <br> <br>
								${hotplace.hotplaceAddress} <br> <br>
							</h2>

							<c:choose>
								<c:when test="${hotplace.hotplaceRestNumber != 0}">
									<p>음식 종류: ${hotplace.hotplaceRestCuisine}</p>
									<p>메뉴: ${hotplace.hotplaceRestMenu}</p>
								</c:when>
								<c:when test="${hotplace.hotplaceAttractionNumber != 0}">
									<p>내용: ${hotplace.hotplaceAttractionContent}</p>
								</c:when>
								<c:otherwise>
									<p>정보가 없습니다.</p>
								</c:otherwise>
							</c:choose>
						</div>
						<div class="hotplace-content-right-button">
							<button type="button" style="width: 50%; height: 50px;" onclick="window.open('${hotplace.hotplaceLink}')">자세히 보기</button>
						</div>
					</div>
				</div>
			</c:if>
		</c:forEach>
	</div>

<c:set var="pageRange" value="5" />
<c:set var="startPage" value="${currentPage - (pageRange / 2) > 1 ? currentPage - (pageRange / 2) : 1}" />
<c:set var="endPage" value="${startPage + pageRange - 1 > totalPages ? totalPages : startPage + pageRange - 1}" />
<c:if test="${endPage - startPage + 1 < pageRange}">
    <c:set var="startPage" value="${endPage - pageRange + 1 > 1 ? endPage - pageRange + 1 : 1}" />
</c:if>

<div class="info-bg2">
    <div class="bottom-list">
        <c:if test="${currentPage > 1}">
            <a class="prev" href="?page=${currentPage - 1}&memberNumber=${memberNumber}"></a>
        </c:if>

        <c:forEach var="i" begin="${startPage}" end="${endPage}">
            <a class="num ${currentPage == i ? 'on' : ''}" href="?page=${i}&memberNumber=${memberNumber}">${i}</a>
        </c:forEach>

        <c:if test="${currentPage < totalPages}">
            <a class="next" href="?page=${currentPage + 1}&memberNumber=${memberNumber}"></a>
        </c:if>
    </div>
</div>
</body>
</html>