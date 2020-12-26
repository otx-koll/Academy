package email;

import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.MultiPartEmail;

public class MultiPartEmailEx {
	public static void main(String[] args) {
		long beginTime = System.currentTimeMillis();

		// MultiPartEmail 객체 준비
		MultiPartEmail email = new MultiPartEmail();
		
		// SMTP 서버 연결설정
		email.setHostName("smtp.gmail.com");
		email.setSmtpPort(465);
		email.setAuthentication("ihs1836", "gytjd2508*");
		
		// 보안연결 SSL, TLS 설정
		email.setSSLOnConnect(true);
		email.setStartTLSEnabled(true);
		
		String response = "fail";
		
		// 첨부파일을 위한 EmailAttachment 객체 준비
		EmailAttachment attach = new EmailAttachment();
		attach.setPath("C:/Users/user/Desktop/물총새/qr.png");
		attach.setDescription("QR코드"); // 설명
//		attach.setName("QR"); // 다른이름으로 변경하기
		
		EmailAttachment attach2 = new EmailAttachment();
		attach2.setPath("C:/Users/user/Desktop/물총새/조조무비 피피티(기본).pptx");

		try {
			// 보내는 사람 설정 (SMTP 서비스 로그인 계정 아이디와 동일하게 해야함에 주의!)
			email.setFrom("ihs1836@gmail.com", "관리자", "utf-8");
			
			// 받는 사람 설정
			email.addTo("ihs1836@naver.com", "임효성", "utf-8");
			
			// 받는 사람(참조인) 설정
			email.addCc("ihs1836@daum.net");
			
			// 받는 사람(숨은 참조인) 설정
			email.addBcc("ihs1836@nate.com");
			
			// 제목 설정
			email.setSubject("첨부파일 메일 제목입니다.");
			
			// 본문 설정
			email.setMsg("메일 본문입니다.\n두번째 줄입니다.\n\n세번째 줄입니다.");
			
			email.attach(attach);
			email.attach(attach2);
			
			// 메일 전송하기
			response = email.send();
			
		} catch (EmailException e) {
			e.printStackTrace();
		}
		
		long endTime = System.currentTimeMillis();
		long execTime = endTime - beginTime;
		
		System.out.println("실행시간: " + execTime + "ms");
		System.out.println("응답메시지: " + response);
	}
}
