# CSS (Cascading Style Sheets)
- 스타일을 관리하기 쉽게 하나로 모아놓은 것
## CSS를 사용하는 이유
- 많은 수의 웹페이지를 동시에 관리할 수 있다.
- 웹 사이트의 스타일을 일관성 있게 유지 (유지보수 쉬워짐)
- 다양한 기기에 맞추어 반응하는 문서 만들 수 있음

## 주석
- \/* 주석 */

## CSS 적용 방법
1. 인라인 스타일 방법
- HTML 태그의 style 속성에 CSS코드를 넣는 방법
```html
<div style="color:red; font-size:20px;">내용</div>
style="속성1:속성값1; 속성2:속성값2; "형태
```

2. 내부 스타일 시트
- HTML 문서 안의 <head>섹션에 <style>과 </style> 안에 CSS 코드를 넣는 방법
```html
<style>
        body {background-color: beige;}
</style>
```

3. 외부 스타일 시트
- 별도의 CSS 파일 만들고 HTML문서와 연결하는 방법
```html
<head>
<link rel="stylesheet" href="style.css">
<head>
```

## CSS 문법
![css문법](https://user-images.githubusercontent.com/66901172/93038940-3ba36700-f681-11ea-8bef-35ec005c49aa.PNG)


