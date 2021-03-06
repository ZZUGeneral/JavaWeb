package com.spring.demo;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.dao.ExampleBean;
import com.spring.dao.JDBCDataSource;
import com.spring.dao.MessageBean;
import com.spring.dao.UserDao;
import com.spring.entity.User;
import com.spring.service.UserLoginService;

public class TestCase {
	@Test
	public void test() {
		String conf = "applicationContext.xml";
		ApplicationContext ac = new ClassPathXmlApplicationContext(conf);
		System.out.println(ac);
		Calendar cr = ac.getBean("calendarObj1",Calendar.class);
		System.out.println("calendarObj1:"+cr);
		Calendar cr2 = ac.getBean("calendarObj2",Calendar.class);
		System.out.println("calendarObj2:"+cr2);
		Date date = ac.getBean("dateObj",Date.class);
		System.out.println("calendarObj3:"+date);
	}
	
	@Test
	public void testExampleBean(){
		String conf = "applicationContext.xml";
		ApplicationContext ac = new ClassPathXmlApplicationContext(conf);
		ExampleBean eb = ac.getBean("exampleBean",ExampleBean.class);
		ExampleBean eb2 = ac.getBean("exampleBean",ExampleBean.class);
		System.out.println(eb == eb2);
		AbstractApplicationContext aac = (AbstractApplicationContext) ac;
		aac.close();
	}
	@Test
	public void testJDBCDataSource() throws SQLException{
		String conf = "applicationContext.xml";
		ApplicationContext ac = new ClassPathXmlApplicationContext(conf);
		JDBCDataSource jds = ac.getBean("dataSource",JDBCDataSource.class);
		Connection cn = jds.getConnection();
		System.out.println(cn);
	}
	@Test
	public void testFindUserByName(){
		String con = "applicationContext.xml";
		ApplicationContext ac = new  ClassPathXmlApplicationContext(con);
		UserDao userDao = ac.getBean("userDao",UserDao.class);
		User user = userDao.findUserByName("lisi");
		System.out.println(user);
		
	}
	@Test
	public void testUserLogin(){
		String con = "applicationContext.xml";
		ApplicationContext ac = new ClassPathXmlApplicationContext(con);
		UserLoginService us = ac.getBean("userLoginService",UserLoginService.class);
		User user = us.login("lisi", "321654");
		System.out.println(user);
	}
	@Test
	public void testMessageBean(){
		String con ="applicationContext.xml";
		ApplicationContext ac = new ClassPathXmlApplicationContext(con);
		MessageBean mb = ac.getBean("messageBean",MessageBean.class);
		mb.excute();
	}
	@Test
	public void testMessageBean2(){
		String con = "applicationContext.xml";
		ApplicationContext ac = new ClassPathXmlApplicationContext(con);
		MessageBean mb = ac.getBean("message2",MessageBean.class);
		mb.excute();
	}
	@Test
	public void testComponent(){
		String con = "applicationContext.xml";
		AbstractApplicationContext ac =new ClassPathXmlApplicationContext(con);
		ExampleBean eb = ac.getBean("exampleBean",ExampleBean.class);
		ExampleBean eb2 = ac.getBean("exampleBean",ExampleBean.class);
		System.out.println(eb==eb2);
		eb.excute();
		ac.close();
	}

}
