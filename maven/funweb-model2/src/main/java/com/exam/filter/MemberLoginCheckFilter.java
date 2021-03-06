package com.exam.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter(urlPatterns = { "/writeForm.do", "/writePro.do", 
		"/fileWriteForm.do", "/fileWritePro.do" }) // 정확하게 쓰려면 .do까지 다 써줘야 함 
public class MemberLoginCheckFilter implements Filter {

	public void init(FilterConfig fConfig) throws ServletException {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		
		HttpSession session = req.getSession();

		// 로그인 안했을때는 로그인 화면으로 리다이렉트 이동시킴
		String id = (String) session.getAttribute("id");

		if (id == null) {
			res.sendRedirect("/memberLogin.do");
			return;
		}

		chain.doFilter(request, response); // 정상흐름으로 이어간다. 필터가 여러개있을 때 그다음 필터를 호출한다.
	}

	public void destroy() {
	}
}
