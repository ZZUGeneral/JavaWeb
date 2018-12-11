package com.zzu.student.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zzu.student.dao.StudentDao;
import com.zzu.student.dao.TeacherDao;
import com.zzu.student.util.CookieEncryptTool;

/**
 * 学生登录 Servlet implementation class StudentLoginServlet
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
		// 设置请求和响应编码
		System.out.println("============1==========");
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		// 获取请求参数
		String stu_no = request.getParameter("stu_no");
		long No = Long.parseLong(stu_no);
		String password = request.getParameter("password");
		String rememberMe = request.getParameter("rememberMe");
		String requestPath = request.getParameter("requestPath");
		// 登录验证
		String name = null;
		if (!stu_no.startsWith("6778")) {
			StudentDao dao = new StudentDao();
			name = dao.login(No, password);
		} else {
			TeacherDao dao = new TeacherDao();
			name = dao.login(No, password);
		}

		if (name != null) {
			// 用户登录成功,将学生信息存入session
			// Student student = new Student(name, No, password);
			// request.getSession().setAttribute("SESSION_STUDENT", student);
			// 通过Cookie记住学号和密码
			rememberMe(rememberMe, stu_no, password, request, response);
			// 判断是否已存在请求路径
			/*
			 * if (!"".equals(requestPath) && null != requestPath) {
			 * response.sendRedirect(requestPath); } else {
			 */
			request.getSession().setAttribute("SESSION_NO", No);
			// 若学生已存在，跳到首页
			response.sendRedirect("index.jsp");
			// }
		} else {
			// 用户登录信息错误，进行错误提示
			out.print("<script type='text/javascript'>");
			out.print("alert('学号或密码错误，请重新输入！');");
			out.print("window.location='login.jsp';");
			out.print("</script>");
		}
	}

	private void rememberMe(String rememberMe, String stu_no, String password, HttpServletRequest request,
			HttpServletResponse response) {
		// 判断是否需要通过Cookie记住学号和密码
		if ("true".equals(rememberMe)) {
			// 记住学号及密码
			Cookie cookie = new Cookie("COOKIE_APPLICANTEMAIL", CookieEncryptTool.encodeBase64(stu_no));
			cookie.setPath("/");
			cookie.setMaxAge(365 * 24 * 3600);
			response.addCookie(cookie);

			cookie = new Cookie("COOKIE_APPLICANTPWD", CookieEncryptTool.encodeBase64(password));
			cookie.setPath("/");
			cookie.setMaxAge(365 * 24 * 3600);
			response.addCookie(cookie);
		} else {
			// 将邮箱及密码Cookie清空
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
