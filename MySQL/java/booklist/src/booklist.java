

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class booklist {
	Connection con;
	
	public booklist() {
		String url = "jdbc:oracle:thin:@localhost:1521:XE";
		/* 11g express edtion�� orcl ��� XE�� �Է� */
		String userid = "madang";
		String pwd = "madang";
		
		try { /* ����̹��� ã�� ���� */
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("����̹� �ε� ����");
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		try { /* �����ͺ��̽��� �����ϴ� ����  */
			System.out.println("�����ͺ��̽� ���� �غ� ...");
			con = DriverManager.getConnection(url, userid, pwd);
			System.out.println("�����ͺ��̽� ���� ����");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	private void sqlRun() {
		String query = "SELECT * FROM Book";
		try {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			System.out.println("BOOK NO \tBOOK NAME \t\t{IBLISHER \tPRICE");
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
	
	public static void main(String[] args) {
		booklist so = new booklist();
		so.sqlRun();
	}
}
