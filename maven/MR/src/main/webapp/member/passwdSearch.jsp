<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>비밀번호 찾기</title>
<link href="/css/bootstrap.min.css" rel="stylesheet">
<link href="/css/member.css" rel="stylesheet">
<script src="/script/jquery-3.5.1.js"></script>
<style>
label {
	margin: 10px 0 10px;
	width: 80px;
}
</style>
</head>

<body>
	<div class="wrapper">
		<div id="formContent" class="login">
		
			<div>
				<a href="/index.jsp">
					<img src="/img/movie_icon.png" id="loginIcon"/>
				</a>
			</div>
			
			<form action="passwdSearchPro.jsp" method="post" id="passwdSearch">
				<fieldset>
					<legend>비밀번호 찾기</legend><br>
					
					<label>아이디</label>
					<input type="text" class="joinInp" name="id" autofocus><br>
					
					<label>전화번호</label>
					<input type="text" class="joinInp" name="tel"><br>
					
					<input type="submit" value="확인">
				</fieldset>
			</form>
			
			<div>
				<a href="/member/idSearch.jsp">아이디 찾기</a><br>
			</div>
		</div>
	</div>
</body>
</html>