<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
// 로그인 여부 확인
String id = (String) session.getAttribute("id");
if (id == null) {
<<<<<<< HEAD
	response.sendRedirect("/center/fileNotice.jsp"); // 같은 center폴더 안에서 있으면 fileNotice.jsp만 써도 가능
=======
	response.sendRedirect("fileNotice.jsp");
>>>>>>> d44115f475ec485145b63ce82940bda6a14e3931
	return;
}
%>

<%-- 파라미터값  pageNum  가져오기 --%>
<% String pageNum = request.getParameter("pageNum"); %>

<!DOCTYPE html>
<html>
<head>
<%-- head 컨텐트 영역 --%>
<jsp:include page="/WEB-INF/views/include/headContent.jsp" />

<link href="/css/subpage.css" rel="stylesheet" type="text/css"  media="all">
<style>
span.file-delete {
	color: red;
	background-color: yellow;
	font-weight: bold;
	margin-left: 10px;
	cursor: pointer;
	border-radius: 5px;
	border: 1px solid black;
	padding: 2px;
<<<<<<< HEAD
	display: inline;
=======
	display: inline-block;
>>>>>>> d44115f475ec485145b63ce82940bda6a14e3931
}
</style>
</head>
<body>
<div id="wrap">
	<%-- header 영역 --%>
	<jsp:include page="/WEB-INF/views/include/topHeader.jsp" />

	<div class="clear"></div>
	<div id="sub_img_center"></div>
	
	<div class="clear"></div>
	<%-- nav 영역 --%>
	<jsp:include page="/WEB-INF/views/include/submenuBoard.jsp" />
	
	<article>
		
	<h1>자료실 게시판 글쓰기</h1>
		
<<<<<<< HEAD
	<form action="fileWritePro.jsp" method="post" enctype="multipart/form-data" name="frm"> <!-- enctype은 무엇인가.. -->
=======
	<form action="fileWritePro.jsp" method="post" enctype="multipart/form-data" name="frm">
>>>>>>> d44115f475ec485145b63ce82940bda6a14e3931
	<input type="hidden" name="pageNum" value="<%=pageNum %>">
	<table id="notice">
		<tr>
			<th scope="col" class="twrite">작성자</th>
			<td class="left" width="500">
				<input type="text" name="id" value="<%=id %>" readonly>
			</td>
		</tr>
		<tr>
			<th scope="col" class="ttitle">글제목</th>
			<td class="left">
				<input type="text" name="subject">
			</td>
		</tr>
		<tr>
			<th scope="col" class="ttitle">글내용</th>
			<td class="left">
				<textarea rows="13" cols="40" name="content"></textarea>
			</td>
		</tr>
		<tr>
			<th scope="col" class="ttitle">파일</th>
			<td class="left">
<<<<<<< HEAD
				<input type="button" id="btnAddFile" value="첨부파일 추가" class="btn">
				<div id="fileBox">
					<input type="file" name="filename1">
					<span class="file-delete">X</span>
=======
				<input type="button" value="첨부파일 추가" id="btnAddFile" class="btn">
				<div id="fileBox">
					<div>
						<input type="file" name="filename0">
						<span class="file-delete">X</span>
					</div>
>>>>>>> d44115f475ec485145b63ce82940bda6a14e3931
				</div>
			</td>
		</tr>
	</table>

	<div id="table_search">
<<<<<<< HEAD
		<input type="submit" value="글쓰기" class="btn">
=======
		<input type="submit" value="파일글쓰기" class="btn">
>>>>>>> d44115f475ec485145b63ce82940bda6a14e3931
		<input type="reset" value="다시쓰기" class="btn">
		<input type="button" value="목록보기" class="btn" onclick="location.href = 'fileNotice.jsp?pageNum=<%=pageNum %>'">
	</div>
	</form>
	
	<div class="clear"></div>
	<div id="page_control">
	</div>
		
	</article>
    
	<div class="clear"></div>
	<%-- footer 영역 --%>
	<jsp:include page="/WEB-INF/views/include/bottomFooter.jsp" />
</div>

<script src="/script/jquery-3.5.1.js"></script>
<script>
	let fileCount = 1;
<<<<<<< HEAD
	let fileIndex = 0;
=======
	let fileIndex = 1;
>>>>>>> d44115f475ec485145b63ce82940bda6a14e3931

	// 정적 이벤트 연결
	$('#btnAddFile').on('click', function () {
		if (fileCount >= 5) {
			alert('첨부파일은 최대 5개 까지만 첨부할 수 있습니다.');
			return;
		}
		
<<<<<<< HEAD
		fileCount++;
		fileIndex++;
		
		let str = `
			<div id="fileBox">
				<input type="file" name="filename\${fileCount}"> 
				<span class="file-delete">X</span>
			</div>
		`; 

		$('#fileBox').append(str);
	});

	// 동적 이벤트 연결 (이벤트 등록을 위임하는 방식)
	$('div#fileBox').on('click', 'span.file-delete', function () {
// 		alert('span X 클릭됨');

		// 방금 클릭한 span태그
// 		$(this).closest('div').remove();
=======
		let str = `
			<div>
				<input type="file" name="filename\${fileIndex}">
				<span class="file-delete">X</span>
			</div>
		`;

		$('#fileBox').append(str);

		fileCount++;
		fileIndex++;
	});


	// 동적 이벤트 연결 (이벤트 등록을 위임하는 방식)
	$('div#fileBox').on('click', 'span.file-delete', function () {
		//alert('span X 클릭됨');

		//$(this).closest('div').remove();
>>>>>>> d44115f475ec485145b63ce82940bda6a14e3931
		$(this).parent().remove();
		
		fileCount--;
	});
<<<<<<< HEAD
	
=======

>>>>>>> d44115f475ec485145b63ce82940bda6a14e3931
</script>
</body>
</html>   

<<<<<<< HEAD
 
=======




    
>>>>>>> d44115f475ec485145b63ce82940bda6a14e3931
