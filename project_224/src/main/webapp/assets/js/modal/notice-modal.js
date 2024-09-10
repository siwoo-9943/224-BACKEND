$(document).ready(function() {
  const $modal = $('#notice-deleteModal');
  let currentNoticeNumber;

<<<<<<< HEAD
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

=======
  // 삭제 모달 열기
 window.openDeleteModal = function(noticeNumber) {
  currentNoticeNumber = noticeNumber;
  $('#noticeNumberInput').val(noticeNumber);  
  $modal.css('display', 'block');
};

  // 삭제 모달 닫기
  window.closeDeleteModal = function() {
    $modal.css('display', 'none');
  };

  // 삭제 확인
  window.confirmDelete = function() {
    console.log("삭제할 공지사항 번호:", $('#noticeNumberInput').val());  // 로그 추가
    $('#deleteForm').submit();
  };

  // 모달 외부 클릭 시 닫기
  $(window).on('click', function(event) {
    if ($(event.target).is($modal)) {
      closeDeleteModal();
    }
  });
});
>>>>>>> main
