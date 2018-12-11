package com.zzu.student.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zzu.student.dao.DeptDao;
import com.zzu.student.dao.StudentDao;
import com.zzu.student.dao.TeacherDao;

/**
 * Servlet implementation class UpdateMyselfServlet
 */
@WebServlet("/UpdateMyselfServlet")
@MultipartConfig
public class UpdateMyselfServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UpdateMyselfServlet() {
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
		String no = request.getParameter("no");
		String name = request.getParameter("name");
		String gender = request.getParameter("gender");
		String dept = request.getParameter("dept");
		String birthday = request.getParameter("birthday");
		String email = request.getParameter("email");
		long No = Long.parseLong(no);
		int dept_no = Integer.parseInt(dept);
		DeptDao dDao = new DeptDao();
		String dept_name = dDao.getDeptNameByNo(dept_no);
		boolean update = false;
		if (no.startsWith("6778")) {
			TeacherDao dao = new TeacherDao();
			update = dao.updateInfo(no, name, gender, dept_name, birthday, email);
		} else {
			StudentDao dao = new StudentDao();
			update = dao.updateInfo(no, name, gender, dept_name, birthday, email);
		}
		PrintWriter out = response.getWriter();
		if (update) {
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
