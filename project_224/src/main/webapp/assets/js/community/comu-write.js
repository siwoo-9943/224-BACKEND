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

            let formData = {
                comuTitle: comuTitle,
                comuCategory: comuCategory,
                editordata: editordata
            };

            $.ajax({
                url: contextPath + "/community/comu-writeOk.cm", // 올바른 URL 경로
                type: "POST",
                data: formData,
                success: function(response) {
                    alert('게시물이 등록되었습니다.');
                    window.location.href = contextPath + "/community/comu-main.cm"; // 페이지 이동
                },
                error: function() {
                    $('#checkIdResult').text('오류가 발생했습니다. 다시 시도해주세요');
                }
            });
        });
    });