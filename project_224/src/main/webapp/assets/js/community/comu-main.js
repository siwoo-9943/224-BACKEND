const navItems = document.querySelectorAll('#navlist li a');

navItems.forEach(item => {
	item.addEventListener('click', function(event) {
		event.preventDefault();

		// 모든 항목에서 'current' 클래스 제거
		navItems.forEach(link => link.removeAttribute('id'));

		// 클릭한 항목에 'current' 클래스 추가
		this.setAttribute('id', 'current');
	});
});