<%@page import="com.project.dao.*"%>
<%@page import="java.sql.Timestamp"%>
<%@page import="com.project.dao.JdbcUtils"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
//로그인 여부 확인
String id = (String) session.getAttribute("id");
if (id == null) {
	response.sendRedirect("/center/notice.jsp");
	return;
}

request.setCharacterEncoding("utf-8");

String pageNum = request.getParameter("pageNum");
%>

<jsp:useBean id="forumVo" class="com.project.vo.ForumVo" />
<jsp:setProperty property="*" name="forumVo"/>

<%
//insert될 글번호 가져오기
int num = JdbcUtils.getNextNum("forum");
forumVo.setNum(num);

//ip  regDate  readcount  값 저장
forumVo.setIp(request.getRemoteAddr());
forumVo.setRegDate(new Timestamp(System.currentTimeMillis()));
forumVo.setReadcount(0);  // 조회수

ForumDao forumDao = ForumDao.getInstance();

// 답글 insert하기
forumDao.updateAndAddReply(forumVo);

response.sendRedirect("/center/content.jsp?num=" + forumVo.getNum() + "&pageNum=" + pageNum);
%>