package com.zzu.student.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zzu.student.dao.CourseDao;

/**
 * Servlet implementation class AddCourseServlet
 */
@WebServlet("/AddCourseServlet")
public class AddCourseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddCourseServlet() {
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
		long teacher_no = (long) request.getSession().getAttribute("SESSION_NO");
		String course_name = request.getParameter("course_name");
		String credit1 = request.getParameter("credit");
		float credit = Float.parseFloat(credit1);
		String type1 = request.getParameter("type");
		int type = Integer.parseInt(type1);
		CourseDao dao = new CourseDao();
		boolean insert = dao.addCourse(teacher_no, course_name, credit, type);
		PrintWriter out = response.getWriter();
		if (insert) {
			out.print("<script type='text/javascript'>");
			out.print("alert('添加成功');");
			out.print("window.location='/StudentManager/TeacherCourseServlet';");
			out.print("</script>");
		} else {
			out.print("<script type='text/javascript'>");
			out.print("alert('添加失败！');");
			out.print("window.location='addCourse.jsp';");
			out.print("</script>");
		}

	}

}
