package com.ssafy.hw;

import java.util.Random;

public class AdminUser implements User {

	@Override
	public void useApp() throws ApplicationException {
		System.out.println("애플리케이션을 관리합니다.");
//		 예외 발생 코드 
		 if(Math.random() > 0.5) {
		 	throw new ApplicationException();
		 }
	}

}
