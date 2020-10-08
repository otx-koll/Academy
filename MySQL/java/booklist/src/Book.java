
public class Book {

	// 1. 멤버 변수
	int bookid;
	String bookname;
	String publisher;
	int price;

	public Book() {}
	
	// 1. 생성자 - 멤버변수를 초기화
	public Book(int bookid, String bookname, String publisher, int price) {
		this.bookid = bookid;
		this.bookname = bookname;
		this.publisher = publisher;
		this.price = price;
	}

	// 3. 메소드 - 화면 출력 메소드 3번 객체용 -> Book 클래스 안으로 옮김
	public void printBook_object() {
		System.out.println("\t" + bookid + "\t" + bookname + "\t\t" + publisher + "\t\t" + price + "\t");
	}
	
	public int getBookid() {
		return bookid;
	}

	public void setBookid(int bookid) {
		this.bookid = bookid;
	}

	public String getBookname() {
		return bookname;
	}

	public void setBookname(String bookname) {
		this.bookname = bookname;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
}
