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
<jsp:include page="/header.jsp" />
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
            <span>
            <a href="" title="페이지 이동">지도</a>
            </span>
        </div>  
       
       <!-- 여기가 지도 api 들어가야하는 부분 -->
       <div id="map" style="width:100%;height:500px;"></div>
       
    </div>
<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=9656e46284633c78d98a5b23b8daf606"></script>
<script>
var mapContainer = document.getElementById('map'), // 지도를 표시할 div  
    mapOption = { 
        center: new kakao.maps.LatLng(37.497952, 127.027619), // 지도의 중심좌표
        level: 3 // 지도의 확대 레벨
    };

var map = new kakao.maps.Map(mapContainer, mapOption); // 지도를 생성합니다
 
// 마커를 표시할 위치와 title 객체 배열입니다 
var positions = [
    {
        title: '병원', 
        latlng: new kakao.maps.LatLng(37.49936340845783, 127.02738583087921)
    },
    {
        title: '공용 주차장', 
        latlng: new kakao.maps.LatLng(37.4972484, 127.02742)
    },
    {
        title: 'CGV', 
        latlng: new kakao.maps.LatLng(37.5015586, 127.026319)
    },
    {
        title: '약국',
        latlng: new kakao.maps.LatLng(37.49880322151236, 127.02922314405441)
    }
];

// 마커 이미지의 이미지 주소입니다
var imageSrc = "https://t1.daumcdn.net/localimg/localimages/07/mapapidoc/markerStar.png"; 
    
for (var i = 0; i < positions.length; i ++) {
    
    // 마커 이미지의 이미지 크기 입니다
    var imageSize = new kakao.maps.Size(24, 35); 
    
    // 마커 이미지를 생성합니다    
    var markerImage = new kakao.maps.MarkerImage(imageSrc, imageSize); 
    
    // 마커를 생성합니다
    var marker = new kakao.maps.Marker({
        map: map, // 마커를 표시할 지도
        position: positions[i].latlng, // 마커를 표시할 위치
        title : positions[i].title, // 마커의 타이틀, 마커에 마우스를 올리면 타이틀이 표시됩니다
        image : markerImage // 마커 이미지 
    });
}
</script>
<jsp:include page="/footer.jsp" />
</body>
</html>