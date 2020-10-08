
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;

public class BookList1 {

	// 0. 멤버변수를 만들건데 종류가 4종류가 있음
	// 1) 변수
	int bookid;
	String bookname;
	String publisher;
	int price;

	// 2) 배열
	int bookid_arr[];
	String bookname_arr[];
	String publisher_arr[];
	int price_arr[];

	// 3) 객체
	Book book1;

	// 4) 객체 배열
	Book book1_arr[];

	// 1. 멤버변수
	Connection con = null; // 멤버변수
	Statement stmt;
	ResultSet rs;

	// 2. 생성자 - 용도 : 배열 초기화
	public BookList1() {
		// 2번 배열용 초기화
		bookid_arr = new int[10];
		bookname_arr = new String[10];
		publisher_arr = new String[10];
		price_arr = new int[10];

		// 3번 객체용 초기화 cf)객체생성을 메소드(selectBookList)에서
		book1 = new Book(); // 1] 일반적인 방법

		// 4번 객체 배열용 초기화
		book1_arr = new Book[10];

		for (int i = 0; i < book1_arr.length; ++i) {
			book1_arr[i] = new Book();
		}
	}

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
			stmt = con.createStatement(); // 2
			rs = stmt.executeQuery(query); // 3
			System.out.println("BOOK ID \tBOOK NAME \t\tPUBLISHER \tPRICE");

			int index = 0;
			while (rs.next()) {

				// (0) 변수 없음
//				System.out.print("\t" + rs.getInt(1));
//				System.out.print("\t" + rs.getString(2));
//				System.out.print("\t\t" + rs.getString(3));
//				System.out.println("\t" + rs.getInt(4));

				// (1) 변수
//				bookid = rs.getInt(1);
//				bookname = rs.getString(2);
//				publisher = rs.getString(3);
//				price = rs.getInt(4);

//				printBook();

//				System.out.println(bookid + "\t" + bookname + "\t" + publisher + "\t" + price + "\t");

				// (2) 배열
//				bookid_arr[index] = rs.getInt(1);
//				bookname_arr[index] = rs.getString(2);
//				publisher_arr[index] = rs.getString(3);
//				price_arr[index] = rs.getInt(4);
//				index++;

				// (3) 객체
//				book1.bookid = rs.getInt(1);
//				book1.bookname = rs.getString(2);
//				book1.publisher = rs.getString(3);
//				book1.price = rs.getInt(4);

				// 메소드를 통한 값 배정(초기화)
//				book1.setBookid(rs.getInt(1));
//				book1.setBookname(rs.getString(2));
//				book1.setPublisher(rs.getString(3));
//				book1.setPrice(rs.getInt(4));

//				book1 = new Book(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4));
				
				// (4) 객체 배열
				book1_arr[index].setBookid(rs.getInt(1));
				book1_arr[index].setBookname(rs.getString(2));
				book1_arr[index].setPublisher(rs.getString(3));
				book1_arr[index].setPrice(rs.getInt(4));
				index++;
			}
//			con.close(); // db연결 닫음
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// 3. 메소드 - 화면 출력 메소드 1번 변수용
	public void printBook() {
		System.out.println("\t" + bookid + "\t" + bookname + "\t\t" + publisher + "\t\t" + price + "\t");
	}

	// 3. 메소드 - 화면 출력 메소드 2번 배열용
	public void printBook_arr() {
		for (int i = 0; i < bookid_arr.length; i++) {
			System.out.println("\t" + bookid_arr[i] + "\t" + bookname_arr[i] + "\t\t" + publisher_arr[i] + "\t\t"
					+ price_arr[i] + "\t");
		}
	}

	// 3. 메소드 - 화면 출력 메소드 3번 객체용 -> Book 클래스 안으로 옮김
//	public void printBook_object() {
//		System.out.println("\t" + book1.bookid + "\t" + book1.bookname + "\t\t" + book1.publisher + "\t\t" + book1.price + "\t");
//	}

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
