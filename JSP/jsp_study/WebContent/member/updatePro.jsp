<%@page import="com.exam.dao.MemberDao"%>
<%@page import="com.exam.vo.MemberVo"%>
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

// post 파라미터값 한글처리 (넘어오는 데이터를 utf-8처리 해주지 않으면 글자가 깨져서 옴)
request.setCharacterEncoding("utf-8");

// VO 객체 준비
MemberVo memberVo = new MemberVo();

// 파라미터값 가져와서 VO에 저장
// request.getParameter : 무조건 사용자 입력값 String. 파라미터값 int면 Integer.parseInt 해줘야함
// Integer로 생성하면 변수값은 무조건 0
memberVo.setId(request.getParameter("id"));
memberVo.setPasswd(request.getParameter("passwd"));
memberVo.setName(request.getParameter("name")); 
memberVo.setAge(Integer.parseInt(request.getParameter("age")));
memberVo.setGender(request.getParameter("gender"));
memberVo.setEmail(request.getParameter("email"));

// DAO 객체 준비
MemberDao memberDao = new MemberDao();

// 회원 수정
memberDao.update(memberVo);

// 응답해서 main.jsp 이동
// response.sendRedirect("main.jsp");
%>
<script>
	alert('회원수정 완료!');
	location.href = 'main.jsp';
</script>