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
		"/fileWriteForm.do", "/fileWritePro.do" }) // ��Ȯ�ϰ� ������ .do���� �� ����� �� 
public class MemberLoginCheckFilter implements Filter {

	public void init(FilterConfig fConfig) throws ServletException {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		
		HttpSession session = req.getSession();

		// �α��� ���������� �α��� ȭ������ �����̷�Ʈ �̵���Ŵ
		String id = (String) session.getAttribute("id");

		if (id == null) {
			res.sendRedirect("/memberLogin.do");
			return;
		}

		chain.doFilter(request, response); // �����帧���� �̾��. ���Ͱ� ���������� �� �״��� ���͸� ȣ���Ѵ�.
	}

	public void destroy() {
	}
}
