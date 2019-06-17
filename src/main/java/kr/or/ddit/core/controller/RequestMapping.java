package kr.or.ddit.core.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.controller.Controller;
import kr.or.ddit.model.DbVO;
import kr.or.ddit.service.DbServiceImpl;
import kr.or.ddit.service.IDbService;

public class RequestMapping {
	private static final Logger logger = LoggerFactory
			.getLogger(RequestMapping.class);
	private static Map<String, Controller> requestMapping;
	private static IDbService service = new DbServiceImpl();
	
	static {
		List<DbVO> dbList = service.getDbList();
		
		requestMapping = new HashMap<>();
		
		for(DbVO dbVO : dbList) {
			String classInfo = dbVO.getClassname();
			logger.debug("classInfo : {}", classInfo);
			try {
				Class clazz = Class.forName(classInfo);
				Object obj = clazz.newInstance();
				requestMapping.put(dbVO.getUri(), (Controller)obj);
				
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (InstantiationException | IllegalAccessException e) {
				e.printStackTrace();
			}
		}
	}
	public static Controller getController(String uri) {
		return requestMapping.get(uri);
	}
	
}
