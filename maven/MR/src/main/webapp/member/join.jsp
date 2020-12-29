<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>회원가입</title>
<link href="/css/bootstrap.min.css" rel="stylesheet">
<link href="/css/member.css" rel="stylesheet">
<script src="/script/jquery-3.5.1.js"></script>

<style>
#joinIcon {
	margin: 20px 0;
	width: 30%;
}
label{
	margin: 10px 0 10px;
	width: 80px;
}
</style>
</head>

<body>
	<div class="wrapper">
		<div id="formContent" class="join">
			<a href="/index.jsp">
				<img src="/img/movie_icon.png" id="joinIcon"/>
			</a>
		
			<form action="joinPro.jsp" method="post" name="frm">
				<div class="info">
					<label>아이디</label>
					<input name="id" type="text" id="id" class="joinInp" required><br>
					<span class="wrongMsg"></span>
					<span id="msgIdDup"></span>
				</div>
		
				<label>비밀번호</label>
				<input name="passwd" type="password" class="pass1 joinInp" id="passwd" required><br>
			
				<label>비밀번호 재확인</label>
				<input type="password" class="pass2 joinInp" id="passwd2" required ><br>
				<span id="msgPass"></span>
			
				<div>
					<label>이름</label>
					<input name="name" type="text" id="name" class="joinInp" required><br>
				</div>
			
				<label>생년월일</label>
				<input name="birthday" type="date" id="birth" class="joinInp" required style="height: 45px;"><br>
			
				<label>이 메 일 (선택)</label>
				<input name="email" type="email" class="email joinInp"><br>
			
				<label>전화번호</label>
				<input name="tel" type="tel" id="tel" class="joinInp" required><br>
	
				<input type="submit" value="회원가입" class="submit joinInp">
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

