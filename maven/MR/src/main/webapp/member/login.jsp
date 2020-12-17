<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>로그인</title>
</head>
<body>
	<h1>
		<a href="/index.jsp">Home</a>
	</h1>
	<form action="loginPro.jsp" method="post" id="join">
		<input type="text" name="id" placeholder="아이디"><br>
		<input type="password" name="passwd" placeholder="비밀번호"><br>
		<input type="submit" value="로그인" class="submit"><br>
		<input type="checkbox" name="keepLogin" value="true">로그인상태유지<br>
		<hr>
		<div>
			<a href="">아이디 찾기</a> | <a href="#">비밀번호 찾기</a> | <a href="/member/join.jsp">회원가입</a>
		</div>
		<jsp:include page="/include/bottomFooter.jsp"/>
	</form>
</body>
</html>

