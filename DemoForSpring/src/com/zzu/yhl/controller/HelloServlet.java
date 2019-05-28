package com.zzu.yhl.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.zzu.yhl.service.AccountService;

@WebServlet("HelloServlet")
public class HelloServlet extends HttpServlet {

	// 从 applicationContext 作用域(ServletContext)获得spring容器

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// 方法1 : 手动从作用于获得
		ApplicationContext ac = (ApplicationContext) this.getServletContext()
				.getAttribute(WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE);
//方法2 : 通过工具获取
		ApplicationContext ac2 = WebApplicationContextUtils.getWebApplicationContext(this.getServletContext());
		AccountService accountService = (AccountService) ac2.getBean("accountService");
		accountService.transfer("jack", "rose", 1000);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}

}
