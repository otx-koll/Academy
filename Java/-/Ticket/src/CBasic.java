
public class CBasic {
	public static void main(String[] args) {
		
		MovieTicket starWarz, starWarzSale, theKing;
		
		starWarz = new MovieTicket(1, "스타워즈", 10000, "K13", "2시간 13분");
		starWarzSale = new MovieTicket(2, "스타워즈", 7000, "H9", "2시간 13분");
		theKing = new MovieTicket(3, "더 킹", 8000, "G10", "1시간 38분");
		
		User v1, v2;
		
		v1 = new User("aaa", "bbb", "사자", "010-1234-1234", 50000, starWarzSale);
		v2 = new User("abc", "def", "기린", "010-4321-4321", 20000, theKing);
		
		v1.show();
		v2.show();
		
	}
}
