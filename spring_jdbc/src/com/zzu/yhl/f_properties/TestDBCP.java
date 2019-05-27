package com.zzu.yhl.f_properties;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.zzu.yhl.a_domain.User;

public class TestDBCP {
	@Test
	public void demo01() {
		/*
		 * User user = new User(); user.setId(1); user.setUsername("杰克");
		 * user.setPassword("123456");
		 */
		String path = "com/zzu/yhl/f_properties/demo.xml";
		ApplicationContext ac = new ClassPathXmlApplicationContext(path);
		UserDao dao = (UserDao) ac.getBean("userDao");
		// dao.update(user);

		List<User> allUser = dao.findAll();
		for (User user : allUser) {
			System.out.println(user);
		}

	}

}
