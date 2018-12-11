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

import com.zzu.student.bean.StudentScoreBean;
import com.zzu.student.dao.ScoreBeanDao;

/**
 * Servlet implementation class ShowStudentScoreServlet
 */
@WebServlet("/ShowStudentScoreServlet")
public class ShowStudentScoreServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private int pageNo;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ShowStudentScoreServlet() {
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
		long teacher_no = (long) request.getSession().getAttribute("SESSION_NO");
		List<StudentScoreBean> ssbList = new ArrayList<StudentScoreBean>();
		ScoreBeanDao dao = new ScoreBeanDao();
		ssbList = dao.getStudentScore(teacher_no, pageNo);
		request.setAttribute("ssbList", ssbList);
		request.getRequestDispatcher("/get_score_list.jsp").forward(request, response);
	}

}
