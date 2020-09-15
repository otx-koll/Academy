# 배경
```css
body {
    background:
        url("img/bg1.jpg") /* image */
        no-repeat /* 초기값 repeat(사이즈에 맞춰서 반복) */
        center /* position */
        center /* size */
        /* center/80% : 중앙 배치 및 크기 조절 */
        fixed; /* attachment */
    background-size: cover; /* 사이즈를 전체 화면에 덮어줌 */
}
```
- position 종류 : left top, right top, right center etc...

## 그라데이션
- to bottom : 위 -> 아래로 그라데이션(기본값)
- to top : 아래 -> 위
- to left : 오 -> 왼
- to right : 왼 -> 오
- ndeg : n도의 방향으로
```css
.bg3{
    height:100vh;
    background: linear-gradient(45deg, red, blue);
}
```
---
# 보더
```css
border:<border-width> || <border-style> || <color>
```
## 박스 모서리 둥글게
```css
border-radius:<라운드 px>;
border-raidus:왼위, 오른위, 오른아래, 왼아래;
```
ex
```css
.three{
    border-radius: 5px 10px 15px 20px; /
    border: 3px solid yellowgreen;
}
```

## box-shadow : 요소의 테두리를 감싼 그림자 효과 추가
- offset-x | offset-y | blur-radius | color
```css
box-shadow: 10px 5px 5px red;
```

## box-sizing : 가로 세로 길이 기준을 정함
- `box-sizing: border-box;`
- `box-sizing: content-box;`(default)
- `box-sizing: padding-box;`
```css
body{
    /* 초기화 : 패딩 마진 0px, 보더박스 설정 */
    padding: 0px;
    margin: 0px;
    box-sizing: border-box;
    
    /* 폰트 사이즈를 2배로 */
    font-size:2em;
}
```
