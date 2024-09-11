<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/convenience/conv-storage-detail.css">
</head>
<body>
<jsp:include page="/header.jsp" />
  <div style="position: relative; height: 350px;">
    <div style="position: absolute; left: 0px; bottom: 0px; right: 0px; z-index: 10;">
      <div style="width: 100%; max-width: 1200px; margin: 0 auto 30px;"><span
          style="font-size: 58px; color: #fff; font-weight: 700;">잠실역</span></div>
    </div>
    <div style="background-image: url(${pageContext.request.contextPath}/assets/images/hotplace.png); width: 100%; height: 100%;"></div>
  </div>
  <div class="sub-contents-inner gettingToSeoul" id="container">
    <div class="loction">
      <span class="ar">&gt;</span>
      물품보관함<span class="ar">&gt;</span>
      <span><a href="" title="페이지 이동">잠실역</a></span>
    </div>
  </div>
  <div style="display: flex; justify-content: center; margin-top: 20px;">
    <img src="${pageContext.request.contextPath}/assets/images/line2.png" alt="" style="width: 900px;">
  </div>
  <div>
    <div class="conv-storage-contents-wrapper">
      <div class="conv-storage-content-left">
        <div class="conv-storage-content-name" style="margin-bottom: 10px;">
          <h1 style="display: inline; margin: 0;">잠실역 </h2>
        </div>
        <img src="${pageContext.request.contextPath}/assets/images/conv-jamsil-box.png" style="height: 256px; width: 256px; margin-bottom: 0px;">
      </div>
      <div class="conv-storage-content-center">
        <div class="conv-storage-content-center-text">
           <h2>&nbsp;이름 : 잠실 109 ~ 125
            <br><br>
            &nbsp;위치 : 잠실역 B1층 10, 11번 출구 방면 (통로)
          </h2>
        </div>
      </div>
    	
    	 <!-- 지도 api 들어가는 부분 -->
      <div id="map" style="width:30%;height:300px;"></div>
    </div>
    <script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=9656e46284633c78d98a5b23b8daf606"></script>
<script>
var mapContainer = document.getElementById('map'), // 지도를 표시할 div  
    mapOption = { 
        center: new kakao.maps.LatLng(37.5141872807826, 127.10281586791105), // 지도의 중심좌표
        level: 3 // 지도의 확대 레벨
    };

var map = new kakao.maps.Map(mapContainer, mapOption); // 지도를 생성합니다
 
// 마커를 표시할 위치와 title 객체 배열입니다 
var positions = [
    {
        title: '10번 물품보관소', 
        latlng: new kakao.maps.LatLng(37.51442138878216, 127.10456219345262)
    },
    {
        title: '11번 물품보관소', 
        latlng: new kakao.maps.LatLng(37.51430331216673, 127.10417040993495)
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