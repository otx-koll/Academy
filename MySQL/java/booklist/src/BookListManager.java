
public class BookListManager {

	void run() {
		// 1.��ü bl1 �����
		BookList1 bl1 = new BookList1();

		// 2. å ���� ��������
		bl1.getCon();
		bl1.selectBookList();
//		bl1.printBook(); 						// 1�� ������ ��� �޼ҵ�
//		bl1.printBook_arr(); 					// 2�� �迭�� ��� �޼ҵ�
//		bl1.printBook_object(); 				// 3�� ��ü�� ��� �޼ҵ� 1
//		bl1.book1.printBook_object(); 			// 3�� ��ü�� ��� �޼ҵ� 2

		// 4�� ��ü�迭�� ��� �޼ҵ�
		for (int i = 0; i < bl1.book1_arr.length; i++) {
			bl1.book1_arr[i].printBook_object(); 	
		}

		bl1.closeDB();
	}
}
