<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
// 세션값 가져오기
// 1) 로그인 안한 경우 null 리턴
// 2) 로그인 했는데 관리자 "admin" 아닌 경우
// 	  -> main.jsp 로 이동
String id = (String) session.getAttribute("id");

// !(id == null || !id.equals("admin"))
// id != null && id.equals("admin")

if (id == null || !id.equals("admin")) { // 반대
	// null체크 먼저 한 후에 equals (왼 -> 오 방향으로 코드가 진행되기 때문에)
	response.sendRedirect("main.jsp"); // script의 location.href와 동일. "main.jsp를 요청하라"
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
	<h1>전체</h1>
</body>
</html>