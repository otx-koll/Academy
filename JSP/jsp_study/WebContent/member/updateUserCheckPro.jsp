<%@page import="com.exam.dao.MemberDao"%>
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

// post 파라미터값 한글처리
request.setCharacterEncoding("utf-8");
// 파라미터 값 passwd 가져오기
String passwd = request.getParameter("passwd");

// DAO 객체 준비
MemberDao memberDao = MemberDao.getInstance();

int check = memberDao.userCheck(id, passwd);

if (check == 1) { // 패스워드 일치할 때 
	response.sendRedirect("updateForm.jsp");
	return;
} else { // 패스워드 일치하지 않을 때
	%>
	<script>
		alert('패스워드 틀림');
		history.back();
	</script>
	<% 
}
%>


