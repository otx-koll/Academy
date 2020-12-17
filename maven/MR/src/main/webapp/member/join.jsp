<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>회원가입</title>
<style type="text/css">
label {
	
}
</style>
</head>

<body>
		
	<h1><a href="/index.jsp">Home</a></h1>
	<form id="join" action="joinPro.jsp" method="post" name="frm">
		<div>
			<label>아이디</label><br>
			<input name="id" type="text" class="id" required><br>
		</div>
		
	<!-- 		<span id="msgPass" style="background-color:yellow;">테</span><br> -->
	<!-- 		<input type="button" value="ID 중복확인" class="dup" id="btnDupChk"><br> -->
	
		<div>
			<label>비밀번호</label><br>
			<input name="passwd" type="password" required><br>
		</div>
		
		<div>
			<label>비밀번호 재확인</label><br>
			<input type="password" required>
		</div>
		
		<div>
			<label>이름</label><br>
			<input name="name" type="text" class="nick" required>
		</div>
		
		<div>
			<label>생년월일</label><br>
			<input name="birthday" type="date">
		</div>
		
		<div>
			<label>성별</label><br>
			<label>Gender</label>
			<select id="gender" name="gender" required>
				<option value="">성별</option>
				<option value="female">여자</option>
				<option value="male">남자</option> 
			</select>
		</div>
		
		<div>
			<label>본인 확인 이메일</label><span>(선택)</span><br>
			<input name="email" type="email" class="email"><br>
		</div>
		
		<div>
			<label>휴대전화</label><br>
			<input name="tel" type="tel" class="mobile" required><br>
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

