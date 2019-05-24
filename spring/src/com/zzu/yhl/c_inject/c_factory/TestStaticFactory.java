package com.zzu.yhl.c_inject.c_factory;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestStaticFactory {
	/*
	 * @Test public void demo01() { UserService service = new
	 * MyBeanFactory().createService(); service.addUser(); }
	 */
	@Test
	public void demo02() {
		String xmlPath = "com/zzu/yhl/c_inject/c_factory/bean.xml";
		ApplicationContext ac = new ClassPathXmlApplicationContext(xmlPath);
		UserService service = (UserService) ac.getBean("userServiceId");
		service.addUser();
	}

}
