
public class CustomerListManager {
	void run() {
		// 1. ��ü cl1 �����
		CustomerList cl1 = new CustomerList();

		// 2. �� ���� ��������
		cl1.getCon();
		cl1.selectCustomerList();
//		cl1.printCustomer(); 				// 1�� ������ ��� �޼ҵ�
//		cl1.printCustomer_arr(); 			// 2�� �迭�� ��� �޼ҵ�
//		cl1.cus1.printCustomer_object(); 	// 3�� ��ü�� ��� �޼ҵ�

		// 4�� ��ü�迭�� ��� �޼ҵ�
		for (int i = 0; i < cl1.cus1_arr.length; i++) {
			cl1.cus1_arr[i].printCustomer_object();
		}

		cl1.closeDB();
	}
}
