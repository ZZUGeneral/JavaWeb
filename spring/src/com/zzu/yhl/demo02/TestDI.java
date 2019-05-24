package com.zzu.yhl.demo02;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.zzu.yhl.demo01.UserService;

public class TestDI {
	@Test
	public void demo02() {
		// 1获取容器
		String xmlPath = "com/zzu/yhl/demo02/applicationContext.xml";
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(xmlPath);
		// 2获得内容 --不需要自己new，都是从spring容器获得
		BookServiceImpl bookService = (BookServiceImpl) applicationContext.getBean("bookServiceId");
		bookService.addBook();
	}

}
