package com.zzu.student.filter;

import java.io.IOException;

import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class AutoFilter
 */
@WebFilter(urlPatterns = { "/StudenrManager/WenContent/*" },
initParams = {@WebInitParam(name = "loginPage", value = "login.jsp") },
dispatcherTypes = { DispatcherType.REQUEST,DispatcherType.FORWARD })
public class AutoFilter implements Filter {
	private String loginPage = "login.jsp";
	/**
	 * Default constructor.
	 */
	public AutoFilter() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
		this.loginPage = null;
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here

		// pass the request along the filter chain
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpServletResponse httpResponse = (HttpServletResponse) response;
		HttpSession session = httpRequest.getSession();
		if (session.getAttribute("SESSION_NO") != null) {
			chain.doFilter(request, response);
		} else {
			// pass the request along the filter chain
			// httpResponse.sendRedirect("/School/login.jsp");
			httpRequest.getRequestDispatcher("/"+loginPage).forward(httpRequest, httpResponse);
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
		loginPage = fConfig.getInitParameter("loginPage");
		if(null == loginPage) {
			loginPage = "login.jsp";
		}
	}

}
