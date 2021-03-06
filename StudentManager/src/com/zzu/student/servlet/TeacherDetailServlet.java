package com.zzu.student.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zzu.student.bean.Student;
import com.zzu.student.bean.Teacher;
import com.zzu.student.dao.TeacherDao;

/**
 * Servlet implementation class TeacherDetailServlet
 */
@WebServlet("/TeacherDetailServlet")
public class TeacherDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public TeacherDetailServlet() {
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
		String no = request.getParameter("teacherNo");
		Long teacher_no = Long.parseLong(no);
		TeacherDao dao = new TeacherDao();
		Teacher teacher = dao.getDetail(teacher_no);
		request.setAttribute("teacher", teacher);
		request.getRequestDispatcher("/teacher_detail.jsp").forward(request, response);
	}

}
