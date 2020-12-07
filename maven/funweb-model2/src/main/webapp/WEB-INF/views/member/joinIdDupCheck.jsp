<<<<<<< HEAD
<%@page import="com.exam.dao.MemberDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
// 파라미터값 id 가져오기
String id = request.getParameter("id");

// DAO 객체 준비
MemberDao memberDao = MemberDao.getInstance();

// 중복 아이디 여부 확인
int count = memberDao.getCountById(id);

%>
=======
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
// request 영역객체에 저장한 데이터 가져오기
// String id = (String) request.getAttribute("id");
int count = (int) request.getAttribute("count");
%>
<%--
* JSP의 EL언어로 영역객체의 데이터에 접근하는 표현이 가능함
${  }로 표현함

Scope 탐색 순서 (↑)
application -> applicationScope
			↑
session -> sessionScope
			↑
request -> requestScope
			↑
page -> pageScope
			↑
--%>
>>>>>>> d44115f475ec485145b63ce82940bda6a14e3931
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<<<<<<< HEAD
<h2>ID 중복 확인</h2>
<hr>
<%
// count == 1 아이디있음 "사용중인 ID 입니다."
// count == 0 아이디없음 "사용가능한 ID 입니다."
if (count == 1) {
	%>
	<p>이미 사용중인 ID 입니다.</p>
=======
<h2>ID 중복확인</h2>
<hr>
<%
//count == 1  아이디있음  "사용중인 ID 입니다."
//count == 0  아이디없음  "사용가능한 ID 입니다."
if (count == 1) {
	%>
	<p>아이디 중복, 이미 사용중인 ID 입니다.</p>
>>>>>>> d44115f475ec485145b63ce82940bda6a14e3931
	<%
} else {
	%>
	<p>사용가능한 ID 입니다.</p>
	<input type="button" value="ID 사용" id="btnUseId">
	<%
}
%>

<<<<<<< HEAD
<form action="joinIdDupCheck.jsp" method="get" name="frm">
	<input type="text" name="id" value="<%=id %>">
=======
<form action="joinIdDupCheck.do" method="get" name="frm">
	<input type="text" name="id" value="${ id }">
>>>>>>> d44115f475ec485145b63ce82940bda6a14e3931
	<input type="submit" value="ID 중복확인">
</form>

<script src="/script/jquery-3.5.1.js"></script>
<script>
	$('#btnUseId').click(function () {
		// 검색한 ID 값 -> 창을 열게해준 부모페이지인 join.jsp의 id 입력상자에 넣기
<<<<<<< HEAD
		// window에 열린 창의 document안에 name이 frm인 태그 안에 name이 id인 value값에
		// 현재 창에 name이 frm인 태그 안에 name이 id인 value값을 집어넣는다. 현재 창이므로 window.document는 생략 가능
		window.opener.document.frm.id.value = /* window.document. */frm.id.value;
		window.close(); // 현재 창 닫기
	});
</script>

</body>
</html>
=======
		window.opener.document.frm.id.value = frm.id.value;
		window.close(); // 현재 창 닫기
	});
</script>
</body>
</html>



>>>>>>> d44115f475ec485145b63ce82940bda6a14e3931
