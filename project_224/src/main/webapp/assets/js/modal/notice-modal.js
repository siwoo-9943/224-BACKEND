
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

$(document).ready(function() {
  const $modal = $('#notice-deleteModal');
  let currentNoticeNumber;

  // 삭제 모달 열기
  window.openDeleteModal = function(noticeNumber) {
    currentNoticeNumber = noticeNumber;
    $modal.css('display', 'block');
  };

  // 삭제 모달 닫기
  window.closeDeleteModal = function() {
    $modal.css('display', 'none');
  };

  // 삭제 확인
  window.confirmDelete = function() {
    $('#noticeNumberInput').val(currentNoticeNumber);
    $('#deleteForm').submit();
  };

  // 모달 외부 클릭 시 닫기
  $(window).on('click', function(event) {
    if ($(event.target).is($modal)) {
      closeDeleteModal();
    }
  });
});