package com.zzu.yhl.b_factory_bean;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 * 切面类中确定通知，需要实现不同接口，借口就是规范，从而确定方法名称。
 *  采用“环绕通知” MethodInterceptor
 * 
 * @author YHL
 *
 */
public class MyAspect implements MethodInterceptor {

	@Override
	public Object invoke(MethodInvocation mi) throws Throwable {
		// TODO Auto-generated method stub
		System.out.println("前123");
		// 手动执行目标方法
		Object obj = mi.proceed();
		System.out.println("后123");
		return obj;
	}
}
