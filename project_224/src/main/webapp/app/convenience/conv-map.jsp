<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/convenience/conv-map.css">
</head>
<body>
    <div style="position: relative; height: 350px;">
        <div style="position: absolute; left: 0px; bottom: 0px; right: 0px; z-index: 10;">
            <div style="width: 100%; max-width: 1200px; margin: 0 auto 30px;"><span
                    style="font-size: 58px; color: #fff; font-weight: 700;">지도</span></div>
        </div>
        <div style="background-image: url(${pageContext.request.contextPath}/assets/images/hotplace.png); width: 100%; height: 100%;"></div>
    </div>
    <div class="sub-contents-inner gettingToSeoul" id="container">
        <div class="loction">
            <span class="ar">&gt;</span>
            여행정보<span class="ar">&gt;</span>
            <span><a href="" title="페이지 이동">지도</a></span>
        </div>  
        <div style="position: relative; height: 600px;">
            <div style="background-color: skyblue; width: 900px; height: 100%; margin: 100px auto 0 auto;"></div>
        </div>
    </div>
</body>
</html>