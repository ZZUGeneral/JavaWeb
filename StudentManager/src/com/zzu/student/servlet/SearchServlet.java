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
import com.zzu.student.bean.ScoreBean;
import com.zzu.student.bean.Student;
import com.zzu.student.bean.StudentScoreBean;
import com.zzu.student.bean.Teacher;
import com.zzu.student.dao.SearchDao;

/**
 * Servlet implementation class SearchServlet
 */
@WebServlet("/SearchServlet")
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SearchServlet() {
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
		String location = request.getParameter("location");
		String keyword = request.getParameter("keyword");
		long no = (long) request.getSession().getAttribute("SESSION_NO");
		SearchDao dao = new SearchDao();
		switch (location) {
		case "course":
			List<CourseBean> cbList = new ArrayList<CourseBean>();
			cbList = dao.getCourseBeanSearch(keyword, no);

			request.setAttribute("cbList", cbList);
			request.getRequestDispatcher("/course_list.jsp").forward(request, response);
			break;
		case "choose":
			List<CourseBean> ccList = new ArrayList<CourseBean>();
			ccList = dao.getChooseCourseSearch(keyword);

			request.setAttribute("cbList", ccList);
			request.getRequestDispatcher("/choose_course_list.jsp").forward(request, response);
			break;
		case "student":
			List<Student> stuList = new ArrayList<Student>();
			stuList = dao.getStudentSearch(keyword, no);
			request.setAttribute("stuList", stuList);
			request.getRequestDispatcher("/student_list.jsp").forward(request, response);
			break;
		case "score":
			List<ScoreBean> ssbList = new ArrayList<ScoreBean>();
			ssbList = dao.getScoreBeanSearch(keyword, no);
			request.setAttribute("ssbList", ssbList);
			request.getRequestDispatcher("/score_list.jsp").forward(request, response);

			break;
		case "teacher":
			List<Teacher> teacherList = new ArrayList<Teacher>();
			teacherList = dao.getTeacherSearch(keyword);
			request.setAttribute("teacherList", teacherList);
			request.getRequestDispatcher("/teacher_list.jsp").forward(request, response);
			break;
		case "getscore":
			List<StudentScoreBean> gsbList = new ArrayList<StudentScoreBean>();
			gsbList = dao.getStudentScoreSearch(keyword, no);
			request.setAttribute("ssbList", gsbList);
			request.getRequestDispatcher("/get_score_list.jsp").forward(request, response);

			break;
		}

	}

}
