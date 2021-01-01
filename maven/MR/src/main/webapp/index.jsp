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
				<jsp:include page="/home/award.jsp" />
			</div>
			<br>

			<div>
				<jsp:include page="/home/recent.jsp" />
			</div>
			<br>
			
		</div>
		
	</div>
</body>
</html>
