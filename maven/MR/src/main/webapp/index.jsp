<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
<title>영화 리뷰 사이트</title>

</head>

<body>
	<div class="container">
		<jsp:include page="/include/topHeader.jsp" />
		
		<div class="wrap">
			<div>
				<h3><a href="/best/award.jsp">Box Office</a></h3>
				<ol>
					<li>가</li>
					<li>나</li>
					<li>다</li>
				</ol>
			</div>
			
			<div>
			<h3><a href="#">Update</a></h3>
				<ul>
					<li>가</li>
					<li>나</li>
					<li>다</li>
				</ul>
			</div>
			
			<div id="center2">
				<div class="center-left">
					<h3><a href="/review/bestReview.jsp">Best Review</a></h3>
					<ol>
						<li>a</li>
						<li>b</li>
					</ol>
				</div>
				
				<div class="center-right">
					<h3><a href="/review/reviewNotice.jsp">Recent Review</a></h3>
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
