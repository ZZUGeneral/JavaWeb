package zzu.minjie.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import zzu.minjie.bean.Order;
import zzu.minjie.dao.OrderDao;

/**
 * Servlet implementation class HistoryOrderServlet
 */
@WebServlet("/HistoryOrderServlet")
public class HistoryOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor.
	 */
	public HistoryOrderServlet() {
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
		request.setCharacterEncoding("UTF-8");
		String userID = (String) request.getSession().getAttribute("userId");

		OrderDao dao = new OrderDao();
		// 获取登录用户订单的订单编号，订单时间，以及订单总价钱
		List<Order> orderList = dao.getOrderList(userID);
		request.setAttribute("OrderList", orderList);
		request.getRequestDispatcher("/historyOrder.jsp").forward(request, response);
	}

}
