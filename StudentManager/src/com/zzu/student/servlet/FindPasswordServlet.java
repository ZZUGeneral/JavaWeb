package com.zzu.student.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zzu.student.bean.MyselfBean;
import com.zzu.student.dao.AdminDao;
import com.zzu.student.dao.DeptDao;
import com.zzu.student.dao.StudentDao;
import com.zzu.student.dao.TeacherDao;

/**
 * Servlet implementation class FindPasswordServlet
 */
@WebServlet("/FindPasswordServlet")
public class FindPasswordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public FindPasswordServlet() {
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
		response.setContentType("text/html;charset=UTF-8");
		String no = request.getParameter("no");
		String name = request.getParameter("name");
		String gender = request.getParameter("gender");
		String dept = request.getParameter("dept");
		DeptDao deptDao = new DeptDao();
		int dept_no = Integer.parseInt(dept);
		dept = deptDao.getDeptNameByNo(dept_no);
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		long No = Long.parseLong(no);
		MyselfBean m = new MyselfBean();
		m.setNo(No);
		m.setDept(dept);
		m.setEmail(email);
		m.setGender(gender);
		m.setName(name);
		boolean result = false;
		if (no.startsWith("6778")) {
			TeacherDao dao = new TeacherDao();
			if (dao.getSure(m)) {
				result = dao.updatePassword(No, password);
			}

		} else if (!no.equals("admin")) {
			StudentDao dao = new StudentDao();
			if (dao.getSure(m)) {
				System.out.println(password);
				result = dao.updatePassword(No, password);
			}
		} else {
			AdminDao dao = new AdminDao();
			result = dao.updatePassword(password);
		}

		PrintWriter out = response.getWriter();
		if (result) {
			out.print("<script type='text/javascript'>");
			out.print("alert('修改成功！');");
			out.print("window.location='login.jsp';");
			out.print("</script>");

		} else {
			out.print("<script type='text/javascript'>");
			out.print("alert('修改失败！');");
			out.print("window.location='findpsd.jsp';");
			out.print("</script>");
		}
	}

}
