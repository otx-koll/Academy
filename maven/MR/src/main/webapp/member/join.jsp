<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>회원가입</title>
</head>

<body>
		
	<h1><a href="/index.jsp">Home</a></h1>
	<form id="join" action="joinPro.jsp" method="post" name="frm">
		<div>
			<label>아이디</label><br>
			<input name="id" type="text" class="values" id="id" required>
			<input type="submit" value="ID 중복확인" id="btnDupChk" onclick=""><br>
			<span class="wrongMsg"></span>
			<span class="wrongId"></span>
		</div>
	
		<div>
			<label>비밀번호</label><br>
			<input name="passwd" type="password" class="pass1 values" id="passwd" required><br>
			<span class="wrongMsg"></span>
		</div>
		
		<div>
			<label>비밀번호 재확인</label><br>
			<input type="password" class="pass2" id="passwd2" required><br>
			<span id="msgPass"></span>
			<span class="wrongMsg"></span>
		</div>
		
		<div>
			<label>이름</label><br>
			<input name="name" type="text" class="values" id="name" required><br>
			<span class="wrongMsg"></span>
		</div>
		
		<div>
			<label>생년월일</label><br>
			<input name="birthday" type="date" id="birth" class="values"><br>
			<span class="wrongMsg"></span>
		</div>
		
		<div>
			<label>성별</label><br>
			<select id="gender" name="gender" class="values" required>
				<option value="">성별</option>
				<option value="female">여자</option>
				<option value="male">남자</option> 
			</select><br>
			<span class="wrongMsg"></span>
		</div>
		
		<div>
			<label>본인 확인 이메일</label><span>(선택)</span><br>
			<input name="email" type="email" class="email"><br>
		</div>
		
		<div>
			<label>휴대전화</label><br>
			<input name="tel" type="tel" id="tel" class="values" required><br>
			<span class="wrongMsg"></span>
		</div>
	
		<div id="buttons">
			<input name="" type="submit" value="회원가입" class="submit">
		</div>
	</form> 
	
	<jsp:include page="/include/bottomFooter.jsp"/>
	
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
		window.open('joinIdDupCheck.jsp?id=' + id, 'idDupCheck', 'width=500,height=400');
	});

	$('.pass2').focusout(function () {
		let pass1 = $('.pass1').val();
		let pass2 = $(this).val();
		
		if (pass1 != pass2) {
			$('#msgPass').html("비밀번호 불일치").css('color', 'red');
		} else {
			$('#msgPass').html("");
		}
	});

// 	$('submit').click(function () {
// 		if()
// 	});

/////////////////////
// 	$('#id, #passwd, #passwd2, #name, #birth, #gender, tel').focusout(function () {
// 		let vals = $(this).val();
// 		let vals2 = $(this).children(input);
		
// 		if (vals == '') {
// 			$(vals).html("필수 정보 입니다").css('color', 'red');
// 		} else {
// 			$(vals).html("");
// 		}
// 	});

</script>
</body>
</html>   

