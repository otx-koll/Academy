<%@page import="com.exam.dao.BoardDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
// post 방식 파라미터값 한글처리
request.setCharacterEncoding("utf-8");

// 파라미터값   pageNum  num  passwd   가져오기
String pageNum = request.getParameter("pageNum");
int num = Integer.parseInt(request.getParameter("num"));
String passwd = request.getParameter("passwd");

// DAO 객체 준비
BoardDao boardDao = BoardDao.getInstance();

// 본인확인용 글 패스워드 비교
boolean isPasswdOk = boardDao.isPasswdOk(num, passwd);
// 글 패스워드 일치하면 글삭제하고 글목록으로 이동 
if (isPasswdOk) {
	boardDao.deleteBoardByNum(num);
	response.sendRedirect("list.jsp?pageNum=" + pageNum);
} else {
	%>
	<script>
		alert('글 패스워드 틀림');
		history.back();
	</script>
	<%
}
%>






