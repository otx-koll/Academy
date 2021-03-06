## CREATE
- 테이블을 구성하고, 속성과 속성에 관한 제약을 정의하며, 기본키 및 외래키를 정의하는 명령
- PRIMARY KEY는 기본키를 정할 때 사용
- FOREIGN KEY는 외래키를 지정할 때 사용
- ON UPDATE와 ON DELETER는 외래키 속성의 수정과 투플 삭제 시 동작을 나타냄
- 기본 문법
```sql
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
### 테이블 복사
```sql
CREATE TABLE DEPT3
AS
SELECT * FROM DEPT2;
```
DEPT2테이블에서 내용을 복사하여 DEPT3테이블을 만든다.

- 원하는 내용만 가져와서 복사
```sql
CREATE TABLE DEPT4
AS
SELECT DCODE, DNAME FROM DEPT2;
```
DEPT2테이블의 DCODE, DNAME만 복사하여 DEPT4테이블을 만든다.

-구조만 복사
```sql
CREATE TABLE DEPT5
AS
SELECT * FROM DEPT2
WHERE 1 = 2;
```
조건을 거짓으로 하면 구조만 가져올 수 있다.

- 원하는 구조에 값만 가져와서 만들기
```sql
CREATE TABLE DEPT6
AS
SELECT DCODE
     , DNAME
FROM DEPT2
WHERE DCODE IN (1000, 1001, 1002);
```
DEPT2에서 DCODE의 값이 1000, 1001, 1002인 DCODE, DNAME구조만 가져와 DEPT6테이블을 만든다.

## ALTER
- 테이블의 속성과 속성에 관한 제약을 변경할 수 있다.
- ADD, DROP은 속성을 추가하거나 제거할 때
- MODIFY는 속성의 기본값을 설정하거나 삭제할 때
- 기본문법
```sql
ALTER TABLE 테이블이름
ADD 속성이름 데이터타입
DROP COLUMN 속성이름
MODIFY 속성이름 데이터타입
MODIFY 속성이름 [NULL | NOT NULL]
ADD PRIMARY KEY(속성이름)
[ADD | DROP] 제약이름
```
### 데이터 추가
```sql
ALTER TABLE DEPT6
ADD(LOCATION2 VARCHAR2(10) DEFAULT 'SEOUL');
```
DEPT6테이블에 LOCATION2 컬럼을 추가하고 유형은 VARCHAR2(10)이다. 기본값은 'SEOUL'

### 변경
- 컬럼이름 변경
```sql
ALTER TABLE DEPT6
RENAME COLUMN LOCATION2 TO LOC;
```
RENAME COLUMN(칼럼을 바꾼다) LOCATION2를 LOC로 바꾼다.

테이블 명을 바꿀 땐 RENAME 테이블 TO 변경할이름

- 속성값 변경
```sql
ALTER TABLE NEW_EMP2
MODIFY(EMPNO NUMBER(7));
```
EMPNO의 속성값을 NUMBER(7)로 바꿈

### 삭제
```sql
ALTER TABLE DEPT7
DROP COLUMN LOC;
```
DEPT7 테이블의 LOC 컬럼을 삭제



## Drop
- 테이블을 삭제하는 명령
- 테이블의 구조와 데이터를 모두 삭제하므로 주의해야한다
- 데이터만 삭제하려면 DELETE문 사용
- 기본 문법
```sql
DROP TABLE 테이블이름
```

### 예제
1-1. NEWBOOK 테이블을 생성하시오. 정수형은 NUMBER를, 문자형은 가변형 문자 타입인 VARCHAR2를 사용한다
- BOOKID(도서번호) - NUMBER, 기본키 지정
- BOOKNAME(도서이름) - VARCHAR2(20)
- PUBLISHER(출판사) - VARCHAR2(20)
- PRICE(가격) - NUMBER
```sql
CREATE TABLE NEWBOOK(
BOOKID NUMBER,
BOOKNAME VARCHAR2(20),
PUBLISHER VARCHAR2(20),
PRICE NUMBER,
PRIMARY KEY(BOOKID)
)
```
1-2. BOOKID속성이 없어서 두 개의 속성 BOOKNAME, PUBLISHER가 기본키가 되면 괄호로 복합키 지정
```sql
CREATE TABLE NEWBOOK(
BOOKNAME VARCHAR2(20),
PUBLISHER VARCHAR2(20),
PRICE NUMBER,
PRIMARY KEY(BOOKNAME, PUBLISHER)
)
```
1-3. BOOKNAME은 NULL값을 가질 수 없고, PUBLISHER는 같은 값이 있으면 안된다. PRICE에 값이 입력되지 않을 경우 기본 값 10000을 저장한다. 또 가격은 최소 1000원 이상으로 한다.
```sql
CREATE TABLE NEWBOOK(
BOOKNAME VARCHAR(20) NOT NULL,
PUBLISHER VARCHAR2(20) UNIQUE,
PRICE NUMBER DEFAULT 10000 CHECK(PRICE > 1000),
PRIMARY KEY(BOOKNAME, PUBLISHER)
)
```
2. 다음과 같은 속성을 가진 NEWCUSTOMER 테이블을 생성하시오
- CUSTID(고객번호) - NUMBER, 기본키
- NAME(이름) - VARCHAR2(40)
- ADDRESS(주소) - VARCHAR2(40)
- PHONE(전화번호) - VARCHAR2(30)
```sql
CREATE TABLE NEWCUSTOMER(
CUSTID NUMBER PRIMARY KEY,
NAME VARCHAR2(40),
ADDRESS VARCHAR2(40),
PHONE VARCHAR2(30)
)
```
3. 다음과 같은 속성을 가진 NEWORDERS 테이블을 생성하시오
- ORDERID(주문번호) - NUMBER, 기본키
- CUSTID(고객번호) - NUMBER, NOT NULL 제약조건, 외래키(NewCustomer.custid,연쇄삭제)
- BOOKID(도서번호) - NUMBER, NOT NULL 제약조건
- SALEPRICE(판매가격) - NUMBER
- ORDERDATE(판매일자) - DATE
```sql
CREATE TABLE NEWORDERS(
ORDERID NUMBER,
CUSTID NUMBER NOT NULL,
BOOKID NUMBER NOT NULL,
SALEPRICE NUMBER,
ORDERDATE DATE,
PRIMARY KEY(ORDERID),
FOREIGN KEY(CUSTID)REFERENCES NEWCUSTOMER(CUSTID) ON DELETE CASCADE
)
```
