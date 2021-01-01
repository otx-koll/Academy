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
</head>
<body>
	<div class="container">
		<jsp:include page="/include/topHeader.jsp" />
		
		<div class="wrap">
			<h3>회원정보수정</h3>
			<hr>
			<form action="userInfoPro.jsp">
				아이디: <input type="text" name="id" value="<%=userVo.getId() %>" readonly><br>
				이름: <input type="text" name="name" value="<%=userVo.getName() %>"><br>
				생년월일 : <input name="birthday" type="date" value="<%=userVo.getBirthday() %>" readonly><br>
				이메일: <input type="email" name="email" value="<%=(userVo.getEmail() == null) ? "" : userVo.getEmail() %>"><br>
				전화번호 : <input name="tel" type="tel" value="<%=userVo.getTel() %>"><br>
				<input type="submit" value="회원수정" onclick="modify()">
			</form>
			
			<form action="deleteUserPro.jsp" method="post" id="frm">
				<input type="hidden" name="id" value="<%=userVo.getId() %>">
				<input type="submit" value="탈퇴하기">
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