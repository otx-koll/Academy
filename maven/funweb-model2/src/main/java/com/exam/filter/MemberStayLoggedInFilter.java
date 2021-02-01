package com.exam.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@WebFilter("/*") // FrontController에 달려있는 @WebServlet이랑 같은 기능이다.
public class MemberStayLoggedInFilter implements Filter {

	public void init(FilterConfig fConfig) throws ServletException {
		ServletContext application = fConfig.getServletContext();
		application.setAttribute("test", "데이터");
	}

	// 실질적으로 일하는 곳.
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		// 요청 사용자의 세션 가져오기
		HttpServletRequest req = (HttpServletRequest) request;
		
		HttpSession session = req.getSession();

		// 세션에 로그인 아이디가 이미 있으면
		// 로그인 상태유지용 쿠키객체 찾는작업 안하고 종료
		String id = (String) session.getAttribute("id");
		if (id == null) {
			// 로그인 상태유지 쿠키정보 가져오기
			Cookie[] cookies = req.getCookies();
			// 쿠키 name이 "id"인 쿠키객체 찾기
			if (cookies != null) {
				for (Cookie cookie : cookies) {
					if (cookie.getName().equals("id")) {
						id = cookie.getValue();

						// 로그인 인증 처리(세션에 id값 추가)
						session.setAttribute("id", id);
					}
				}
			}
		}

		// 다음 필터로 실행을 넘기는 작업을 수행함
		chain.doFilter(request, response);
	}

	public void destroy() {
	}
}
