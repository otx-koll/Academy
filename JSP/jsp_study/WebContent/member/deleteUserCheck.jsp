<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
//세션값 가져오기
String id = (String) session.getAttribute("id");
//세션값 없으면 loginForm.jsp 이동
if (id == null) {
	response.sendRedirect("loginForm.jsp");
	return;
}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

</head>
<body>
	<h1>회원정보 삭제 전 사용자 패스워드 확인</h1>
	<hr>
	<form action="delete.jsp" method="post" id="frm">
		아이디: <input type="text" value="<%=id %>" readonly><br>
		패스워드: <input type="password" name="passwd"><br>
		<input type="submit" value="패스워드 확인">
	</form>
	<script src="../js/jquery-3.5.1.js"></script>
	<script>
		$('form#frm').submit(function () { // 함수를 바로 던질때는 이름을 넣으면 안된다
			let isDelete = confirm('정말 탈퇴하시겠습니까?'); // true / false 리턴
			if (!isDelete) { // isDelete == false
// 				event.preventDefault(); // 기본 기능 막기
// 				return;

				return false;
			} 
		});
	
	</script>
</body>
</html>