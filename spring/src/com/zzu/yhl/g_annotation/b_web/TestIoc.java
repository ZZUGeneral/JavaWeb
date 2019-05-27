package com.zzu.yhl.g_annotation.b_web;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestIoc {
	@Test
	public void demo01() {
		// 1获取容器
		String xmlPath = "/com/zzu/yhl/g_annotation/b_web/applicationContext.xml";
		@SuppressWarnings("resource")
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(xmlPath);
		// 2获得内容 --不需要自己new，都是从spring容器获得
		StudentAction action = (StudentAction) applicationContext.getBean("studentAction");
		action.execute();
	}

}
