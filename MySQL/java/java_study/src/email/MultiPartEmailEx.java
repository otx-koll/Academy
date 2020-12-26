package email;

import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.MultiPartEmail;

public class MultiPartEmailEx {
	public static void main(String[] args) {
		long beginTime = System.currentTimeMillis();

		// MultiPartEmail ��ü �غ�
		MultiPartEmail email = new MultiPartEmail();
		
		// SMTP ���� ���ἳ��
		email.setHostName("smtp.gmail.com");
		email.setSmtpPort(465);
		email.setAuthentication("ihs1836", "gytjd2508*");
		
		// ���ȿ��� SSL, TLS ����
		email.setSSLOnConnect(true);
		email.setStartTLSEnabled(true);
		
		String response = "fail";
		
		// ÷�������� ���� EmailAttachment ��ü �غ�
		EmailAttachment attach = new EmailAttachment();
		attach.setPath("C:/Users/user/Desktop/���ѻ�/qr.png");
		attach.setDescription("QR�ڵ�"); // ����
//		attach.setName("QR"); // �ٸ��̸����� �����ϱ�
		
		EmailAttachment attach2 = new EmailAttachment();
		attach2.setPath("C:/Users/user/Desktop/���ѻ�/�������� ����Ƽ(�⺻).pptx");

		try {
			// ������ ��� ���� (SMTP ���� �α��� ���� ���̵�� �����ϰ� �ؾ��Կ� ����!)
			email.setFrom("ihs1836@gmail.com", "������", "utf-8");
			
			// �޴� ��� ����
			email.addTo("ihs1836@naver.com", "��ȿ��", "utf-8");
			
			// �޴� ���(������) ����
			email.addCc("ihs1836@daum.net");
			
			// �޴� ���(���� ������) ����
			email.addBcc("ihs1836@nate.com");
			
			// ���� ����
			email.setSubject("÷������ ���� �����Դϴ�.");
			
			// ���� ����
			email.setMsg("���� �����Դϴ�.\n�ι�° ���Դϴ�.\n\n����° ���Դϴ�.");
			
			email.attach(attach);
			email.attach(attach2);
			
			// ���� �����ϱ�
			response = email.send();
			
		} catch (EmailException e) {
			e.printStackTrace();
		}
		
		long endTime = System.currentTimeMillis();
		long execTime = endTime - beginTime;
		
		System.out.println("����ð�: " + execTime + "ms");
		System.out.println("����޽���: " + response);
	}
}
