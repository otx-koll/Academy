# Grid
- CSS의 레이아웃
- 플렉스박스와 유사
- 이차원 레이아웃으로 아이템들을 배치
- align-items와 justify-content 사용 가능

## grid 만들기
```css
.grid{
    display: grid;
    grid-template-columns: repeat(4, 1fr);
    /* 갭 : grid간의 간격 */
    /* 갭 가로/세로 */
    gap: 10px;
}
```
- `display : grid` : 틀 만들기
- `grid-template-columns` : 열 만들기
- `grid-template-rows` : 행 만들기

### 옵션
```css
auto : 화면 크기에 따라 변경 
repeat(횟수, 사이즈)
fr : 비율
auto-fit(fill)
grid-auto-rows
```

### 병합
```css
.item:first-child{
    grid-column: 1/4;
    grid-row: 1/3;
}
```
- `grid-column: 시작/끝;` : 시작부터 끝라인까지 병합
- `grid-row: 시작/끝;` : 시작부터 끝라인까지 병합

---
## 파비콘(Favicon)
- 인터넷 웹 브라우저의 주소창에 표시되는 웹사이트나 웹페이지를 대표하는 아이콘

### 사용방법
```css
 <link rel="shortcut icon" href="사진주소" type="image/x-icon">
```
