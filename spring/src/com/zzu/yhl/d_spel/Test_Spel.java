package com.zzu.yhl.d_spel;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test_Spel {
	@Test
	public void demo() {
		String path = "/com/zzu/yhl/d_spel/applicationContext.xml";
		ApplicationContext ac = new ClassPathXmlApplicationContext(path);
		Customer s = (Customer) ac.getBean("customerId");
		System.out.println(s.toString());

	}
}
