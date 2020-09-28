<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// request 기본 객체
	// 사용자 입력 파라미터 값 가져오기. 인자로 name 속성 값 전달.
	
	// request 파라미터 정보는 모두 String형
	// request 파라미터 정보가 없으면 null을 리턴함
	String strNum = request.getParameter("num"); // 문자열 "27"
	
	// String -> 정수형
	int num = Integer.parseInt(strNum); // "27" -> 27
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

파라미터값 - 숫자 : <%=num %><br>

</body>
</html>