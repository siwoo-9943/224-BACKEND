<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
   href="${pageContext.request.contextPath}/assets/css/mypage/my-profile.css" />
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>

</head>
<%@ include file="../../header.jsp"%>
<body>
   <main>
      
         <!-- 목록 -->
         <form action="" method="post">
            <div class="my-profileBox">
               <div class="my-leftbox">
                  <div class="my-hello">
                     <div class="my-wellcome">반가워요!</div>
                     <div class="my-nickname">"${sessionScope.member.memberName}"님</div>
                  </div>
                  <div class="my-category">
                     <div class="my-category-menu">메뉴</div>
                     <div class="my-line"></div>
                     <a
                        href="${pageContext.request.contextPath}/app/mypage/my-passcheck.jsp">
                        <div class="my-category-menu">개인정보수정</div>
                     </a> <a
                        href="${pageContext.request.contextPath}/app/mypage/my-comunity.my">
                        <div class="my-category-menu">내가 작성한 글</div>
                     </a> <a
                        href="${pageContext.request.contextPath}/app/mypage/my-pick.my">
                        <div class="my-category-menu">찜목록</div>
                     </a> <a
                        href="${pageContext.request.contextPath}/app/mypage/my-quit.jsp">
                        <div class="my-category-menu">회원탈퇴</div>
                     </a>
                  </div>
               </div>

               <!-- 프로필 -->
               <div class="my-rightbox">
                  <div class="my-profile">
                     <div class="my-profile-title">내 프로필</div>
                     <div class="my-line"></div>
                     <div class="my-profile-center">
                        <div class="my-profile-category">
                           <div class="my-profile-menu">아이디 </div>
                           <div class="my-profile-value" id="memberNumber">${sessionScope.member.memberEmail}</div>
                        </div>
                        <div class="my-profile-category">
                           <div class="my-profile-menu">이름 </div>
                           <div class="my-profile-value" id="memberName">${sessionScope.member.memberName}</div>
                        </div>
                        <div class="my-profile-category">
                           <div class="my-profile-menu">닉네임 </div>
                           <div class="my-profile-value" id="memberNickname">${sessionScope.member.memberNickname}</div>
                        </div>
                        <div class="my-profile-category">
                           <div class="my-profile-menu">휴대폰 </div>
                           <div class="my-profile-value" id="memberPhone">${sessionScope.member.memberPhone}</div>
                        </div>
                        <div class="my-profile-category">
                           <div class="my-profile-menu">성별 </div>
                           <div class="my-profile-value" id="memberGender">${sessionScope.member.memberGender}</div>
                        </div>
                        <div class="my-profile-category">
                           <div class="my-profile-menu">생년월일 </div>
                           <div class="my-profile-value" id="memberBirth">${sessionScope.member.memberBirth}</div>
                        </div>
                     </div>

                     <!-- 개인정보수정 이동 버튼 -->
                     <a
                        href="${pageContext.request.contextPath}/app/mypage/my-passcheck.jsp"><button
                           type="button" class="my-button">개인정보수정</button></a>

                  </div>
               </div>
   </main>
</body>
<%@ include file="../../footer.jsp"%>
</html>