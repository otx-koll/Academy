<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>결제페이지</title>
</head>
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

table, td, tr {
	border: solid 1px blue;
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

ul{
   list-style:none;
   }

.costTab {
    display: inline-block;
    position: sticky;
    top: 10px;
}

</style>

<body>
    <div class="app">
        <div class="horizontal">
            <a href=""><  </a>
            <h1>예약 요청하기</h1>
        </div>
        <div class="horizontal">
            <div>
                <div class="verticality" style="width: 600px;">
                    <div class="verticality discount_info">
                        <div>저렴한 요금</div>
                        <div>검색하시는 날짜의 요금은 지난 3개월의 평균 1박 요금보다 $7 저렴합니다.</div>
                    </div>
                    <div class="verticality book_info">
                        <h2>예약정보</h2>
                        <div class="horizontal">
                            <div class="verticality">
                                <div>날짜</div>
                                <div>2021.2.22-2021.2.23</div>
                                <div>(시계아이콘) 체크인:오후 3:00이후</div>
                            </div>
                            <div><a href="">수정</a></div>
                        </div>
                        <div class="horizontal">
                            <div class="verticality">
                                <div>게스트</div>
                                <div>게스트 2명</div>
                            </div>
                            <div><a href="">수정</a></div>
                        </div>
                        <div class="horizontal business_trip">
                            <div>출장인가요?</div>
                            <div>(슬라이드 버튼)</div>
                        </div>
                    </div>
                    <div class="verticality payment_means">
                        <h2>결제 수단</h2>
                        <div>(결제 수단 아이콘 묶음)</div>
                        <div>
                            (toggle or dropdown로변경)
                            <br>
                            <select name="payment_means" id="payment-select">
                                <option value="">--Please choose an option--</option>
                                <option value="card">신용카드 또는 체크카드</option>
                                <option value="kakaopay">kakaopay</option>
                                <option value="paypal">paypal</option>
                                <option value="payco">payco</option>
                                <option value="googlepay">googlepay</option>
                            </select>
                        </div>
                        <div><a href="">쿠폰 입력하기</a></div>
                    </div>
                    <div class="verticality required_info">
                        <h2>필수 입력 정보</h2>
                        <div class="verticality">
                            <div>호스트에게 메시지 보내기</div>
                            <div>호스트에게 여행 목적과 도착 예정 시간을 알려주세요.</div>
                        </div>
                        <div class="horizontal host_info">
                            <div class="host_photo">(호스트사진)</div>
                            <div class="verticality">
                                <div class="host_name">홍길동</div>
                                <div class="host_join_date">에어비앤비 가입:2018년</div>
                            </div>
                        </div>
                        <div><textarea name="message_to_host" id="message_to_host" cols="30" rows="10"></textarea></div>
                    </div>
                    <div class="verticality refund_policy">
                        <h2>환불 정책</h2>
                        <div>
                            1월 23일 12:00 PM 전에 예약을 취소하면 요금 전액이 환불됩니다.
                            <br>
                            <a href="">자세히 알아보기</a>
                        </div>
                        <div>
                            호스트가 제공하는 환불 정책이 내게 적합한지 확인하세요. 3월 15일 혹은 그 이후 확정된 예약에는 코로나19 확산 사태에 따른 정상참작이 가능한 상황 정책이 적용되지 않습니다.
                            <a href="">자세히 알아보기</a>
                        </div>
                    </div>
                    <div class="confirm_message">
                        <div class="horizontal confirm_message_top">
                            <div class="icon">(예약아이콘)</div>
                            <div>호스트가 24시간 이내 예약 요청을 수락하기 전까지는 예약이 아직 확정된 것이 아닙니다.
                                <br>
                                예약 확정 전까지는 요금이 청구되지 않습니다.
                            </div>
                        </div>
                        <div class="confirm_message_bottom">
                            아래 버튼을 선택하면, 숙소 이용규칙, 안전 정보 공개, 환불 정책, 에어비앤비의 사회적 거리 두기 및 기타 코로나19 관련 가이드라인, 및 게스트 환불 정책에 동의하는 것입니다. 또한 숙박세 및 서비스 수수료를 포함하여 표시된 총 금액에 동의합니다. 에어비앤비는 이제 이 지역에서 정부가 부과한 숙박세를 징수하여 납부합니다.
                        </div>
                    </div>
                    <div class="btn_book"><button>예약 요청하기</button></div>
                </div>
            </div>

            <!-- costTab -->
            <div>

                <div class="verticality costTab">
                    <div class="horizontal">
                        <div class="accommodation_photo">(숙소사진)</div>
                        <div class="accommodation_info">
                            <ul>
                                <li>(숙소 카테고리)</li>
                                <li>(숙소이름)</li>
                                <li>(숙소 스펙)</li>
                                <li>(리뷰)</li>
                                <li>(호스트클래스)</li>
                            </ul>
                        </div>
                    </div>
                    <div class="rate_details">
                        <h2>요금 세부정보</h2>
                        <table>
                            <tr>
                                <td>$44.64 x 1박</td>
                                <td>$44.64</td>
                            </tr>
                            <tr>
                                <td>서비스 수수료</td>
                                <td>$6.30</td>
                            </tr>
                            <tr>
                                <td>숙박세와 수수료</td>
                                <td>$0.63</td>
                            </tr>
                            <tr>
                                <td>총 합계 (USD)</td>
                                <td>$51.57</td>
                            </tr>
                        </table>
                    </div>
                </div>
            </div>

        </div>
        

    </div>
</body>
</html>