function pickHotplace(hotplaceNumber, memberNumber) {
    $.ajax({
        url: '${pageContext.request.contextPath}/hotplace/pickHotplace.hp', // 요청을 보낼 URL
        type: 'POST',
        data: {
            hotplaceNumber: hotplaceNumber,
            memberNumber: memberNumber
        },
        success: function() {
            // 성공하면 이미지를 "picked"로 변경
            document.getElementById('pickImage' + hotplaceNumber).src = '${pageContext.request.contextPath}/assets/images/picked.png';
        },
        error: function(error) {
            console.error('Error:', error);
        }
    });
}