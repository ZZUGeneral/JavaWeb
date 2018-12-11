package com.zzu.student.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zzu.student.dao.StudentDao;

/**
 * Servlet implementation class AddStudentServlet
 */
@WebServlet("/AddStudentServlet")
public class AddStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddStudentServlet() {
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
		// …Ë÷√«Î«Û∫ÕœÏ”¶±‡¬Î
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		String name = request.getParameter("name");
		String gender = request.getParameter("gender");
		String dept = request.getParameter("dept");
		String birthday = request.getParameter("birthday");
		birthday = birthday.replace("/", "-");
		String email = request.getParameter("email");
		String fileName = "a.png";
		StudentDao dao = new StudentDao();
		long stu_no = dao.addStudent(name, gender, dept, birthday, email, fileName);
		PrintWriter out = response.getWriter();
		out.print("<script type='text/javascript'>");
		out.print("alert('’À∫≈:" + stu_no + "\n√‹¬Î:" + 123456 + "');");
		out.print("window.location='password.jsp';");
		out.print("</script>");
	}

}
