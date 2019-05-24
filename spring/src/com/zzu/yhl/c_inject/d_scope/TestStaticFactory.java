package com.zzu.yhl.c_inject.d_scope;

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
		String xmlPath = "com/zzu/yhl/c_inject/d_scope/bean.xml";
		ApplicationContext ac = new ClassPathXmlApplicationContext(xmlPath);
		UserService service = (UserService) ac.getBean("userServiceId");
		UserService service1 = (UserService) ac.getBean("userServiceId");
		System.out.println(service);
		System.out.println(service1);
	}

}
