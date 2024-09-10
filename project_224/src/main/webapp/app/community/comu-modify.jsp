<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script>
	var contextPath = '${pageContext.request.contextPath}';
</script>
<!-- Bootstrap CSS -->
<link
	href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css"
	rel="stylesheet">
<!-- Summernote CSS -->
<link
	href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.css"
	rel="stylesheet">
<!-- 사용자 정의 CSS -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/css/community/comu-modify.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/css/modal/comu-modal.css" />
</head>
<body>
	<main>
		<div class="wrapper">
			<div class="contents">
				<div class="container">
					<div id="header-box">
						<div class="bbs-title">
							<h1 style="font-weight: bold;">커뮤톡톡!</h1>
						</div>
						<div class="desc">2호선 이용에 대한 정보 공유 및 각종 이야기를 나누는 공간입니다.</div>
					</div>

					<form
						action="${pageContext.request.contextPath}/community/comu-modifyOk.cm"
						method="post">
						<input type="hidden" name="boardNumber"
							value="${community.boardNumber}"> <input
							class="top-inp title" type="text" name="boardTitle"
							value="${community.boardTitle}" placeholder="제목을 입력해주세요."
							size="100" maxlength="200">

						<!-- Summernote 에디터로 대체될 영역 -->
						<textarea id="summernote" name="boardContent">${community.boardContent}</textarea>

						<div style="display: flex; justify-content: space-between;">
							<div>
								<button type="button" class="tempas-bt01" id="comu-back-modal"
									onclick="openBackModal()">
									<span>취소</span>
								</button>
							</div>
							<div>
								<button id="ok-button" type="submit" class="tempas-bt01">작성완료</button>
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>


		<!-- 뒤로가기 모달창 -->
		<div id="comu-backModal" class="comu-modal">
			<div class="comu-modal-content">
				<span class="comu-close" onclick="closeBackModal()">&times;</span>
				<h2>정말로 뒤로가시겠습니까?</h2>
				<p>뒤로가기 버튼을 클릭하면 작성한 내용은 저장되지 않습니다</p>
				<button class="confirm-btn" onclick="confirmBack()">뒤로가기</button>
				<button class="comu-cancel-btn" onclick="closeBackModal()">취소</button>
			</div>
		</div>
	</main>
</body>
<script>
$(document).ready(function() {
    $('#summernote').summernote({
        lang: 'ko-KR', // 한국어 설정
        height: 300,
        minHeight: null,
        maxHeight: null,
        focus: true,
        toolbar: [
            ['style', ['style']],
            ['font', ['bold', 'underline', 'clear']],
            ['color', ['color']],
            ['para', ['ul', 'ol', 'paragraph']],
            ['table', ['table']],
            ['insert', ['link', 'picture', 'video']],
            ['view', ['fullscreen', 'codeview', 'help']]
        ],
        placeholder: '내용을 입력해주세요.',
        callbacks: {
            onImageUpload: function(files) {
                // 이미지 업로드 처리
                // 여기에 서버로 이미지를 업로드하는 로직을 추가해야 합니다.
            }
        }
    });
});

function openBackModal() {
    // 뒤로 가기 모달 열기 로직
    if(confirm('작성 중인 내용이 저장되지 않습니다. 정말 나가시겠습니까?')) {
        window.history.back();
    }
}





	$(document).ready(
			function() {
				const $modal = $('#comu-backModal');

				// 뒤로가기 모달 열기
				window.openBackModal = function() {
					$modal.css('display', 'block');
				};

				// 뒤로가기 모달 닫기
				window.closeBackModal = function() {
					$modal.css('display', 'none');
				};

				// 뒤로가기 확인
				window.confirmBack = function() {
					var boardNumber = $('input[name="boardNumber"]').val();
					window.location.href = contextPath
							+ '/community/comu-detail.cm?boardNumber='
							+ boardNumber;
				};

				// 모달 외부 클릭 시 닫기
				$(window).on('click', function(event) {
					if ($(event.target).is($modal)) {
						closeBackModal();
					}
				});
			});
</script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<!-- Summernote JS -->
<script
	src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.js"></script>
<!-- Summernote 한글 언어 파일 -->
<script
	src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/lang/summernote-ko-KR.min.js"></script>
</html>