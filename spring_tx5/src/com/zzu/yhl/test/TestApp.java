package com.zzu.yhl.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.zzu.yhl.service.AccountService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class TestApp {
	@Autowired
	private AccountService accountService;

	@Test
	public void demo01() {
		// String path = "applicationContext.xml";
		// ApplicationContext ac = new ClassPathXmlApplicationContext(path);
		// AccountService as = (AccountService) ac.getBean("accountService");
		accountService.transfer("jack", "rose", 1000);
	}

}
