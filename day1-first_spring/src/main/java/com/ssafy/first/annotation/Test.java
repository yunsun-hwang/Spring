package com.ssafy.first.annotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ssafy.first.xml.controller.BoardController;
import com.ssafy.first.xml.model.dao.BoardDao;
import com.ssafy.first.xml.model.service.BoardService;

public class Test {
	public static void main(String[] args) {
		ApplicationContext container = new ClassPathXmlApplicationContext(
				"annotation/first-exam.xml");
		
		String[] names = container.getBeanDefinitionNames();
		for (String name : names) {
			System.out.println(name);
		}
		
		BoardController controller = (BoardController)container.getBean("boardController");
		System.out.println(controller);
		
		BoardService boardService = container.getBean("boardService", BoardService.class);
		System.out.println(boardService);
		
		BoardDao boardDao = container.getBean(BoardDao.class);
		System.out.println(boardDao);
		
		System.out.println("정상적으로 실행");
	}
}
