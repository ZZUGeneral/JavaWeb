package com.zzu.yhl.a_P;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.zzu.yhl.demo01.UserService;

public class TestP {
	@Test
	public void demo01() {
		// 1获取容器
		String xmlPath = "/com/zzu/yhl/a_P/applicationContext.xml";
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(xmlPath);
		// 2获得内容 --不需要自己new，都是从spring容器获得
		Person person = (Person) applicationContext.getBean("personId");
		System.out.println(person.toString());
	}
}
