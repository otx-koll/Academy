package java1030;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Ex1 {

	public static void main(String[] args) {
		// �ڹ� IO(�����) ������ ����

		// byte ���� ó�� ����� : �̹������� ���� ���̳ʸ� ������ ������ �����
		// 		InputStream �������̽� ������ Ŭ����
		// 			- FileInputStream, BufferedInputStream
		// 		OutputStream �������̽� ������ Ŭ����
		// 			- FileOutputStream, BufferedOutputStream

		// char ���� ó�� ����� : ������� charó��, �ؽ�Ʈ ������ ������ �����
		// 		Reader �������̽� ������ Ŭ����
		// 			- FileReader, InputStreamReader, BufferedReader
		// 		Writer �������̽� ������ Ŭ����
		// 			- FileWriter, OutputStreamWriter, BufferedWriter

		// FileReader�� �ؽ�Ʈ ���� �о �ܼ�ȭ�鿡 ����ϱ�

		// �Է½�Ʈ�� �غ�
		FileReader reader = null;
		// ��볡���� �ڷḦ ã�� ���ؼ�
		try {
			reader = new FileReader("C:/Users/admin/Desktop/�ڹ�/�����α׷���_�н�.txt"); // ���� �Է� ��Ʈ�� ����

			int c;
			// int���ִ� ���� : reader.read()�� int���̱⋚���� int������ �ϰ� ���߿� ���ε�?����
			while ((c = reader.read()) != -1) { // ������ ��(-1)�� �ƴҶ����� ���� �Ѱ��� ����
				System.out.print((char)c); // ���ڸ� int������ �ް� char������ ���
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	} // main
}
