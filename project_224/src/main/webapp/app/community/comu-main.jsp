<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>커뮤톡톡 - 게시판</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/community/comu-main.css" />
</head>
<body>
    <jsp:include page="/header.jsp" />
    <main>
        <div class="wrapper">
            <div class="contents">
                <div id="header-box">
                    <div class="bbs-title">
                        <h1>커뮤톡톡!</h1>
                    </div>
                    <div class="desc">2호선 이용에 대한 정보 공유 및 각종 이야기를 나누는 공간입니다.</div>
                </div>

                <div class="navcontainer">
                    <ul id="navlist">
                        <li><a href="?category=전체" class="category-filter ${selectedCategory eq '전체' ? 'active' : ''}" data-category="전체">전체</a></li>
                        <li><a href="?category=자유" class="category-filter ${selectedCategory eq '자유' ? 'active' : ''}" data-category="자유">자유</a></li>
                        <li><a href="?category=핫플 자유" class="category-filter ${selectedCategory eq '핫플 자유' ? 'active' : ''}" data-category="핫플 자유">핫플 자유</a></li>
                        <li><a href="?category=핫플 후기" class="category-filter ${selectedCategory eq '핫플 후기' ? 'active' : ''}" data-category="핫플 후기">핫플 후기</a></li>
                        <li><a href="?category=편공 자유" class="category-filter ${selectedCategory eq '편공 자유' ? 'active' : ''}" data-category="편공 자유">편공 자유</a></li>
                        <li><a href="?category=편공 후기" class="category-filter ${selectedCategory eq '편공 후기' ? 'active' : ''}" data-category="편공 후기">편공 후기</a></li>
                    </ul>
                    <c:if test="${not empty sessionScope.member}">
                        <a class="write-btn" href="${pageContext.request.contextPath}/community/comu-write.cm">글쓰기</a>
                    </c:if>
                </div>

                <div id="headNotice">
                    <div class="baseList-space">
                        <span class="baseList-sector">분류</span>
                        <span class="baseList-sector">제목</span>
                        <span class="baseList-sector">글쓴이</span>
                        <span class="baseList-sector">등록일</span>
                        <span class="baseList-sector">추천</span>
                    </div>
                </div>

                <ul id="communityList">
                    <c:forEach var="community" items="${communityList}">
                        <li class="baseList-item">
                            <div class="baseList-space">
                                <span class="baseList-sector">${community.boardCate}</span>
                                <a href="${pageContext.request.contextPath}/community/comu-detail.cm?boardNumber=${community.boardNumber}"
                                   class="baseList-sector baseList-title">${community.boardTitle}</a>
                                <c:if test="${not empty community.memberNickname}">
                           <span class="baseList-sector">${community.memberNickname}</span>
                        </c:if>
                        <c:if test="${empty community.memberNickname}">
                           <span class="baseList-sector">탈퇴회원</span>
                        </c:if>
                                <span class="baseList-sector">${community.boardRegistDate}</span>
                                <span class="baseList-sector">${community.recommendCount}</span>
                            </div>
                        </li>
                    </c:forEach>
                </ul>

                <!-- 페이지네이션 -->
                <div class="pagination-container">
                    <ul class="community-pagenation">
                        <c:if test="${currentPage > 1}">
                            <li><a href="?page=${currentPage - 1}&category=${selectedCategory}">&lt;</a></li>
                        </c:if>

                        <c:forEach var="i" begin="${startPage}" end="${endPage}">
                            <li><a href="?page=${i}&category=${selectedCategory}"
                                class="${i == currentPage ? 'active' : ''}">${i}</a></li>
                        </c:forEach>

                        <c:if test="${currentPage < maxPages}">
                            <li><a href="?page=${currentPage + 1}&category=${selectedCategory}">&gt;</a></li>
                        </c:if>
                    </ul>
                </div>

            </div>
        </div>
    </main>
    <jsp:include page="/footer.jsp" />
</body>
<script src="${pageContext.request.contextPath}/assets/js/community/comu-main.js"></script>
</html>