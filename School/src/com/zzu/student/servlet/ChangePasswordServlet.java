package com.zzu.student.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zzu.student.dao.StudentDao;
import com.zzu.student.dao.TeacherDao;

/**
 * Servlet implementation class ChangePasswordServlet
 */
@WebServlet("/ChangePasswordServlet")
public class ChangePasswordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ChangePasswordServlet() {
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
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		long No = (long) request.getSession().getAttribute("SESSION_NO");
		String oldPassword = request.getParameter("oldPassword");
		String newPassword = request.getParameter("newPassword");
		String verifyCode = request.getParameter("verifyCode");
		System.out.println(newPassword + "=====================" + oldPassword);
		String sessionVerifuCode = (String) request.getSession().getAttribute("SESSION_VALIDATECODE");
		String no = Long.toString(No);
		PrintWriter out = response.getWriter();
		boolean result = false;
		if (!sessionVerifuCode.equals(verifyCode)) {
			out.print("<script type='text/javascript'>");
			out.print("alert('请正确输入验证码！');");
			out.print("window.location='password.jsp';");
			out.print("</script>");
		} else {
			if (no.startsWith("6778")) {
				TeacherDao dao = new TeacherDao();
				result = dao.updatePassword(No, newPassword);

			} else {
				StudentDao dao = new StudentDao();
				result = dao.updatePassword(No, newPassword);
			}

		}
		if (result) {
			out.print("<script type='text/javascript'>");
			out.print("alert('修改成功！');");
			out.print("window.location='password.jsp';");
			out.print("</script>");

		} else {
			out.print("<script type='text/javascript'>");
			out.print("alert('修改失败！');");
			out.print("window.location='password.jsp';");
			out.print("</script>");
		}

	}

}
