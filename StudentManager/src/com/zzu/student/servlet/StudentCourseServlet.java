package com.zzu.student.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zzu.student.bean.CourseBean;
import com.zzu.student.dao.CourseDao;

/**
 * Servlet implementation class SCServlet
 */
@WebServlet("/StudentCourseServlet")
public class StudentCourseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public StudentCourseServlet() {
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
		long stu_no = (long) request.getSession().getAttribute("SESSION_NO");
		CourseDao dao = new CourseDao();
		List<CourseBean> cbList = new ArrayList<CourseBean>();
		cbList = dao.getCourseForStudent(stu_no);
		request.setAttribute("cbList", cbList);
		request.getRequestDispatcher("/course_list.jsp").forward(request,response);

	}

}
