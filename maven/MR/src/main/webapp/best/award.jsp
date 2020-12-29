<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Box Office</title>
</head>

<body>
<div class="container">
	<jsp:include page="/include/topHeader.jsp" />
	
	<div class="wrap">
		<input type="button" value="버튼" id="btn">
		<section></section>
	</div>
	
</div>

<script src="../js/jquery-3.5.1.js"></script>
<script>
	function process(data) {
		$('section').append('<p>' + data.name + ' : ' + data.gender + ' : ' + data.age + '</p>');
		// 객체니까 data.name형식으로
	}

	$('#btn').click(function () {

		$.ajax({
			url: 'awardJson.jsp',
			success: function (data) {
				console.log(typeof data);
				console.log(data);
				
				process(data);
			}
		});

		// 다른 실행문;
	});
</script>
</body>
</html>