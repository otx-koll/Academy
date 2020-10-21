package exercise;

public class Hospital {
	public static void main(String[] args) {
		// 객체 생성
		h marine = new h("전사", 80);
		n medic = new n("힐러", 60);
		// 마린 스팀팩 버프~
		marine.stimpack();
		// 힐러의 치료 -> 전사
		medic.heal(marine);
	}
}
