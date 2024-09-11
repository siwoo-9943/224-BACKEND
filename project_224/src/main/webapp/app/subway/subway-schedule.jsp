<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>지하철 도착 시간표</title>
</head>

<body>
	<%@ include file="../../header.jsp"%>
	<main>

		<div>
		<h1>배차시간 조회</h1>
			출발시간<input type="time">
			도착시간<input type="time">
			<button type="button">검색</button>

		</div>
		<section id="section1"></section>
	</main>
	<%@ include file="../../footer.jsp"%>
	<script>
// JSON 파일 경로
const jsonFilePath = "../../assets/json/jamsil.json";

//JSON 데이터를 불러오는 함수
function loadJSON() {
    fetch(jsonFilePath)
        .then(response => {
            if (!response.ok) {
                throw new Error('네트워크 응답이 좋지 않습니다');
            }
            return response.json();
        })
        .then(data => {
            console.log('JSON 데이터:', data); // 전체 데이터 확인

            if (data.SearchSTNTimeTableByIDService) {
                const service = data.SearchSTNTimeTableByIDService;
                
                // SearchSTNTimeTableByIDService와 row가 있는지 확인
                console.log('SearchSTNTimeTableByIDService:', service);
                if (service.row) {
                    console.log('row 데이터:', service.row); // row 데이터를 확인
                    displayTrainInfo(service.row);
                } else {
                    displayError('row 데이터가 없습니다.');
                }
            } else {
                displayError('SearchSTNTimeTableByIDService가 정의되지 않았습니다.');
            }
        })
        .catch(error => {
            console.error('JSON 파일을 불러오는 중 오류 발생:', error);
        });
}


// 역 도착 및 출발 시간 정보를 표시하는 함수
function displayTrainInfo(trainData) {
    let section = document.getElementById('section1');
    section.innerHTML = '<h2>잠실역 도착 및 출발 시간</h2>';

    
	for(i = 0; i < trainData.length; i++){
		console.log('train: ' + trainData[i].ARRIVETIME);
		const arriveTime = trainData[i].ARRIVETIME;
		const leftTime = trainData[i].LEFTTIME;
		
	    const trainInfo = 
	        '<div>' +
	            '<p>도착 시간: ' + arriveTime + '</p>' + 
	            '<p>출발 시간: ' + leftTime + '</p>' + 
	            '<hr>' +
	        '</div>';
	    
	    
	    section.innerHTML += trainInfo;
	}
}


// 페이지가 로드될 때 JSON 데이터를 불러옴
document.addEventListener('DOMContentLoaded', loadJSON);

</script>
</body>
</html>
