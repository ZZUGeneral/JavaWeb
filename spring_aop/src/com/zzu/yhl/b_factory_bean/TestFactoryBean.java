package com.zzu.yhl.b_factory_bean;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestFactoryBean {
	@Test
	public void demo01() {
		String path = "com/zzu/yhl/b_factory_bean/applicationContext.xml";
		ApplicationContext ac = new ClassPathXmlApplicationContext(path);
		// 获得代理类
		UserService userService = (UserService) ac.getBean("proxyService");
		userService.addUser();
		userService.updateUser();
		userService.deleteUser();
	}

}
