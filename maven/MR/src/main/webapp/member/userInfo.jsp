<%@page import="com.project.vo.UserVo"%>
<%@page import="com.project.dao.UserDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
// 세션값 가져오기
String id = (String) session.getAttribute("id");

// 세션 값 없으면 login.jsp로 이동
if (id == null) {
	response.sendRedirect("login.jsp");
	return;
}

UserDao userDao = UserDao.getInstance();

UserVo userVo = userDao.getUserById(id);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원정보수정</title>
<style>
.wrap{
	margin: auto;
}
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
			<h3>회원정보수정</h3>
			<hr>
			<form action="userInfoPro.jsp">
				<label>아이디</label> <input type="text" name="id" value="<%=userVo.getId() %>" class="check" readonly><br>
				<label>이름</label> <input type="text" name="name" value="<%=userVo.getName() %>" class="check"><br>
				<label>생년월일</label> <input name="birthday" type="date" value="<%=userVo.getBirthday() %>" class="check" readonly><br>
				<label>이메일</label> <input type="email" name="email" value="<%=(userVo.getEmail() == null) ? "" : userVo.getEmail() %>" class="check"><br>
				<label>전화번호</label> <input name="tel" type="tel" value="<%=userVo.getTel() %>" class="check"><br><br>
				<input type="submit" value="회원수정" class="btn btn-secondary mb-3" onclick="modify()">
			</form>
			<br>
			<form action="deleteUserPro.jsp" method="post" id="frm">
				<input type="hidden" name="id" value="<%=userVo.getId() %>">
				<input type="submit" value="탈퇴하기" class="btn btn-secondary mb-3">
			</form>
		</div>
	</div>
</body>
<script>
function modify() {
	var result = confirm('수정하시겠습니까?');
	
	if (result == false) {
		return;
	} else {
		alert("수정완료!");
	}
	
	location.href = 'index.jsp';
} // modify

$('form#frm').submit(function () { 
	let isDelete = confirm('정말 탈퇴하시겠습니까?');
	if (!isDelete) { 
		return false;
	} 
});

</script>
</html>