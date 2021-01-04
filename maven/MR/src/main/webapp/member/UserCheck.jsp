<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
//세션값 가져오기
String id = (String) session.getAttribute("id");

//세션값 없으면 loginForm.jsp 이동
if (id == null) {
	response.sendRedirect("login.jsp");
	return;
}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style>
label{
	width: 100px;
}
.check {
	background-color: #f6f6f6;
	border: none;
	color: #0d0d0d;
	padding: 10px 15px;
	text-align: left;
	text-decoration: none;
	display: inline-block;
	font-size: 16px;
	margin: 5px;
	width: 30%;
	border: 2px solid #f6f6f6;
	border-radius: 5px 5px 5px 5px;
}
</style>
</head>
<body>
	<div class="container">
		<jsp:include page="/include/topHeader.jsp" />
			
		<div class="wrap text-center">
			<h3>패스워드 확인</h3>
			<hr>
			<form action="UserCheckPro.jsp" method="post">
				<label>아이디</label> <input type="text" value="<%=id %>" class="check" readonly><br><br>
				<label>패스워드</label> <input type="password" name="passwd" class="check"><br><br>
				<input type="submit" value="패스워드 확인" class="btn btn-secondary mb-3">
			</form>
		</div>
	</div>	
</body>
</html>