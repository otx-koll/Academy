
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;

public class BookList1 {
	// 1. 멤버변수
	Connection con;
	Statement stmt;
	ResultSet rs;
	
	// 2. 생성자
	public BookList1() {
		String url = "jdbc:oracle:thin:@localhost:1521:XE";
		String userid = "madang"; // 
		String pwd = "madang"; // 

		// 1. 드라이버 로드를 위한 (파일 안에 클래스 임포트)
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("드라이버 로드 성공");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		// 2. DB 연결(오라클)
		try {
			System.out.println("데이터베이스 연결 준비 .....");
			con = DriverManager.getConnection(url, userid, pwd);
			System.out.println("데이터베이스 연결 성공");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	// 3. 메소드
	public void sqlRun() { // 생성자
		String query = "SELECT * FROM book";
		try {
			stmt = con.createStatement(); // 2
			rs = stmt.executeQuery(query); // 3
			System.out.println("BOOK ID \tBOOK NAME \t\tPUBLISHER \tPRICE");
			while (rs.next()) {
				System.out.print("\t" + rs.getInt(1));
				System.out.print("\t" + rs.getString(2));
				System.out.print("\t\t" + rs.getString(3));
				System.out.println("\t" + rs.getInt(4));

			}
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

