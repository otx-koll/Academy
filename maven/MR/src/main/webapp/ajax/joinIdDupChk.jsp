<%@page import="org.json.simple.JSONObject"%>
<%@page import="com.project.dao.UserDao"%>
<%@ page language="java" contentType="application/json; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
// 아이디 중복체크할 파라미터값 가져오기
String id = request.getParameter("id");

UserDao userDao = UserDao.getInstance();

int count = userDao.getCountById(id);

JSONObject jsonObj = new JSONObject();
if (count == 0) {
	jsonObj.put("isIdDup", false);
} else { // count == 1
	jsonObj.put("isIdDup", true);
}

out.println(jsonObj);
%>

