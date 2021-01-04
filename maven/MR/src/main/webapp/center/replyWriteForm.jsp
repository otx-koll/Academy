<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
// 로그인 여부 확인
String id = (String) session.getAttribute("id");
if (id == null) {
	response.sendRedirect("/center/notice.jsp");
	return;
}
%>

<%
String reRef = request.getParameter("reRef");
String reLev = request.getParameter("reLev");
String reSeq = request.getParameter("reSeq");
String pageNum = request.getParameter("pageNum");
%>

<!DOCTYPE html>
<html>
<head>
<style>
table{
	margin-left:auto;
	margin-right:auto;
}
th { padding: 10px; }
input[type="text"], textarea { width: 100%; }
</style>
</head>

<body>
<div class="container">
	<jsp:include page="/include/topHeader.jsp" />
	
	<div class="wrap text-center">
		<h3>Reply</h3><br>
		
		<form action="replyWritePro.jsp" method="post" name="frm">
			<input type="hidden" name="id" value="<%=id %>">
			<input type="hidden" name="pageNum" value="<%=pageNum %>">
			<input type="hidden" name="reRef" value="<%=reRef %>">
			<input type="hidden" name="reLev" value="<%=reLev %>">
			<input type="hidden" name="reSeq" value="<%=reSeq %>">
			
			<table class="table">
				<tr>
					<th scope="col">글제목</th>
					<td>
						<input type="text" name="subject" class="form-control mr-sm-2">
					</td>
				</tr>
				<tr>
					<th scope="col">글내용</th>
					<td>
						<textarea rows="13" cols="40" name="content" class="form-control mr-sm-2"></textarea>
					</td>
				</tr>
			</table>
		
			<div>
				<input type="submit" value="답글쓰기" class="btn btn-secondary mb-3">
				<input type="reset" value="다시쓰기" class="btn btn-secondary mb-3">
				<input type="button" value="목록보기" class="btn btn-secondary mb-3" onclick="location.href = 'notice.jsp?pageNum=<%=pageNum %>'">
			</div>
		</form>
	</div>
</div>

</body>
</html>   
