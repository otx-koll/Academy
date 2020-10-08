
public class BookListManager {

	void run() {
		// 1.객체 bl1 만들기
		BookList1 bl1 = new BookList1();

		// 2. 책 정보 가져오기
		bl1.getCon();
		bl1.selectBookList();
//		bl1.printBook(); 						// 1번 변수용 출력 메소드
//		bl1.printBook_arr(); 					// 2번 배열용 출력 메소드
//		bl1.printBook_object(); 				// 3번 객체용 출력 메소드 1
//		bl1.book1.printBook_object(); 			// 3번 객체용 출력 메소드 2

		// 4번 객체배열용 출력 메소드
		for (int i = 0; i < bl1.book1_arr.length; i++) {
			bl1.book1_arr[i].printBook_object(); 	
		}

		bl1.closeDB();
	}
}
