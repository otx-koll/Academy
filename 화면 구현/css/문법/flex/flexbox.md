# Flexbox 레이아웃
- float 를 대체하며 더 효율적인 사용 가능
- 가로 세로로 아이템 정렬

## display
```css
.container{
  display:flex;
}
```
## flex-direction
- flex의 방향. row인지 column인지
```css
.container{
  flex-direction: row | row-reverse | column | column-reverse;
}
```

## flex-wrap
```css
.container{
  flex-wrap: nowrap | wrap | wrap-reverse;
}
```
- nowrap(default) : 모든 아이템들을 한줄로
- wrap : 위에서 아래로 여러줄로 나열
- wrap-reverse : 아래에서 위로 여러줄로 나열

## justify-content
- 아이템들의 정렬 방법
```css
.container{
  justify-content : flex-start | flex-end | center | space-between | space-around | space-evenly;
}
```
![justify-content](https://user-images.githubusercontent.com/66901172/93212127-24599c00-f79d-11ea-9908-a907aea9457e.JPG)

## align-items
```css
.container{
  align-items : stretch | flex-start | flex-end | center | baseline;
}
```
![align-itmes](https://user-images.githubusercontent.com/66901172/93212388-80bcbb80-f79d-11ea-838c-eecf222ee992.JPG)

## align-content
```css
.container{
  align-content: flex-start | flex-end | center | space-between | space-around | stretch;
}
```
![align-content](https://user-images.githubusercontent.com/66901172/93212137-258ac900-f79d-11ea-82ea-b8f50ad04bf2.JPG)

## order
```css
.item{
  order : <integer>; /* default is 0 */
}
```
![order](https://user-images.githubusercontent.com/66901172/93212138-26235f80-f79d-11ea-99a4-a336588613f4.JPG)


## flex-grow
- 숫자만큼 비율로 화면분할 (음수일 때 최소 공간)
```css
.item{
  flex-grow: <number>; /* default 0 */
}
```

## flex-shrink
- 화면이 줄어들 때 높은 숫자의 비율로 줄어듦. 음수일 때 줄어들지 않음
```css
.item{
  flex-shrink: <number>; /* default 1 */
}
```

## flex-basis
- 0일때 빈공간을 차지하지 않고 auto일때 flex-grow 숫자 비율로 공간 차지
```css
.item{
  flex-basis: <length> | auto; /* default auto */
}
```

## align-self
- 아이템 중 하나의 요소만 따로 정렬하는 방법
```css
.item{
  align-self: auto | flex-start | flex-end | center | baseline | stretch;
}
```
