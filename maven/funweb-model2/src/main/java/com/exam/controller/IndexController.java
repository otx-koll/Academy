package com.exam.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class IndexController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("IndexController......");
		
<<<<<<< HEAD
		// DBó���� ���� Model������ Dao�� ����� �� ����
		
//		return "redirect:/joinForm.do"; // �����̷�Ʈ ���� 
		
//		return "/WEB-INF/views/index.jsp";
		return "index"; // ������ jsp������ ����̸� ���� (����ġ ���)
		
	}
=======
		// DBó���� ���� Model������ Dao�� ����Ҽ� ����
		
		//return "redirect:/joinForm.do"; // �����̷�Ʈ ����
		
		//return "/WEB-INF/views/index.jsp";
		return "index";  // ������ jsp������ ����̸� ���� (����ġ ���)
		
		
	}

>>>>>>> d44115f475ec485145b63ce82940bda6a14e3931
}
