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

@WebFilter("/*") // FrontController�� �޷��ִ� @WebServlet�̶� ���� ����̴�.
public class MemberStayLoggedInFilter implements Filter {

	public void init(FilterConfig fConfig) throws ServletException {
		ServletContext application = fConfig.getServletContext();
		application.setAttribute("test", "������");
	}

	// ���������� ���ϴ� ��.
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		// ��û ������� ���� ��������
		HttpServletRequest req = (HttpServletRequest) request;
		
		HttpSession session = req.getSession();

		// ���ǿ� �α��� ���̵� �̹� ������
		// �α��� ���������� ��Ű��ü ã���۾� ���ϰ� ����
		String id = (String) session.getAttribute("id");
		if (id == null) {
			// �α��� �������� ��Ű���� ��������
			Cookie[] cookies = req.getCookies();
			// ��Ű name�� "id"�� ��Ű��ü ã��
			if (cookies != null) {
				for (Cookie cookie : cookies) {
					if (cookie.getName().equals("id")) {
						id = cookie.getValue();

						// �α��� ���� ó��(���ǿ� id�� �߰�)
						session.setAttribute("id", id);
					}
				}
			}
		}

		// ���� ���ͷ� ������ �ѱ�� �۾��� ������
		chain.doFilter(request, response);
	}

	public void destroy() {
	}
}
