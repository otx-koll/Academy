<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
// String id = request.
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="/include/topHeaderMinusNav.jsp" />

	<a href="/member/passwdSearch.jsp">비밀번호 찾기</a><br>
	<form action="idSearchPro.jsp" method="post" id="idSearch">
		<fieldset>
			<legend>아이디 찾기</legend>
			
			<label>이름</label>
			<input type="text" name="name"><br>
			
			<label>전화번호</label>
			<input type="text" name="tel"><br>
			
			<input type="submit" value="확인">
		</fieldset>
	</form>
</body>
</html>