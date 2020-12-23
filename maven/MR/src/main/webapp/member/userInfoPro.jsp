<%@page import="com.project.dao.UserDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
// 세션 값 가져오기
String id = (String) session.getAttribute("id");

if (id == null) {
	response.sendRedirect("login.jsp");
	return;
}

request.setCharacterEncoding("utf-8");
%>
<jsp:useBean id="userVo" class="com.project.vo.UserVo"/>
<jsp:setProperty property="*" name="userVo"/>
<%
UserDao userDao = UserDao.getInstance();

userDao.update(userVo);

response.sendRedirect("/index.jsp");
%>
