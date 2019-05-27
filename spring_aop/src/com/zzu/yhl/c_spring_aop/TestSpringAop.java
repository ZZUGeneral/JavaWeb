package com.zzu.yhl.c_spring_aop;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpringAop {
	@Test
	public void demo01() {
		String path = "com/zzu/yhl/c_spring_aop/applicationContext.xml";
		ApplicationContext ac = new ClassPathXmlApplicationContext(path);
		// 获得代理类
		UserService userService = (UserService) ac.getBean("userService");
		userService.addUser();
		userService.updateUser();
		userService.deleteUser();
	}

}
