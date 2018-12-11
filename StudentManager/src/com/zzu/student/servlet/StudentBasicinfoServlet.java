package com.zzu.student.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zzu.student.bean.Student;
import com.zzu.student.dao.StudentDao;

/**
 * Servlet implementation class StudentServlet
 */
@WebServlet("/StudentBasicinfoServlet")
public class StudentBasicinfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private int pageNo;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public StudentBasicinfoServlet() {
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
		// �����������Ӧ����
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		StudentDao dao = new StudentDao();
		List<Student> list = new ArrayList<Student>();
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
		list = dao.getBasicinfoForStudent(pageNo);
		request.setAttribute("stuList", list);
		request.getRequestDispatcher("/student_list.jsp").forward(request, response);

	}

}
