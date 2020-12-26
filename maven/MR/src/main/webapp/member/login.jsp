<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>로그인</title>
<link href="/css/bootstrap.min.css" rel="stylesheet">
<script src="/script/jquery-3.5.1.js"></script>

<style>

/* BASIC */
body {
	height: 100vh;
	background-color: #2E2E2E;
}

a {
	color: #92badd;
	display: inline-block;
	text-decoration: none;
	font-weight: 400;
}
a:hover{
	text-decoration: none;
}

/* STRUCTURE */
.wrapper {
	display: flex;
	align-items: center;
	flex-direction: column;
	justify-content: center;
	width: 100%;
	min-height: 100%;
	padding: 20px;
	background-color: #2E2E2E;
}

#formContent {
	border-radius: 10px 10px 10px 10px;
	background: #fff;
	padding: 30px;
	width: 90%;
	max-width: 450px;
	height: 500px;
	position: relative;
	padding: 0px;
	box-shadow: 0 30px 60px 0 rgba(0, 0, 0, 0.3);
	text-align: center;
}

input[type=submit] {
	background-color: #56baed;
	border: none;
	color: white;
	padding: 15px 80px;
	text-align: center;
	text-decoration: none;
	display: inline-block;
	font-size: 13px;
	border-radius: 5px 5px 5px 5px;
	margin: 10px 20px 10px 20px;
}

input[type=text], input[type=password]{
	background-color: #f6f6f6;
	border: none;
	color: #0d0d0d;
	padding: 15px 32px;
	text-align: left;
	text-decoration: none;
	display: inline-block;
	font-size: 16px;
	margin: 5px;
	width: 85%;
	border: 2px solid #f6f6f6;
	border-radius: 5px 5px 5px 5px;
}
input[type=submit]:hover {
  background-color: #39ace7;
}
.stick{
	color: lightgray;
	margin: 0 5px;
}
*:focus {
	outline: none;
}

#icon {
	margin: 15px 0 15px;
	width: 50%;
}
label{
	margin: 10px 0 20px;
}
</style>
</head>
<body>
	<div class="wrapper">
		<div id="formContent">
			<!-- Icon -->
			<div>
				<a href="/index.jsp">
					<img src="/img/movie_icon.png" id="icon"/>
				</a>
			</div>

			<!-- Login Form -->
			<form action="loginPro.jsp" method="post">
				<input type="text" name="id" placeholder="아이디" autofocus requried><br>
				<input type="password" name="passwd" placeholder="비밀번호" requried><br>
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

