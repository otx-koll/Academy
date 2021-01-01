<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
// 로그인 여부 확인
String id = (String) session.getAttribute("id");
if (id == null) {
	response.sendRedirect("/review/reviewNotice.jsp");
	return;
}

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
input[type="text"], textarea { width: 500px; }
</style>
</head>
<body>
<div class="container">
	<jsp:include page="/include/topHeader.jsp" />
	
	<div class="wrap text-center">
			
		<h1>Review</h1>

		<form action="reviewWritePro.jsp" method="post" enctype="multipart/form-data" name="frm">
			<input type="hidden" name="pageNum" value="<%=pageNum %>">
			<input type="hidden" name="id" value="<%=id %>">

			<table class="table text-center">
				<tr>
					<th scope="col">영화제목</th>
					<td>
						<input type="text" name="mvSubject" class="form-control mr-sm-2" style="width:100%;">
					</td>
				</tr>
				
				<tr>
					<th scope="col">제목</th>
					<td>
						<input type="text" name="subject" class="form-control mr-sm-2" style="width:100%;">
					</td>
				</tr>
				
				<tr>
					<th scope="col">내용</th>
					<td>
						<textarea rows="13" cols="40" name="content" class="form-control mr-sm-2"></textarea>
					</td>
				</tr>
				
				<tr>
					<th scope="col">사진첨부</th>
					<td>
						<div id="fileBox">
							<input type="file" name="filename1" class="btn">
						</div>
					</td>
				</tr>
			</table>
		
			<div style="margin: 30px 0;">
				<input type="submit" value="글쓰기" class="btn btn-secondary mb-3">
				<input type="button" value="목록보기" class="btn btn-secondary mb-3" onclick="location.href = 'reviewNotice.jsp?pageNum<%=pageNum %>'">
			</div>
		</form>
		
		</div>
	</div>
</div>
</body>
</html>   

 