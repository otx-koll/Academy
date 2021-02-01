package com.exam.controller.notice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.exam.controller.Controller;

public class WriteFormController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("WriteFormController......");
		
		// session 객체 참조 가져오기
		HttpSession session = request.getSession();
		
//		// 로그인 여부 확인
//		String id = (String) session.getAttribute("id");
//		if (id == null) {
////			response.sendRedirect("/center/notice.jsp");
//			return "redirect:/notice.do"; // redirect없으면 jsp경로 다시 사용자가 요청하게 만듦
//		}
		
		// 파라미터값  pageNum  가져오기
		String pageNum = request.getParameter("pageNum");
		
		// 위엔 파라미터로, 밑엔 어트리뷰트로 중복 저장
		// 파라미터로 가져오고싶으면 ex) param.pageNum 으로 쓸 수 있는데 스프링에서 웬만하면 권장하지 않는다.
		// attribute로 일관되게 가져오기 위해 밑에 코드를 적었다. 
		
		// 뷰(jsp)에서 필요한 데이터를 request 영역객체에 저장 
		request.setAttribute("pageNum", pageNum);
		
		
		return "center/writeForm";
	}
}
