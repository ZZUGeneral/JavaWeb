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
 * Servlet implementation class DeleteCourseServlet
 */
@WebServlet("/DeleteCourseServlet")
public class DeleteCourseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DeleteCourseServlet() {
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

		String courseNo = request.getParameter("courseNo");
		int course_no = Integer.parseInt(courseNo);
		CourseDao dao = new CourseDao();
		boolean rs = dao.delete(course_no);
		PrintWriter out = response.getWriter();
		if (rs) {
			out.print("<script type='text/javascript'>");
			out.print("alert('删除成功');");
			out.print("window.location='/StudentManger/StudentChooseCourseServlet?page=false");
			out.print("</script>");
		} else {
			out.print("<script type='text/javascript'>");
			out.print("alert('删除失败！');");
			out.print("window.location='/StudentManager/StudentChooseCourseServlet?page=false");
			out.print("</script>");
		}
	}

}
