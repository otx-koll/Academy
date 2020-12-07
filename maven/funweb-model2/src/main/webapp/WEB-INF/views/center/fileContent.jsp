<%@page import="com.exam.vo.AttachVo"%>
<<<<<<< HEAD
<%@page import="com.exam.dao.AttachDao"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.exam.vo.NoticeVo"%>
<%@page import="java.util.List"%>
=======
<%@page import="java.util.List"%>
<%@page import="com.exam.dao.AttachDao"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.exam.vo.NoticeVo"%>
>>>>>>> d44115f475ec485145b63ce82940bda6a14e3931
<%@page import="com.exam.dao.NoticeDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
<<<<<<< HEAD
// 파라미터값 num pageNum 가져오기
=======
// 파라미터값  num  pageNum  가져오기
>>>>>>> d44115f475ec485145b63ce82940bda6a14e3931
int num = Integer.parseInt(request.getParameter("num"));
String pageNum = request.getParameter("pageNum");

// DAO 객체 준비
NoticeDao noticeDao = NoticeDao.getInstance();
AttachDao attachDao = AttachDao.getInstance();

// 조회수 1 증가
noticeDao.updateReadcount(num);

// 글 한개 가져오기
NoticeVo noticeVo = noticeDao.getNoticeByNum(num);
<<<<<<< HEAD

// 첨부파일 리스트 정보 가져오기
List<AttachVo> attachList = attachDao.getAttachesByNoNum(num);

=======
// 첨부파일 리스트 정보 가져오기
List<AttachVo> attachList = attachDao.getAttachesByNoNum(num);


>>>>>>> d44115f475ec485145b63ce82940bda6a14e3931
// 글 내용에서 "\n" 줄바꿈 문자열을 "<br>"로 교체하기
String content = "";
if (noticeVo.getContent() != null) {
	content = noticeVo.getContent().replace("\n", "<br>");
}

// 작성일자 출력포맷 "2020-11-09 12:27:10"
SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
%>
<!DOCTYPE html>
<html>
<head>
<%-- head 컨텐트 영역 --%>
<jsp:include page="/WEB-INF/views/include/headContent.jsp" />

<link href="/css/subpage.css" rel="stylesheet" type="text/css"  media="all">
</head>
<<<<<<< HEAD

=======
>>>>>>> d44115f475ec485145b63ce82940bda6a14e3931
<body>
<div id="wrap">
	<%-- header 영역 --%>
	<jsp:include page="/WEB-INF/views/include/topHeader.jsp" />

	<div class="clear"></div>
	<div id="sub_img_center"></div>
	
	<div class="clear"></div>
<<<<<<< HEAD
	<!-- nav 영역 -->
	<jsp:include page="/WEB-INF/views/include/submenuBoard.jsp"/>
=======
	<%-- nav 영역 --%>
	<jsp:include page="/WEB-INF/views/include/submenuBoard.jsp" />
>>>>>>> d44115f475ec485145b63ce82940bda6a14e3931
	
	<article>
		
	<h1>자료실 게시판 상세보기</h1>
		
	<table id="notice">
		<tr>
			<th scope="col" class="tno">글번호</th>
			<td class="left" width="500"><%=noticeVo.getNum() %></td>
		</tr>
		<tr>
			<th scope="col" class="tread">조회수</th>
			<td class="left"><%=noticeVo.getReadcount() %></td>
		</tr>
		<tr>
			<th scope="col" class="twrite">작성자</th>
			<td class="left"><%=noticeVo.getId() %></td>
		</tr>
		<tr>
			<th scope="col" class="tdate">작성일자</th>
			<td class="left"><%=sdf.format(noticeVo.getRegDate()) %></td>
		</tr>
		<tr>
			<th scope="col" class="ttitle">글제목</th>
			<td class="left"><%=noticeVo.getSubject() %></td>
		</tr>
		<tr>
			<th scope="col" class="ttitle">글내용</th>
			<td class="left"><%=content %></td>
		</tr>
		<tr>
			<th scope="col" class="ttitle">첨부파일</th>
			<td class="left">
			<%
<<<<<<< HEAD
			if (attachList != null && attachList.size() > 0) { // 최소 파일이 하나 이상 있을 때
				for(AttachVo attachVo : attachList) {
					if (attachVo.getImage().equals("I")) {
						%>
						<p>
							<a href="/upload/<%=attachVo.getUploadpath() %>/<%=attachVo.getFilename() %>" width="100" height="100">
=======
			if (attachList != null && attachList.size() > 0) {
				for (AttachVo attachVo : attachList) {
					if (attachVo.getImage().equals("I")) {
						%>
						<p>
							<a href="/upload/<%=attachVo.getUploadpath() %>/<%=attachVo.getFilename() %>">
>>>>>>> d44115f475ec485145b63ce82940bda6a14e3931
								<img src="/upload/<%=attachVo.getUploadpath() %>/<%=attachVo.getFilename() %>" width="100" height="100">
							</a>
						</p>
						<%
					} else {
						%>
						<p>
<<<<<<< HEAD
							<a href="/upload/<%=attachVo.getUploadpath() %>/<%=attachVo.getFilename() %>" width="100" height="100">
								<%=attachVo.getFilename() %>
							</a>
						</p>
=======
							<a href="/upload/<%=attachVo.getUploadpath() %>/<%=attachVo.getFilename() %>">
								<%=attachVo.getFilename() %>
							</a>
						</p>					
>>>>>>> d44115f475ec485145b63ce82940bda6a14e3931
						<%
					}
				} // for
			}
			%>
			</td>
		</tr>
	</table>

	<div id="table_search">
		<%
		String id = (String) session.getAttribute("id");
<<<<<<< HEAD
		if (id != null) { // 로그인 했을 때
			if (id.equals(noticeVo.getId())) { // 로그인 아이디와 글작성자 아이디가 같을 때
=======
		if (id != null) { // 로그인 했을때
			if (id.equals(noticeVo.getId())) { // 로그인 아이디와 글작성자 아이디가 같을때
>>>>>>> d44115f475ec485145b63ce82940bda6a14e3931
				%>
				<input type="button" value="글수정" class="btn">
				<input type="button" value="글삭제" class="btn" onclick="remove()">
				<%
			}
			%>
			<input type="button" value="답글쓰기" class="btn">
			<%
		}
		%>
<<<<<<< HEAD
		<input type="button" value="목록보기" class="btn" onclick="location.href='fileNotice.jsp?pageNum=<%=pageNum %>'">
=======
		<input type="button" value="목록보기" class="btn" onclick="location.href = 'fileNotice.jsp?pageNum=<%=pageNum %>'">
>>>>>>> d44115f475ec485145b63ce82940bda6a14e3931
	</div>
	
	<div class="clear"></div>
	<div id="page_control">
<<<<<<< HEAD
		
=======
>>>>>>> d44115f475ec485145b63ce82940bda6a14e3931
	</div>
		
	</article>
    
	<div class="clear"></div>
	<%-- footer 영역 --%>
<<<<<<< HEAD
	<jsp:include page="../include/bottomFooter.jsp" />
</div>
<script>
	function remove() {
		let isDelete = confirm('<%=noticeVo.getNum() %>번 글을 정말 삭제하시겠습니까?'); // 확인 창 띄우기. true와 false 리턴
		if (isDelete) { // confirm이 true라면
=======
	<jsp:include page="/WEB-INF/views/include/bottomFooter.jsp" />
</div>

<script>
	function remove() {
		let isDelete = confirm('<%=noticeVo.getNum() %>번 글을 정말 삭제하시겠습니까?');
		if (isDelete) {
>>>>>>> d44115f475ec485145b63ce82940bda6a14e3931
			location.href = 'fileDelete.jsp?num=<%=noticeVo.getNum() %>&pageNum=<%=pageNum %>';
		}
	}
</script>
</body>
</html>   

<<<<<<< HEAD
=======


    
>>>>>>> d44115f475ec485145b63ce82940bda6a14e3931
