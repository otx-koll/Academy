<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
// 로그인 여부 확인
String id = (String) session.getAttribute("id");
if (id == null) {
	response.sendRedirect("/center/notice.jsp");
	return;
}

String pageNum = request.getParameter("pageNum");
%>

<!DOCTYPE html>
<html>
<head>
<title>글쓰기</title>
</head>
<body>
<jsp:include page="/include/topHeader.jsp" />
<div>
	<form action="writePro.jsp" method="post" name="frm">
	<input type="hidden" name="pageNum" value="<%=pageNum %>">
	<table>
		<tr>
			<th scope="col">작성자</th>
			<td width="500">
				<input type="text" name="id" value="<%=id %>" readonly>
			</td>
		</tr>
		<tr>
			<th scope="col">글제목</th>
			<td>
				<input type="text" name="subject">
			</td>
		</tr>
		<tr>
			<th scope="col" c>글내용</th>
			<td>
				<textarea rows="13" cols="40" name="content"></textarea>
			</td>
		</tr>
	</table>
	
	<input type="button" value="좋아요">
	
	<div id="table_search">
		<input type="submit" value="글쓰기" class="btn">
		<input type="reset" value="다시쓰기" class="btn">
		<input type="button" value="목록보기" class="btn" onclick="location.href = 'notice.jsp?pageNum=<%=pageNum %>'">
	</div>
	</form>
</div>
<jsp:include page="/include/bottomFooter.jsp" />

</body>
</html>   

    