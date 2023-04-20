package com.ssafy.hw;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class AopTest {

	public static void main(String[] args) {
		//테스트 코드 작성
		 // xml 설정파일을 통해 스프링 컨텍스트 로드
		 ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		 User user1 = context.getBean("adminUser", AdminUser.class);
		 User user2 = context.getBean("generalUser", GeneralUser.class);
		 try {
			user1.useApp();
		
		} catch (ApplicationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			user2.useApp();
		} catch (ApplicationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
