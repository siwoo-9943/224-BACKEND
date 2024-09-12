// JSON 파일 경로를 저장할 객체
const jsonFileUpPaths = {
    '강남': "http://openapi.seoul.go.kr:8088/526b4b794a73736d313131694779517a/json/SearchSTNTimeTableByIDService/1/999/0222/1/1/",
    '잠실': "http://openapi.seoul.go.kr:8088/526b4b794a73736d313131694779517a/json/SearchSTNTimeTableByIDService/1/999/0216/1/1/",
    '홍대입구': "http://openapi.seoul.go.kr:8088/526b4b794a73736d313131694779517a/json/SearchSTNTimeTableByIDService/1/999/0239/1/1/",
    '성수': "http://openapi.seoul.go.kr:8088/526b4b794a73736d313131694779517a/json/SearchSTNTimeTableByIDService/1/999/0211/1/1/",
    '문래': "http://openapi.seoul.go.kr:8088/526b4b794a73736d313131694779517a/json/SearchSTNTimeTableByIDService/1/999/0235/1/1/",
    '을지로입구': "http://openapi.seoul.go.kr:8088/526b4b794a73736d313131694779517a/json/SearchSTNTimeTableByIDService/1/999/0202/1/1/"
};
const jsonFileDownPaths = {
    '강남': "http://openapi.seoul.go.kr:8088/526b4b794a73736d313131694779517a/json/SearchSTNTimeTableByIDService/1/999/0222/1/2/",
    '잠실': "http://openapi.seoul.go.kr:8088/526b4b794a73736d313131694779517a/json/SearchSTNTimeTableByIDService/1/999/0216/1/2/",
    '홍대입구': "http://openapi.seoul.go.kr:8088/526b4b794a73736d313131694779517a/json/SearchSTNTimeTableByIDService/1/999/0239/1/2/",
    '성수': "http://openapi.seoul.go.kr:8088/526b4b794a73736d313131694779517a/json/SearchSTNTimeTableByIDService/1/999/0211/1/2/",
    '문래': "http://openapi.seoul.go.kr:8088/526b4b794a73736d313131694779517a/json/SearchSTNTimeTableByIDService/1/999/0235/1/2/",
    '을지로입구': "http://openapi.seoul.go.kr:8088/526b4b794a73736d313131694779517a/json/SearchSTNTimeTableByIDService/1/999/0202/1/2/"
};

// 상행선 JSON 데이터를 불러오는 함수
function loadJSONUp(location) {
    const jsonFileUpPath = jsonFileUpPaths[location];

    if (!jsonFileUpPath) {
        console.error('유효하지 않은 위치입니다:', location);
        return;
    }

    const xhr = new XMLHttpRequest();
    xhr.open('GET', jsonFileUpPath, true);
    
    xhr.onload = function() {
        if (xhr.status >= 200 && xhr.status < 300) {
            const data = JSON.parse(xhr.responseText);
            console.log('JSON 데이터:', data); // 전체 데이터 확인

            if (data.SearchSTNTimeTableByIDService) {
                const service = data.SearchSTNTimeTableByIDService;

                console.log('SearchSTNTimeTableByIDService:', service);
                if (service.row) {
                    console.log('row 데이터:', service.row); // row 데이터를 확인
                    displayTrainUpwardInfo(service.row);
                } else {
                    displayError('row 데이터가 없습니다.');
                }
            } else {
                displayError('SearchSTNTimeTableByIDService가 정의되지 않았습니다.');
            }
        } else {
            console.error('네트워크 응답이 좋지 않습니다:', xhr.statusText);
        }
    };

    xhr.onerror = function() {
        console.error('JSON 파일을 불러오는 중 오류 발생:', xhr.statusText);
    };

    xhr.send();
}

// 하행선 JSON 데이터를 불러오는 함수
function loadJSONDown(location) {
    const jsonFileDownPath = jsonFileDownPaths[location];

    if (!jsonFileDownPath) {
        console.error('유효하지 않은 위치입니다:', location);
        return;
    }

    const xhr = new XMLHttpRequest();
    xhr.open('GET', jsonFileDownPath, true);
    
    xhr.onload = function() {
        if (xhr.status >= 200 && xhr.status < 300) {
            const data = JSON.parse(xhr.responseText);
            console.log('JSON 데이터:', data); // 전체 데이터 확인

            if (data.SearchSTNTimeTableByIDService) {
                const service = data.SearchSTNTimeTableByIDService;

                console.log('SearchSTNTimeTableByIDService:', service);
                if (service.row) {
                    console.log('row 데이터:', service.row); // row 데이터를 확인
                    displayTrainDescendInfo(service.row);
                } else {
                    displayError('row 데이터가 없습니다.');
                }
            } else {
                displayError('SearchSTNTimeTableByIDService가 정의되지 않았습니다.');
            }
        } else {
            console.error('네트워크 응답이 좋지 않습니다:', xhr.statusText);
        }
    };

    xhr.onerror = function() {
        console.error('JSON 파일을 불러오는 중 오류 발생:', xhr.statusText);
    };

    xhr.send();
}



// 역 도착 및 출발 시간 정보를 표시하는 함수
// 상행선
function displayTrainUpwardInfo(trainData) {
    let section = document.getElementById('section1');
    section.innerHTML = ''; // 이전 내용 제거

    for (let i = 0; i < trainData.length; i++) {
        const arriveTime = trainData[i].ARRIVETIME;
        const leftTime = trainData[i].LEFTTIME;

        const trainInfo =
            '<div>' +
            '<p>도착 시간 : ' + arriveTime + '</p>' +
            '<p>출발 시간 : ' + leftTime + '</p>' +
            '<hr>' +
            '</div>';

        section.innerHTML += trainInfo;
    }
}

// 하행선
function displayTrainDescendInfo(trainData) {
    let section = document.getElementById('section2');
    section.innerHTML = ''; // 이전 내용 제거

    for (let i = 0; i < trainData.length; i++) {
        const arriveTime = trainData[i].ARRIVETIME;
        const leftTime = trainData[i].LEFTTIME;

        const trainInfo =
            '<div>' +
            '<p>도착 시간 : ' + arriveTime + '</p>' +
            '<p>출발 시간 : ' + leftTime + '</p>' +
            '<hr>' +
            '</div>';

        section.innerHTML += trainInfo;
    }
}

let activeButton = null;

// 버튼 클릭 시 호출되는 함수
function onLocationButtonClick(location , button) {
	// 이전에 선택된 버튼이 있다면 클래스를 제거
    if (activeButton) {
        activeButton.classList.remove('active');
    }
    
    // 현재 클릭된 버튼에 클래스 추가
    button.classList.add('active');
    
    // 현재 버튼을 activeButton으로 설정
    activeButton = button;
    
    document.getElementById('station').innerText = location + '역 '; // 예: "강남역"
    
    loadJSONUp(location);
    loadJSONDown(location);
}

