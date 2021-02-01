package com.exam.controller.filenotice;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;

import javax.servlet.ServletContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.exam.controller.Controller;
import com.exam.dao.AttachDao;
import com.exam.vo.AttachVo;

public class DownloadController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("DownloadController......");
		
		// ÷������ ��ȣ num �Ķ���� ��������
		int num = Integer.parseInt(request.getParameter("num"));

		AttachDao attachDao = AttachDao.getInstance();

		// ÷������ ��ȣ�� �ش��ϴ� ���ڵ� �Ѱ� ��������
		AttachVo attachVo = attachDao.getAttachByNum(num);

		ServletContext application = request.getServletContext();
		String realPath = application.getRealPath("/"); // webapp

		// �ٿ�ε��� ���������� File ��ü�� �غ�
		File file = new File(realPath + "/upload/" + attachVo.getUploadpath(), attachVo.getFilename());

		// �Է½�Ʈ�� �غ�
		BufferedInputStream is = null;
		is = new BufferedInputStream(new FileInputStream(file));

		// ����(Mime)Ÿ�� �����ͼ� ����Ʈ Ÿ������ �����ϱ� (image/png, audio/mp3, video/mp4)
		String mimeType = application.getMimeType(file.getPath());
		if (mimeType == null) { // ����Ÿ�� ������ ������ application/octet-stream �� �����ϱ�
			mimeType = "application/octet-stream";
		}
		response.setContentType(mimeType);

		String filename = attachVo.getFilename();
		System.out.println("utf-8 ���ϸ�: " + filename);

		// �ٿ�ε� ���ϸ��� ���ڼ��� utf-8���� iso-8859-1�� ��ȯ
		filename = new String(filename.getBytes("utf-8"), "iso-8859-1");
		System.out.println("iso-8859-1 ���ϸ�: " + filename);

		// �ٿ�ε� �� ���� ���ϸ��� ����� ����
		response.setHeader("Content-Disposition", "attachment; filename=" + filename);

		// ��½�Ʈ�� �غ�
		ServletOutputStream os = response.getOutputStream();

		// �ٿ�ε� ���� : �Է½�Ʈ������ ������ �о
//		      Ŭ���̾�Ʈ ���� ��½�Ʈ������ ����ϱ�
		int data;
		while ((data = is.read()) != -1) {
			os.write(data);
		}

		// ����� ��ü �ڿ��ݱ�
		is.close();
		os.close();
		
		return null;
	}

}
