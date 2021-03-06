package com.zzu.student.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zzu.student.dao.AdminDao;
import com.zzu.student.dao.StudentDao;
import com.zzu.student.dao.TeacherDao;
import com.zzu.student.util.CookieEncryptTool;

/**
 * Servlet implementation class LoginServlet
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
		// �����������Ӧ����
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		// ��ȡ�������
		long No = 0;
		String stu_no = request.getParameter("stu_no");
		if (!stu_no.equals("admin")) {
			No = Long.parseLong(stu_no);
		}
		String password = request.getParameter("password");
		String rememberMe = request.getParameter("rememberMe");
		String requestPath = request.getParameter("requestPath");
		// ��¼��֤
		String name = null;
		String identity = null;
		if (stu_no.startsWith("6778")) {
			TeacherDao dao = new TeacherDao();
			name = dao.login(No, password);
			identity = "teacher";

		} else if (stu_no.equals("admin")) {
			AdminDao dao = new AdminDao();
			name = dao.login(stu_no, password);
			identity = "admin";
		} else {
			StudentDao dao = new StudentDao();
			name = dao.login(No, password);
			identity = "student";
		}
		System.out.println("=============="+rememberMe);
		if (name != null) {
			rememberMe(rememberMe, stu_no, password, request, response);
			request.getSession().setAttribute("identity", identity);
			request.getSession().setAttribute("SESSION_NO", No);
			// ���Ѵ��ڣ�������ҳ
			identity = identity + ".jsp";
			response.sendRedirect(identity);
		} else {
			// �û���¼��Ϣ���󣬽��д�����ʾ
			out.print("<script type='text/javascript'>");
			out.print("alert('账号或密码错误！');");
			out.print("window.location='login.jsp';");
			out.print("</script>");
		}
	}

	private void rememberMe(String rememberMe, String stu_no, String password, HttpServletRequest request,
			HttpServletResponse response) {
		// �ж��Ƿ���Ҫͨ��Cookie��סѧ�ź�����
		if ("true".equals(rememberMe)) {
			// ��סѧ�ż�����
			Cookie cookie = new Cookie("COOKIE_NO", CookieEncryptTool.encodeBase64(stu_no));
			cookie.setPath("/");
			cookie.setMaxAge(365 * 24 * 3600);
			response.addCookie(cookie);

			cookie = new Cookie("COOKIE_PWD", CookieEncryptTool.encodeBase64(password));
			cookie.setPath("/");
			cookie.setMaxAge(365 * 24 * 3600);
			response.addCookie(cookie);
		} else {
			// �����估����Cookie���
			Cookie[] cookies = request.getCookies();
			if (cookies != null) {
				for (Cookie cookie : cookies) {
					if ("COOKIE_NO".equals(cookie.getName()) || "COOKIE_PWD".equals(cookie.getName())) {
						cookie.setMaxAge(0);
						cookie.setPath("/");
						response.addCookie(cookie);
					}
				}
			}
		}
	}

}
