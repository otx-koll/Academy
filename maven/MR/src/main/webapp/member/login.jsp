<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>로그인</title>
<link href="/css/bootstrap.min.css" rel="stylesheet">
<link href="/css/member.css" rel="stylesheet">
<script src="/script/jquery-3.5.1.js"></script>
</head>

<body>
	<div class="wrapper">
		<div id="formContent" class="login">
			<!-- Icon -->
			<div>
				<a href="/index.jsp">
					<img src="/img/movie_icon.png" id="loginIcon"/>
				</a>
			</div>

			<!-- Login Form -->
			<form action="loginPro.jsp" method="post">
				<input type="text" name="id" placeholder="아이디" class="loginInp" autofocus requried><br>
				<input type="password" name="passwd" placeholder="비밀번호" class="loginInp" requried><br>
				<input type="submit" value="로그인"><br>
				
				<label>
					<input type="checkbox" name="keepLogin" value="true"> 로그인 상태 유지
				</label>
			</form>

			<div>
				<a href="/member/idSearch.jsp">아이디 찾기</a><span class="stick">|</span>
				<a href="/member/passwdSearch.jsp">비밀번호 찾기</a><span class="stick">|</span> 
				<a href="/member/join.jsp">회원가입</a>
			</div>

		</div>
	</div>
</body>
</html>

