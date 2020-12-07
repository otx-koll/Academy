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
// 요청 주소이다. 속성들을 갖고 있음
// urlPatterns으로만 인식이 된다. 다른 속성들은 콤마로 계속 추가
// loadOnStartup : 웹서버가 시작할 때 미리 로딩하겠다. 숫자는 1순위인 것.
// localhost/funweb-model2/FrontController

@WebServlet(urlPatterns = "*.do", loadOnStartup = 1)
public class FrontController extends HttpServlet {
	public void init(ServletConfig config) throws ServletException {
		System.out.println("init() 호출됨");

		// application 객체 가져와서 필요한 데이터 저장
		ServletContext application = config.getServletContext();
		application.setAttribute("aa", "안녕"); // 뭔가를 저장할 때

=======

@WebServlet(urlPatterns = "*.do", loadOnStartup = 1)
public class FrontController extends HttpServlet {

	public void init(ServletConfig config) throws ServletException {
		System.out.println("init() 호출됨");
		
		// application 객체 가져와서 필요한 데이터 저장
		ServletContext application = config.getServletContext();
		application.setAttribute("aa", "안녕");
		
>>>>>>> d44115f475ec485145b63ce82940bda6a14e3931
		String hello = (String) application.getAttribute("aa");
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet() 호출됨");
		
		// 요청 주소
<<<<<<< HEAD
		// http://localhost:8080/funweb-model2/index.do
		// 주소가 /funweb-model2일때
		// http://localhost:8080/index.do
		// 주소가 /일때
		
		// 1단계) 명령어 command 구하기
		
		// URL 주소 가져오기
		String requestURI = request.getRequestURI();
		System.out.println("URL주소 : " + requestURI);
		// URI 주소 : /funweb-model2/index.do
		
		// 프로젝트 이름 경로 가져오기
		String contextPath = request.getContextPath();
		System.out.println("contextPath : " + contextPath);
		// contextPath : /index.do
		
		// 요청 명령어 구하기
		String command = requestURI.substring(contextPath.length());
		// command : /index.do
		command = command.substring(0, command.indexOf(".do")); // command.indexOf(".do") : .do있는 위치 리턴
		System.out.println("command : " + command);
		// command : /index
=======
		// http://localhost:80/funweb-model2/index.do
		// http://localhost:80/index.do
		
		// 1단계) 명령어 command 구하기
		
		// URI 주소 가져오기
		String requestURI = request.getRequestURI();
		System.out.println("URI 주소: " + requestURI);
		// URI 주소: /funweb-model2/index.do
		
		// 프로젝트 이름 경로 가져오기
		String contextPath = request.getContextPath();
		System.out.println("contextPath: " + contextPath);
		// contextPath: /funweb-model2
		
		// 요청 명령어 구하기
		String command = requestURI.substring(contextPath.length());
		// command: /index.do
		command = command.substring(0, command.indexOf(".do"));
		System.out.println("command: " + command);
		// command: /index
		
>>>>>>> d44115f475ec485145b63ce82940bda6a14e3931
		
		// 2단계) 명령어 실행하기
		Controller controller = null;
		ControllerFactory factory = ControllerFactory.getInstance();
		String strView = null;
		
		// 명령어에 해당하는 컨트롤러 객체 구하기
		controller = factory.getController(command);
		if (controller == null) {
			System.out.println(command + "를 처리하는 컨트롤러가 없습니다.");
			return;
		}
		
		try {
			// 컨트롤러 객체 실행하기
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
		// 3단계) 화면응답(jsp실행) 또는 리다이렉트(.do) 이동
		if (strView == null) {
			System.out.println("이동할 화면 View 정보가 없습니다.");
			return;
		}
		
		if (strView.startsWith("redirect:")) { // .do로 끝나는 경로
			String redirectPath = strView.substring("redirect:".length());
			response.sendRedirect(redirectPath);
		} else {
			String jspPath = "/WEB-INF/views/" + strView + ".jsp";
			RequestDispatcher dispatcher = request.getRequestDispatcher(jspPath);
<<<<<<< HEAD
			dispatcher.forward(request, response); // 해당 jsp 바로 실행
		}
		
	} // doGet

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("doPost() 호출됨");

		request.setCharacterEncoding("utf-8"); // post요청 파라미터값 한글처리
		doGet(request, response); // Post로 요청이 되면 Get으로 가게 몰아준다.
	} // doPost

	public void destroy() {
		System.out.println("destroy() 호출됨");
	} // destroy
=======
			dispatcher.forward(request, response); // 해당 jsp 바로 실행하기
		}
		
	} // doGet
	
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doPost() 호출됨");
		
		request.setCharacterEncoding("utf-8"); // post요청 파라미터값 한글처리
		doGet(request, response);
	} // doPost
	
	public void destroy() {
		System.out.println("destroy() 호출됨");
	}

>>>>>>> d44115f475ec485145b63ce82940bda6a14e3931
}
