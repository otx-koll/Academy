id속성 지정
"@+id/형식으로 지정한다. /다음에는 새로 지정할 id를 적음
`android:id="@+id/btn1`의 의미 : 버튼 위젯의 아이디를 btn1로 부여한 것

match_parent : 자신의 부모에 폭이나 높이를 맞춤
wrap_content : 자신의 폭이나 높이를 자신 안의 글자가 들어갈 정도로만 설정

orientation 속성을 생략하면 LinearLayout이 horizontal(수평)이 된다. 대부분은 vertical정렬이다.

padding과 margin : `android:padding="30dp"` , `android:layout_margin="20dp"`


visibility : 위젯을 보일 것인지 여부를 설정
        - invisible : 칸은 차지하지만 보이지 않는 상태
        - visible : 보이는 상태
        - gone : 칸도 차지 하지 않고 보이지 않는 상태

enabled : 위젯의 동작 여부
    clickable : 클릭이나 터치가 가능하도록 함
    true와 false로 지정한다(default : true)

rotation : 위젯을 회전시켜서 출력. 값은 각도로 지정


텍스트뷰의 속성
    text : 텍스트뷰에 나타나는 문자열 표현
    textColor : 글자의 색상을 지정, rgb나 argb형식
    textSize : 글자의 크기를 dp, px, in, mm, sp 단위로 지정
    typeface : 글자의 글꼴을 지정
        - 값으로 sans, serif, monospace설정. default는 normal
    textStyle : 글자의 스타일을 지정
        - 값으로 bolid, italic, bolid|italic을 설정. default는 normal
    singleLine : 글이 길어 넘어갈 경우 강제로 한 줄만 출력. 문자열 맨 뒤에는 '...'표시
        - 값으로 true와 false를 설정할 수 있다. default는 false


mipmap : 폰 해상도에 맞춘 이미지들



