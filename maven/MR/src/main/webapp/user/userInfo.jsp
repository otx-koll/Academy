<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>개인정보</title>
<link href="/css/bootstrap.css" rel="stylesheet">
<style>
div{
	padding: 10px;
	border:1px solid black;
}
</style>

</head>
<body>
<div class="container text-center">
	<div class="wrap row">
		<div class="col-6">
			<div>
				<div>실명</div>
				<div>효성</div>
			</div>
			
			<div>
				<div>성별</div>
				<div>
					<select>
						<option>여</option>
						<option>남</option>
					</select>
				</div>
			</div>
			
			<div>
				<div>생년월일</div>
				<div>
					<input type="date">
				</div>
			</div>
			
			<div>
				<div>이메일 주소</div>
				<div>
					<input type="text">
				</div>
			</div>
			
			<div>
				<div>전화번호</div>
				<div>
					<input type="tel">
				</div>
			</div>
			
			<div>
				<div>정부 발급 신분증</div>
				<div>
					<a href="#">추가</a>
				</div>
			</div>
			
			<div>
				<div>주소</div>
				<div>
					<div>
						<div>국가/지역</div>
						<select>
							<option>한국</option>
							<option>중국</option>
							<option>일본</option>
						</select>
					</div>
					
					<div class="row">
						<div class="col-6">
							<div>시/도</div>
							<input type="text" placeholder="예)서울특별시">
						</div>
						<div class="col-6">
							<div>시/군/구</div>
							<input type="text" placeholder="예) 강남구">
						</div>
					</div>
					
					<div>
						<div>도로명주소</div>
						<input type="text" placeholder="예) 언주로 406">
					</div>
					
					<div>
						<div>우편번호</div>
						<input type="text">
					</div>
				</div>
			</div>
		</div>
		<div class="col-6">
			ㅁㄴㅇㄹ
		</div>
	</div>
</div>
</body>
</html>