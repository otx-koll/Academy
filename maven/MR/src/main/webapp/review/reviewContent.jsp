<%@page import="com.project.vo.*"%>
<%@page import="com.project.dao.*"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// 파라미터값 num pageNum 가져오기
int num = Integer.parseInt(request.getParameter("num"));
String pageNum = request.getParameter("pageNum");

// DAO 객체 준비
ReviewDao reviewDao = ReviewDao.getInstance();
AttachDao attachDao = AttachDao.getInstance();

// 글 한개 가져오기
///////////////////////////////////////
ReviewVo reviewVo = reviewDao.getReviewAndAttaches(num);

// 첨부파일 리스트 정보 가져오기
List<AttachVo> attachList = reviewVo.getAttachList();

// 글 내용에서 "\n" 줄바꿈 문자열을 "<br>"로 교체하기
String content = "";
if (reviewVo.getContent() != null) {
	content = reviewVo.getContent().replace("\n", "<br>");
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
	margin: auto;
	width: 100%;
}
th, td {
	padding: 10px 15px;
}
</style>
</head>

<body>
<div class="container">
	<jsp:include page="/include/topHeader.jsp" />
	
	<div class="wrap">
		<table border="1">
			<tr>
				<td rowspan="3" style="padding: 0px; width: 100px">
					<%
					if (attachList != null && attachList.size() > 0) { // 최소 파일이 하나 이상 있을 때
						for(AttachVo attachVo : attachList) {
							if (attachVo.getImage().equals("I")) {
								%>
									<a href="/upload/<%=attachVo.getUploadpath() %>/<%=attachVo.getFilename() %>">
										<img src="/upload/<%=attachVo.getUploadpath() %>/<%=attachVo.getFilename() %>" style="width: 200px; height: 300px;">
									</a>
								<%
							} else {
								%>
									<a href="/upload/<%=attachVo.getUploadpath() %>/<%=attachVo.getFilename() %>" style="width: 100px; height: 200px;">
										<%=attachVo.getFilename() %>
									</a>
								<%
							}
						} // for
					}
					%>
				</td>
				
				<td colspan="4"><%=reviewVo.getMvSubject() %></td>
			</tr>
			
			<tr>
				<th scope="col">제목</th>
				<td><%=reviewVo.getSubject() %></td>
				<th scope="col">작성일</th>
				<td><%=sdf.format(reviewVo.getRegDate()) %></td>
			</tr>

			<tr>
				<th scope="col">내용</th>
				<td colspan="4"><%=content %></td>
			</tr>
		</table>
	</div>

	<div class="float-right">
		<%
		String id = (String) session.getAttribute("id");
		if (id != null) { // 로그인 했을때
			if (id.equals(reviewVo.getId())) { // 로그인 아이디와 글작성자 아이디가 같을때
				%>
				<input type="button" value="글수정" class="btn btn-secondary mb-3" onclick="location.href = 'modifyForm.jsp?num=<%=reviewVo.getNum() %>&pageNum=<%=pageNum %>'">
				<input type="button" value="글삭제" class="btn btn-secondary mb-3" onclick="remove()">
				<%
			}
		}
		%>
		<input type="button" value="목록보기" class="btn btn-secondary mb-3" onclick="location.href = 'reviewNotice.jsp?pageNum=<%=pageNum %>'">
	</div>
	<br>
	
</div>

<script>
	function remove() {
		var result = confirm('해당 글을 정말 삭제하시겠습니까?');
		
		if (result == false) {
			return;
		} else {
			alert("삭제되었습니다.");
		}
		
		location.href = 'reviewDelete.jsp?num=<%=reviewVo.getNum() %>&pageNum=<%=pageNum %>';
	} // remove
</script>
</body>
</html>   

