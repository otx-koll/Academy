<%@page import="com.exam.vo.BoardVo"%>
<%@page import="java.util.List"%>
<%@page import="com.exam.dao.BoardDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
// DAO 객체 준비
BoardDao boardDao = BoardDao.getInstance();

// 전체 글 갯수 가져오기
int count = boardDao.getCount(); // 페이지 번호 출력할 때 필요함. 

// 한페이지당 보여줄 글갯수 설정
int pageSize = 10;

// 사용자가 요청하는 페이지번호 파라미터값 가져오기
String strPageNum = request.getParameter("pageNum");
// 사용자 요청 페이지 정보가 없을때(null 일때)
// 기본 요청 페이지번호를 1페이지로 설정하기
strPageNum = (strPageNum == null) ? "1" : strPageNum;
// 사용자 요청 페이지를 정수로 변환
int pageNum = Integer.parseInt(strPageNum);

// 가져올 첫 행 번호 구하기
int startRow = (pageNum - 1) * pageSize;

// 글 목록 가져오기
List<BoardVo> boardList = null;
if (count > 0) {
	boardList = boardDao.getBoards(startRow, pageSize);
}

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>글목록 (전체 글 갯수 : <%=count %>)</h1>
	<hr>
	<table border="1">
		<thead>
			<tr>
				<th>번호</th>
				<th>제목</th>
				<th>작성자</th>
				<th>작성일</th>
				<th>조회</th>
				<th>IP</th>
			</tr>
		</thead>
		<tbody>
		<%
		if (count > 0) {
			for (BoardVo boardVo : boardList) {
				%>
				<tr>
					<td><%=boardVo.getNum() %></td>
					<td><%=boardVo.getSubject() %></td>
					<td><%=boardVo.getName() %></td>
					<td><%=boardVo.getRegDate() %></td>
					<td><%=boardVo.getReadcount() %></td>
					<td><%=boardVo.getIp() %></td>
				</tr>
				<%
			}
		} else { // count == 0
			%>
			<tr>
				<td colspan="6">게시판 글 없음</td>
			</tr>
			<%	
		}
		%>
		</tbody>
	</table>
</body>
</html>
