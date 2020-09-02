## GUI(Graphical User Interface)
1. 목적
- 그래픽 이용, 사용자에게 이해하기 쉬운 모양으로 정보 제공
2. 특징
- 쉬운 GUI 프로그래밍, 강력한 GUI 컴포넌트 제공
3. GUI 프로그래밍 방법
- AWT - java.awt 패키지
- Swing - javax.swing 패키지

### AWT(Abstract  Windowing Toolkit)
- 자바가 처음 나왔을 때 함께 배포된 GUI 라이브러리
- native(peer) 운영체제의 GUI 컴포넌트의 도움을 받아 작동
- 운영체제에 많은 부담. 처리 속도는 빠르다

### Swing
- AWT 기술 기반으로 순수 자바 언어로 만들어진 라이브러리
- native(peer)운영체제에 의존하지 않는다
#### 특징
- 클래스 이름이 J로 시작
- 화려하고 다양한 컴포넌트로 쉽게 GUI 프로그래밍
#### 유형
1. JComponent는 상속받는 클래스
2. AWT 의 Container를 상속받는 몇 개의 클래스
`컴포넌트` 
- java.awt.Component를 상속받음
- 모든 스윙 컴포넌트는 javax.swing.JComponent를 상속받는다

### 스윙 GUI 만들기
1. 스윙 프레임 작성
2. main() 메소드 작성
3. 프레임에 스윙 컴포넌트 붙이기

- import java.awt.*; // 그래픽 처리를 위한 클래스들의 경로명
- import java.awt.event.*; // AWT 이벤트 사용을 위한 경로명
- import javax.swing.*; // 스윙 컴포넌트 클래스들의 경로명
- import javax.swing.event.*; // 스윙 이벤트를 위한 경로명

### 프레임에 컴포넌트 붙이기
타이틀 달기
```
public MyFrame(){ //생성자
	super("타이틀문자열"); // Jframe의 생성자 호출하여 타이틀 달기
	setTitle("타이틀문자열"); //메소드를 호출하여 타이틀 달기
}
```
컨텐트팬 알아내기
```
Containter contentPane = frame.getContentPane();
```
컨텐트팬에 컴포넌트 달기
```
Container c = frame.getContentPane();
JButton b = new JButton("Click");
c.add(b);
```
컨텐트팬 변경
```
JPanel p = new JPanel();
frame.setContentPane(p);
```

> 스윙 프로그램이 실행되는 동안 생성되는 스레드
- 메인 스레드와 이벤트 분배 스레드
> main() 종료 후에도 프레임이 살아 있는 이유
- 메인 스레드가 종료되어도 이벤트 분배 스레드가 살아 있어 프레임 화면을 그리고 마우스나 키 입력을 받기 때문에 프레임을 닫고 응용 프로그램을 종료시켜야 한다 그러기 위해서는 다음과 같은 문장을 적는다
`setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);`

---

## Container
- 다른 GUI 컴포넌트를 포함할 수 있는 컴포넌트
- java.awt.Container 상속

- 대표 유형 4가지
1. FlowLayout : 차례대로
2. BorderLayout : 동서남북가운데로 나뉘어져있음
3. GridLayout : 칸을 나누어 좌표로 지정
4. CardLayout : 카드처럼 겹쳐져 있음

- 컨테이너에 새로운 배치관리자 설정

ex) `Container.setLayout(new FlowLayout())` : flowlayout을 배치관리자로 지정

### FlowLayout
- 컨테이너 공간 내에 왼쪽에서 오른쪽으로 배치한다. 후엔 위에서 아래로 배치
- 생성자
```
FlowLayout()
FlowLayout(int align)
FlowLayout(int align, int hGap, int vGap)
- align : 컴포넌트 정렬 방법(왼쪽 정렬 FlowLayout.LEFT)
- hGap : 좌우 컴포넌트 사이 수평간격, 픽셀 단위
- vGap : 상하 컴포넌트 사이 수평간격, 픽셀 단위
```

### BorderLayout
- 컨테이너 공간을 5구역으로 분할 배치한다(East, West, South, North, Center)
- 생성자
```
void add(Component comp, int index) // comp 컴포넌트를 index위치에 삽입한다.
- comp : 컨테이너에 삽입되는 컴포넌트
- index : 컴포넌트 위치
```

ex) container.add(new JButton("div"), BorderLayout.WEST);

### GridLayout
- 컨테이너 공간을 동일한 사각형 격자(그리드)로 분할하고 각 셀에 하나의 컴포넌트 배치
- 생성자
```
GridLayout()
GridLayout(int rows, int cols)
GridLayout(int rows, int cols, int hGap, int vGap)
- rows : 그리드의 행 수
- cols : 그리드의 열 수
- hGap : 좌우 컴포넌트 사이의 수평 간격, 픽셀 단위
- vGap : 상하 컴포넌트 사이의 수직 간격, 픽셀 단위
```

### 배치관리자 없는 컨테이너
- 응용프로그램에서 컴포넌트의 절대 크기와 절대 위치 결정
- 컨테이너의 배치 관리자 제거 방법 `container.setLayout(null);`
- 절대 크기와 절대 위치 설정
	- 크기 설정 : component.setSize(int width, int height);
	- 위치 설정 : component.setLocation(int x, int y);
	- 위치와 크기 동시 설정 : component.setBounds(int x, int y, int width, int height);

#### 용도
- 컴포넌트의 크기나 위치를 개발자 임의로 결정하고자 하는 경우
- 게임 프로그램과 같이 시간이나 마우스/키보드 입력에 따라 컴포넌트들의 위치와 크기가 수시로 변하는 경우
- 여러 컴포넌트들이 서로 겹쳐 출력하고자 하는 경우
