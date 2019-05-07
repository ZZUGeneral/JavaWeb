package zzu.minjie.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import zzu.minjie.bean.Food;
import zzu.minjie.dao.MenuDao;


@WebServlet("/MenuServlet")
public class MenuServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public MenuServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// 设置请求和响应编码
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		// 获取请求操作类型
		String type = request.getParameter("type");
		if("select1".equals(type)) {
		//查询川菜
		    MenuDao dao = new MenuDao();
		    List<Food> foodList = dao.getMenuList("川菜");
		    // 将成绩信息存入request对象进行请求转发
		    request.setAttribute("foodList", foodList);
		    request.getRequestDispatcher("/Restaurant/orders.html").forward(request, response);
       }
		else if("select2".equals(type)) {
		//查询浙菜
		    MenuDao dao = new MenuDao();
		    List<Food> foodList = dao.getMenuList("浙菜");
		    // 将成绩信息存入request对象进行请求转发
		    request.setAttribute("foodList", foodList);
		    request.getRequestDispatcher("orders.html").forward(request, response);
       }
		else if("select3".equals(type)) {
		//查询徽菜
		    MenuDao dao = new MenuDao();
		    List<Food> foodList = dao.getMenuList("徽菜");
		    // 将成绩信息存入request对象进行请求转发
		    request.setAttribute("foodList", foodList);
		    request.getRequestDispatcher("orders.html").forward(request, response);
       }
		else if("select4".equals(type)) {
		//查询闽菜
		    MenuDao dao = new MenuDao();
		    List<Food> foodList = dao.getMenuList("闽菜");
		    // 将成绩信息存入request对象进行请求转发
		    request.setAttribute("foodList", foodList);
		    request.getRequestDispatcher("orders.html").forward(request, response);
       }
		else if("select5".equals(type)) {
		//查询苏菜
		    MenuDao dao = new MenuDao();
		    List<Food> foodList = dao.getMenuList("苏菜");
		    // 将成绩信息存入request对象进行请求转发
		    request.setAttribute("foodList", foodList);
		    request.getRequestDispatcher("orders.html").forward(request, response);
       }
		else if("select6".equals(type)) {
		//查询湘菜
		    MenuDao dao = new MenuDao();
		    List<Food> foodList = dao.getMenuList("湘菜");
		    // 将成绩信息存入request对象进行请求转发
		    request.setAttribute("foodList", foodList);
		    request.getRequestDispatcher("orders.html").forward(request, response);
       }
		
	}


}