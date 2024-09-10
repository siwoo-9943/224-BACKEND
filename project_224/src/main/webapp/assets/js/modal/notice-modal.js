
// 수정모달
function openModal() {
	document.getElementById('notice-myModal').style.display = 'block';
}

function closeModal() {
	document.getElementById('notice-myModal').style.display = 'none';
}

function goToPage() {
	window.location.href = 'notice-addetail.jsp';
}
// 모달 외부 클릭 시 닫기
window.onclick = function(event) {
	const modal = document.getElementById('notice-myModal');
	if (event.target == modal) {
		closeModal();
	}
};

