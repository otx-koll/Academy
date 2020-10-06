
public class CBasic {
	public static void main(String args[]) { // 메소드이면서 프로그램실행에 관여함
		
		// 1.객체 bl1 만들기
		BookList1 bl1 = new BookList1();
		
		// 2. 책 정보 가져오기
		bl1.getCon();
		bl1.selectBookList();
//		bl1.printBook(); // 1번 변수용 출력 메소드
//		bl1.printBook_arr(); // 2번 배열용 출력 메소드
//		bl1.printBook_object(); // 3번 객체용 출력 메소드 1
		bl1.book1.printBook_object(); // 3번 객체용 출력 메소드 2
		bl1.closeDB();
		
		// 3. 고객 정보 가져오기
//		CustomerList cl1 = new CustomerList();
//		cl1.getCon();
//		cl1.selectBookList();
//		cl1.closeDB();
	}
}
