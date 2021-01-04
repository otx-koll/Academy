<%@page import="com.project.vo.*"%>
<%@page import="com.project.dao.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
// 로그인 여부 확인
String id = (String) session.getAttribute("id");
if (id == null) {
	response.sendRedirect("/center/notice.jsp");
	return;
}

int num = Integer.parseInt(request.getParameter("num"));
String pageNum = request.getParameter("pageNum");

ForumDao forumDao = ForumDao.getInstance();

ForumVo forumVo = forumDao.getForumByNum(num);

//request.setAttribute("noticeVo", vo);
%>

<!DOCTYPE html>
<html>
<head>
<title>글 수정</title>
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
		<h3>Modify</h3><br>
	
		<form action="modifyPro.jsp" method="post" name="frm">
		<input type="hidden" name="pageNum" value="<%=pageNum %>">
		<input type="hidden" name="num" value="<%=forumVo.getNum() %>">
		
		<table class="table">
			<tr>
				<th scope="col">작성자</th>
				<td>
					<input type="text" name="id" value="<%=forumVo.getId() %>" style="border:none; background-color:transparent" readonly>
				</td>
			</tr>
			<tr>
				<th scope="col" class="ttitle">글제목</th>
				<td class="left">
					<input type="text" name="subject" value="<%=forumVo.getSubject() %>" class="form-control mr-sm-2">
				</td>
			</tr>
			<tr>
				<th scope="col" class="ttitle">글내용</th>
				<td class="left">
					<textarea rows="13" cols="40" name="content" class="form-control mr-sm-2"><%=forumVo.getContent() %></textarea>
				</td>
			</tr>
		</table>
	
		<div>
			<input type="submit" value="글수정" class="btn btn-secondary mb-3">
			<input type="button" value="목록보기" class="btn btn-secondary mb-3" onclick="location.href = 'notice.jsp?pageNum=<%=pageNum %>'">
		</div>
		</form>
	</div>
</div>
<jsp:include page="/include/bottomFooter.jsp" />

</body>
</html>   

    