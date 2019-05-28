package com.zzu.yhl.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.zzu.yhl.service.AccountService;

public class TestApp {
	@Test
	public void demo01() {
		String path = "applicationContext.xml";
		ApplicationContext ac = new ClassPathXmlApplicationContext(path);
		AccountService as = (AccountService) ac.getBean("accountService");
		as.transfer("jack", "rose", 1000);
	}
}
