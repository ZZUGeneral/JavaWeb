package com.zzu.student.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zzu.student.dao.ScoreBeanDao;

/**
 * Servlet implementation class StudentScoreServlet
 */
@WebServlet("/UpdateStudentScoreServlet")
public class UpdateStudentScoreServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UpdateStudentScoreServlet() {
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
		String updateScore = request.getParameter("score");
		float score = Float.parseFloat(updateScore);
		String no = request.getParameter("stu_no");
		long stu_no = Long.parseLong(no);
		String courseNo = request.getParameter("course_no");
		int course_no = Integer.parseInt(courseNo);
		ScoreBeanDao dao = new ScoreBeanDao();
		int i = dao.updateScore(stu_no, score, course_no);
		if (i > 0) {
			request.getRequestDispatcher("/ShowStudentScoreServlet?page=false").forward(request, response);
		} else {
			PrintWriter out = response.getWriter();
			out.print("<script type='text/javascript'>");
			out.print("alert('更新失败！');");
			out.print("window.location='ShowStudentScoreServlet?page=false'");
			out.print("</script>");
		}
	}

}
