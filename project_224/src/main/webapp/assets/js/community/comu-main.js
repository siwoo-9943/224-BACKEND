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



document.addEventListener('DOMContentLoaded', function() {
    const filterButtons = document.querySelectorAll('.category-filter');
    const posts = document.querySelectorAll('.baseList-item');

    function removeSpaces(str) {
        return str.replace(/\s/g, '');
    }

    filterButtons.forEach(button => {
        button.addEventListener('click', function(e) {
            e.preventDefault();
            const category = removeSpaces(this.getAttribute('data-category'));

            filterButtons.forEach(btn => btn.classList.remove('active'));
            this.classList.add('active');

            posts.forEach(post => {
                const postCategoryElement = post.querySelector('.baseList-sector');
                if (!postCategoryElement) return; // 카테고리 요소가 없으면 건너뛰기

                const postCategory = removeSpaces(postCategoryElement.textContent.trim());
                
                if (category === '전체' || postCategory === category) {
                    post.style.display = '';
                } else {
                    post.style.display = 'none';
                }
            });
        });
    });

    // 페이지 로드 시 '전체' 카테고리 선택
    const allCategoryButton = document.querySelector('.category-filter[data-category="전체"]');
    if (allCategoryButton) {
        allCategoryButton.click();
    }
});