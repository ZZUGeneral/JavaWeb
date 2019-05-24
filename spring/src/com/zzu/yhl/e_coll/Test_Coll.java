package com.zzu.yhl.e_coll;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test_Coll {
	@Test
	public void demo() {
		String path = "/com/zzu/yhl/e_coll/applicationContext.xml";
		ApplicationContext ac = new ClassPathXmlApplicationContext(path);
		CollData collData = (CollData) ac.getBean("collDataId");
		System.out.println(collData.toString());

	}
}
