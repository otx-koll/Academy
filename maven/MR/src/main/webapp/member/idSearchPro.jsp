<%@page import="com.project.dao.UserDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
request.setCharacterEncoding("utf-8");

String name = request.getParameter("name");
int tel = Integer.parseInt(request.getParameter("tel"));

UserDao userDao = UserDao.getInstance();

String id = userDao.idSearch(name, tel);

if (id == null) {
%>
	<script>
		alert("가입된 아이디가 없습니다");
		history.back();
	</script>
	<%
} else {
	%>
	<script>
		alert("아이디는 " + "<%=id %>" + "입니다.");
		location.href = "login.jsp";
	</script>
	<%
}
%>
