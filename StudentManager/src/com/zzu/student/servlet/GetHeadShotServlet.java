package com.zzu.student.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zzu.student.dao.HeadShotDao;

/**
 * Servlet implementation class GetHeadShotServlet
 */
@WebServlet("/GetHeadShotServlet")
public class GetHeadShotServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GetHeadShotServlet() {
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
		String no = request.getParameter("No");
		long No = Long.parseLong(no);
		HeadShotDao dao = new HeadShotDao();
		String fileName = "a.png";
		if (no.startsWith("6778")) {
			fileName = dao.getHeadShotForTeacher(No);
		} else {
			fileName = dao.getHeadShotForStudent(No);
		}
		request.setAttribute("headShot", fileName);
		request.getRequestDispatcher("/headShot.jsp").forward(request, response);
	}

}
