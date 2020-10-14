<%@page import="com.exam.vo.MemberVo"%>
<%@page import="java.util.List"%>
<%@page import="com.exam.dao.MemberDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
// 세션값 가져오기
// 1) 로그인 안한 경우 null 리턴
// 2) 로그인 했는데 관리자 "admin" 아닌 경우
// 	  -> main.jsp 로 이동
String id = (String) session.getAttribute("id");

// !(id == null || !id.equals("admin"))
// id != null && id.equals("admin")

if (id == null || !id.equals("admin")) { // 반대
	// null체크 먼저 한 후에 equals (왼 -> 오 방향으로 코드가 진행되기 때문에)
	response.sendRedirect("main.jsp"); // script의 location.href와 동일. "main.jsp를 요청하라"
	return;
}

// DAO 객체 준비
MemberDao memberDao = new MemberDao();

List<MemberVo> memberList = memberDao.getAllMembers();

%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>전체 회원목록 조회</h1>
	<hr>
	<table border="1">
		<thead>
			<tr>
				<th>아이디</th>
				<th>패스워드</th>
				<th>이름</th>
				<th>성별</th>
				<th>나이</th>
				<th>이메일</th>
				<th>가입일자</th>
			</tr>
		</thead>
		<tbody>
			<%
			for (MemberVo memberVo : memberList) {
				%>
				<tr>
					<td><%=memberVo.getId() %></td>
					<td><%=memberVo.getPasswd() %></td>
					<td><%=memberVo.getName() %></td>
					<td><%=memberVo.getGender() %></td>
					<td><%=memberVo.getAge() %></td>
					<td><%=memberVo.getEmail() %></td>
					<td><%=memberVo.getRegDate() %></td>
				</tr>
				<%
			}
			%>
		</tbody>
	</table>
	
	<h3><a href="main.jsp">메인화면</a></h3>
</body>
</html>