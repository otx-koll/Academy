package exercise;
// 
// public은 외부 클래스 어디에서나 접근가능
// protected는 같은 패키지 안이랑 상속 관계의 클래스에서만 접근가능
// 아무것도 없을 땐 default로 같은 패키지 내부에서만 접근가능
// private는 같은 클래스 내부에서만 가능하다. 외부에서 접근못한다. 그래서 private으로 선언한 변수를 가져오려면
// get(), set()메서드로 가져올 수 있다. get은 값을 얻는 getter이고, set은 값을 지정하는 setter이다.
// 예를들어
//	public class s {
//		public int id;
//		private int passwd;
//
//		public int getPasswd() {
//			return passwd;
//		}
//		public void setPasswd() {
//			this.passwd = passwd;
//		}
//	}
// id값을 가져올땐 new s().id이렇게 가져와도 가능하지만
// passwd를 가져올땐 s.getPaswd()로 가져올 수 있다. passwd가 private이기 때문에 get메서드로 가져왔다.
// 

public class h {
	// 필드
	String name;
	int hp;

	// 생성자
	public h(String name, int hp) {
		this.name = name;
		this.hp = hp;
	}

	// 메소드
	public void stimpack() {
		System.out.printf("[%s]의 스팀팩! HP: %d -> ", name, hp);
		hp -= 10;
		System.out.printf("%d\n", hp);
	}
}
