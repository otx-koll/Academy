<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="/include/topHeaderMinusNav.jsp" />
	
	<a href="/member/idSearch.jsp">아이디 찾기</a><br>
	<form action="passwdSearchPro.jsp" method="post" id="passwdSearch">
		<fieldset>
			<legend>비밀번호 찾기</legend>
			
			<label>아이디</label>
			<input type="text" name="id"><br>
			
			<label>전화번호</label>
			<input type="text" name="tel"><br>
			
			<input type="submit" value="확인">
		</fieldset>
	</form>
</body>
</html>