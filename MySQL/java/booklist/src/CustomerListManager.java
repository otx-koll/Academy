
public class CustomerListManager {
	void run() {
		// 1. 객체 cl1 만들기
		CustomerList cl1 = new CustomerList();

		// 2. 고객 정보 가져오기
		cl1.getCon();
		cl1.selectCustomerList();
//		cl1.printCustomer(); 				// 1번 변수용 출력 메소드
//		cl1.printCustomer_arr(); 			// 2번 배열용 출력 메소드
//		cl1.cus1.printCustomer_object(); 	// 3번 객체용 출력 메소드

		// 4번 객체배열용 출력 메소드
		for (int i = 0; i < cl1.cus1_arr.length; i++) {
			cl1.cus1_arr[i].printCustomer_object();
		}

		cl1.closeDB();
	}
}
