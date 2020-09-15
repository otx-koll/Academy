# float
- 정렬하기 위해 사용되는 속성
```css
none : 띄우지않음(default)
left : 왼쪽
right : 오른쪽
```
- clear : float를 해제하기 위한 속성
```css
none : 기본 값
left : float의 left속성 해제
right : float의 right 속성 해제
both : left, right 속성 둘 다 해제
```

# 화면 정가운데 박스의 정가운데 글자넣기
## 박스
```css
.box{
    width: 200px;
    height: 50px;
    border:2px solid white;
    color:white;
    
}
```
## 박스 내의 글자 가운데 정렬
1. 디스플레이를 flex로 바꾸고
2. align-items 세로 정렬 기준
3. justify-content 가로 정렬 기준
```css
.box{
    display: flex;
    align-items: center;
    justify-content: center;
}
```
## 화면 정가운데 넣기
1. 방법
```css
.center1{
    position: absolute;
    top:50%;
    left:50%;
    margin-top: -25px;
    margin-left: -100px;
    /* 잘 안쓰긴 함 */
}
```
2. 방법
```css
.center2{
    position: absolute;
    top:50%;
    left:50%;
    transform: translate(-50%, -50%);
    /* transform 이용 */
}
```
3. 방법
```css
flexbox 레이아웃
```
