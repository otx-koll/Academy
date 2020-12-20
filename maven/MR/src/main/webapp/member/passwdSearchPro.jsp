<%@page import="com.project.dao.UserDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
request.setCharacterEncoding("utf-8");

String id = request.getParameter("id");
String tel = request.getParameter("tel");

UserDao userDao = UserDao.getInstance();

String passwd = userDao.passwdSearch(id, tel);

if (passwd == null) {
%>
	<script>
		alert("잘못 입력한 정보입니다");
		history.back();
	</script>
	<%
} else {
	%>
	<script>
		alert("비밀번호는 " + <%=passwd %> + "입니다.");
		location.href = "login.jsp";
	</script>
	<%
}
%>