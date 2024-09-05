$(document).ready(function() {
   $('#checkIdBtn').on('click', function() {
      console.log("클릭");
      let memberId = $('#memberId').val();
      
      if(memberNumber === ''){
         alert('아이디를 입력하세요');
         return;
      }
      
      $.ajax({
         url : "/member/checkIdOk.me",
         type : "get",
         data: {"memberId" : memberId},
         success : function(result){
            $('#checkIdResult').text(result);
         },
         error : function(){
            $('#checkIdResult').text('오류가 발생했습니다. 다시 시도해주세요');
         }
      });
   });
});