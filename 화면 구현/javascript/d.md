주석 // 또는 /* */

자바스크립트 자료형(타입) 종류
	문자열형 : string
	숫자형 : number
	불리언형 : boolean

var, let, const로 변수 선언
차이점
var : 선언 전에 사용해도 에러 x / 이미 존재하는 이름과 같은 이름으로 또 선언해도 에러 x / 초기 값 안줘도 됨 / 값 다시 할당 가능
let : 선언 전에 사용하면 에러 발생 / 이미 존재하는 변수와 같은 이름을 선언하면 에러 발생 / 초기 값 안줘도 됨 / 값 다시 할당 가능
const : 선언 전에 사용하면 에러 발생 / 이미 존재하는 변수와 같은 이름을 선언하면 에러 발생 / 초기 값 반드시 할당 / 한번 할당하면 변경불가

var의 경우 버그 발생과 메모리 누수의 위험이 있기때문에 let이나 const를 사용하는게 좋다.

let 변수는 가장 가까운 코드블록 기준으로 수명주기가 결정됨.
	// var 변수는 가장 가까운 함수블록 기준으로 수명주기가 결정됨. 

var : 자바스크립트에서는 for문 안에 있는 var가 밖에서도 살아있다. 변수 재선언 가능
	// let : 변수 재선언 불가능. 변수에 재할당 가능
	// const : 변수 재선언, 재할당 모두 불가능

hoisting : var선언문이나 function 선언문 등을 해당 스코프의 선두로 옮긴 것처럼 동작하는 특성
---

연산자 우선순위
1. 괄호 ()
2. 단항연산자 + - 부호	++ -- 증감	! 부정
3. 산술연산자 * / %		+	-
> 자바와 달리 자바스크립트에서 나눗셈은 실수형 나눗셈만 수행함.
자바에서 5 / 2 -> 2
자바에서 5 / 2.0 -> 5.0 / 2.0 -> 2.5 (자바스크립트는 나눗셈은 실수형으로만 수행함)
	
4. 관계연산자	<	<=	>	>=	==	!=
5. 논라연산자	&&	||
6. 조건연산자	(조건식) ? 참값	: 거짓값
   삼항연산자
	
	var num = 10;
	var result = (num == 10)? '같다' : '다르다';
	console.log(result);
	
7. 대입연산자	=	+=	-=	*=	/=	%=

---

자바스크립트에서의 배열나열 방법 : []

제어문 : 조건문, 반복문
	
	// 조건문		if	switch

반복문		for		while	do~while

자바에서의 for( : )문은 자바스크립트에선 for( of )문이다

---

함수 : 자주쓰는 실행문들을 기능단위로 정의한 것.
	  자바스크립트에서 함수정의는 브라우저에 의해 최우선적으로 메모리에 로딩됨

---

- GUI(Graphic User Interface) : 그래픽기반 유저 인터페이스
- 이벤트 : 사용자 또는 프로그램 자체적으로 발생시키는 사건.
			발생하면 특정 대상에 신호를 줌.
- 이벤트 핸들러 : 이벤트를 처리하는 함수 정의.
				신호를 받으면 연결된 함수의 명령문을 실행함.
- 이벤트 소스 : 이벤트가 발생된 대상 (버튼 등)
			  이벤트 핸들러를 등록하는 대상이 됨.
	
document 는 브라우저가 로딩한 문서정보를 가진 문서 객체이다.
	
**이벤트 종류**
- click / dblclick
- mousedown / mouseup / mouseover / mouseout / mousemove
- dragndrop
- keydown / keypress / keyup
- focus / blur / select / change

---

- window.open(새창에 보여질 주소, 창의 속성 또는 이름, 새로 띄어질 페이지의 모양)
- 이름을 지정해 주지 않으면 계속 새 창을 띄움

웹브라우저 객체 (내장객체)

window(브라우저)
- location(주소표시줄)
- history(뒤로가기, 앞으로가기, 새로고침)
- document(html문서) - html - head - body

window.멤버변수		window.opener 자신창을 띄운 부모창 참조
window.메소드()	window.open()	self.open()		open()
				window.close()	self.close()	close()

---
window - location 웹 문서의 주소 정보 저장
window 생략 가능
window.location.속성	href / protocol / hostname / port / host
window.location.메소드()	reload()	replace()

---

window - history : 방문정보 저장
		window 생략가능
			history.속성		length 갯수
			history.메소드()	back() 뒤로가기	forward() 앞으로가기
								go(-2) 뒤로2번가기	go(2) 앞으로2번가기

---
action -> b.jsp 변경
document.forms[0].action = 'b.jsp';
method -> get 변경
document.frm.method = 'get';
form submit 호출
document.frm.submit();

---
입력 요소(input 관련 태그)
window.document.frm
	 (앞에 생략가능) frm 
	
 	 frm.id.속성		type / name / value
 	 frm.id.메소드()	focus / blur() / select()

```javascript
frm.id.focus();  // 포커스 주기
// 		frm.id.blur();	 // 포커스 해제
// 		frm.id.select(); // 포커스를 주고 value값 선택
```

---
select에서 첫번째 option요소가 선택되면
		'학년을 선택하세요' 포커스 주기 return

```javascript		
if(frm.grade.selectedIndex == 0) {
	alert('학년을 선택하세요')
	frm.grade.focus();
	return;
}
```
---

- 배열 (가변크기. 자바의 리스트 컬렉션 개념)
- 객체 (가변크기. 자바의 맵 컬렉션 개념)
- 맵 : 키, 값 쌍

---
**프레임워크와 라이브러리의 차이점**
- 라이브러리: 우리 코드가 직접 사용하는 대상
- 프레임워크: 우리 코드가 라이브러리에 의해 사용되면 프레임워크로 부름.
 			 프레임워크의 코드 규칙대로 사용하게 됨.
		
jQuery 프론트엔트 프레임워크 
		
메소드 체이닝 지원
jQuery('선택자').메소드().메소드().메소드();
		
선택자 => 전체 *		태그명	아이디	클래스	선택자
		
jQuery('*').css('color', 'orange');
(위와 아래는 동일)
$('*').css('color', 'orange');

---
```javascript
$('태그명[속성="값"]') : 값일치
$('태그명[속성^="값"]') : 시작값
$('태그명[속성$="값"]')	: 끝값		
$('태그명[속성~="값"]')	: 값포함

$('태그명:first') : 태그명의 첫번째 요소
$('태그명:last') : 태그명의 마지막 요소
	
$('태그명:odd') : 태그명의 홀수번째 요소
$('태그명:even') : 태그명의 짝수번째 요소
```

val : value값 

---

속성을 다루는 함수		
- attr() : attribute. 웹디자이너 관점에서 사용
- prop() : property. 웹프로그래머 관점에서 사용

---

#app요소를 가지지 않는 div
$('div').not('#app').text('<h2>text method</h2>');

---

- append() : 뒤에 추가
- prepend() : 앞에 추가
	- html() 함수와 동일하게 html내용을 살려서 내용 추가해줌
```javascript
// h1문자열을 div#app에 추가
$(h1).appendTo('div#app');
```
---
- setInterval(함수정의, 밀리초) : 일정 간격으로 계속 실행. (1초 = 1000밀리초)
```javascript
intervalId = setInterval(function () {
	// $('div#app > img:first').appendTo('div#app');
	// 위와 아래는 동일하다
	$('div#app > img').first().appendTo('div#app');
```
이벤트가 연결된 자기 자신. 시작 버튼이 this가 됨
	$(this).prop('disabled', true); // true false나올땐 prop() 씀
---
**키보드 이벤트 종류**
- keydown
- keypress
- keyup
---

```javascript
// a 클릭		css()	background-color	blue
$('a').on('click', function(event) {
	$(this).css('background-color', 'blue')
	
// 현재 태그요소의 기본기능 막기(a태그의 하이퍼링크 기능 막기)
// 			event.preventDefault();
	
// 이벤트 전파 막기 (태그가 포함관계로 겹쳐있을 경우)
// 			event.stopPropagation();
	
	return false; // 기본기능과 이벤트 전파 모두 막기
});
```
---
```javascript
// 대상.mouseover(함수정의).mouseout(함수정의);
$('img.img1').mouseover(function () {
	$(this).attr('src', '../images/2.jpg');
}).mouseout(function() {
	$(this).attr('src', '../images/1.jpg');
});
```
```javascript
// 대상.on({});
$('img.img1').on({ // 요소들에 대한 구분 콤마(,)
	mouseover: function() {
		$(this).attr('src', '../images/2.jpg');
	},
	mouseout: function() {
		$(this).attr('src', '../images/1.jpg');
	}
});
```
```javascript
let str = $(this).serialize(); // 직렬화(데이터를 텍스트화)
```
---
- 제이쿼리 간단한 화면효과 함수
```javascript
// show()		hide()		toggle()
// slideDown()	slideUp()	slideToggle()
// fadeIn()		fadeOut()	fadeToggle()

// 제이쿼리에서 현재 태그 요소 기준으로 다른 태그 요소를 탐색하는 함수
// next() : 형제관계에서 바로 다음요소
// prev() : 형제관계에서 바로 이전요소
// find() : 포함하고 있는 자식 또는 자손요소를 찾기
// closest() : 자신을 포함하고 있는 부모 또는 조상요소를 찾기
```
- css를 한번에 처리하려면 객체로 처리. {key : value, ...} value엔 변수 값 사용 가능

- 제이쿼리 간단한 애니메이션 효과 함수 animate()
- animate() 함수는 CSS 속성을 값으로 넣어주면 적용됨
```javascript
$(this).animate({ width: width, height: height });
```




> javascript_study 정리하기
> jsp 옮긴 후 정리
> Dao, Vo 정리
> 안드로이드스튜디오 zip

