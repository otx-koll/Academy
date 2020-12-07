package com.exam.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

<<<<<<< HEAD
// ��û �ּ��̴�. �Ӽ����� ���� ����
// urlPatterns���θ� �ν��� �ȴ�. �ٸ� �Ӽ����� �޸��� ��� �߰�
// loadOnStartup : �������� ������ �� �̸� �ε��ϰڴ�. ���ڴ� 1������ ��.
// localhost/funweb-model2/FrontController

@WebServlet(urlPatterns = "*.do", loadOnStartup = 1)
public class FrontController extends HttpServlet {
	public void init(ServletConfig config) throws ServletException {
		System.out.println("init() ȣ���");

		// application ��ü �����ͼ� �ʿ��� ������ ����
		ServletContext application = config.getServletContext();
		application.setAttribute("aa", "�ȳ�"); // ������ ������ ��

=======

@WebServlet(urlPatterns = "*.do", loadOnStartup = 1)
public class FrontController extends HttpServlet {

	public void init(ServletConfig config) throws ServletException {
		System.out.println("init() ȣ���");
		
		// application ��ü �����ͼ� �ʿ��� ������ ����
		ServletContext application = config.getServletContext();
		application.setAttribute("aa", "�ȳ�");
		
>>>>>>> d44115f475ec485145b63ce82940bda6a14e3931
		String hello = (String) application.getAttribute("aa");
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet() ȣ���");
		
		// ��û �ּ�
<<<<<<< HEAD
		// http://localhost:8080/funweb-model2/index.do
		// �ּҰ� /funweb-model2�϶�
		// http://localhost:8080/index.do
		// �ּҰ� /�϶�
		
		// 1�ܰ�) ��ɾ� command ���ϱ�
		
		// URL �ּ� ��������
		String requestURI = request.getRequestURI();
		System.out.println("URL�ּ� : " + requestURI);
		// URI �ּ� : /funweb-model2/index.do
		
		// ������Ʈ �̸� ��� ��������
		String contextPath = request.getContextPath();
		System.out.println("contextPath : " + contextPath);
		// contextPath : /index.do
		
		// ��û ��ɾ� ���ϱ�
		String command = requestURI.substring(contextPath.length());
		// command : /index.do
		command = command.substring(0, command.indexOf(".do")); // command.indexOf(".do") : .do�ִ� ��ġ ����
		System.out.println("command : " + command);
		// command : /index
=======
		// http://localhost:80/funweb-model2/index.do
		// http://localhost:80/index.do
		
		// 1�ܰ�) ��ɾ� command ���ϱ�
		
		// URI �ּ� ��������
		String requestURI = request.getRequestURI();
		System.out.println("URI �ּ�: " + requestURI);
		// URI �ּ�: /funweb-model2/index.do
		
		// ������Ʈ �̸� ��� ��������
		String contextPath = request.getContextPath();
		System.out.println("contextPath: " + contextPath);
		// contextPath: /funweb-model2
		
		// ��û ��ɾ� ���ϱ�
		String command = requestURI.substring(contextPath.length());
		// command: /index.do
		command = command.substring(0, command.indexOf(".do"));
		System.out.println("command: " + command);
		// command: /index
		
>>>>>>> d44115f475ec485145b63ce82940bda6a14e3931
		
		// 2�ܰ�) ��ɾ� �����ϱ�
		Controller controller = null;
		ControllerFactory factory = ControllerFactory.getInstance();
		String strView = null;
		
		// ��ɾ �ش��ϴ� ��Ʈ�ѷ� ��ü ���ϱ�
		controller = factory.getController(command);
		if (controller == null) {
			System.out.println(command + "�� ó���ϴ� ��Ʈ�ѷ��� �����ϴ�.");
			return;
		}
		
		try {
			// ��Ʈ�ѷ� ��ü �����ϱ�
<<<<<<< HEAD
			strView = controller.execute(request, response); 
		} catch (Exception e) {
			e.printStackTrace();
		}

=======
			strView = controller.execute(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
>>>>>>> d44115f475ec485145b63ce82940bda6a14e3931
		// 3�ܰ�) ȭ������(jsp����) �Ǵ� �����̷�Ʈ(.do) �̵�
		if (strView == null) {
			System.out.println("�̵��� ȭ�� View ������ �����ϴ�.");
			return;
		}
		
		if (strView.startsWith("redirect:")) { // .do�� ������ ���
			String redirectPath = strView.substring("redirect:".length());
			response.sendRedirect(redirectPath);
		} else {
			String jspPath = "/WEB-INF/views/" + strView + ".jsp";
			RequestDispatcher dispatcher = request.getRequestDispatcher(jspPath);
<<<<<<< HEAD
			dispatcher.forward(request, response); // �ش� jsp �ٷ� ����
		}
		
	} // doGet

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("doPost() ȣ���");

		request.setCharacterEncoding("utf-8"); // post��û �Ķ���Ͱ� �ѱ�ó��
		doGet(request, response); // Post�� ��û�� �Ǹ� Get���� ���� �����ش�.
	} // doPost

	public void destroy() {
		System.out.println("destroy() ȣ���");
	} // destroy
=======
			dispatcher.forward(request, response); // �ش� jsp �ٷ� �����ϱ�
		}
		
	} // doGet
	
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doPost() ȣ���");
		
		request.setCharacterEncoding("utf-8"); // post��û �Ķ���Ͱ� �ѱ�ó��
		doGet(request, response);
	} // doPost
	
	public void destroy() {
		System.out.println("destroy() ȣ���");
	}

>>>>>>> d44115f475ec485145b63ce82940bda6a14e3931
}
