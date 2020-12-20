<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>로그인</title>
<style>
	
</style>
</head>
<body>
	<h1>
		<a href="/index.jsp">Home</a>
	</h1>
	
	<form action="loginPro.jsp" method="post" id="login">
		<input type="text" name="id" placeholder="아이디"><br>
		<input type="password" name="passwd" placeholder="비밀번호"><br>
		<input type="submit" value="로그인" class="submit"><br>
		<input type="checkbox" name="keepLogin" value="true">로그인 상태 유지<br>
		<hr>
		<div>
			<a href="/member/idSearch.jsp">아이디 찾기</a> | <a href="/member/passwdSearch.jsp">비밀번호 찾기</a> | <a href="/member/join.jsp">회원가입</a>
		</div>
		<jsp:include page="/include/bottomFooter.jsp"/>
	</form>
	
<script src="/script/jquery-3.5.1.js"></script>
<script>
		
</script>
</body>
</html>

