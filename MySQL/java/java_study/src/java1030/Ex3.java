package java1030;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Ex3 {
	public static void main(String[] args) {
		// Ű���� �Է��� ���Ϸ� �����ϱ�
		
		// �Է½�Ʈ�� �غ�
		Scanner scanner = new Scanner(System.in); 

		// ��½�Ʈ�� �غ�
		FileWriter writer = null;
		
		try {
			writer = new FileWriter("C:/Users/admin/Desktop/�ڹ�/test.txt", true); // true : append �ɼ� Ŵ 
			
			System.out.println("Ű����� ���ڸ� �Է��ϼ���");
			
			String line = "";
			while (scanner.hasNextLine()) {
				line = scanner.nextLine(); // �ٹٲ޹��ڴ� �����ϰ� ������ ������ 
				if (line.length() == 0) { // ����Ű�� �Է��� ��� ���ڿ�
					break;
				}
				
				writer.write(line + "\n"); // ��½�Ʈ�� ��ü�� �⺻������ ���۸� ����.
				writer.flush(); // ������
			} // while
			
			writer.flush(); // ���� �����ؼ� ���Ͽ� ����
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			scanner.close();
			try {
				writer.close(); // close()�� ������ ���������� flush() ȣ���ؼ� ���� ���� ����
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	} // main
}
