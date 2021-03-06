package com.zzu.minjie.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zzu.minjie.bean.Order;
import com.zzu.minjie.dao.OrderDao;

/**
 * Servlet implementation class OrderSearchServlet
 */
@WebServlet("/OrderSearchServlet")
public class OrderSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public OrderSearchServlet() {
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

		String orderNo = request.getParameter("OID");

		OrderDao dao = new OrderDao();
		List<Order> order = new ArrayList<Order>();

		order = dao.searchOrderByOrderNo(orderNo);
		System.out.print(order);

		// 将查询到的企业信息存入request请求域
		request.setAttribute("order", order);

		// 请求转发
		/*
		 * 从servlet传参跳转到jsp页面
		 */
		request.getRequestDispatcher("/order_search.jsp").forward(request, response);
		// }
	}

}
