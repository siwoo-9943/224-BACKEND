$(document).ready(function() {
	var maxLength = 1000;  // 최대 글자 수 설정
	$('#summernote').summernote({

		// airMode: true,
		callbacks: {
			onChange: function(contents, $editable) {

				// 태그와 공백 제거
				editorText = f_SkipTags_html(contents);
				editorText = editorText.replace(/\s/gi, ""); // 줄바꿈 제거
				editorText = editorText.replace(/&nbsp;/gi, ""); // 공백 제거

				// 글자 수가 제한을 초과할 경우, 초과한 부분을 자름
				if (editorText.length > maxLength) {
					alert('최대 글자 수는 ' + maxLength + '자입니다.');
					// 에디터 내용 자르기
					var truncatedText = editorText.substring(0, maxLength);
					$('#summernote').summernote('code', truncatedText);
				}

				// 현재 글자 수 표시
				$("#letter-length").text(editorText.length);
			},
			onImageUpload: function(files, editor) {
				console.log(files);
			}
		}
	});

	function f_SkipTags_html(input, allowed) {
		// 허용할 태그는 다음과 같이 소문자로 넘겨받습니다. (<a><b><c>)
		allowed = (((allowed || "") + "").toLowerCase().match(/<[a-z][a-z0-9]*>/g) || []).join('');
		var tags = /<\/?([a-z][a-z0-9]*)\b[^>]*>/gi,
			commentsAndPhpTags = /<!--[\s\S]*?-->|<\?(?:php)?[\s\S]*?\?>/gi;
		return input.replace(commentsAndPhpTags, '').replace(tags, function($0, $1) {
			return allowed.indexOf('<' + $1.toLowerCase() + '>') > -1 ? $0 : '';
		});
	}
});

$(document).ready(function() {
	$('#summernote').summernote({
		height: 300,
		maxHeight: 500,
		minHeight: 300
	});
});

// 제출 버튼을 눌렀을 때 이벤트 핸들러 추가
$('#submitButton').click(function(e) {
	if (!$('#notice-board-title').val()) {
		alert('제목을 입력해 주세요.');
		e.preventDefault();  // 제목이 없으면 제출되지 않도록 함
	}
});