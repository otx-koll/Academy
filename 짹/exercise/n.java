package exercise;

public class n {
	  // �ʵ�
	private String name;
	private int hp;
	  // ������
	  public n(String name, int hp) {
	    this.name = name;
	    this.hp = hp;
	  }
	  // �޼ҵ�
	  public void heal(h target) {
	    System.out.printf("[%s]�� ġ��! %s HP(%d -> ", name, target.name, target.hp);
	    target.hp += 10;
	    System.out.printf("%d)\n", target.hp);
	}
}
