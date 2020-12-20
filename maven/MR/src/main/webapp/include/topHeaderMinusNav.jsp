<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
String id = (String) session.getAttribute("id");
%>
<header>
	<div id="login">
		<a href="/index.jsp">Home</a>
		<%
		if (id != null) {
			%>
			<a href="/member/logout.jsp">Logout</a>
			<%
		} else {
			%>
			<a href="/member/login.jsp">Login</a>
			<%
		}
		%>
		
	</div>
	<hr>
</header>