<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>커뮤톡톡 - 글 작성</title>

    <!-- External CSS & JS -->
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/community/comu-write.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/modal/comu-modal.css" />
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.css" rel="stylesheet">
    
    <!-- Custom Styling -->
    <style>
        body {
            font-family: 'Arial', sans-serif;
            background-color: #f9f9f9;
            color: #333;
        }
        
        main {
            padding: 20px;
            background-color: #fff;
            box-shadow: 0 4px 12px rgba(0, 0, 0, 0.1);
            margin: 40px auto;
            max-width: 900px;
            border-radius: 8px;
        }

        .bbs-title h1 {
            font-weight: bold;
            color: #007BFF;
        }

        .desc {
            font-size: 14px;
            color: #666;
            margin-top: 10px;
            margin-bottom: 30px;
        }

        #summernote {
            border: 1px solid #ddd;
            border-radius: 5px;
        }

        form {
            margin-top: 30px;
        }

        #letter-length {
            font-weight: bold;
            color: #007BFF;
            display: inline-block;
            margin-right: 5px;
        }

        .comu-modal {
            display: none;
            position: fixed;
            z-index: 1000;
            left: 0;
            top: 0;
            width: 100%;
            height: 100%;
            background-color: rgba(0, 0, 0, 0.6);
            justify-content: center;
            align-items: center;
        }

        .comu-modal-content {
            background-color: #fff;
            padding: 20px;
            border-radius: 8px;
            text-align: center;
        }

        .comu-modal h2 {
            margin-bottom: 15px;
            font-size: 20px;
        }

        .confirm-btn, .comu-cancel-btn {
            padding: 10px 20px;
            border-radius: 5px;
            font-size: 16px;
            margin: 10px;
        }

        .confirm-btn {
            background-color: #007BFF;
            color: #fff;
            border: none;
        }

        .comu-cancel-btn {
            background-color: #6c757d;
            color: #fff;
            border: none;
        }

        .confirm-btn:hover, .comu-cancel-btn:hover {
            opacity: 0.9;
        }

        /* Custom Button */
        .submit-btn {
            background-color: #28a745;
            color: #fff;
            border: none;
            padding: 10px 20px;
            border-radius: 5px;
            font-size: 16px;
            cursor: pointer;
        }

        .submit-btn:hover {
            background-color: #218838;
        }

        /* Responsive styling */
        @media (max-width: 768px) {
            main {
                padding: 15px;
                margin: 20px auto;
            }

            #summernote {
                height: 200px;
            }
        }
    </style>
</head>
<body>
<%@ include file="../../header.jsp"%>

<main>
    <div class="wrapper">
        <div class="contents">
            <div class="container">
                <div id="header-box">
                    <div class="bbs-title">
                        <h1>커뮤톡톡! - 글 작성</h1>
                    </div>
                    <div class="desc">
                        2호선 이용에 대한 정보 공유 및 각종 이야기를 나누는 공간입니다.
                    </div>
                </div>

                <!-- 글 작성 폼 -->
                <form method="post" action="submit">
                    <textarea id="summernote" name="editordata"></textarea>
                    <p id="letter-length">0</p>/100
                    <button type="submit" class="submit-btn">작성 완료</button>
                </form>
            </div>
        </div>
    </div>

    <!-- 뒤로가기 모달창 -->
    <div id="comu-backModal" class="comu-modal">
        <div class="comu-modal-content">
            <span class="comu-close" onclick="closeBackModal()">&times;</span>
            <h2>정말로 뒤로가시겠습니까?</h2>
            <p>뒤로가기 버튼을 클릭하면 작성한 내용은 저장되지 않습니다.</p>
            <button class="confirm-btn" onclick="confirmBack()">뒤로가기</button>
            <button class="comu-cancel-btn" onclick="closeBackModal()">취소</button>
        </div>
    </div>
</main>

<!-- External JS -->
<script src="${pageContext.request.contextPath}/assets/js/modal/comu-modal.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.js"></script>

<%@ include file="../../footer.jsp"%>

<!-- Summernote Initialization -->
<script>
    $(document).ready(function() {
        $('#summernote').summernote({
            height: 300,
            placeholder: '여기에 내용을 입력하세요...',
            toolbar: [
                ['style', ['bold', 'italic', 'underline', 'clear']],
                ['font', ['strikethrough', 'superscript', 'subscript']],
                ['fontsize', ['fontsize']],
                ['para', ['ul', 'ol', 'paragraph']],
                ['height', ['height']]
            ]
        });

        // Update letter count dynamically
        $('#summernote').on('summernote.change', function(we, contents, $editable) {
            var textLength = $('#summernote').text().length; // Changed from .val() to .text() to count visible text
            $('#letter-length').text(textLength);
        });
    });
</script>

</body>
</html>