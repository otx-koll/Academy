package java0922;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

// select, insert, update, delete sql문 수행 기능

public class ActorDao {

	public List<ActorVo> getActors() {
		List<ActorVo> list = new ArrayList<>();

		// DB접속정보
		String dbUrl = "jdbc:mysql://localhost:3306/sakila?useUnicode=true&characterEncoding=utf8&allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=Asia/Seoul";
		String dbId = "myid";
		String dbPwd = "mypwd";

		// SELECT문 실행에 필요한 JDBC 객체 3가지
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "";

		try {
			// 1단계. DB드라이버 클래스 로딩
			Class.forName("com.mysql.cj.jdbc.Driver");
			// 2단계. DB에 연결 시도. 연결후 Connection객체를 리턴함.
			con = DriverManager.getConnection(dbUrl, dbId, dbPwd);

			// 3단계. sql문장객체 준비
			sql = "SELECT * FROM actor ORDER BY actor_id DESC";
			pstmt = con.prepareStatement(sql);
			// 실행 후 select결과를 ResultSet으로 받음
			rs = pstmt.executeQuery(); // SELECT문 수행시 호출함.

			// 4단계. ResultSet 데이터 꺼내서 사용
			while (rs.next()) {
				ActorVo actorVo = new ActorVo();
				actorVo.setActorId(rs.getInt("actor_id"));
				actorVo.setFirstName(rs.getString("first_name"));
				actorVo.setLastName(rs.getString("last_name"));
				actorVo.setLastUpdate(rs.getTimestamp("last_update"));

				list.add(actorVo);
			} // while
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	} // getActors()

	public ActorVo getActorById(int actorId) {
		ActorVo actorVo = null;

		// DB접속정보
		String dbUrl = "jdbc:mysql://localhost:3306/sakila?useUnicode=true&characterEncoding=utf8&allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=Asia/Seoul";
		String dbId = "myid";
		String dbPwd = "mypwd";

		// SELECT문 실행에 필요한 JDBC 객체 3가지
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "";

		try {
			// 1단계. DB드라이버 클래스 로딩
			Class.forName("com.mysql.cj.jdbc.Driver");
			// 2단계. DB에 연결 시도. 연결후 Connection객체를 리턴함.
			con = DriverManager.getConnection(dbUrl, dbId, dbPwd);

			// 3단계. sql문장객체 준비
			sql = "SELECT * FROM actor WHERE actor_id = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, actorId);

			// 실행 후 select결과를 ResultSet으로 받음
			rs = pstmt.executeQuery(); // SELECT문 수행시 호출함.

			// 4단계. ResultSet 데이터 꺼내서 사용
			if (rs.next()) {
				actorVo = new ActorVo();
				actorVo.setActorId(rs.getInt("actor_id"));
				actorVo.setFirstName(rs.getString("first_name"));
				actorVo.setLastName(rs.getString("last_name"));
				actorVo.setLastUpdate(rs.getTimestamp("last_update"));
			} // while
		} catch (Exception e) {
			e.printStackTrace();
		}
		return actorVo;
	}

	public static void main(String[] args) {

		ActorDao actorDao = new ActorDao();

		List<ActorVo> list = actorDao.getActors();

		for (ActorVo actorVo : list) {
			System.out.println(actorVo.toString());
		}

		System.out.println("요소의 갯수: " + list.size());

		System.out.println("========================");

		ActorVo actorVo1 = actorDao.getActorById(203);
		System.out.println("actorVo1 : " + actorVo1);

		ActorVo actorVo2 = actorDao.getActorById(204);
		System.out.println("actorVo2 : " + actorVo2);

		if (actorVo2 == null) {

		} else { // actorVo2 != null

		}

	} // main

} // class ActorDao
