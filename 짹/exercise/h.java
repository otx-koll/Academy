package exercise;
// 
// public�� �ܺ� Ŭ���� ��𿡼��� ���ٰ���
// protected�� ���� ��Ű�� ���̶� ��� ������ Ŭ���������� ���ٰ���
// �ƹ��͵� ���� �� default�� ���� ��Ű�� ���ο����� ���ٰ���
// private�� ���� Ŭ���� ���ο����� �����ϴ�. �ܺο��� ���ٸ��Ѵ�. �׷��� private���� ������ ������ ����������
// get(), set()�޼���� ������ �� �ִ�. get�� ���� ��� getter�̰�, set�� ���� �����ϴ� setter�̴�.
// �������
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
// id���� �����ö� new s().id�̷��� �����͵� ����������
// passwd�� �����ö� s.getPaswd()�� ������ �� �ִ�. passwd�� private�̱� ������ get�޼���� �����Դ�.
// 

public class h {
	// �ʵ�
	String name;
	int hp;

	// ������
	public h(String name, int hp) {
		this.name = name;
		this.hp = hp;
	}

	// �޼ҵ�
	public void stimpack() {
		System.out.printf("[%s]�� ������! HP: %d -> ", name, hp);
		hp -= 10;
		System.out.printf("%d\n", hp);
	}
}
