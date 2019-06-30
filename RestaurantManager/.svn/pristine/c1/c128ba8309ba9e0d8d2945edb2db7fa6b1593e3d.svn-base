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
 * Servlet implementation class Order2Servlet
 */
@WebServlet("/Order3Servlet")
public class Order3Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Order3Servlet() {
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

		String type = request.getParameter("action");
		System.out.println(type);
		String orderNo = request.getParameter("order");
		System.out.println(orderNo);
		OrderDao dao = new OrderDao();

		if (type.equals("ok")) {
			dao.updateStatus("3", orderNo);
			System.out.println("ok");
		}
		if (type.equals("no")) {
			dao.updateStatus("0", orderNo);
			System.out.println("no");
		}
		request.getRequestDispatcher("/OrderListServlet").forward(request, response);
	}

}
