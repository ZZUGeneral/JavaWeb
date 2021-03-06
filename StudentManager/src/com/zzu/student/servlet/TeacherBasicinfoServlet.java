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

import com.zzu.student.bean.Teacher;
import com.zzu.student.dao.TeacherDao;

/**
 * Servlet implementation class TeacherBasicinforServlet
 */
@WebServlet("/TeacherBasicinfoServlet")
public class TeacherBasicinfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private int pageNo;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public TeacherBasicinfoServlet() {
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
		TeacherDao dao = new TeacherDao();
		List<Teacher> list = new ArrayList<Teacher>();
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
		list = dao.getBasicinfoForTeacher(pageNo);
		request.setAttribute("teacherList", list);
		request.getRequestDispatcher("/teacher_list.jsp").forward(request, response);
	}

}
