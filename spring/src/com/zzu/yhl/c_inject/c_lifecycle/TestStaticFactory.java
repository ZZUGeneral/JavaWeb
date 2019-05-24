package com.zzu.yhl.c_inject.c_lifecycle;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestStaticFactory {
	/*
	 * @Test public void demo01() { UserService service = new
	 * MyBeanFactory().createService(); service.addUser(); }
	 */
	@Test
	public void demo02() throws Exception {
		String xmlPath = "com/zzu/yhl/c_inject/c_lifecycle/bean.xml";
		ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext(xmlPath);
		UserService service = (UserService) ac.getBean("userServiceId");
		UserService service1 = (UserService) ac.getBean("userServiceId");
		System.out.println(service);
		System.out.println(service1);
		// 要求：1.容器必须close，销毁方法执行; 2.必须是单例的
		// ac.getClass().getMethod("close").invoke(ac);
		// * 此方法接口中没有定义，实现类提供
		ac.close();
	}

}
