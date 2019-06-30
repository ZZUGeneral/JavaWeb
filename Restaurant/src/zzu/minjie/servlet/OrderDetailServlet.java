package zzu.minjie.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import zzu.minjie.bean.Order;
import zzu.minjie.dao.OrderDao;

@WebServlet("/OrderDetailServlet")
public class OrderDetailServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 207305745301520924L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public OrderDetailServlet() {
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
		request.setCharacterEncoding("UTF-8");
		String orderNo = request.getParameter("orderNo");
		OrderDao dao = new OrderDao();
		List<Order> foodList = dao.getFoodList(orderNo);
		float sum = 0;
		for (Order o : foodList) {
			sum = sum + o.getPrice() * o.getNumber();
		}
		request.setAttribute("sum", sum);
		request.setAttribute("FoodList", foodList);
		request.getRequestDispatcher("/orderDetail.jsp").forward(request, response);
	}

}
