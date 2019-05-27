package com.zzu.yhl.c_dbcp;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.zzu.yhl.a_domain.User;

public class TestDBCP {
	@Test
	public void demo01() {
		User user = new User();
		user.setId(1);
		user.setUsername("杰克123");
		user.setPassword("123456");
		
		String path = "com/zzu/yhl/c_dbcp/demo.xml";
		ApplicationContext ac = new ClassPathXmlApplicationContext(path);
		UserDao dao = (UserDao) ac.getBean("userDao");
		dao.update(user);
	}

}
