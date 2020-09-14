# WEB
## 웹의 역사
1989년 3월 스위스와 프랑스 사이에 위치한 유럽 입자 물리 연구소(CERN)의 소프트웨어 공학자인 __팀 버너스리__ 등의 제안으로 시작되어 연구 개발되었다. 원래는 세계의 여러 대학과 연구기관에서 일하는 물리학자들 상호간의 신속한 정보교환과 공동연구를 위해 고안되었다. 문자나 사진, 동영상, 음성 등이 조합된 데이터베이스의 사이트의 정보를 전용 열람용 소프트웨어인 웹 브라우저를 통해 볼 수 있다.



최초의 웹사이트
http://info.cern.ch/

## WEB 동작 방식
1. 사용자(Client)는 크롬, 엣지, 파이어폭스 등의 브라우저에 원하는 사이트의 주소(도메인 이름)를 입력하여 엔터
2. 컴퓨터는 도메인 이름 주소를 모르기 때문에 DNS 서버에서 Domain => IP address 변환
3. IP address 로 서버에 요청
4. 서버는 HTML CSS JavaScript 등의 웹사이트를 구현할수 있는 데이터를 가지고 브라우저에 전달
5. 브라우저는 HTML을 기반으로 웹사이트를 구현 (렌더링, rendering )

---
# HTML(Hyper Text Markup Language)
- 웹 문서의 구조를 정의하고 콘텐츠를 표현 하는 기본 형식의 언어

## HTML 구조
![html구조](https://user-images.githubusercontent.com/66901172/93051820-078b6e80-f6a0-11ea-965a-5bd9af892394.PNG)

- <!DOCTYPE html\> : html5문서를 선언
- <html\>...</html\> : html 문서의 시작과 끝
- <head\>...</head\>
	- <title\> : 문서의 상단 제목 표시
	- <meta\> : 문서의 정보 설정
		- <meta charset="UTF-8"> : UTF-8형식의 글자 인코딩 알려주는 정보
		- <meta name="viewport" content="width=device-width, initial-scale=1.0"> : 브라우저로 표시하는 기기(모바일 폰, PC등)의 화면 사이즈에 따라 맞추는 기능
	- <link\> : 태그 등 화면에 출력되지 않는 설정 작성
- <body\>...</body\> : 실제 화면에 나오는 콘텐츠 작성

> Ctrl + Shift + x -> live server 설치(라이브서버로 html문서 열면 저장할때마다 웹페이지 바로 수정됨)
