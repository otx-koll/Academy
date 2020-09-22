package java0921;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;

public class Ex3 {

	public static void main(String[] args) {
		// DB접속정보
		String dbUrl = "jdbc:mysql://localhost:3306/sakila?useUnicode=true&characterEncoding=utf8&allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=Asia/Seoul";
		String dbId = "myid";
		String dbPwd = "mypwd";

		String sql = "";
		
		// SELECT문 실행에 필요한 JDBC 객체 3가지(자바와 데이터베이스 간의 연결 JDBC)
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			// 1단계. DB드라이버 클래스 로딩
			Class.forName("com.mysql.cj.jdbc.Driver");
			// 2단계. DB에 연결 시도. 연결 후 Connection객체를 리턴함.
			con = DriverManager.getConnection(dbUrl, dbId, dbPwd);
			
			// 3단계. sql문장객체 준비
			sql = "SELECT * FROM actor WHERE first_name LIKE 'B%' ORDER BY actor_id DESC";
			pstmt = con.prepareStatement(sql);
			// 실행 후 select결과를 ResultSet으로 받음
			rs = pstmt.executeQuery(); // SELECT문 수행 시 호출
			
			// 4단계. ResultSEt 데이터 꺼내서 사용
			while(rs.next()) {
				int actorId = rs.getInt("actor_id");
				String firstName = rs.getString("first_name");
				String lastName = rs.getString("last_name");
				Timestamp lastUpdate = rs.getTimestamp("last_update");
				
				System.out.print(actorId + "\t");
				System.out.print(firstName + "\t");
				System.out.print(lastName + "\t");
				System.out.print(lastUpdate);
				System.out.println();
			} // while
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
