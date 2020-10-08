
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;

public class CustomerList {

	// 0. 멤버변수 4종류
	// 1) 변수
	int cusid;
	String name;
	String address;
	String phone;

	// 2) 배열
	int cusid_arr[];
	String name_arr[];
	String address_arr[];
	String phone_arr[];

	// 3) 객체
	Customer cus1;

	// 4) 객체 배열
	Customer cus1_arr[];

	// 1. 멤버변수
	Connection con;
	Statement stmt;
	ResultSet rs;

	// 2. 생성자 - 용도 : 배열 초기화
	public CustomerList() {
		// 2번 배열용 초기화
		cusid_arr = new int[5];
		name_arr = new String[5];
		address_arr = new String[5];
		phone_arr = new String[5];

		// 3번 객체용 초기화 cf)객체생성을 메소드(selectCustomerList)에서
		cus1 = new Customer(); // 1] 일반적인 방법

		// 4번 객체 배열용 초기화
		cus1_arr = new Customer[5];

		for (int i = 0; i < cus1_arr.length; i++) {
			cus1_arr[i] = new Customer();
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

	// 3.메소드1
	public void selectCustomerList() {
		String query = "SELECT * FROM customer";
		try {
			stmt = con.createStatement(); // 2
			rs = stmt.executeQuery(query); // 3
			System.out.println("고객 아이디 \t고객이름 \t주소 \t\t전화번호");

			int index = 0;
			while (rs.next()) {

				// (0). 변수 없음
//				System.out.print("\t" + rs.getInt(1));
//				System.out.print("\t" + rs.getString(2));
//				System.out.print("\t" + rs.getString(3));
//				System.out.println("\t" + rs.getString(4));

				// (1) 변수
//				cusid = rs.getInt(1);
//				name = rs.getString(2);
//				address = rs.getString(3);
//				phone = rs.getString(4);

				// (2) 배열
//				cusid_arr[index] = rs.getInt(1);
//				name_arr[index] = rs.getString(2);
//				address_arr[index] = rs.getString(3);
//				phone_arr[index] = rs.getString(4);
//				index++;

				// (3) 객체
				// 메소드를 통한 값 배정(초기화)
//				cus1.setCusid(rs.getInt(1));
//				cus1.setName(rs.getString(2));
//				cus1.setAddress(rs.getString(3));
//				cus1.setPhone(rs.getString(4));

//				cus1 = new Customer(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));

				// (4) 객체 배열
				cus1_arr[index].setCusid(rs.getInt(1));
				cus1_arr[index].setName(rs.getString(2));
				cus1_arr[index].setAddress(rs.getString(3));
				cus1_arr[index].setPhone(rs.getString(4));
				index++;
			}
//			con.close(); // db연결 닫음
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// 3. 메소드 - 화면 출력 메소드 1번 변수용
	public void printCustomer() {
		System.out.println("\t" + cusid + "\t" + name + "\t" + address + "\t" + phone + "\t");
	}

	// 3. 메소드 - 화면 출력 메소드 2번 배열용
	public void printCustomer_arr() {
		for (int i = 0; i < cusid_arr.length; i++) {
			System.out.println(
					"\t" + cusid_arr[i] + "\t" + name_arr[i] + "\t" + address_arr[i] + "\t" + phone_arr[i] + "\t");
		}
	}

	// 3. 메소드 - 화면 출력 메소드 3번 객체용 -> Customer 클래스 안으로 옮김
//	public void printCustomer_object() {
//		System.out.println("\t" + cusid + "\t" + name + "\t" + address + "\t" + phone + "\t");
//	}

	public void closeDB() {
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
