<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>회원가입</title>
<link href="/css/bootstrap.min.css" rel="stylesheet">
<script src="/script/jquery-3.5.1.js"></script>
<style>
body {
	height: 100vh;
	background-color: #2E2E2E;
}
.wrapper {
	display: flex;
	align-items: center;
	flex-direction: column;
	justify-content: center;
	width: 100%;
	min-height: 100%;
	padding: 20px;
	background-color: #2E2E2E;
}
#formContent {
	border-radius: 10px 10px 10px 10px;
	background: #fff;
	padding: 30px;
	width: 90%;
	max-width: 450px;
	height: 700px;
	position: relative;
	padding: 0px;
	box-shadow: 0 30px 60px 0 rgba(0, 0, 0, 0.3);
	text-align: center;
}
input{
	background-color: #f6f6f6;
	border: none;
	color: #0d0d0d;
	padding: 10px 15px;
	text-align: left;
	text-decoration: none;
	display: inline-block;
	font-size: 16px;
	margin: 5px;
	width: 70%;
	border: 2px solid #f6f6f6;
	border-radius: 5px 5px 5px 5px;
}
input[type=submit] {
	background-color: #56baed;
	border: none;
	color: white;
	padding: 15px 80px;
	text-align: center;
	text-decoration: none;
	display: inline-block;
	font-size: 13px;
	border-radius: 5px 5px 5px 5px;
	margin: 40px 0px;
}
input[type=submit]:hover {
  background-color: #39ace7;
}
#icon {
	margin: 15px 0 15px;
	width: 20%;
}
label{
	margin: 10px 0 20px;
	width: 80px;
}
</style>
</head>

<body>
	<div class="wrapper">
		<div id="formContent">
			<a href="/index.jsp">
				<img src="/img/movie_icon.png" id="icon"/>
			</a>
		
			<form action="joinPro.jsp" method="post" name="frm">
				<div class="info">
					<label>아이디</label>
					<input name="id" type="text" id="id" required><br>
					<span class="wrongMsg"></span>
					<span id="msgIdDup"></span>
				</div>
		
				<label>비밀번호</label>
				<input name="passwd" type="password" class="pass1" id="passwd" required><br>
				<span class="wrongMsg"></span>
			
				<label>비밀번호 재확인</label>
				<input type="password" class="pass2" id="passwd2" required ><br>
				<span id="msgPass"></span>
				<span class="wrongMsg"></span>
			
				<label>이름</label>
				<input name="name" type="text" id="name" required><br>
				<span class="wrongMsg"></span>
			
				<label>생년월일</label>
				<input name="birthday" type="date" id="birth" required style="height: 45px;"><br>
				<span class="wrongMsg"></span>
			
				<label>이메일(선택)</label>
				<input name="email" type="email" class="email"><br>
			
				<label>전화번호</label>
				<input name="tel" type="tel" id="tel" required><br>
				<span class="wrongMsg"></span>
	
				<input type="submit" value="회원가입" class="submit">
			</form> 
		</div>
	</div>
	


<script>
	// 아이디 중복 체크
	$('input[name="id"]').focusout(function () {
		let id = $(this).val();
	
		if (id.length <= 2) { // 아이디 두글자 까지는 중복체크 안함
			return;
		}
	
		// 아이디 세글자 부터는 Ajax로 아이디 중복체크하기
		$.ajax({
			url: '/ajax/joinIdDupChk.jsp',
			data: { id: id },
			success: function (response) {
				console.log(typeof response);
				console.log(response);
	
				if (response.isIdDup) {
					$('span#msgIdDup').html('이미 사용중인 아이디 입니다.').css('color', 'red');
				} else {
					$('span#msgIdDup').html('사용 가능한 아이디 입니다.').css('color', 'green');
				}
			}
		});
	});

	// 비밀번호 확인
	$('.pass2').focusout(function () {
		let pass1 = $('.pass1').val();
		let pass2 = $(this).val();
		
		if (pass1 != pass2) {
			$('#msgPass').html("비밀번호 불일치").css('color', 'red');
		} else {
			$('#msgPass').html("");
		}
	});

	// 값 오류일 때
	$('.submit').click(function () {
		let id = $('#id').val();
		let pass1 = $('.pass1').val();
		let pass2 = $('.pass2').val();

		if (pass1 != pass2) {
			alert("잘못된 값이 있습니다");
			return false;
		}
	});
	
</script>
</body>
</html>   

