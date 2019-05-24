package zzu.minjie.servlet;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import zzu.minjie.bean.Dishstyle;
import zzu.minjie.bean.Food;
import zzu.minjie.dao.MenuManageDao;;


@WebServlet("/MenuManageServlet")
public class MenuManageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public MenuManageServlet() {
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
		if("select".equals(type)) {
			MenuManageDao dao = new MenuManageDao();
			List<Dishstyle> dishStyle = dao.getDishStyleList();
		    //System.out.println(dishStyle);
		    // 将信息存入request对象进行请求转发
		    request.setAttribute("foodList", dishStyle);
			//System.out.println("数据库存储执行了");
			request.getRequestDispatcher("Menu.jsp").forward(request, response);
			
		}
		
	}


}