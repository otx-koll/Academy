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
<title>Info</title>
<style>
.mody {
	margin: 10px;
}
</style>
</head>

<body>
<div class="container">
	<jsp:include page="/include/topHeader.jsp" />
	
	<div class="wrap">
		<div>
			<ul>
				<li class="mody"><a href="/member/UserCheck.jsp">내정보 수정</a></li>
				<li class="mody"><a href="#">내가 쓴 리뷰</a></li>
			</ul>
		</div>
	</div>
	
</div>
</body>
</html>