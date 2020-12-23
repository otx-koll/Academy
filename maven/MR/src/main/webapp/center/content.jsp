<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.project.vo.*"%>
<%@page import="com.project.dao.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
// 파라미터값  num  pageNum  가져오기
int num = Integer.parseInt(request.getParameter("num"));
String pageNum = request.getParameter("pageNum");

// DAO 객체 준비
ForumDao forumDao = ForumDao.getInstance();

// 조회수 1 증가
forumDao.updateReadcount(num);

// 글 한개 가져오기
ForumVo forumVo = forumDao.getForumByNum(num);

// 글 내용에서 "\n" 줄바꿈 문자열을 "<br>"로 교체하기
String content = "";
if (forumVo.getContent() != null) {
	content = forumVo.getContent().replace("\n", "<br>");
}

// 작성일자 출력포맷 "2020-11-09 12:27:10"
SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
%>
<!DOCTYPE html>
<html>
<head>
<title>상세보기</title>
</head>
<body>
<jsp:include page="/include/topHeader.jsp" />
<div>
	<table border="1">
		<tr>
			<th scope="col">글번호</th>
			<td width="500"><%=forumVo.getNum() %></td>
		</tr>
		<tr>
			<th scope="col">조회수</th>
			<td ><%=forumVo.getReadcount() %></td>
		</tr>
		<tr>
			<th scope="col" >작성자</th>
			<td><%=forumVo.getId() %></td>
		</tr>
		<tr>
			<th scope="col">작성일자</th>
			<td><%=sdf.format(forumVo.getRegDate()) %></td>
		</tr>
		<tr>
			<th scope="col">글제목</th>
			<td><%=forumVo.getSubject() %></td>
		</tr>
		<tr>
			<th scope="col">글내용</th>
			<td><%=content %></td>
		</tr>
	</table>

	<div id="table_search">
		<%
		String id = (String) session.getAttribute("id");
		if (id != null) { // 로그인 했을때
			if (id.equals(forumVo.getId())) { // 로그인 아이디와 글작성자 아이디가 같을때
				%>
				<input type="button" value="글수정" class="btn" onclick="location.href = 'modifyForm.jsp?num=<%=forumVo.getNum() %>&pageNum=<%=pageNum %>'">
				<input type="button" value="글삭제" class="btn" onclick="remove()">
				<%
			}
			%>
			<input type="button" value="답글쓰기" class="btn" onclick="location.href = 'replyWriteForm.jsp?reRef=<%=forumVo.getReRef() %>&reLev=<%=forumVo.getReLev() %>&reSeq=<%=forumVo.getReSeq() %>&pageNum=<%=pageNum %>'">
			<%
		}
		%>
		<input type="button" value="목록보기" class="btn" onclick="location.href = 'notice.jsp?pageNum=<%=pageNum %>'">
	</div>
</div>

<jsp:include page="/include/bottomFooter.jsp" />


<script>
	function remove() {
		var result = confirm('해당 글을 정말 삭제하시겠습니까?');
		
		if (result == false) {
			return;
		}
		
		location.href = 'delete.jsp?num=<%=forumVo.getNum() %>&pageNum=<%=pageNum %>';
	} // remove
</script>

</body>
</html>   






    