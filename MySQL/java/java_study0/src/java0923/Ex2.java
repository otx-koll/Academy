package java0923;

public class Ex2 {
	public static void main(String[] args) {
		// ������ ���� : ����(Error), ����(Exception)

		// ���� : ��ǻ�� �ϵ���� ���� ������ ���� JVM ����. �ɰ��� ����.
		// ���� �Ұ����� �ɰ��� ����.

		// ���� : ���α׷� ������� �߸��� ���� �Ǵ�
		// �߸��� �ڵ����� ���� �߻��ϴ� ���α׷� ����.
		// ���α׷� ������ �߻��� �� �ִ� ����ġ ���� ������ ����.

		System.out.println("=== ���α׷� ���� ===");
		// ����ó��
		int a = 10, b = 0, c = 0;

		int[] arrNum = { 1, 2, 3 };

		String str = null;

		try { // ���� ����� �߿��� ���ܰ� �߻��ϸ� �� ��� catch�� �̵�

			// �����...
//			c = a / b;

			System.out.println(str.length());
			// �����...

			arrNum[5] = 50;
			// �����...
		} catch (ArithmeticException e) {
			e.printStackTrace(); // ���� �޼����� �߻� �ٿ����� ã�Ƽ� �ܰ躰�� ������ ���
		} catch (NullPointerException e) {
			e.printStackTrace();
		} catch (RuntimeException e) {
			e.printStackTrace();
		} catch (Exception e) { // Exception : ����ó�� ����
			e.printStackTrace();
		}

		System.out.println("c = " + c);

		System.out.println("=== ���α׷� ���� ===");

	} // main
}
