package com.exam.controller;

import java.util.HashMap;
import java.util.Map;

<<<<<<< HEAD
public class ControllerFactory {

=======
import com.exam.controller.company.*;
import com.exam.controller.member.*;

public class ControllerFactory {
	
>>>>>>> d44115f475ec485145b63ce82940bda6a14e3931
	private static ControllerFactory instance = new ControllerFactory();
	
	public static ControllerFactory getInstance() {
		return instance;
	}
<<<<<<< HEAD
	
	////////////////////////////////////////////////////
=======

	///////////////////////////////////////////////////////////
>>>>>>> d44115f475ec485145b63ce82940bda6a14e3931

	private Map<String, Controller> map = new HashMap<>();
	
	private ControllerFactory() {
<<<<<<< HEAD
		// ��ɾ�� ��ɾ ó���ϴ� ��Ʈ�ѷ� ��ü�� ������ �����
		map.put("/index",  new IndexController());
		
	} // ������
	
	public Controller getController(String command) {
		// Map �÷����� Ű���� �������� �ʴ� ���� ������ null�� ������.
		Controller controller = map.get(command);
		return controller;
	}

=======
		// Ű���� .do�� ������ ��û URL�ּ��� �Ϻ� - ��ɾ� �������� ���
		
		// ��ɾ�� ��ɾ ó���ϴ� ��Ʈ�ѷ� ��ü�� ������ �����
		map.put("/index", new IndexController());
		
		// company
		map.put("/welcome", new WelcomeController());
		map.put("/history", new HistoryController());
		
		// member
		map.put("/memberJoin", new MemberJoinController());
		map.put("/joinIdDupCheck", new JoinIdDupCheckController());
		map.put("/memberJoinPro", new MemberJoinProController());
		map.put("/memberLogin", new MemberLoginController());
		map.put("/memberLoginPro", new MemberLoginProController());
		map.put("/memberLogout", new MemberLogoutController());
		
	} // ������

	
	public Controller getController(String command) {
		// Map �÷����� Ű���� ���������ʴ� ���� ������ null�� ������
		Controller controller = map.get(command);
		return controller;
	}
>>>>>>> d44115f475ec485145b63ce82940bda6a14e3931
}
