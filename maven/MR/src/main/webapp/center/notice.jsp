<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.project.vo.ForumVo"%>
<%@page import="java.util.List"%>
<%@page import="com.project.dao.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>게시판</title>
<style>
.subject{
	color: black;
}
#table_search {
	padding: 10px;
}
div[class="text-center"] a {
	padding: 0 5px;
}
td[class="text-center"] a{
	color: black;
}
form {
	margin-top: 20px;
}
</style>
</head>
<%
// 검색어 관련 파라미터값 가져오기. 없으면 null 리턴
String category = request.getParameter("category"); // 검색유형
String search = request.getParameter("search"); // 검색어

// 검색어 관련 파라미터값이 null이면 빈문자열("")로 대체
category = (category == null) ? "" : category;
search = (search == null) ? "" : search;

System.out.println("category = " + category);
System.out.println("search = " + search);

// DAO 객체 준비
ForumDao forumDao = ForumDao.getInstance();

//검색어 기준으로 글갯수 가져오기
int count = forumDao.getCountBySearch(category, search); 

// 한페이지당 보여줄 글갯수 설정
int pageSize = 10;

// 사용자가 요청하는 페이지번호 파라미터값 가져오기
String strPageNum = request.getParameter("pageNum");
// 사용자 요청 페이지번호 정보가 없을때(null 일때)
// 기본 요청 페이지번호를 1페이지로 설정하기
strPageNum = (strPageNum == null) ? "1" : strPageNum;
// 사용자 요청 페이지를 정수로 변환
int pageNum = Integer.parseInt(strPageNum);

// 가져올 첫행번호 구하기
int startRow = (pageNum - 1) * pageSize;

// 글목록 가져오기
List<ForumVo> forumList = null;
if (count > 0) {
	forumList = forumDao.getForumBySearch(startRow, pageSize, category, search);
}
%>
<body>
<div class="container">
	<jsp:include page="/include/topHeader.jsp" />
	
	<div class="wrap">
		<table class="table table-hover">
			<thead>
				<tr>
					<th class="text-center" scope="col">글번호</th>
					<th class="text-center" scope="col">글제목</th>
					<th class="text-center" scope="col">작성자</th>
					<th class="text-center" scope="col">작성일자</th>
					<th class="text-center" scope="col">조회수</th>
				</tr>
			</thead>
			
			<tbody>
				<%
				if (count > 0) {
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd");
				
				for (ForumVo forumVo : forumList) {
				%>
				<tr>
					<th scope="row" class="text-center"><%=forumVo.getNum() %></th>
					<td class="text-center">
						<%
						if (forumVo.getReLev() > 0) { // 답글이면
							%>
							<img src="/img/level.gif" width="<%=forumVo.getReLev() * 15 %>" height="13">
							<img src="/img/re.gif">
							<%
						}
						%>
						<a href="content.jsp?num=<%=forumVo.getNum() %>&pageNum=<%=pageNum %>">
							<%=forumVo.getSubject() %>
						</a>
					</td class="text-center">
					<td class="text-center"><%=forumVo.getId() %></td>
					<td class="text-center"><%=sdf.format(forumVo.getRegDate()) %></td>
					<td class="text-center"><%=forumVo.getReadcount() %></td>
				</tr>
				<%
					}
				} else { // count == 0
					%>
					<tr>
						<td colspan="6" class="text-center">게시판 글 없음</td>
					</tr>
					<%
				}
				%>
			</tbody>
		</table>
		
		<div class="text-center">
			<%
			// 글갯수가 0보다 크면 페이지블록 계산해서 출력하기
			if (count > 0) {
				// 총 필요한 페이지 갯수 구하기
				// 글50개. 한화면에보여줄글 10개 => 50/10 = 5 
				// 글55개. 한화면에보여줄글 10개 => 55/10 = 5 + 1페이지(나머지존재) => 6
				int pageCount = (count / pageSize) + (count % pageSize == 0 ? 0 : 1);
				//int pageCount = (int) Math.ceil((double) count / pageSize);
				
				// 한 화면에 보여줄 페이지갯수 설정
				int pageBlock = 5;
				
				// 화면에 보여줄 시작페이지번호 구하기
				// 1~5          6~10          11~15          16~20       ...
				// 1~5 => 1     6~10 => 6     11~15 => 11    16~20 => 16
				int startPage = ((pageNum / pageBlock) - (pageNum % pageBlock == 0 ? 1 : 0)) * pageBlock + 1;
				
				// 화면에 보여줄 끝페이지번호 구하기
				int endPage = startPage + pageBlock - 1;
				if (endPage > pageCount) {
					endPage = pageCount;
				}
				
				// [이전]
				if (startPage > pageBlock) {
					%>
					<a class="text-reset" href="notice.jsp?pageNum=<%=startPage - pageBlock %>&category=<%=category %>&search=<%=search %>">[이전]</a>
					<%
				}
				
				// 1 ~ 5
				for (int i=startPage; i<=endPage; i++) {
					if (i == pageNum) {
						%>
						<a class="text-reset" href="notice.jsp?pageNum=<%=i %>&category=<%=category %>&search=<%=search %>" class="active">[<%=i %>]</a>
						<%
					} else {
						%>
						<a class="text-reset" href="notice.jsp?pageNum=<%=i %>&category=<%=category %>&search=<%=search %>">[<%=i %>]</a>
						<%
					}
				} // for
				
				
				// [다음]
				if (endPage < pageCount) {
					%>
					<a class="text-reset" href="notice.jsp?pageNum=<%=startPage + pageBlock %>&category=<%=category %>&search=<%=search %>">[다음]</a>
					<%
				}
			}
			%>
		</div>
		
<!-- 		<form class="form-inline my-2 my-lg-0" role="search"> -->
<!-- 			<input type="text" class="form-control mr-sm-2" name="search" placeholder="Search"> -->
<!-- 			<input type="submit" value="검색" class="btn btn-dark my-2 my-sm-0" style="margin: 0 20px 0 0;"> -->
<!-- 		</form> -->
		
		<div id="table_search" class="text-center">
			<form action="notice.jsp" method="get" class="form-inline" style="margin-left: 30%;">
				<select name="category" class="form-control" style="margin-right: 5px;">
					<option value="subject" <%=category.equals("subject") ? "selected" : ""%>>글제목</option>
					<option value="content" <%=category.equals("content") ? "selected" : ""%>>글내용</option>
					<option value="id" <%=category.equals("id") ? "selected" : ""%>>작성자ID</option>
				</select>
				<input type="text" name="search" class="form-control mr-sm-2" value="<%=search%>">
				<input type="submit" value="검색" class="btn btn-secondary my-3 my-sm-0" style="margin-right: 5px;">
				
				<%
				// 로그인 했을때만 [글쓰기] 버튼 보이기
				String id = (String) session.getAttribute("id");
				if (id != null) {
					%>
					<input type="button" value="글쓰기" class="btn btn-secondary mb-3 my-sm-0" onclick="location.href='writeForm.jsp?pageNum=<%=pageNum%>'">
					<%
					}
				%>
			</form>
		</div>
	</div>
</div>
</body>
</html>   

    