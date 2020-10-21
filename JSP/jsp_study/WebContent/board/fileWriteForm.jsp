<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>파일 게시판 글쓰기</h1>
	<hr>
	<!-- 222쪽 7번. enc인코딩타입 / 멀티파트방식에 저장. enctype안써주면 파일 전송이 안됨. 전송방식이 post으로 저장해야 저장공간이 무제한 -->
	<form action="fileWritePro.jsp" method="post" enctype="multipart/form-data">  
		<table border="1">
			<tr>
				<th>작성자</th>
				<td><input type="text" name="name" required></td>
			</tr>
			<tr>
				<th>패스워드</th>
				<td><input type="password" name="passwd" required></td>
			</tr>
			<tr>
				<th>제목</th>
				<td><input type="text" name="subject" required></td>
			</tr>
			<tr>
				<th>파일</th>
				<td><input type="file" name="filename"></td>
			</tr>
			<tr>
				<th>내용</th>
				<td><textarea rows="13" cols="40" name="content"></textarea></td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="파일 글쓰기">
					<input type="reset" value="다시쓰기">
					<input type="button" value="글목록" onclick="location.href='list.jsp'">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>