
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;

public class CustomerList {
	// 1. 멤버변수
	Connection con;
	Statement stmt;
	ResultSet rs;

	// 3. 메소드- 연결(Connection)을 얻어온다
	public void getCon() {

		// url은 연결 문자열이다
		String url = "jdbc:oracle:thin:@localhost:1521:XE";
		/* 11g express edtion은 orcl 대신 XE를 입력 */
		String userid = "madang"; //
		String pwd = "madang"; //

		// 1. 드라이버 로드를 위한 (파일 안에 클래스 임포트)
		try { /* 드라이버를 찾는 과정 */
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("드라이버 로드 성공");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		// 2. DB 연결(오라클)
		try { /* 데이터베이스를 연결하는 과정 */
			System.out.println("데이터베이스 연결 준비 .....");
			// 1. db연결
			con = DriverManager.getConnection(url, userid, pwd);
			System.out.println("데이터베이스 연결 성공");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// 3. 메소드1
	public void selectBookList() { // 생성자
		String query = "SELECT * FROM book";
		try {
			stmt = con.createStatement(); // 2 // 쿼리 문장 날려보낼 수 있다
			rs = stmt.executeQuery(query); // 3 //
			System.out.println("BOOK ID \tBOOK NAME \t\tPUBLISHER \tPRICE");
			while (rs.next()) {
				System.out.print("\t" + rs.getInt(1));
				System.out.print("\t" + rs.getString(2));
				System.out.print("\t\t" + rs.getString(3));
				System.out.println("\t" + rs.getInt(4));

			}
//			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	// 3.메소드2
	public void selectCustomerList() {
		String query = "SELECT * FROM customer";
		try {
			stmt = con.createStatement(); // 2
			rs = stmt.executeQuery(query); // 3
			System.out.println("고객 아이디 \t고객이름 \t주소 \t\t전화번호");
			while (rs.next()) {
				System.out.print("\t" + rs.getInt(1));
				System.out.print("\t" + rs.getString(2));
				System.out.print("\t" + rs.getString(3));
				System.out.println("\t" + rs.getString(4));

			}
			
//			con.close(); // db연결 닫음
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void closeDB() {
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

//	public static void main(String args[]) { // 메소드이면서 프로그램실행에 관여함
//		BookList so = new BookList();
//		so.sqlRun();
//	}
}
