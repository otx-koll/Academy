package com.exam.controller.notice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.exam.controller.Controller;

public class WriteFormController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("WriteFormController......");
		
		// session ��ü ���� ��������
		HttpSession session = request.getSession();
		
//		// �α��� ���� Ȯ��
//		String id = (String) session.getAttribute("id");
//		if (id == null) {
////			response.sendRedirect("/center/notice.jsp");
//			return "redirect:/notice.do"; // redirect������ jsp��� �ٽ� ����ڰ� ��û�ϰ� ����
//		}
		
		// �Ķ���Ͱ�  pageNum  ��������
		String pageNum = request.getParameter("pageNum");
		
		// ���� �Ķ���ͷ�, �ؿ� ��Ʈ����Ʈ�� �ߺ� ����
		// �Ķ���ͷ� ������������� ex) param.pageNum ���� �� �� �ִµ� ���������� �����ϸ� �������� �ʴ´�.
		// attribute�� �ϰ��ǰ� �������� ���� �ؿ� �ڵ带 ������. 
		
		// ��(jsp)���� �ʿ��� �����͸� request ������ü�� ���� 
		request.setAttribute("pageNum", pageNum);
		
		
		return "center/writeForm";
	}
}
