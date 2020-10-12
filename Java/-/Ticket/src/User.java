
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
		System.out.println(name + "���� �����Ͻ� Ƽ���� " + mt.getMovie() + "�Դϴ�.");
		System.out.println("Ƽ�� ��ȣ : " + mt.getTicketNum());
		System.out.println("Ƽ�� ���� : " + mt.getTicketPrice());
		System.out.println("�¼� ��ȣ : " + mt.getSeatNum());
		System.out.println("�� �ð� : " + mt.getRunningTime());
		System.out.println("���� �ݾ� : " + (money - mt.getTicketPrice()));
		System.out.println("----------------------------------");
	}
	
	
}
