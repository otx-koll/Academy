<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="//code.jquery.com/jquery-1.12.4.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/vue/2.2.4/vue.min.js"></script>
<script src="//code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<style>
h4 {
	font-size: 13px;
}

div.wrap>div {
	font-size: 12px;
	position: relative;
	float: left;
	margin-right: 5px;
	height: 30px;
	line-height: 30px;
	vertical-align: middle; input { line-height : 30px;
	margin: 0;
	padding: 0;
	padding-left: 5px;
	padding-right: 5px;
	width: 100px;
}

}
button {
	clear: both;
	display: block;
	line-height: 40px;
	margin-top: 80px;
	background-color: #eee;
	color: #333;
	border: 1px solid #666;
	padding-left: 20px;
	padding-right: 20px;
	border-radius: 4px;
}

#ui-datepicker-div {
	top: -999px;
	border: 0;
	font-size: 14px;
}

.ui-datepicker-header {
	font-size: 13px;
}

.ui-datepicker-calendar {
	background-color: #fff;
	border: 1px solid #ddd;
	tr {
		font-size: 11px;
	}
}
</style>
</head>

<body>
	<h4>기간 선택</h4>
	<div class="wrap">
		<div>체크인</div>
		<div>
			<input type="text" id="from">
		</div>
		<div>체크아웃</div>
		<div>
			<input type="text" id="to">
		</div>
	</div>
	<button class="btn">조회</button>
</body>

<script>
	var rangeDate = 31; // set limit day
	var setSdate, setEdate;
	$("#from").datepicker({
		dateFormat : 'yy-mm-dd',
		minDate : 0,
		onSelect : function(selectDate) {
			var stxt = selectDate.split("-");
			stxt[1] = stxt[1] - 1;
			var sdate = new Date(stxt[0], stxt[1], stxt[2]);
			var edate = new Date(stxt[0], stxt[1], stxt[2]);
			edate.setDate(sdate.getDate() + rangeDate);

			$('#to').datepicker('option', {
				minDate : selectDate,
				beforeShow : function() {
					$("#to").datepicker("option", "maxDate", edate);
					setSdate = selectDate;
					console.log(setSdate)
				}
			});
			//to 설정
		}
	//from 선택되었을 때
	});

	$("#to").datepicker({
		dateFormat : 'yy-mm-dd',
		onSelect : function(selectDate) {
			setEdate = selectDate;
			console.log(setEdate)
		}
	});
	$('.btn').on('click', function(e) {
		if ($('input#from').val() == '') {
			alert('시작일을 선택해주세요.');
			$('input#from').focus();
			return false;
		} else if ($('input#to').val() == '') {
			alert('종료일을 선택해주세요.');
			$('input#to').focus();
			return false;
		}

		var t1 = $('input#from').val().split("-");
		var t2 = $('input#to').val().split("-");
		var t1date = new Date(t1[0], t1[1], t1[2]);
		var t2date = new Date(t2[0], t2[1], t2[2]);
		var diff = t2date - t1date;
		var currDay = 24 * 60 * 60 * 1000;
		if (parseInt(diff / currDay) > rangeDate) {
			alert('로그 조회 기간은 ' + rangeDate + '일을 초과할 수 없습니다.');
			return false;
		}

		alert("성공")
	});
	//조회 버튼 클릭
</script>
</html>