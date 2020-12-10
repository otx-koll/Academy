package com.exam.controller.notice;

import java.sql.Timestamp;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.exam.controller.Controller;
import com.exam.dao.JdbcUtils;
import com.exam.dao.NoticeDao;
import com.exam.vo.NoticeVo;

public class WriteProController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("WriteProController......");

		// session ��ü ���� ��������
		HttpSession session = request.getSession();
		
		// �α��� ���� Ȯ��
		String id = (String) session.getAttribute("id");
		if (id == null) {
			return "redirect:/notice.do"; // redirect������ jsp��� �ٽ� ����ڰ� ��û�ϰ� ����
		}
		
		// pageNum �Ķ���� ��������
		String pageNum = request.getParameter("pageNum");
		
		//DAO ��ü �غ�
		NoticeDao noticeDao = NoticeDao.getInstance();
				
		// NoticeVo ��ü �غ�
		NoticeVo noticeVo = new NoticeVo();
		
		int num = noticeDao.getNextNum();
		
		// �Ķ���Ͱ��� �����ͼ� NoticeVo ��ü�� ����
		noticeVo.setNum(num);
		noticeVo.setId(request.getParameter("id"));
		noticeVo.setSubject(request.getParameter("subject"));
		noticeVo.setContent(request.getParameter("content"));
		
		//ip  regDate  readcount  �� ����
		noticeVo.setIp(request.getRemoteAddr());
		noticeVo.setRegDate(new Timestamp(System.currentTimeMillis()));
		noticeVo.setReadcount(0);  // ��ȸ��

		//re_ref  re_lev  re_seq
		noticeVo.setReRef(num); // �ֱ��϶��� �۹�ȣ�� �׷��ȣ�� ��
		noticeVo.setReLev(0); // �ֱ��϶��� �鿩���� ������ 0 (�鿩���� ����)
		noticeVo.setReSeq(0); // �ֱ��϶��� �۱׷� ������ ������ 0 (ù��°)
		
		System.out.println(noticeVo);

		

		//�ֱ� ����ϱ�
		noticeDao.addNotice(noticeVo);

		// �۳��� �󼼺��� ȭ�� content.jsp�� �̵�
//		response.sendRedirect("/center/content.jsp?num=" + num + "&pageNum=" + pageNum); // ��
		return "redirect:/content.do?num=" + num + "&pageNum=" + pageNum;
	}
}
