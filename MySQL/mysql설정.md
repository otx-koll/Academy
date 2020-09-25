# MySQL 설정

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
IDENIFIED BY 'mypwd';
```
```sql
GRANT ALL PRIVILEGES
ON sakila.* TO 'myid'@'%'
IDENTIFIED BY 'mypwd';
```
+ 데이터베이스 jspdb사용자 계정 설정도 해준다
	+ 회원 테이블 생성
```sql
CREATE TABLE memeber (
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