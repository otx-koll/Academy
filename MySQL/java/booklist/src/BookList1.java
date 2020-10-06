
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;

public class BookList1 {
	// 1. �������
	Connection con;
	Statement stmt;
	ResultSet rs;
	
	// 2. ������
	public BookList1() {
		String url = "jdbc:oracle:thin:@localhost:1521:XE";
		String userid = "madang"; // 
		String pwd = "madang"; // 

		// 1. ����̹� �ε带 ���� (���� �ȿ� Ŭ���� ����Ʈ)
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("����̹� �ε� ����");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		// 2. DB ����(����Ŭ)
		try {
			System.out.println("�����ͺ��̽� ���� �غ� .....");
			con = DriverManager.getConnection(url, userid, pwd);
			System.out.println("�����ͺ��̽� ���� ����");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	// 3. �޼ҵ�
	public void sqlRun() { // ������
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

//	public static void main(String args[]) { // �޼ҵ��̸鼭 ���α׷����࿡ ������
//		BookList so = new BookList();
//		so.sqlRun();
//	}
}

