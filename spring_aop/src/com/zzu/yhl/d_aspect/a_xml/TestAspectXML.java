package com.zzu.yhl.d_aspect.a_xml;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class TestAspectXML {
	@Test
	public void demo01() {
		String path = "com/zzu/yhl/d_aspect/a_xml/applicationContext.xml";
		ApplicationContext ac = new ClassPathXmlApplicationContext(path);
		UserService userService = (UserService) ac.getBean("userService");
		userService.addUser();
		userService.updateUser();
		userService.deleteUser();
	}

}
