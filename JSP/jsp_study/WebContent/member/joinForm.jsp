<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>스터디 - 회원가입</title>
<style>
span.positive {
	color: green;
	background-color: aqua;
	font-style: italic;
}
span.negative {
	color: red;
	background-color: yellow;
	font-weight: bold;
}
</style>
</head>
<body>
	<h1>회원가입</h1>
	<hr>
	<form action="joinProcess.jsp" method="post">
		아이디: <input type="text" name="id">
				<span id="msgIdDup"></span>
		<br>
		패스워드: <input type="password" name="passwd"><br>
		이름: <input type="text" name="name"><br>
		나이: <input type="number" name="age" min="0" max="200"><br>
		성별: <input type="radio" name="gender" value="남"> 남성
		      <input type="radio" name="gender" value="여"> 여성<br>
		이메일: <input type="email" name="email"><br>
		<input type="submit" value="회원가입">
	</form>
	<script src="../js/jquery-3.5.1.js"></script>
	<script>
		function process(item) {
// 			let spanMsg = document.getElementById('msgIdDup');
			let $spanMsg = $('#msgIdDup'); // jquery문서 객체인걸 구분하기 위해 변수명에 '$' 붙힘
			
			if (item.count == 0) { // 아이디 사용가능
// 				$spanMsg.html('사용가능한 아이디 입니다.').css('color', 'green') // 태그를 살려서 밀어넣는 것 html

				$spanMsg.html('사용가능한 아이디 입니다.').addClass('positive').removeClass('negative'); // addClass('positive') : 긍정 
			} else { // item.count == 1 // 아이디 중복됨
// 				$spanMsg.html('이미 사용중인 아이디 입니다.').css('color', 'red');
				$spanMsg.html('이미 사용중인 아이디 입니다.').addClass('negative').removeClass('positive'); // addClass('negative') : 부정
			}
		} // process()
		
		// 키 이벤트 연결
		// input태그의 name이 id인 태그 
		// 키보드 버튼이 눌렀다 떼졌을 때
		$('input[name="id"]').keyup(function () {

			//let id = $(this).val().trim();
			//let str = 'id=' + id;
			
			let str = $(this).serialize();
			console.log('쿼리스트링: ' + str);
	
			$.ajax({
				url: 'ajaxIdDupCheck.jsp',
				data: str,
				success: function (data) {
					process(data);
				}
			});
	
		});
	</script>
</body>
</html>






