<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<head>
<style>
body {
	margin: 10px;
}

.box1 {
	width: auto;
	background-color: black;
	color: white;
	padding: 10px;
	text-align: center;
	margin-right: auto;
	margin-left: auto;
}

#msg {
 	padding: 10px 30px;
 	margin: 10px 20px;
}
li {
	margin: 5px;
}
</style>
</head>

<h3><div class="box1">Box Office</div></h3>
<div class="row">
	<div class=" col-6 align-self-center">
		<div id="msg" class="border border-secondary rounded row"></div>
	</div>
	<div class="col-6" style="margin-bottom: auto; margin-top: auto;">
		<div class="box3"></div>
	</div>
</div>
	
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script>
$(function(){

	var Now = new Date(),
	   StrNow = String(Now),
	   nowYear = String(Now.getFullYear()),
	   nowMon = String(Now.getMonth()+1),
	   nowDay = String(Now.getDate());
	if(nowMon.length == 1) {
		nowMon = "0" + nowMon
	}
	var NowToday = nowYear+nowMon+nowDay;
	console.log('NowToday', NowToday);
	
	var url = 'http://www.kobis.or.kr/kobisopenapi/webservice/rest/boxoffice/searchDailyBoxOfficeList.json?key=b4c4156506ac48f0b03cacd440f5f561&targetDt=';
	url += NowToday - 1;
	console.log(url);
	
	$.ajax({
		url : url,
		type : 'get',
		dataType : 'json',
		success : function(item){
			var str = "";
			
			$.each(item.boxOfficeResult.dailyBoxOfficeList, function(i, content) {

				str += "<div class='col-4'>" + content.rank + "위";
				var rankInten = parseInt(content.rankInten);
				
				if (rankInten > 0) str += "(▲";
				else if (rankInten < 0) str += "(▼";
				else str = str+"(";
				
				str += rankInten + ")</div><hr>";
				
				var movieCd = content.movieCd;
				var movieNm = content.movieNm+"<br>";
				str += "<div class='col-8'><a href='#' onclick='javascript:show("+content.movieCd+")'>"+movieNm+"</a></div>";
				
				$("#msg").html(str);
			})
		}
	})
})

function show(movieCd){
	var url = 'http://www.kobis.or.kr/kobisopenapi/webservice/rest/movie/searchMovieInfo.json?key=b4c4156506ac48f0b03cacd440f5f561&movieCd=';
	url += movieCd;

	$.ajax({
		url : url,
		dataType : 'json',
		success : function(item){
			
			console.log(item);
			
			var str = "<ul class='list-group'>";
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
			
			str += "<li class='list-group-item'><strong>영화제목</strong> : " + movieNm + " / " + movieNmEn + "</li>";
			str += "<li class='list-group-item'><strong>상영시간</strong> : "+showTm+"분</li>";
			str += "<li class='list-group-item'><strong>감독</strong> : "+director+"</li>";
			str += "<li class='list-group-item'><strong>출연배우</strong> : "+people+"</li></ul>";
			
			$(".box3").html(str);
		}
	})
}

</script>
