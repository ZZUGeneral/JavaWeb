package com.zzu.student.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zzu.student.bean.Student;
import com.zzu.student.dao.TeacherDao;

/**
 * Servlet implementation class TeacherStudentServlet
 */
@WebServlet("/TeacherStudentServlet")
public class TeacherStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public TeacherStudentServlet() {
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
		long teacher_no = (long) request.getSession().getAttribute("SESSION_NO");
		TeacherDao dao = new TeacherDao();
		List<Student> sList = new ArrayList<Student>();
		sList = dao.getStudent(teacher_no);
		request.setAttribute("stuList", sList);
		request.getRequestDispatcher("/student_list.jsp").forward(request, response);

	}

}
