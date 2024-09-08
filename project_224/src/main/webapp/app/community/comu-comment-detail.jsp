<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<link rel="stylesheet" 
href="${pageContext.request.contextPath}/assets/css/community/comu-comment-detail.css" />
<link rel="stylesheet" 
href="${pageContext.request.contextPath}/assets/css/modal/comu-modal.css" />
</head>
<body>
  <main>
    <div class="wrapper">
      <div class="contnets">
        <div class="container">
          <div>
            <div id="header-box">
              <div class="bbs-title">
                <h1 style="font-weight: bold;">커뮤톡톡!</h1>
              </div>
              <div class="desc">
                2호선 이용에 대한 정보 공유 및 각종 이야기를 나누는 공간입니다.
              </div>
            </div>
          </div>
          
          <div id="topTitle">
            <h1>고속버스 명당자리.jpg
            <span id="comment">[38]</span></h1>
            <div class="topTitle-box">
              <span class="topTitle-profile"
                style="background-image:url(https://www.ppomppu.co.kr/images/no-face.jpg);"></span>
              <ul class="topTitle-mainbox">
                <li class="topTitle-name">
                <strong>닉네임1</strong>
                <small>등록일 2024-08-23 13:40</small></li>
              </ul>
            </div>
          </div>
          <!-- 게시글 내용 -->
          <div class="comu-posting-textarea">
            <span>차멀미가 좀 있어서 고속버스 타고 멀리갈때 항상 걱정인데..</span><br>
            <span>참고하면 좋을 것 같네요!</span>
          </div>

          <div class="recommendArea">
            <div id="recommend">
              <span class="up-numb"><span id="vote-list-btn-txt">6</span>
                <div class="up-list">
                  <div id="vote-member-list"></div>
                </div>
              </span>
              <span class="recommend-up">추천하기</span>
              <span class="wall">|</span>
            </div>
          </div>

          <div class="comu-div-flex-content">
            <div class="com-div-flex-box-div">
              <button class="comu-submit">
              <a href="./comu-main-member.html">이전</a></button>
            </div>
          </div>
        </div>

      </div>
    </div>
    </div>
    <!-- 삭제 모달 HTML -->
    <div id="comu-deleteModal" class="comu-modal">
      <div class="comu-modal-content">
        <span class="comu-close" onclick="closeDeleteModal()">&times;</span>
        <h2>정말로 삭제하시겠습니까?</h2>
        <p>삭제 버튼을 클릭하면 항목이 영구히 삭제됩니다.</p>
        <button class="confirm-btn" onclick="confirmDelete()">삭제</button>
        <button class="comu-cancel-btn" onclick="closeDeleteModal()">취소</button>
      </div>
    </div>
    <!-- 입력값 없이 등록버튼 모달 -->
    <div id="comu-NullModal" class="comu-modal">
      <div class="comu-modal-content">
        <span class="comu-close" onclick="closeNullModal()">&times;</span>

        <p>등록할 글이 작성되지 않았습니다</p>

        <button class="comu-cancel-btn" onclick="closeNullModal()">확인</button>
      </div>
    </div>
  </main>
</body>
<script src="${pageContext.request.contextPath}/assets/js/modal/comu-modal.js"></script>
</html>