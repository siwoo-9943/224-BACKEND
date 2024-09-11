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
					displayTrainUpwardInfo(service.row);
					displayTrainDescendInfo(service.row);
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
function displayTrainUpwardInfo(trainData) {
	let section = document.getElementById('section1');

	for (i = 0; i < trainData.length; i++) {
		console.log('train: ' + trainData[i].ARRIVETIME);
		const stationNumber = trainData[i].STATION_NM;
		const arriveTime = trainData[i].ARRIVETIME;
		const leftTime = trainData[i].LEFTTIME;

		const trainInfo =
			'<div>' +
			'<p>역 정보: ' + stationNumber + '<p>' +
			'<p>도착 시간: ' + arriveTime + '</p>' +
			'<p>출발 시간: ' + leftTime + '</p>' +
			'<hr>' +
			'</div>';


		section.innerHTML += trainInfo;
	}
}

function displayTrainDescendInfo(trainData) {
	let section = document.getElementById('section2');

	for (i = 0; i < trainData.length; i++) {
		console.log('train: ' + trainData[i].ARRIVETIME);
		const stationNumber = trainData[i].STATION_NM;
		const arriveTime = trainData[i].ARRIVETIME;
		const leftTime = trainData[i].LEFTTIME;

		const trainInfo =
			'<div>' +
			'<p>역 정보: ' + stationNumber + '<p>' +
			'<p>도착 시간: ' + arriveTime + '</p>' +
			'<p>출발 시간: ' + leftTime + '</p>' +
			'<hr>' +
			'</div>';


		section.innerHTML += trainInfo;
	}
}


// 페이지가 로드될 때 JSON 데이터를 불러옴
document.addEventListener('DOMContentLoaded', loadJSON);



let selectedLocation = '강남'; // 기본 선택값

const buttons = document.querySelectorAll('.location-btn');
buttons.forEach(button => {
	button.addEventListener('click', () => {
		selectedLocation = button.getAttribute('data-value');
		buttons.forEach(btn => btn.classList.remove('selected'));
		button.classList.add('selected');
	});
});

function submitForm() {
	const startTime = document.getElementById('start').value;
	const endTime = document.getElementById('end').value;

	// 시간 유효성 검사
	if (!startTime || !endTime) {
		startTime = null;
		endTime = null;
		return;
	}

	if (startTime >= endTime) {
		endTime = startTime;
		return ;
	}
	// 여기에 폼 데이터를 전송하는 코드를 추가하세요
	console.log('선택된 위치:', selectedLocation);
	console.log('시작 시간:', startTime);
	console.log('종료 시간:', endTime);
	// 예: AJAX 요청 등
}