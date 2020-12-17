<%@page import="com.project.dao.UserDao"%>
<%@page import="java.sql.Timestamp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
// post 전송 파라미터값 한글처리
request.setCharacterEncoding("utf-8");
%>
<%-- 액션태그로 VO 객체 준비 --%>
<jsp:useBean id="userVo" class="com.project.vo.UserVo" />
<%-- 액션태그로 VO객체에 파라미터값 저장 --%>
<jsp:setProperty property="*" name="userVo" />
<%
// // 가입날짜 생성해서 넣기
// memberVo.setRegDate(new Timestamp(System.currentTimeMillis()));

// DAO 객체 준비
UserDao userDao = UserDao.getInstance();

// 회원가입 메서드 호출
userDao.addUser(userVo);

// 회원가입 후 로그인 페이지로 리다이렉트()
// response.sendRedirect("login.jsp");
%>
<script>
	alert('회원가입 성공');
	location.href = "login.jsp";
</script>
