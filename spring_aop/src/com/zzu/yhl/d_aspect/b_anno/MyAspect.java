package com.zzu.yhl.d_aspect.b_anno;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class MyAspect {
	// 切入点当前有效
	// @Before("execution(* com.zzu.yhl.d_aspect.b_anno.UserServiceImpl.*(..) )")
	public void myBefore(JoinPoint joinPoint) {
		System.out.println("前置通知：" + joinPoint.getSignature().getName());
	}
// 声明公共的切入点

	@Pointcut("execution(* com.zzu.yhl.d_aspect.b_anno.UserServiceImpl.*(..) )")
	public void myPointCut() {

	}

	// @AfterReturning(value="myPointCut()", returning="ret")
	public void myAfterReturning(JoinPoint joinPoint, Object ret) {
		System.out.println("后置通知：" + joinPoint.getSignature().getName() + "--->" + ret);
	}

	// @Around(value = "myPointCut()")
	public Object myAround(ProceedingJoinPoint joinPoint) throws Throwable {
		System.out.println("--------前---------");
		// 手动执行目标方法
		Object obj = joinPoint.proceed();
		System.out.println("--------后---------");
		return obj;

	}

	// @AfterThrowing(value = "myPointCut()", throwing = "e")
	public void myAfterThrowing(JoinPoint joinPoint, Throwable e) {
		System.out.println("抛出异常通知：" + e.getMessage());
	}

	@After("myPointCut()")
	public void myAfter(JoinPoint joinPoint) {
		System.out.println("最终通知");
	}
}
