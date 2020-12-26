package email;

import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

public class SimpleEmailEx {

	public static void main(String[] args) {
		
		// CommonsEmail ���̺귯���� ����ؼ� �̸��� ���۱�� ����
		//  -> JavaMail ���̺귯���� ����
		//  -> JAF(Java Activation Framework) ���̺귯���� ����
		
		// SimpleEmail Ŭ���� : �ؽ�Ʈ �޽����� �����ϴ� �뵵
		// MultiPartEmail Ŭ���� : �ؽ�Ʈ �޽����� ������ �Բ� ����
		// HtmlEmail Ŭ���� : �̸����� HTML �������� �����ϴ� �뵵
		
		// �̸��� ���񽺴� ���� ���ۿ� ���������� SMTP�� �����.
		// SMTP ���� ȣ��Ʈ��(IP�ּ�)
		// SMTP ���� ��Ʈ: �⺻��Ʈ 465(SSL) �Ǵ� 587(TLS)
		
		long beginTime = System.currentTimeMillis();
		
		// SimpleEmail ��ü �غ�
		SimpleEmail email = new SimpleEmail();
		
		// SMTP ���� ���ἳ��
		email.setHostName("smtp.gmail.com");
		email.setSmtpPort(465);
		email.setAuthentication("ihs1836", "gytjd2508*");
		
		// ���ȿ��� SSL, TLS ����
		email.setSSLOnConnect(true);
		email.setStartTLSEnabled(true);
		
		String response = "fail";
		
		try {
			// ������ ��� ���� (SMTP ���� �α��� ���� ���̵�� �����ϰ� �ؾ��Կ� ����!)
			email.setFrom("ihs1836@gmail.com", "������", "utf-8");
			
			// �޴� ��� ����
			email.addTo("ihs1836@daum.net", "��ȿ��", "utf-8");
			
			// �޴� ���(������) ����
			email.addCc("ihs1836@naver.com");
			
			// �޴� ���(���� ������) ����
			email.addBcc("ihs1836@nate.com");
			
			// ���� ����
			email.setSubject("���� �����Դϴ�.");
			
			// ���� ����
			email.setMsg("���� �����Դϴ�.\n�ι�° ���Դϴ�.\n\n����° ���Դϴ�.");
			
			// ���� �����ϱ�
			response = email.send();
			
		} catch (EmailException e) {
			e.printStackTrace();
		}
		
		long endTime = System.currentTimeMillis();
		long execTime = endTime - beginTime;
		
		System.out.println("����ð�: " + execTime + "ms");
		System.out.println("����޽���: " + response);
	}// main

}