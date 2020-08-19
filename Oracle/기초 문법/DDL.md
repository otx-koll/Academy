### CREATE
- 테이블을 구성하고, 속성과 속성에 관한 제약을 정의하며, 기본키 및 외래키를 정의하는 명령
- PRIMARY KEY는 기본키를 정할 때 사용
- FOREIGN KEY는 외래키를 지정할 때 사용
- ON UPDATE와 ON DELETER는 외래키 속성의 수정과 투플 삭제 시 동작을 나타냄
- 기본 문법
```
CREATE TABLE 테이블이름
({속성이름 데이터타입
  [NOT NULL | UNIQUE | DEFAULT 기본값 | CHECK 체크조건]
  }
  [PRIMARY KEY 속성이름]
  {[FOREIGN KEY 속성이름 REFERENCES 테이블이름(속성이름]
    [ON DELETE [CASCADE | SET NULL]
  }
)
```
#### 예제
NEWBOOK 테이블을 생성하시오. 정수형은 NUMBER를, 문자형은 가변형 문자 타입인 VARCHAR2를 사용한다
- BOOKID(도서번호) - NUMBER, 기본키 지정
- BOOKNAME(도서이름) - VARCHAR2(20)
- PUBLISHER(출판사) - VARCHAR2(20)
- PRICE(가격) - NUMBER
```
CREATE TABLE NEWBOOK(
BOOKID NUMBER,
BOOKNAME VARCHAR2(20),
PUBLISHER VARCHAR2(20),
PRICE NUMBER,
PRIMARY KEY(BOOKID)
)
```
