<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
<title>영화 리뷰 사이트</title>
<link href="/css/bootstrap.min.css" rel="stylesheet">
<script src="/script/jquery-1.6.1.min.js"></script>

</head>

<body>
	<div class="container">
	<jsp:include page="/include/topHeader.jsp" />
	<br>
	<br>
	<br>
	<div class="jumbotron">
		<div>
			<h3><a href="/best/award.jsp">박스 오피스 순위</a></h3>
			<ol>
				<li>가</li>
				<li>나</li>
				<li>다</li>
			</ol>
		</div>
		
		<div>
		<h3><a href="#">신작 업데이트</a></h3>
			<ul>
				<li>가</li>
				<li>나</li>
				<li>다</li>
			</ul>
		</div>
	
	<br>
	<div id="center2">
		<div class="center-left">
			<h3><a href="/review/bestReview.jsp">인기리뷰</a></h3>
			<ol>
				<li>a</li>
				<li>b</li>
			</ol>
		</div>
		
		<div class="center-right">
			<h3><a href="/review/reviewNotice.jsp">최근리뷰</a></h3>
			<ul>
				<li>가</li>
				<li>나</li>
				<li>다</li>
			</ul>
		</div>
	</div>
	</div>
	</div>
</body>
</html>
