package com.exam.bcrypt;

import org.mindrot.jbcrypt.BCrypt;

public class Ex1 {

	public static void main(String[] args) {
		// ��ȣȭ �� �н�����
		String inputPwd = "abcd1234";
		// ��Ʈ ���ڿ� ����
		String salt = BCrypt.gensalt();
		System.out.println("salt : " + salt);
		// ��Ʈ ���ڿ��� �߰��Ͽ� �н����� ��ȣȭ
		String hashedPwd = BCrypt.hashpw(inputPwd, salt);
		System.out.println("hashedPwd : " + hashedPwd);
		System.out.println("hashedPwd length : " + hashedPwd.length()); // ���ڱ��� 60
		// ��ȣȭ�� ���ڿ��� ������������ ��. ��ȣȭ�� �Ұ�����.
		boolean isValidPwd = BCrypt.checkpw(inputPwd, hashedPwd);
		System.out.println("isValidPwd : " + isValidPwd);
	} // main
}
