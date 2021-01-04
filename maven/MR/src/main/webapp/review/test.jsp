<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>박스오피스 순위</title>
<style type="text/css">
body {
margin: 10px;
}
.box1 {
width: 400px;
background-color: green;
color: white;
padding: 15px;
text-align: center;
}
.box2 {
width: 400px;
background-color: white;
padding: 15px;
text-align: center;
}
#msg {
border-radius: 5px;
border: 2px solid #73AD21;
padding: 10px;
padding-left: 20px;
margin-top: 15px;
width: 400px;
height: 200px;
font-size: 14px;
text-align: left;
}
</style>
</head>
<body>
<div class="box1">일별 박스 오피스</div>
<div class="box2">
<form action="">
<input type="text" name="txtYear" id="txtYear" size="6" />년 <select
name="" id="selMon">
<option value="01">1월</option>
<option value="02">2월</option>
<option value="03">3월</option>
<option value="04">4월</option>
<option value="05">5월</option>
<option value="06">6월</option>
<option value="07">7월</option>
<option value="08">8월</option>
<option value="09">9월</option>
<option value="10">10월</option>
<option value="11">11월</option>
<option value="12">12월</option>
</select>
<select name="" id="selDay">
<option value="01">1일</option>
<option value="02">2일</option>
<option value="03">3일</option>
<option value="04">4일</option>
<option value="05">5일</option>
<option value="06">6일</option>
<option value="07">7일</option>
<option value="08">8일</option>
<option value="09">9일</option>
<option value="10">10일</option>
<option value="11">11일</option>
<option value="12">12일</option>
<option value="13">13일</option>
<option value="14">14일</option>
<option value="15">15일</option>
<option value="16">16일</option>
<option value="17">17일</option>
<option value="18">18일</option>
<option value="19">19일</option>
<option value="20">20일</option>
<option value="21">21일</option>
<option value="22">22일</option>
<option value="23">23일</option>
<option value="24">24일</option>
<option value="25">25일</option>
<option value="26">26일</option>
<option value="27">27일</option>
<option value="28">28일</option>
<option value="29">29일</option>
<option value="30">30일</option>
<option value="31">31일</option>
</select>
<input type="button" value="확인" id="bt1" />
</form>
</div>
<div id="msg"></div>
<div class="cardClear"></div>
<div class="box3"></div>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>

<script>
$(function(){
	init();
	
	$("#bt1").click(function(){
		
		var url = 'http://www.kobis.or.kr/kobisopenapi/webservice/rest/boxoffice/searchDailyBoxOfficeList.json?key=b4c4156506ac48f0b03cacd440f5f561&targetDt=';
	
		url += $("#txtYear").val()+$("#selMon").val()+$("#selDay").val();
		console.log(url);
	
		$.ajax({
			url : url,
			type : 'get',
			dataType : 'json',
			success : function(item){
				var str = "";
	
				$.each(item.boxOfficeResult.dailyBoxOfficeList, function(i, content) {
					str += content.rank+" 위";
					
					var rankInten = parseInt(content.rankInten);
	
					if (rankInten>0) str += "(▲";
					else if (rankInten<0) str += "(▼";
					else str = str+"(";
	
					str += rankInten+") : ";
	
					var movieCd = content.movieCd;
					var movieNm = content.movieNm + "<br>";
					str += "<a href='#' onclick='javascript:show("+movieCd+")'>"+movieNm+"</a>";
					$("#msg").html(str);
				})
			}
		})
	})
})
	
function init(){
	var newDate = new Date();
	var year = newDate.getFullYear();
	var month = newDate.getMonth()+1; //월 시작 0부터
	var day = newDate.getDate()-1; //어제날짜
	
	if (month<10) month = "0"+month;
	if (day<10) dat = "0"+day;
	
	$("#txtYear").val(year);
	$("#selMon").val(month);
	$("#selDay").val(day);

}
function show(movieCd){
	var url = 'http://www.kobis.or.kr/kobisopenapi/webservice/rest/movie/searchMovieInfo.json?key=b4c4156506ac48f0b03cacd440f5f561&movieCd=';
	url += movieCd;

	$.ajax({
		url : url,
		dataType : 'json',
		success : function(item){
			console.log(item);
			
			var str = "<ul>";
			var movieInfo = item.movieInfoResult.movieInfo;

			var movieNm = movieInfo.movieNm;
			var movieNmEn = movieInfo.movieNmEn;
			var showTm = movieInfo.showTm;
			var director = movieInfo.directors[0].peopleNm;

			var people = "";
			var length = movieInfo.actors.length;

			$.each(movieInfo.actors, function(i, content) {
				if (i == length-1)
					people += content.peopleNm;
				else
					people += content.peopleNm+", ";
			})
			
			str += "<li>영화제목 : "+movieNm+"</li>";
			str += "<li>영어제목 : "+movieNmEn+"</li>";
			str += "<li>상영시간 : "+showTm+"</li>";
			str += "<li>감독 : "+director+"</li>";
			str += "<li>출연배우 : "+people+"</li></ul>";

			$(".box3").html(str);
		}
	})
}

</script>
</body>
</html>

