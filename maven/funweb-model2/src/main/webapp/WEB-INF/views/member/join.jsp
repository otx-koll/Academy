<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<<<<<<< HEAD
<!-- head 영역 -->
<jsp:include page="/WEB-INF/views/include/headContent.jsp"/>
=======
<%-- head 컨텐트 영역 --%>
<jsp:include page="/WEB-INF/views/include/headContent.jsp" />
>>>>>>> d44115f475ec485145b63ce82940bda6a14e3931

<link href="/css/subpage.css" rel="stylesheet" type="text/css"  media="all">
</head>

<body>
<div id="wrap">
<<<<<<< HEAD
    <!-- header 영역 -->
	<jsp:include page="/WEB-INF/views/include/topHeader.jsp"/>
=======
	<%-- header 영역 --%>
	<jsp:include page="/WEB-INF/views/include/topHeader.jsp" />
>>>>>>> d44115f475ec485145b63ce82940bda6a14e3931
	
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
<<<<<<< HEAD
	<form id="join" action="joinPro.jsp" method="post" name="frm">
=======
	<form id="join" action="memberJoinPro.do" method="post" name="frm">
>>>>>>> d44115f475ec485145b63ce82940bda6a14e3931
	<fieldset>
		<legend>Basic Info</legend>
		
		<label>User ID</label>
<<<<<<< HEAD
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
=======
		<input type="text" name="id" class="id" required> 
		<input type="button" value="ID 중복확인" class="dup" id="btnDupChk"><br>
		
		<label>Password</label> 
		<input type="password" name="passwd" class="pass pass1" required><br>
		
		<label>Retype Password</label> 
		<input type="password" class="pass pass2" required>
		<span id="msgPass"></span>
		<br>
		
		<label>Name</label> 
		<input type="text" name="name" class="nick" required><br>
		
		<label>E-Mail</label> 
		<input type="email" name="email" class="email" required><br>
		
		<label>Retype E-mail</label> 
>>>>>>> d44115f475ec485145b63ce82940bda6a14e3931
		<input type="email" class="email" required><br>
	</fieldset>
	
	<fieldset>
		<legend>Optional</legend>
		
<<<<<<< HEAD
		<label>Address</label>
		<input name="address" type="text" class="address"><br>
		
		<label>Phone Number</label>
		<input name="tel" type="tel" class="mobile"><br>

		<label>Age</label>
		<input name="age" type="tel" min="0" max="200" class="phone"><br>
		
		<label>Gender</label>
		<input name="gender" type="radio" value="남">남
		<input name="gender" type="radio" value="여">여<br>
=======
		<label>Address</label> 
		<input type="text" name="address" class="address"><br>
		
		<label>Phone Number</label> 
		<input type="tel" name="tel" class="phone"><br>
		
		<label>Age</label> 
		<input type="number" name="age" min="0" max="200" class="mobile"><br>
		
		<label>Gender</label> 
		<input type="radio" name="gender" value="남"> 남성
		<input type="radio" name="gender" value="여"> 여성
		<br>
>>>>>>> d44115f475ec485145b63ce82940bda6a14e3931
	</fieldset>

	<div class="clear"></div>
	<div id="buttons">
<<<<<<< HEAD
		<input name="" type="submit" value="회원가입" class="submit">
		<input name="" type="reset" value="초기화" class="cancel">
=======
		<input type="submit" value="회원가입" class="submit"> 
		<input type="reset" value="초기화" class="cancel">
>>>>>>> d44115f475ec485145b63ce82940bda6a14e3931
	</div>
	</form> 
	
	</article>
	
	<div class="clear"></div>
<<<<<<< HEAD
	<!-- footer 영역 -->
	<jsp:include page="/WEB-INF/views/include/bottomFooter.jsp"/>
</div>
<script src="/script/jquery-3.5.1.js"></script>
<script>
	$('#btnDupChk').click(function () {
=======
	<%-- footer 영역 --%>
	<jsp:include page="/WEB-INF/views/include/bottomFooter.jsp" />
</div>

<script src="/script/jquery-3.5.1.js"></script>
<script>
	$('#btnDupChk').click(function () {
		
>>>>>>> d44115f475ec485145b63ce82940bda6a14e3931
		let id = $('input[name="id"]').val();
		
		// id가 공백이면 '아이디 입력하세요' 포커스주기
		if (id == '') { // id.length == 0
			alert('아이디를 입력하세요');
			$('input[name="id"]').focus();
			return;
		}
<<<<<<< HEAD
		
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
=======

		// id중복체크 창열기  joinIdDupCheck.jsp
		window.open('joinIdDupCheck.do?id=' + id, 'idDupCheck', 'width=500,height=400');
	});

	// .pass2 요소에 포커스가 해제되면
	$('.pass2').focusout(function () {
		let pass1 = $('.pass1').val();
		let pass2 = $(this).val();

		if (pass1 == pass2) {
			$('#msgPass').html('패스워드 일치함').css('color', 'green');
		} else {
			$('#msgPass').html('패스워드 불일치').css('color', 'red');
>>>>>>> d44115f475ec485145b63ce82940bda6a14e3931
		}
	});

</script>
</body>
</html>   

<<<<<<< HEAD
=======
    
>>>>>>> d44115f475ec485145b63ce82940bda6a14e3931
