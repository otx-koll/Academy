
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
		System.out.println(name + "님이 구매하신 티켓은 " + mt.getMovie() + "입니다.");
		System.out.println("티켓 번호 : " + mt.getTicketNum());
		System.out.println("티켓 가격 : " + mt.getTicketPrice());
		System.out.println("좌석 번호 : " + mt.getSeatNum());
		System.out.println("상영 시간 : " + mt.getRunningTime());
		System.out.println("남은 금액 : " + (money - mt.getTicketPrice()));
		System.out.println("----------------------------------");
	}
	
	
}
