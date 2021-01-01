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
<style>
.wrap table{
	margin-left:auto; margin-right:auto;
}
th, td {
	padding: 10px 15px;
}
</style>
</head>

<body>
<div class="container">
	<jsp:include page="/include/topHeader.jsp" />
	
	<!-- 글 내용 -->
	<div class="wrap">
		<table border="1" style="margin: auto">
			<tr>
				<th scope="col" >작성자</th>
				<td><%=forumVo.getId() %></td>
				<th scope="col">조회수</th>
				<td width="500"><%=forumVo.getReadcount() %></td>
			</tr>
			
			<tr>
				<th scope="col">제목</th>
				<td><%=forumVo.getSubject() %></td>
				<th scope="col">작성일</th>
				<td><%=sdf.format(forumVo.getRegDate()) %></td>
			</tr>

			<tr>
				<td colspan="4"><%=content %></td>
			</tr>
		</table>
		
	</div>
	
	<div class="float-right">
		<%
		String id = (String) session.getAttribute("id");
		if (id != null) { // 로그인 했을때
			if (id.equals(forumVo.getId())) { // 로그인 아이디와 글작성자 아이디가 같을때
				%>
				<input type="button" value="글수정" class="btn btn-secondary mb-3" onclick="location.href = 'modifyForm.jsp?num=<%=forumVo.getNum() %>&pageNum=<%=pageNum %>'">
				<input type="button" value="글삭제" class="btn btn-secondary mb-3" onclick="remove()">
				<%
			}
			%>
			<input type="button" value="답글쓰기" class="btn btn-secondary mb-3" onclick="location.href = 'replyWriteForm.jsp?reRef=<%=forumVo.getReRef() %>&reLev=<%=forumVo.getReLev() %>&reSeq=<%=forumVo.getReSeq() %>&pageNum=<%=pageNum %>'">
			<%
		}
		%>
		<input type="button" value="목록보기" class="btn btn-secondary mb-3" onclick="location.href = 'notice.jsp?pageNum=<%=pageNum %>'">
	</div>
	<br>
	
	<!-- 댓글 -->
	<!-- 
	<form id="commentForm" name="commentForm" method="post">
		<div style="margin: 10px 0;">
		    <span style="color:white;"><strong>댓글</strong></span>
		</div>
		
		<div>
		    <table class="table">
		        <tr>
		            <td>
		                <textarea style="width: 100%" rows="3" id="comment" name="comment" placeholder="댓글을 입력하세요"></textarea>
		               <br>
		               <div>
		                   <a href='#' onClick="fn_comment('${result.code }')" class="btn pull-right btn-success">등록</a>
		                </div>
		            </td>
		        </tr>
		    </table>
		</div>
    	<input type="hidden" id="b_code" name="b_code" value="${result.code }" />        
	</form>
	-->
	
</div>

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






    