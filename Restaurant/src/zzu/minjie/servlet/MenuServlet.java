package zzu.minjie.servlet;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import zzu.minjie.bean.Food;
import zzu.minjie.dao.MenuDao;;

@WebServlet("/MenuServlet")
public class MenuServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public MenuServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 设置请求和响应编码
		request.setCharacterEncoding("UTF-8");
		// String type = request.getParameter("type");
		response.setContentType("text/html;charset=UTF-8");
		// 获取请求操作类型
		String type = request.getParameter("type");
		String dish = request.getParameter("dish");
		// System.out.println(type);
		if ("select1".equals(dish)) {
			// 查询川菜
			MenuDao dao = new MenuDao();
			List<Food> foodList = dao.getMenuList("川菜");
			System.out.println(foodList);
			// 将信息存入request对象进行请求转发
			request.setAttribute("foodList", foodList);
			request.setAttribute("dish", dish);
			// System.out.println("数据库检索数据执行了");
			request.getRequestDispatcher("orders.jsp").forward(request, response);
		} else if ("select2".equals(dish)) {
			// 查询浙菜
			MenuDao dao = new MenuDao();
			List<Food> foodList = dao.getMenuList("浙菜");
			// 将信息存入request对象进行请求转发
			request.setAttribute("foodList", foodList);
			request.setAttribute("dish", dish);
			request.getRequestDispatcher("orders.jsp").forward(request, response);
		} else if ("select3".equals(dish)) {
			// 查询徽菜
			MenuDao dao = new MenuDao();
			List<Food> foodList = dao.getMenuList("徽菜");
			// 将信息存入request对象进行请求转发
			request.setAttribute("foodList", foodList);
			request.setAttribute("dish", dish);
			request.getRequestDispatcher("orders.jsp").forward(request, response);
		} else if ("select4".equals(dish)) {
			// 查询闽菜
			MenuDao dao = new MenuDao();
			List<Food> foodList = dao.getMenuList("闽菜");
			// 将信息存入request对象进行请求转发
			request.setAttribute("foodList", foodList);
			request.setAttribute("dish", dish);
			request.getRequestDispatcher("orders.jsp").forward(request, response);
		} else if ("select5".equals(dish)) {
			// 查询苏菜
			MenuDao dao = new MenuDao();
			List<Food> foodList = dao.getMenuList("苏菜");
			// 将信息存入request对象进行请求转发
			request.setAttribute("foodList", foodList);
			request.setAttribute("dish", dish);
			request.getRequestDispatcher("orders.jsp").forward(request, response);
		} else if ("select6".equals(dish)) {
			// 查询湘菜
			MenuDao dao = new MenuDao();
			List<Food> foodList = dao.getMenuList("湘菜");
			// 将信息存入request对象进行请求转发
			request.setAttribute("foodList", foodList);
			request.setAttribute("dish", dish);
			request.getRequestDispatcher("orders.jsp").forward(request, response);
		}
		if ("add".equals(type)) {  //加入购物车操作
			// 获取菜品Id
			int foodid = Integer.parseInt(request.getParameter("FoodId"));
			// 获取用户Id作为购物车cartId
			String userId = (String) request.getSession().getAttribute("userId");

			// 获取菜的价格
			float price = Float.parseFloat(request.getParameter("MemberPrice"));
			// 获取菜品名称
			String name = (String) request.getParameter("FoodName");
			// 获取图片
			String image = (String) request.getParameter("Image");
			// System.out.println("菜品数据获取了，下一步执行存储");
			// System.out.println(foodid+" "+userId+" "+price+" "+name+" "+image);
			MenuDao dao = new MenuDao();

			dao.save(foodid, userId, price, name, image);
			// System.out.println("数据库存储执行了");
			// request.setAttribute("dish", dish);
			request.getRequestDispatcher("MenuServlet?dish=dish").forward(request, response);

		}

	}

}