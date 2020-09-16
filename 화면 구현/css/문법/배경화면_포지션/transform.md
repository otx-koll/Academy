# transform
- 요소에 회전, 크기 조절, 기울이기, 이동 효과를 부여할 수 있다
- 시각적 서식 모델의 좌표 공간을 변경

```css
.container{
    transform: translate(100px, 50%);
    transform: scale(2, 0.5);
    transform: rotate(0.5turn);
}
```
- translate(가로, 세로) : 위치
- scale(가로, 세로) : 크기
- rotate(n turn) : 얼마나 돌릴건지

## transition
- 효과를 추가하려는 css 속성
- 효과의 지속시간
```css
.container img {
    transition: all 0.3s;
}
```
