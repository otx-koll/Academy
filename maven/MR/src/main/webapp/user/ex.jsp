<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시물</title>
<style>
.app {
	width: 1020px;
	position: absolute;
	top: 50%;
	left: 50%;
	margin-top: -450px;
	margin-left: -450px;
}

div {
	padding: 10px;
	border: solid red 1px;
}

span {
	border: solid green 1px;
}

.float_right {
	float: right;
}

.container {
	display: grid;
	grid-template-columns: 500px 250px 250px;
	grid-template-rows: 250px 250px;
}

.item:nth-child(1) {
	grid-colum: 1/3;
	grid-row: 1/3;
}

.dateNperson {
	display: grid;
	grid-template-columns: 1fr 1fr;
	grid-template-rows: 1fr 1fr;
}
.dateNpersonItem:nth-child(3) {
/* 	grid-colum: 1/3; */
/* 	grid-row: 2/3; */
	grid-column: 1 / span 2;
	grid-row: 2 / span 1;
}
.verticality {
	display: inline-flex;
	flex-direction: column;
}

.horizontal {
	display: inline-flex;
	flex-direction: row;
}

hr {
	border: 0;
	height: 1px;
	background: #d2d2d2;
}

.notice {
	width: 297px;
}

.reviewWidth {
	width: 434px;
}

table, td, tr {
	border: solid 1px blue;
}
</style>
</head>
<body>
	<div class="app">
		<div>메인</div>
		<div>글제목</div>
		<div>
			<span>별점</span><span>지역</span><span class="float_right">저장</span>
		</div>
		<div class="container">
			<div class="item"></div>
			<div class="item"></div>
			<div class="item"></div>
			<div class="item"></div>
			<div class="item" style="position: relative;">
				<span style="position: relative; left: 100px; top: 180px;">사진모두보기</span>
			</div>
		</div>

		<div class="horizontal">
			<div class="verticality" style="width: 600px;">
				<div class="horizontal">
					<div class="verticality">
						<div>누구누구님이 호스팅하는 아파트 전체</div>
						<div>최대 인원 2명등등</div>
					</div>
					<div class="float_right">호스터 이미지</div>
				</div>
				<hr>
				<div>
					<table>
						<tr>
							<td>집아이콘</td>
							<td>
								<div>집전체</div>
								<div>아파트 전체를 단독으로 사용하시게 됩니다.</div>
							</td>
						</tr>
						<tr>
							<td>집아이콘</td>
							<td>
								<div>집전체</div>
								<div>아파트 전체를 단독으로 사용하시게 됩니다.</div>
							</td>
						</tr>
						<tr>
							<td>집아이콘</td>
							<td>
								<div>집전체</div>
								<div>아파트 전체를 단독으로 사용하시게 됩니다.</div>
							</td>
						</tr>
						<tr>
							<td>집아이콘</td>
							<td>
								<div>집전체</div>
								<div>아파트 전체를 단독으로 사용하시게 됩니다.</div>
							</td>
						</tr>
						<tr>
							<td>집아이콘</td>
							<td>
								<div>집전체</div>
								<div>아파트 전체를 단독으로 사용하시게 됩니다.</div>
							</td>
						</tr>
					</table>
				</div>
				<hr>
				<div>
					호스트 코멘트
				</div>
				<hr>
				<div>
					<h3>침대/침구 유형</h3>
					<div></div>
				</div>
				<hr>
				<div>
					<h3>편의시설</h3>
					<div>편의시설 모드보기</div>
				</div>
				<hr>
				<div>
					<h3>접근성</h3>
					<div>기능 세부정보 모두보기</div>
				</div>
				<hr>
				<div>
					<h3>달력</h3>
					<div>날짜지우기</div>
				</div>
			</div>
			<div>
				<div style="width: 332px;">
					<div>
						<span>얼마/1박</span>
						<span class="float_right">평점</span>
					</div>
					<div class="dateNperson">
						<div class="dateNpersonItem">체크인</div>
						<div class="dateNpersonItem">체크아웃</div>
						<div class="dateNpersonItem">게스트 인원</div>
					</div>
					<div>예약하기</div>
					<div>예약 확정 전에는 요금이 청구되지 않습니다.</div>
					<div>
						<table>
							<tr>
								<td>박당 몇일</td>
								<td>금액</td>							
							</tr>
							
							<tr>
								<td>청소비</td>
								<td>금액</td>							
							</tr>
							
							<tr>
								<td>서비스 수수료</td>
								<td>금액</td>							
							</tr>
							
							<tr>
								<td>숙박세와 수수료</td>
								<td>금액</td>							
							</tr>
						</table>
					</div>
					<hr>
					<div>
					총금액
					</div>
				</div>
			</div>
		</div>
		<div>
		<hr>
			<div>
				<h3>후기</h3>
				<div class="horizontal">
					<div class="verticality">
						<div class="reviewWidth">별점 왼쪽</div>
						<div class="reviewWidth">후기 왼쪽</div>
					</div>
					<div class="verticality">
						<div class="reviewWidth">별점 오른쪽</div>
						<div class="reviewWidth">후기 오른쪽</div>
					</div>
				</div>
			</div>
			<hr>
			<div>
				<h3>위치</h3>
				<div>지도</div>
				<div>코멘트</div>
				<div>자세한 위치정보</div>
			</div>
			<hr>
			<div>
				<h3>알아두어야할 사항</h3>
				<div class="horizontal">
					<div class="notice">
						<h4>숙소 이용규칙</h4>
						<table>
							<tr>
								<td>아이콘</td>
								<td>체크인 시간: 오후 3:00 이후</td>
							</tr>
							<tr>
								<td>아이콘</td>
								<td>체크인 시간: 오후 3:00 이후</td>
							</tr>
							<tr>
								<td>아이콘</td>
								<td>체크인 시간: 오후 3:00 이후</td>
							</tr>
							<tr>
								<td>아이콘</td>
								<td>체크인 시간: 오후 3:00 이후</td>
							</tr>
							<tr>
								<td>아이콘</td>
								<td>체크인 시간: 오후 3:00 이후</td>
							</tr>
							<tr>
								<td>아이콘</td>
								<td>체크인 시간: 오후 3:00 이후</td>
							</tr>
						</table>
					</div>
					<div class="notice">
						<h4>숙소 이용규칙</h4>
						<table>
							<tr>
								<td>아이콘</td>
								<td>에어비앤비의 강화된 청소 절차 준수에 동의했습니다. 자세히 알아보기</td>
							</tr>
							<tr>
								<td>아이콘</td>
								<td>에어비앤비의 강화된 청소 절차 준수에 동의했습니다. 자세히 알아보기</td>
							</tr>
							<tr>
								<td>아이콘</td>
								<td>에어비앤비의 강화된 청소 절차 준수에 동의했습니다. 자세히 알아보기</td>
							</tr>
							<tr>
								<td>아이콘</td>
								<td>에어비앤비의 강화된 청소 절차 준수에 동의했습니다. 자세히 알아보기</td>
							</tr>
						</table>
					</div>
					<div class="notice">
						<h4>환불 정책</h4>
						<p>1월 16일 12:00 PM 전에 예약을 취소하면 요금 전액이 환불됩니다.</p>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>