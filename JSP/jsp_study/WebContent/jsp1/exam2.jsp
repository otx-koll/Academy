<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// 변수선언 문자열 myid / 문자열 passwd / 정수형 age
	String myid;
	String passwd;
	int age;
	
	// 변수에 값넣기. "textid" / "testpass" / 27
	myid = "textid";
	passwd = "testpass";
	age = 27;
	
	// body태그 안에서 브라우저 출력
	// myid 님의 비밀번호는 passwd이고,
	// 나이는 age 입니다.<br>
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%=myid %> 님의 비밀번호는 <%=passwd %> 이고, 나이는 <%=age %> 입니다.<br> 
	
<% 
	// out - jsp 기본 출력객체(브라우저로 출력)
	out.println(myid+" 님의 비밀번호는 "+passwd+" 이고, 나이는 "+age+" 입니다.");
%>
</body>
</html>