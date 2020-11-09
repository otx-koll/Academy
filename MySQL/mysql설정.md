# MySQL 설정
- C드라이브에서 숨김파일 보이기 설정 후, `C:\ProgramData\MySQL\MySQL Server 8.0\my.ini`에서 설정 
```
[client]
default-character-set=utf8
[mysql]
default-character-set=utf8
[mysqld]
collation-server = utf8_unicode_ci
init-connect='SET NAMES utf8'
init_connect='SET collation_connection = utf8_general_ci'
character-set-server=utf8
```
- mysql 터미널 접속해서 utf8 설정 확인 : `show variables like 'c%';`
- root 아이디 허용이 안되어 있을시 세팅방법 : `C:\> mysql -u root -p`
```sql
GRANT ALL PRIVILEGES ON *.* TO 'root'@'%' IDENTIFIED BY 'root';
FLUSH PRIVILEGES;
```

## 데이터베이스 사용자 계정 생성
- 사용자계정명: myid / 패스워드: mypwd
```sql
GRANT ALL PRIVILEGES
ON sakila.* TO 'myid'@'localhost'
IDENTIFIED BY 'mypwd';
```
```sql
GRANT ALL PRIVILEGES
ON sakila.* TO 'myid'@'%'
IDENTIFIED BY 'mypwd';
```
+ 데이터베이스 jspdb사용자 계정 설정도 해준다
	+ 회원 테이블 생성
```sql
CREATE TABLE member (
	id VARCHAR(50) PRIMARY KEY,
	passwd VARCHAR(50) NOT NULL,
	name VARCHAR(50) NOT NULL,
	reg_date TIMESTAMP
);
```

## 테이블 수정
```sql
ALTER TABLE member
ADD age INT;
```
```sql
ALTER TABLE member
ADD gender VARCHAR(5);
```
```sql
ALTER TABLE member
ADD email VARCHAR(30);
```

```sql
DESC member; // member테이블의 상세 내역 출력
```
- default값 지정
```sql

```
## jspdb 스키마 생성
- jspdb 스키마 생성
```sql
CREATE SCHEMA jspdb;  // jspdb 스키마 생성
```

- myid에 jspdb 스키마 허용
```sql
GRANT ALL PRIVILEGES
ON jspdb.*TO 'myid'@'localhost';
```

- myid에 jspdb 스키마에 member 테이블 생성
```sql
CREATE TABLE member (
	id VARCHAR(50) PRIMARY KEY,
	passwd VARCHAR(50) NOT NULL,
	name VARCHAR(50) NOT NULL,
	reg_date TIMESTAMP
);
```

> 데이터베이스 선택 : use 테이블

## 자바에서 DB접속정보
```java
String dbUrl = "jdbc:mysql://localhost:3306/sakila?useUnicode=true&characterEncoding=utf8&allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=Asia/Seoul";
String dbId = "myid";
String dbPwd = "mypwd";
```

---
### 게시판 테이블 생성
```sql
CREATE TABLE board (
	num INT PRIMARY KEY,
	name VARCHAR(20),
	passwd VARCHAR(20),
	subject VARCHAR(50),
	content VARCHAR(2000),
	readcount INT,
	reg_date DATETIME,
	ip VARCHAR(20),
	file VARCHAR(50),
	re_ref INT,
	re_lev INT,
	re_seq INT
);
```
 - 우클릭후 alter 웅앵 클릭 -> reg_date Timestamp를 datetime으로 변경 후 nn 해제 및 값 null
---
> 추가된 항목
```sql
ALTER TABLE member
ADD address VARCHAR(100);
```
```sql
ALTER TABLE member
ADD tel VARCHAR(20);
```

* funweb 게시판 테이블
```sql
CREATE OR REPLACE TABLE notice (
	num INT PRIMARY KEY AUTO_INCREMENT,
	id VARCHAR(20),
	subject VARCHAR(50),
	content VARCHAR(2000),
	readcount INT,
	reg_date DATETIME,
	ip VARCHAR(20),
	re_ref INT,
	re_lev INT,
	re_seq INT
);
```
* funweb 첨부파일 테이블
```sql
CREATE TABLE attach (
	num 	   INT PRIMARY KEY AUTO_INCREMENT,
	filename   VARCHAR(1000),
	uploadpath VARCHAR(1000),
	image	   VARCHAR(5),
	no_num	   INT
);
```

* 특정 테이블의 AUTO_INCREMENT 컬럼 다음숫자 가져오기
```sql
SELECT AUTO_INCREMENT
FROM information_schema.tables
WHERE table_name = 'table name'
AND table_schema = DATABASE();
```
> query를 사용하다보면 insert시 다음 auto_increment값이 필요할 때가 있다.
> select LAST_INDERT_ID() 를 사용할 수도 있지만, LAST_INSERT_ID()는 table을 선택할 수 없다.
> 그래서 위의 query를 이용하면 다음 auto_increment의 값을 얻을 수 있다.