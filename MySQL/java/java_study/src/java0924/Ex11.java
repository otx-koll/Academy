
public class Ex11 {
	
	public static void methodA(int a, int b, int c) {
		
	}
	
	public static void methodB(int... num) { // �������� �޼ҵ�
		// �������� �޼ҵ��� �Ű������� �迭�� ��
		System.out.println(num.length);
		for(int n : num) {
			System.out.print(n + " ");
		}
		System.out.println("\n");
	}

	public static void main(String[] args) {
		methodA(10, 20, 30); // methodA()�� ���� Ŭ���� �ȿ� �ֱ� ������ �տ� Ex11.�� ������ �ʾƵ� ��
		
		methodB();
		methodB(100);
		methodB(100, 200, 300, 400, 500);
	}
}
