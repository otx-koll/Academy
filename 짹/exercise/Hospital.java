package exercise;

public class Hospital {
	public static void main(String[] args) {
		// ��ü ����
		h marine = new h("����", 80);
		n medic = new n("����", 60);
		// ���� ������ ����~
		marine.stimpack();
		// ������ ġ�� -> ����
		medic.heal(marine);
	}
}
