package com.exam.controller;

import java.util.HashMap;
import java.util.Map;

public class ControllerFactory {
	
	private static ControllerFactory instance = new ControllerFactory();
	
	public static ControllerFactory getInstance() {
		return instance;
	}

	///////////////////////////////////////////////////////////

	private Map<String, Controller> map = new HashMap<>();
	
	private ControllerFactory() {
		// 명령어와 명령어를 처리하는 컨트롤러 객체를 쌍으로 등록함
		map.put("/index", new IndexController());
		
	} // 생성자

	
	public Controller getController(String command) {
		// Map 컬렉션은 키값이 존재하지않는 값을 꺼내면 null을 리턴함
		Controller controller = map.get(command);
		return controller;
	}
	
}
