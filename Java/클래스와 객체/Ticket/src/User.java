
public class User {
	private String id;
	private String password;
	private String name;
	private String phoneNum;
	private int money;
	private MovieTicket mt;
	
	public User() {}
	
	public User(String id, String password, String name, String phoneNum, int money, MovieTicket mt) {
		this.id = id;
		this.password = password;
		this.name = name;
		this.phoneNum = phoneNum;
		this.money = money;
		this.mt = mt;
	}
	
	public void show() {
		System.out.println("남은 금액 : " + (money - mt.getTicketPrice()));
		System.out.println("----------------------------------");
	}
	
	
}
