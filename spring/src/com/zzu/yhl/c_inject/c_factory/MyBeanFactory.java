package com.zzu.yhl.c_inject.c_factory;

/**
 * 实例工厂:方法非静态
 * @author YHL
 *
 */
public class MyBeanFactory {
	public UserService createService() {
		return new UserServiceImpl();
	}
}
