package com.zzu.yhl.g_annotation.c_other;

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
		String xmlPath = "com/zzu/yhl/g_annotation/c_other/bean.xml";
		ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext(xmlPath);
		UserService service = (UserService) ac.getBean("userServiceId");
		UserService service1 = (UserService) ac.getBean("userServiceId");
		System.out.println(service);
		System.out.println(service1);
		ac.close();
	}

}
