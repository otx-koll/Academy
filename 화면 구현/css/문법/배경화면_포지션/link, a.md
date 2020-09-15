# list

## 리스트 관련 기본 스타일 속성 제거
```css
ul.myList, ol.myList{
    list-style: none;
    margin: 0px;
    padding: 0px;
}
```
## first-child / :last-child / :nth-child 선택자
- 
```css
ol.myList li:last-child{ /* 클래스가 myList인 ol태그의 마지막 자식 li */
    border-bottom: 0px;
}
.myList li:nth-child(2){ /* 클래스가 myList인 ol태그의 2번째 자식 li */
    color:blueviolet;
}
```

# a
- `href=#` : 현재 페이지
```css
<a href="#" target="_blank">Text Link</a>
```
- `:visited` : 링크를 방문한 후
```css
a:visited{
    color: pink;
}
```
- `:hover` : 링크에 마우스를 올렸을 때 
```css
a:hover{ 
    color: red;
    background-color: cyan;
}
```
- `:active` : 링크를 클릭했을 때 
```css
a:active{ 
    color: skyblue;
}
```
