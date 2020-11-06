<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<!-- head 영역 -->
<jsp:include page="/include/headContent.jsp"/>

<link href="/css/subpage.css" rel="stylesheet" type="text/css"  media="all">
</head>

<body>
<div id="wrap">
    <!-- header 영역 -->
	<jsp:include page="/include/topHeader.jsp"/>
	
	<div class="clear"></div>
	<div id="sub_img_member"></div>

	<div class="clear"></div>
	<nav id="sub_menu">
        <ul>
            <li> <a href="#">Join us</a></li>
            <li> <a href="#">Privacy policy</a></li>
    	</ul>
    </nav>
	
	<article>
		
	<h1>회원 가입</h1>
	<form id="join" action="joinPro.jsp" method="post" name="frm">
	<fieldset>
		<legend>Basic Info</legend>
		
		<label>User ID</label>
		<input name="id" type="text" class="id" required>
		<input type="button" value="ID 중복확인" class="dup" id="btnDupChk"><br>
		
		<label>Password</label>
		<input name="passwd" type="password" class="pass pass1" required><br>
		<label>Retype Password</label>
		<input type="password" class="pass pass2" required>
		<span id="msgPass"></span><br>
		
		<label>Name</label>
		<input name="name" type="text" class="nick"><br>
		
		<label>E-Mail</label>
		<input name="email" type="email" class="email" required><br>
		
		<label>Retype E-mail</label>
		<input type="email" class="email" required><br>
	</fieldset>
	
	<fieldset>
		<legend>Optional</legend>
		
		<label>Address</label>
		<input name="address" type="text" class="address"><br>
		
		<label>Phone Number</label>
		<input name="tel" type="tel" class="mobile"><br>

		<label>Age</label>
		<input name="age" type="tel" min="0" max="200" class="phone"><br>
		
		<label>Gender</label>
		<input name="gender" type="radio" value="남">남
		<input name="gender" type="radio" value="여">여<br>
	</fieldset>

	<div class="clear"></div>
	<div id="buttons">
		<input name="" type="submit" value="회원가입" class="submit">
		<input name="" type="reset" value="초기화" class="cancel">
	</div>
	</form> 
	
	</article>
	
	<div class="clear"></div>
	<!-- footer 영역 -->
	<jsp:include page="/include/bottomFooter.jsp"/>
</div>
<script src="/script/jquery-3.5.1.js"></script>
<script>
	$('#btnDupChk').click(function () {
		let id = $('input[name="id"]').val();
		
		// id가 공백이면 '아이디 입력하세요' 포커스주기
		if (id == '') { // id.length == 0
			alert('아이디를 입력하세요');
			$('input[name="id"]').focus();
			return;
		}
		
		// id 중복체크 창 열기 joinIdDupCheck.jsp
		window.open('joinIdDupCheck.jsp?id=' + id, 'idDupCheck', 'width=500,height=400'); // open(요청할 페이지 주소 및 값, 이름 지정(이름지정안하면 계속 생성됨), 크기지정)   
	});

	// 포커스가 해제되면
	$('.pass2').focusout(function () {
		let pass1 = $('.pass1').val();
		let pass2 = $(this).val();
		
		if (pass1 == pass2) {
			$('#msgPass').html("비밀번호 일치").css('color', 'green');
		} else {
			$('#msgPass').html("비밀번호 불일치").css('color', 'red');
		}
	});

</script>
</body>
</html>   

