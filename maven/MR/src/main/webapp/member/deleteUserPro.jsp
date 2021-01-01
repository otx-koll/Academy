<%@page import="com.project.dao.UserDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
//세션값 가져오기
String id = (String) session.getAttribute("id");
//세션값 없으면 loginForm.jsp 이동
if (id == null) {
	response.sendRedirect("login.jsp");
	return;
}

// post 파라미터값 한글처리
request.setCharacterEncoding("utf-8");

// 파라미터값 passwd 가져오기
String passwd = request.getParameter("passwd");

// DAO 객체 준비
UserDao userDao = UserDao.getInstance();

// 패스워드 일치여부 확인
int check = userDao.loginCheck(id, passwd);

if (check == 0) { // 패스워드 불일치
	%>
	<script>
		alert('패스워드 틀림');
		history.back();
	</script>
	<%
	return;
}

//패스워드 일치 시	check == 1	

// 회원정보 삭제하기
userDao.deleteById(id);
%>
<script>
	alert('회원탈퇴 완료');
	location.href = "login.jsp";
</script>