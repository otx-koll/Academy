## position
- 문서 상에 요소를 배치하는 방법
1. static : 일반적인 문서 흐름에 따라 배치. 기본값
2. relative : 상대좌표 / 원래 위치에서 top, left, right, bottom으로 이동
3. absolute : 절대좌표 / 상위부모의 포지션이 static(기본)이 아닐때 부모의 좌표에서 이동 
4. fixed : 화면을 기준으로 고정
```css
.relative{
    position: relative;
    top:15px;
    left:25px;
}
.absoulte{
    position: absolute;
    top:50%;
    left:30px;
}
.fixed{
    position: fixed;
    bottom: 20px;
    right:20px;
}
```
## z-index, opacity
- z-index : 값이 크면 작은 요소보다 위에 쌓임
- opacity : 투명도(1일때 불투명 0일때 투명)
```css
span{
    opacity: 0.9;
}
.red{
    z-index: 10;
    top:20px;
    left:80px;
    background: red;
}
.green{
    z-index: 2;
    top:80px;
    left:20px;
    background: green;
}
.blue{
    z-index: 1;
    top:100px;
    left:100px;
    background: blue;
}
```
