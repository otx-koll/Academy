package com.exam.controller.member;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.exam.controller.Controller;

public class MemberLogoutController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("MemberLogoutController......");
		
		// 세션 객체 참조 가져오기
		HttpSession session = request.getSession();

		// 세션값 초기화. 로그아웃 작업
		session.invalidate();
		
		// 로그인 상태유지용 쿠키가 존재하면 삭제하기
		Cookie[] cookies = request.getCookies();

		if (cookies != null) {
			for (Cookie cookie : cookies) {
				if (cookie.getName().equals("id")) {
					cookie.setMaxAge(0); // 유효기간 0으로 설정 -> 쿠키 삭제처리
					cookie.setPath("/"); // 경로 설정 // 최초 생성 경로와 일치해야 함
					
					response.addCookie(cookie); // 쿠키정보 보내기
				}
			}
		}
		
		// index.do로 리다이렉트
//		return "index"; // 디스패치로 바로 실행하면
		return "redirect:/index.do"; // 새로고침 이슈 // 서버가 시키는대로 index.do를 요청해서 index.jsp를 실행하게 될 것이다.
	}
}
