package exercise;

public class n {
	  // 필드
	private String name;
	private int hp;
	  // 생성자
	  public n(String name, int hp) {
	    this.name = name;
	    this.hp = hp;
	  }
	  // 메소드
	  public void heal(h target) {
	    System.out.printf("[%s]의 치유! %s HP(%d -> ", name, target.name, target.hp);
	    target.hp += 10;
	    System.out.printf("%d)\n", target.hp);
	}
}
