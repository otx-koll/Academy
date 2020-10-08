
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;

public class CustomerList {

	// 0. ������� 4����
	// 1) ����
	int cusid;
	String name;
	String address;
	String phone;

	// 2) �迭
	int cusid_arr[];
	String name_arr[];
	String address_arr[];
	String phone_arr[];

	// 3) ��ü
	Customer cus1;

	// 4) ��ü �迭
	Customer cus1_arr[];

	// 1. �������
	Connection con;
	Statement stmt;
	ResultSet rs;

	// 2. ������ - �뵵 : �迭 �ʱ�ȭ
	public CustomerList() {
		// 2�� �迭�� �ʱ�ȭ
		cusid_arr = new int[5];
		name_arr = new String[5];
		address_arr = new String[5];
		phone_arr = new String[5];

		// 3�� ��ü�� �ʱ�ȭ cf)��ü������ �޼ҵ�(selectCustomerList)����
		cus1 = new Customer(); // 1] �Ϲ����� ���

		// 4�� ��ü �迭�� �ʱ�ȭ
		cus1_arr = new Customer[5];

		for (int i = 0; i < cus1_arr.length; i++) {
			cus1_arr[i] = new Customer();
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

	// 3.�޼ҵ�1
	public void selectCustomerList() {
		String query = "SELECT * FROM customer";
		try {
			stmt = con.createStatement(); // 2
			rs = stmt.executeQuery(query); // 3
			System.out.println("�� ���̵� \t���̸� \t�ּ� \t\t��ȭ��ȣ");

			int index = 0;
			while (rs.next()) {

				// (0). ���� ����
//				System.out.print("\t" + rs.getInt(1));
//				System.out.print("\t" + rs.getString(2));
//				System.out.print("\t" + rs.getString(3));
//				System.out.println("\t" + rs.getString(4));

				// (1) ����
//				cusid = rs.getInt(1);
//				name = rs.getString(2);
//				address = rs.getString(3);
//				phone = rs.getString(4);

				// (2) �迭
//				cusid_arr[index] = rs.getInt(1);
//				name_arr[index] = rs.getString(2);
//				address_arr[index] = rs.getString(3);
//				phone_arr[index] = rs.getString(4);
//				index++;

				// (3) ��ü
				// �޼ҵ带 ���� �� ����(�ʱ�ȭ)
//				cus1.setCusid(rs.getInt(1));
//				cus1.setName(rs.getString(2));
//				cus1.setAddress(rs.getString(3));
//				cus1.setPhone(rs.getString(4));

//				cus1 = new Customer(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));

				// (4) ��ü �迭
				cus1_arr[index].setCusid(rs.getInt(1));
				cus1_arr[index].setName(rs.getString(2));
				cus1_arr[index].setAddress(rs.getString(3));
				cus1_arr[index].setPhone(rs.getString(4));
				index++;
			}
//			con.close(); // db���� ����
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// 3. �޼ҵ� - ȭ�� ��� �޼ҵ� 1�� ������
	public void printCustomer() {
		System.out.println("\t" + cusid + "\t" + name + "\t" + address + "\t" + phone + "\t");
	}

	// 3. �޼ҵ� - ȭ�� ��� �޼ҵ� 2�� �迭��
	public void printCustomer_arr() {
		for (int i = 0; i < cusid_arr.length; i++) {
			System.out.println(
					"\t" + cusid_arr[i] + "\t" + name_arr[i] + "\t" + address_arr[i] + "\t" + phone_arr[i] + "\t");
		}
	}

	// 3. �޼ҵ� - ȭ�� ��� �޼ҵ� 3�� ��ü�� -> Customer Ŭ���� ������ �ű�
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
