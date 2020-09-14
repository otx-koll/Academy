## form
- 사용자가 웹브라우저에 입력한 정보를 서버로 넘겨주는 역할
- 입력된 정보를 DB에 저장하거나 저장된 회원정보를 검색, 수정 등의 작업을 하여 결과를 브라우저로 다시 보낸다
- ASP, JSP, PHP 등과 같은 서버 프로그래밍
```
<form [속성="속성 값"]>폼 요소들</form>
```
action : form태그 안의 내용들을 처리해줄 서버 프로그램 지정
```
<form action="URL">
```
method : 폼에 입력한 내용을 서버 쪽 프로그램으로 어떻게 넘겨줄지 결정
```
<form method="get">, <form method="post">
```
> get : URL 표시줄에 입력내용 표시. 보낼 수 있는 데이터 한계 (IE : 2048 이하)

> post : 입력내용 표시 되지 않음. 길이 제한 없음. 표준 입력 방식

## input
```
<input type="유형" [속성="속성값"]>
<input type="text" value="길동"> <!-- value="초기값"
```

attribute | Description
--|--
hidden | 사용자에게 보이지 않지만 폼 입력값 추가되어 서버로 전달
text | 텍스트 상자
search | 검색 상자
tel | 전화번호 입력 필드
 url | url 주소 필드
email | 메일주소 입력필드
password | 비밀번호 입력필드
date | 사용자 지역 기준으로 날짜(년, 월, 일) 입력
time | 사용자 지역 기준으로 시간 입력
number | 숫자 조절할 수 있는 화살표 입력
range | 숫자 조절할 수 있는 슬라이드 막대 입력
color | 색상표 입력
checkbox | 여러개 선택할 수 있는 체크박스
radio | 여러 항목 중 1개만 선택가능한 라디오 버튼(radio 버튼끼리 name이 같다)
file | 파일 첨부할 수 있는 버튼
submit | 서버로 전송 버튼( <button type="submit">으로도 가능 )
image | submit 버튼 대신 사용할 이미지
reset | 리셋 버튼
button | 버튼입력


+ autofocus : 페이지를 불러오자마자 폼 요소에 마우스 커서 표시
+placeholder : 입력란에 표시하는 힌트
+ required : 필수로 들어가야 하는 필드
+ minlegnth, maxlength, size : 입력해야 할 최소글자, 입력가능한 최대글자, 화면에 몇 글자까지 보이게 할지 설정

## label
- 폼 요소의 제목 붙이기
```
<label for="id이름">레이블</label>
<input type="" id="id이름"...>
```

## fieldset
- 폼 요소 그룹 묶기
	- <legend> : fieldset의 제목
```
<fieldset>
<legend>제목</legend>
<input type="text" ...>
</fieldset>
```

## select
- 선택 가능한 입력창. option의 내용을 선택할 수 있다
```
<select name="gender" id="gender">
                <option value="male">남성</option> <!-- select 안에 들어갈 값 -->
                <option value="female" selected>여성</option> <!-- selected : 먼저 보일 값 설정 -->
            </select>
```
