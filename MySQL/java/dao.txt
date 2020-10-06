# DAO(Data Access Object)
- 데이터를 조회(select), 추가(insert), 수정(update), 삭제(delete) 가능한 객체

## JDBC를 사용한 JSP와 데이터베이스 연동 확인
- 해당 DBMS의 드라이버를 등록한 후, getConnection()을 사용해 연결
- 연결에 문제 발생하면 Exception 발생
```	
public Connection getConnection() throws Exception { // throws : 어떤 예외가 발생하면 거기로 던짐 
	// DB접속정보
	String dbUrl = "jdbc:mysql://localhost:3306/sakila"; // 사용하려는 데이터베이스명을 포함한 URL 기술
	String dbId = "myid"; // 사용자 계정
	String dbPwd = "mypwd"; // 사용자 계정의 패스워드

	Connection con = null; // null로 초기화

	// 1단계. DB드라이버 클래스 로딩
	Class.forName("com.mysql.cj.jdbc.Driver"); //데이터베이스와 연동하기 위해 DriverManager에 등록
	// 2단계. DB에 연결 시도. 연결후 Connection객체를 리턴함.
	con = DriverManager.getConnection(dbUrl, dbId, dbPwd); // DriverManager 객체로부터 Connection 객체를 얻어온다
	
	return con;
} // getConnection()
```

## JDBC를 사용한 테이블에 레코드 추가, 수정, 삭제(insert, update, delete)
- JDBC를 사용하여 테이블에 쿼리를 실행하기 위해서 PreparedStatement 객체 사용
- insert, update, delete는 executeUpdate()를 호출하여 쿼리 실행






## Vo(Value Object)
- 데이터베이스 테이블 구조와 보통 일치하게 설계
- 값을 집어넣고 꺼내오는 작업

```java
private int actorId;
private String firstName;
private String lastName;

public ActorVo(String firstName, String lastName){
	this.firstName = firstName;
	this.lastName = lastName;
}
public int getActorId() {
		return actorId;
}
public void setActorId(int actorId) {
	this.actorId = actorId;
}
@Override
public String toString() {
	return "ActorVo [actorId=" + actorId + ", firstName=" + firstName + ", lastName=" + lastName + ", lastUpdate=" + lastUpdate + "]";
}
```