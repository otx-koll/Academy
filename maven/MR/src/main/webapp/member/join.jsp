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
			<input name="id" type="text" id="id" required><br>
			<span class="wrongMsg"></span>
			<span id="msgIdDup"></span>
		</div>
	
		<div>
			<label>비밀번호</label><br>
			<input name="passwd" type="password" class="pass1" id="passwd" required><br>
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
			<input name="name" type="text" id="name" required><br>
			<span class="wrongMsg"></span>
		</div>
		
		<div>
			<label>생년월일</label><br>
			<input name="birthday" type="date" id="birth" required><br>
			<span class="wrongMsg"></span>
		</div>
		
		<div>
			<label>성별</label><br>
			<select id="gender" name="gender" required>
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
			<input name="tel" type="tel" id="tel" required><br>
			<span class="wrongMsg"></span>
		</div>
	
		<div id="buttons">
			<input type="submit" value="회원가입" class="submit">
		</div>
	</form> 
	
	<jsp:include page="/include/bottomFooter.jsp"/>
	
<script src="/script/jquery-3.5.1.js"></script>

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

			$('.submit').click(function () {
				alert('비밀번호가 일치하지 않습니다');
				$('.pass1').focus();
				return false;
			});
		} else {
			$('#msgPass').html("");
		}
	});

	// 중복 값 미처리시
	$('.submit').click(function () {
		let id = $('#id').val();
		let pass1 = $('.pass1').val();
		let pass2 = $('.pass2').val();

		if (pass1 != pass2 || id) {

		}
	});
	
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

