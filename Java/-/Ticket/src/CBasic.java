
public class CBasic {
	public static void main(String[] args) {
		
		MovieTicket starWarz, starWarzSale, theKing;
		
		starWarz = new MovieTicket(1, "��Ÿ����", 10000, "K13", "2�ð� 13��");
		starWarzSale = new MovieTicket(2, "��Ÿ����", 7000, "H9", "2�ð� 13��");
		theKing = new MovieTicket(3, "�� ŷ", 8000, "G10", "1�ð� 38��");
		
		User v1, v2;
		
		v1 = new User("aaa", "bbb", "����", "010-1234-1234", 50000, starWarzSale);
		v2 = new User("abc", "def", "�⸰", "010-4321-4321", 20000, theKing);
		
		v1.show();
		v2.show();
		
	}
}
