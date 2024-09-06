 $(document).ready(function() {
            function loadProfile(memberNumber) {
                $.ajax({
                    url: '/mypage/Mypage', // 서버 측 컨트롤러 URL
                    type: 'GET',
                    data: { memberNumber: memberNumber },
                    success: function(data) {
                        // 받은 데이터로 HTML을 업데이트
                        $('#memberEmail').text(data.memberEmail);
                        $('#memberPw').text(data.memberPw);
                        $('#memberName').text(data.memberName);
                        $('#memberNickName').text(data.memberNickName);
                        $('#memberPhone').text(data.memberPhone);
                        $('#memberPhoneInput').text(data.memberPhoneInput);
                        $('#memberGender').text(data.memberGender);
                        $('#memberBirth').text(data.memberBirth);
                        $('#memberTerms').text(data.memberTerms);
                    },
                    error: function() {
                        alert('정보를 불러오는 데 실패했습니다.');
                    }
                });
            }

            // 예시로 특정 멤버 번호를 가지고 프로필 로드
            const memberNumber = 1; // 실제 값으로 변경
            loadProfile(memberNumber);
        });
        
        