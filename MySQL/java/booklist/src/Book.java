
public class Book {

	// 1. ��� ����
	int bookid;
	String bookname;
	String publisher;
	int price;

	public Book() {}
	
	// 1. ������ - ��������� �ʱ�ȭ
	public Book(int bookid, String bookname, String publisher, int price) {
		this.bookid = bookid;
		this.bookname = bookname;
		this.publisher = publisher;
		this.price = price;
	}

	// 3. �޼ҵ� - ȭ�� ��� �޼ҵ� 3�� ��ü�� -> Book Ŭ���� ������ �ű�
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
