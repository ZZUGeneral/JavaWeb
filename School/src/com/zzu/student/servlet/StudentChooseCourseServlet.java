package com.zzu.student.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zzu.student.bean.CourseBean;
import com.zzu.student.dao.CourseDao;

/**
 * Servlet implementation class StudentChooseCourseServlet
 */
@WebServlet("/StudentChooseCourseServlet")
public class StudentChooseCourseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private int pageNo;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public StudentChooseCourseServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void init(ServletConfig config) throws ServletException {
		pageNo = 0;
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
		String page = request.getParameter("page");
		if (page.equals("first")) {
			pageNo = 0;
		}
		if (page.equals("previous")) {
			pageNo--;

		}
		if (page.equals("next")) {
			pageNo++;
		}
		if (page.equals("last")) {
			pageNo = -1;
		}
		CourseDao dao = new CourseDao();
		List<CourseBean> cbList = new ArrayList<CourseBean>();
		cbList = dao.chooseCourse(pageNo);
		request.setAttribute("cbList", cbList);
		request.getRequestDispatcher("/choose_course_list.jsp").forward(request, response);
	}

}
