package com.zzu.minjie.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zzu.minjie.Util.CookieEncryptTool;
import com.zzu.minjie.dao.AdminDao;

/**
 * Servlet implementation class Login
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		String ID = request.getParameter("ID");
		String password = request.getParameter("password");
		String rememberMe = request.getParameter("cookiesave");
		if (ID != null && !ID.equals("")) {
			AdminDao dao = new AdminDao();
			String name = dao.login(ID, password);
			if (name != null) {// 存在这个用户，
				// 输入的验证码正确
				request.getSession().setAttribute("Name", name);
				request.getSession().setAttribute("userId", ID);
				rememberMe(rememberMe, ID, password, request, response);
				request.getRequestDispatcher("index.jsp").forward(request, response);
			} else {// 不存在这个用户，给出提示，转回登录页面
				PrintWriter out = response.getWriter();
				out.print("<script type='text/javascript'>");
				out.print("alert('账号或密码错误！');");
				out.print("window.location='login.jsp';");
				out.print("</script>");
			}
		}
	}

	private void rememberMe(String rememberMe, String ID, String password, HttpServletRequest request,
			HttpServletResponse response) {
		System.out.println(rememberMe);
		if ("true".equals(rememberMe)) {
			Cookie cookie = new Cookie("COOKIE_APPLICANTID", CookieEncryptTool.encodeBase64(ID));
			cookie.setPath("/");
			cookie.setMaxAge(5 * 24 * 3600);
			response.addCookie(cookie);

			cookie = new Cookie("COOKIE_APPLICANTPWD", CookieEncryptTool.encodeBase64(password));
			cookie.setPath("/");
			cookie.setMaxAge(5 * 24 * 3600);
			response.addCookie(cookie);
		} else {
			Cookie[] cookies = request.getCookies();
			if (cookies != null) {
				for (Cookie cookie : cookies) {
					if ("COOKIE_APPLICANTEMAIL".equals(cookie.getName())
							|| "COOKIE_APPLICANTPWD".equals(cookie.getName())) {
						cookie.setMaxAge(0);
						cookie.setPath("/");
						response.addCookie(cookie);
					}
				}
			}
		}
	}

}
