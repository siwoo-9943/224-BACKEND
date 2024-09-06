$(document).ready(function() {
    $('#submitButton').on('click', function() {
        console.log("등록 버튼 클릭");
        
        let comuTitle = $('#comu-board-title').val();
        let comuCategory = $('#comu-category-select').val();
        let editordata = $('#summernote').val();

        if (comuTitle === '') {
            alert('제목을 입력해 주세요');
            return;
        }

        // 데이터 객체 생성
        let formData = {
            comuTitle: comuTitle,
            comuCategory: comuCategory,
            editordata: editordata
        };

        $.ajax({
            url: "/community/registerPost.me", // 서버 엔드포인트
            type: "post",
            data: formData,
            success: function(result) {
                // 성공 시 처리 (예: 결과 메시지 표시)
                alert('게시물이 등록되었습니다.');
                location.href = '../community/comu-main.jsp'; // 게시판 메인으로 이동
            },
            error: function() {
                $('#checkIdResult').text('오류가 발생했습니다. 다시 시도해주세요');
            }
        });
    });
});