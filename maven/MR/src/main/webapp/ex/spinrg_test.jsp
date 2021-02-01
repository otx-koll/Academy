<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
</head>
<body>

	<form action="sum_result4.iot" method="POST">
		<p>
			값1<br />
			<form:input path="value1" />
		</p>
		<p>
			값2<br />
			<form:input path="value2" />
		</p>
		<p>
			<input type="submit" value="Submit">
		</p>
</form>
</body>
</html>
