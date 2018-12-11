package com.zzu.student.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zzu.student.bean.MyselfBean;
import com.zzu.student.dao.MyselfDao;

/**
 * Servlet implementation class MyselfServlet
 */
@WebServlet("/MyselfServlet")
public class MyselfServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MyselfServlet() {
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
		String no = request.getParameter("No");
		long No = Long.parseLong(no);
		MyselfBean myself = new MyselfBean();
		MyselfDao dao = new MyselfDao();
		if (no.startsWith("6778")) {
			myself = dao.getTeacherDetail(No);
		} else {
			myself = dao.getStudentDetail(No);
		}

		request.setAttribute("myself", myself);
		request.getRequestDispatcher("/myself_detail.jsp").forward(request, response);
	}

}
