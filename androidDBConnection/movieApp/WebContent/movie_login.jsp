<%@page import="db.beans.*, java.sql.*, java.util.*, java.io.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:useBean id="QueryBean" scope="page" class="db.beans.QueryBean" />
<jsp:setProperty name="QueryBean" property="*" />
<%
	response.setHeader("Cache-Control", "no-store");
response.setHeader("Pragma", "no-cache");
response.setDateHeader("Expires", 0);

request.setCharacterEncoding("utf-8");

// 파라미터 id passwd 가져오기
String id = request.getParameter("id") == null ? "" : request.getParameter("id").trim();
String password = request.getParameter("password") == null ? "" : request.getParameter("password").trim();

QueryBean.getConnection();

//로그인 확인
// check -1이면 없는 아이디
// check  0이면 패스워드 틀림
// check  1이면 아이디, 패스워드 모두 일치

int check = 0;

try {
	check = QueryBean.loginCheck(id, password);
} catch (Exception e) {
	out.print(e.toString());
} finally {
	QueryBean.closeConnection();
}

out.println("[");
out.println("{");
out.println("\"RESULT_OK\": \"" + check + "\" ");
out.println("}");
out.println("]");

System.out.println("res: " + check);
%>