## 사용자 관리
### 사용자 생성
- CREATE USER문을 사용한다. 
- 기본 형식
```
CREATE USER 사용자 이름(필수)
IDENTIFIED BY 패스워드(필수)
DEFAULT TABLESAPCE 테이블 스페이스 이름(선택)
TEMPORARY TABLESPACE 테이블 스페이스(그룹) 이름(선택)
QUOTA 테이블 스페이스 크기 ON 테이블 스페이스 이름(선택)
PROFILE 프로파일 이름(선택)
PASSWORD EXPIRE(선택)
ACCOUNT [LOCK | UNLOCK](선택);
```

### 사용자 정보 조회
- ALL_XXXX
- USER_XXXX
- DBA_XXXX

### 사용자의 변경과 삭제
- 사용자 정보 변경할 때 ALTER USER문 사용
```
ALTER USER ORCLSTUDY
IDENTIFIED BY ORCL;
```
사용자 ORCLSTUDY의 비밀번호를 ORCL로 변경

- 사용자 삭제는 DROP USER문을 사용하여 삭제한다.
```
DROP USER 사용자 CASCADE
```
CASCADE는 객체도 삭제한다는 뜻이다.

## 권한 관리
### 시스템 권한 부여
```
GRANT [시스템 권한(예를들어 create, alter..) TO [사용자 이름/롤(Role)이름/PUBLIC]
[WITH ADMIN OPTION]
```
\[WITH ADMIN OPTION] : GRANT문을 통해 부여 받은 권한을 다른 사용자에게 부여할 수 있는 권한

### 시스템 권한 취소
```
REVOKE [시스템 권한] FROM [사용자 이름/롤(Role)이름/PUBLIC];
```

### 객체 권한 부여
```
GRANT [객체 권한/ALL PRIVILEGES]
ON [스키마.객체 이름]
TO [사용자 이름/롤(Role)이름/PUBLIC]
[WITH ADMIN OPTION];
```

### 객체 권한 취소
```
REVOKE [객체 권한/ALL PRIVILEGES]
ON [스키마.객체 이름]
FROM [사용자 이름/롤(Role)이름/PUBLIC](필수)
[CASCADE CONSTRAINTS/FORCE](선택);
```
