package com.zzu.yhl.b_cglib;

import java.lang.reflect.Method;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

public class MyBeanFactory {
	public static UserServiceImpl createService() {
		// 1目标类
		final UserServiceImpl userService = new UserServiceImpl();
		// 2切面类
		final MyAspect myAspect = new MyAspect();
		/**
		 * 3 代理类,采用 cglib，就是创建目标类的子类
		 */

		// 3.1 核心类
		Enhancer enhancer = new Enhancer();

		// 3.2 确定父类
		enhancer.setSuperclass(userService.getClass());
		/**
		 *  3.3 设置回调函数,MethodInterceptor接口等效jdk InvocationHandler接口
		 *  intercept() 等效于 jdk invoke(), 参数与invoke一样
		 *  参数 4 ：放大的代理
		 * 
		 */

		enhancer.setCallback(new MethodInterceptor() {

			@Override
			public Object intercept(Object proxy, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
				// TODO Auto-generated method stub
				//前执行
				myAspect.before();
				// 执行目标类的方法
				Object obj = method.invoke(userService, args);
				
				//执行代理类的父类，即执行目标类（目标类是代理类的父类）
				methodProxy.invokeSuper(proxy, args);
				// 后执行
				myAspect.after();
				return obj;
			}
		});
		;
		// 3.4 创建代理
		UserServiceImpl proxService = (UserServiceImpl) enhancer.create();

		return proxService;
	}
}
