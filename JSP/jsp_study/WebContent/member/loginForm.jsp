<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>스터디 - 로그인</title>
</head>
<body>
	<h1>로그인</h1>
	<hr>
	<form action="loginProcess.jsp" method="post"> <!-- post : 서버의 상태나 값을 바꾸기 위해 / get : select적인 성향 서버의 값을 가져옴 -->
		아이디: <input type="text" name="id" requried><br> <!-- required 반드시 입력. submit 있을떄만 동작 -->
		패스워드: <input type="password" name="passwd" requried><br>
		<input type="submit" value="로그인">
		<input type="button" value="회원가입" onclick="location.href='joinForm.jsp'">
	</form>
</body>
</html>






