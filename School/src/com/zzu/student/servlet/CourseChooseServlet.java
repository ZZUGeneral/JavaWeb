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
 * Servlet implementation class CourseChooseServlet
 */
@WebServlet("/CourseChooseServlet")
public class CourseChooseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CourseChooseServlet() {
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
		String courseNo = request.getParameter("courseNo");
		int course_no = Integer.parseInt(courseNo);
		long stu_no = (long) request.getSession().getAttribute("SESSION_NO");
		CourseDao dao = new CourseDao();
		int rs = dao.addSC(stu_no, course_no);
		PrintWriter out = response.getWriter();
		if (rs > 0) {
			out.print("<script type='text/javascript'>");
			out.print("alert('选课成功！');");
			out.print("window.location='/School/StudentCourseServlet';");
			out.print("</script>");
		} else {
			out.print("<script type='text/javascript'>");
			out.print("alert('选课失败！');");
			out.print("window.location='/School/StudentChooseCourseServlet?page=false';");
			out.print("</script>");
		}
	}

}
