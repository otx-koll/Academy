<%@page import="com.project.vo.AttachVo"%>
<%@page import="com.project.vo.ReviewVo"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.project.vo.ForumVo"%>
<%@page import="java.util.List"%>
<%@page import="com.project.dao.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>동행 게시판</title>
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
td, th {
	margin: auto;
	padding: 10px;
}
form {
	margin-top: 20px;
}
table{
	margin-right: auto;
	margin-left: auto;
	width:100%;
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
ReviewDao reviewDao = ReviewDao.getInstance();

//검색어 기준으로 글갯수 가져오기
int count = reviewDao.getCountBySearch(category, search); 

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
List<ReviewVo> reviewList = null;
if (count > 0) {
	reviewList = reviewDao.getReviewBySearch(startRow, pageSize, category, search);
}

%>
<body>
<div class="container">
	<jsp:include page="/include/topHeader.jsp" />
	
	<div class="wrap">
		<table border="1">
			<%
			if (count > 0) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd");
			
			for (ReviewVo reviewVo : reviewList) {
			%>
			<tr>
<!-- 				<td class="text-center" rowspan="3"> -->
<%-- 					<img src="/upload/<%=attachVo.getUploadpath() %>/<%=attachVo.getFilename() %>" style="width: 200px; height: 300px;"> --%>
<!-- 				</td> -->
				
				<td class="text-center"colspan="4"><%=reviewVo.getMvSubject() %></td>

			</tr>
			
			<tr>
				<th scope="col" class="text-center">제목</th>
				<td class="text-center" scope="col">
					<a href="reviewContent.jsp?num=<%=reviewVo.getNum() %>&pageNum=<%=pageNum %>">
						<%=reviewVo.getSubject() %>
					</a>
				</td>
				
				<td class="text-center"><%=sdf.format(reviewVo.getRegDate()) %></td>
				<td class="text-center">
					<%=reviewVo.getId() %>
				</td>
			</tr>
			
			<tr>
				<td class="text-center" colspan="4">
					<%=reviewVo.getContent() %>
				</td>
			</tr>
			
			<%
				}
			} else { // count == 0
				%>
				<tr>
					<td colspan="7" class="text-center">리뷰 없음</td>
				</tr>
				<%
			}
			%>
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
					<a class="text-reset" href="reviewNotice.jsp?pageNum=<%=startPage - pageBlock %>&category=<%=category %>&search=<%=search %>">[이전]</a>
					<%
			 	}
				
				// 1 ~ 5
				for (int i=startPage; i<=endPage; i++) {
					if (i == pageNum) {
						%>
						<a class="text-reset" href="reviewNotice.jsp?pageNum=<%=i %>&category=<%=category %>&search=<%=search %>" class="active">[<%=i %>]</a>
						<%
					} else {
						%>
						<a class="text-reset" href="reviewNotice.jsp?pageNum=<%=i %>&category=<%=category %>&search=<%=search %>">[<%=i %>]</a>
						<%
					}
				} // for
				
				
				// [다음]
				if (endPage < pageCount) {
					%>
					<a class="text-reset" href="reviewNotice.jsp?pageNum=<%=startPage + pageBlock %>&category=<%=category %>&search=<%=search %>">[다음]</a>
					<%
				}
			}
			%>
		</div>
		
		<div id="table_search" class="text-center">
			<form action="notice.jsp" method="get">
<!-- 				<select name="category"> -->
<%-- 					<option value="subject" <%=category.equals("subject") ? "selected" : ""%>>글제목</option> --%>
<%-- 					<option value="content" <%=category.equals("content") ? "selected" : ""%>>글내용</option> --%>
<%-- 					<option value="id" <%=category.equals("id") ? "selected" : ""%>>작성자ID</option> --%>
<!-- 				</select> -->
<%-- 				<input type="text" name="search" value="<%=search%>"> --%>
<!-- 				<input type="submit" value="검색" class="btn btn-secondary mb-3"> -->
				
				<%
				// 로그인 했을때만 [글쓰기] 버튼 보이기
				String id = (String) session.getAttribute("id");
				if (id != null) {
					%>
					<input type="button" value="리뷰쓰기" class="btn btn-secondary mb-3" onclick="location.href='reviewWriteForm.jsp?pageNum=<%=pageNum%>'">
					<%
					}
				%>
			</form>
		</div>
	</div>
</div>
</body>
</html>   

    