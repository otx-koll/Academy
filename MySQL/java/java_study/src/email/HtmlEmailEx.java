package email;

import java.io.File;

import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;

public class HtmlEmailEx {

	public static void main(String[] args) {
		
		long beginTime = System.currentTimeMillis();
		
		// HtmlEmail ��ü �غ�
		HtmlEmail email = new HtmlEmail();
		
		// SMTP ���� ���ἳ��
		email.setHostName("smtp.gmail.com");
		email.setSmtpPort(465);
		email.setAuthentication("ihs1836", "gytjd2508*");
		
		// ���ȿ��� SSL, TLS ��� ����
		email.setSSLOnConnect(true);
		email.setStartTLSEnabled(true);
		
		String response = "fail";
		
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
			email.setSubject("���� �����Դϴ�.");
			
			// ���뿡 ǥ���� �̹��� ������ File ��ü�� �غ�
			File imgFile = new File("C:/Users/user/Desktop/���ѻ�/qr.png");
			String strEmbed = email.embed(imgFile);
			System.out.println("strEmbed : " + strEmbed);
			
			// ���� ����
//			email.setMsg("���� �����Դϴ�.\n�ι�° ���Դϴ�.\n\n����° ���Դϴ�.");
			String str = "";
			str += "<html>";
			str += "<head>";
			str += "<meta charset='UTF-8'>";
			str += "<style>";
			str += "body { color: purple; }";
			str += "</style>";
			str += "</head>";
			str += "<body>";
			str += "���� �����Դϴ�.<br>";
			str += "<img src=cid:" + strEmbed + "><br>";
			str += "�ι�° ���Դϴ�.<br><br>";
			str += "����° ���Դϴ�.";
			str += "</body>";
			str += "</html>";
			
			email.setHtmlMsg(str);
			email.setCharset("utf-8");
			
			// ���� �����ϱ�
			response = email.send();
			
		} catch (EmailException e) {
			e.printStackTrace();
		}
		
		long endTime = System.currentTimeMillis();
		long execTime = endTime - beginTime;
		
		System.out.println("����ð�: " + execTime + "ms");
		System.out.println("����޽���: " + response);
	} // main

}