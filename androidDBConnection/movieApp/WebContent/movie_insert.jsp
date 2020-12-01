<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="QueryBean" scope="page" class="db.beans.QueryBean"/>
<jsp:setProperty name="QueryBean" property="*"/>
<%
	response.setHeader("Cache-Control", "no-store");
	response.setHeader("Pragma", "no-cache");
	response.setDateHeader("Expires", 0);
	
	request.setCharacterEncoding("utf-8");
	
	String id = request.getParameter("id") == null ? "" : request.getParameter("id").trim();
	String name = request.getParameter("name") == null ? "" : request.getParameter("name").trim();
	String password = request.getParameter("password") == null ? "" : request.getParameter("password").trim();

	System.out.println("id: " + id);
	System.out.println("name: " + name);
	System.out.println("password: " + password);
	
	QueryBean.getConnection();
	
	int res = 0;
	
	try {
		res = QueryBean.setUserInfo(id, name, password);
	} catch (Exception e) {
		out.print(e.toString());
	} finally {
		QueryBean.closeConnection();
	}
	
	// 문서를 만들 부분
	out.println("[");
	out.println("{");
	out.println("\"RESULT_OK\": \"" + res + "\" ");
	out.println("}");
	out.println("]");
	
	System.out.println("res: " + res);
%>