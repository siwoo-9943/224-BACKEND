<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<link rel="stylesheet" 
href="${pageContext.request.contextPath}/assets/css/community/comu-comment-modify.css" />
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
            <h1>고속버스 명당자리.jpg<span id="comment">[38]</span></h1>
            <div class="topTitle-box">
              <span class="topTitle-profile"
                style="background-image:url(https://www.ppomppu.co.kr/images/no-face.jpg);"></span>
              <ul class="topTitle-mainbox">
                <li class="topTitle-name"><strong>닉네임1</strong><small>등록일 2024-08-23 13:40</small></li>
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
              <button class="comu-submit"><a href="./comu-main-member.html">이전</a></button>
            </div>
          </div>
        </div>

        <div id="form-commentInfo">
          <div id="comment-count">댓글 <span id="count">5</span></div>
          <div id="comment-comment-list">
            <ul>
              <li>
                <div><strong>닉네임2</strong></div>
                <div>
                  <div class="comu-member-rewrite-contents">
                    <div class="comu-comment-inputbox-but">
                      <input class="comu-comment-rewrite-input" value="감사합니다~!">
                      <a href="../../html/community/comu-post-member.html"><button class="comu-comment-rewrite-submit"
                          type="button">등록</button></a>
                    </div>
                  </div>
                </div>

              </li>
              <br>
              <li>
                <div><strong>닉네임</strong></div>
                <div><span>감사합니다~!</span></div>

                <div><small>2024-08-23 14:30</small></div>
              </li>
              <br>
              <li>
                <div><strong>닉네임</strong></div>
                <div><span>감사합니다~!</span></div>

                <div><small>2024-08-23 14:30</small></div>
              </li>
              <br>
              <li>
                <div><strong>닉네임</strong></div>
                <div><span>감사합니다~!</span></div>

                <div><small>2024-08-23 14:30</small></div>
              </li>
              <br>
              <li>
                <div><strong>닉네임</strong></div>
                <div><span>감사합니다~!</span></div>

                <div><small>2024-08-23 14:30</small></div>
              </li>
              <br>

            </ul>
          </div>

          <span id="comu-text-red">[알림]</span><span> 욕설,상처 줄 수 있는 악플은 삼가주세요</span>
          <div class="comu-inputbox-but">
            <input id="comment-input" placeholder="댓글을 입력해 주세요.">
            <button class="comu-submit" id="comu-Null-Modal" type="button" onclick="openNullModal()">등록</button>
          </div>
        </div>


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