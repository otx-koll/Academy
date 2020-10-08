
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;

public class BookList1 {

	// 0. ��������� ����ǵ� ������ 4������ ����
	// 1) ����
	int bookid;
	String bookname;
	String publisher;
	int price;

	// 2) �迭
	int bookid_arr[];
	String bookname_arr[];
	String publisher_arr[];
	int price_arr[];

	// 3) ��ü
	Book book1;

	// 4) ��ü �迭
	Book book1_arr[];

	// 1. �������
	Connection con = null; // �������
	Statement stmt;
	ResultSet rs;

	// 2. ������ - �뵵 : �迭 �ʱ�ȭ
	public BookList1() {
		// 2�� �迭�� �ʱ�ȭ
		bookid_arr = new int[10];
		bookname_arr = new String[10];
		publisher_arr = new String[10];
		price_arr = new int[10];

		// 3�� ��ü�� �ʱ�ȭ cf)��ü������ �޼ҵ�(selectBookList)����
		book1 = new Book(); // 1] �Ϲ����� ���

		// 4�� ��ü �迭�� �ʱ�ȭ
		book1_arr = new Book[10];

		for (int i = 0; i < book1_arr.length; ++i) {
			book1_arr[i] = new Book();
		}
	}

	// 3. �޼ҵ�- ����(Connection)�� ���´�
	public void getCon() {

		// url�� ���� ���ڿ��̴�
		String url = "jdbc:oracle:thin:@localhost:1521:XE";
		/* 11g express edtion�� orcl ��� XE�� �Է� */
		String userid = "madang"; //
		String pwd = "madang"; //

		// 1. ����̹� �ε带 ���� (���� �ȿ� Ŭ���� ����Ʈ)
		try { /* ����̹��� ã�� ���� */
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("����̹� �ε� ����");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		// 2. DB ����(����Ŭ)
		try { /* �����ͺ��̽��� �����ϴ� ���� */
			System.out.println("�����ͺ��̽� ���� �غ� .....");
			// 1. db����
			con = DriverManager.getConnection(url, userid, pwd);
			System.out.println("�����ͺ��̽� ���� ����");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// 3. �޼ҵ�1
	public void selectBookList() { // ������
		String query = "SELECT * FROM book";
		try {
			stmt = con.createStatement(); // 2
			rs = stmt.executeQuery(query); // 3
			System.out.println("BOOK ID \tBOOK NAME \t\tPUBLISHER \tPRICE");

			int index = 0;
			while (rs.next()) {

				// (0) ���� ����
//				System.out.print("\t" + rs.getInt(1));
//				System.out.print("\t" + rs.getString(2));
//				System.out.print("\t\t" + rs.getString(3));
//				System.out.println("\t" + rs.getInt(4));

				// (1) ����
//				bookid = rs.getInt(1);
//				bookname = rs.getString(2);
//				publisher = rs.getString(3);
//				price = rs.getInt(4);

//				printBook();

//				System.out.println(bookid + "\t" + bookname + "\t" + publisher + "\t" + price + "\t");

				// (2) �迭
//				bookid_arr[index] = rs.getInt(1);
//				bookname_arr[index] = rs.getString(2);
//				publisher_arr[index] = rs.getString(3);
//				price_arr[index] = rs.getInt(4);
//				index++;

				// (3) ��ü
//				book1.bookid = rs.getInt(1);
//				book1.bookname = rs.getString(2);
//				book1.publisher = rs.getString(3);
//				book1.price = rs.getInt(4);

				// �޼ҵ带 ���� �� ����(�ʱ�ȭ)
//				book1.setBookid(rs.getInt(1));
//				book1.setBookname(rs.getString(2));
//				book1.setPublisher(rs.getString(3));
//				book1.setPrice(rs.getInt(4));

//				book1 = new Book(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4));
				
				// (4) ��ü �迭
				book1_arr[index].setBookid(rs.getInt(1));
				book1_arr[index].setBookname(rs.getString(2));
				book1_arr[index].setPublisher(rs.getString(3));
				book1_arr[index].setPrice(rs.getInt(4));
				index++;
			}
//			con.close(); // db���� ����
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// 3. �޼ҵ� - ȭ�� ��� �޼ҵ� 1�� ������
	public void printBook() {
		System.out.println("\t" + bookid + "\t" + bookname + "\t\t" + publisher + "\t\t" + price + "\t");
	}

	// 3. �޼ҵ� - ȭ�� ��� �޼ҵ� 2�� �迭��
	public void printBook_arr() {
		for (int i = 0; i < bookid_arr.length; i++) {
			System.out.println("\t" + bookid_arr[i] + "\t" + bookname_arr[i] + "\t\t" + publisher_arr[i] + "\t\t"
					+ price_arr[i] + "\t");
		}
	}

	// 3. �޼ҵ� - ȭ�� ��� �޼ҵ� 3�� ��ü�� -> Book Ŭ���� ������ �ű�
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

//	public static void main(String args[]) { // �޼ҵ��̸鼭 ���α׷����࿡ ������
//		BookList so = new BookList();
//		so.sqlRun();
//	}
}
