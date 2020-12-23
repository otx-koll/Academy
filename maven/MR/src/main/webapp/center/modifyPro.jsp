<%@page import="com.project.dao.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
//로그인 체크를 위해 세션값 가져오기
String id = (String) session.getAttribute("id");
//세션값 id 없으면 login.jsp로 리다이렉트 이동
if (id == null) {
	response.sendRedirect("/member/login.jsp"); 
	return;
}

request.setCharacterEncoding("utf-8"); %>

<jsp:useBean id="forumVo" class="com.project.vo.ForumVo" />
<jsp:setProperty property="*" name="forumVo"/>

<% String pageNum = request.getParameter("pageNum"); 

ForumDao forumDao = ForumDao.getInstance();

forumDao.updateBoard(forumVo);

response.sendRedirect("/center/content.jsp?num=" + forumVo.getNum() + "&pageNum=" + pageNum);

%>


