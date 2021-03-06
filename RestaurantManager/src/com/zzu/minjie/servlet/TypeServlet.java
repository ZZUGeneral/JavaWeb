package com.zzu.minjie.servlet;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.zzu.minjie.bean.DishStyle;
import com.zzu.minjie.dao.DishStyleDao;

@WebServlet("/TypeServlet")
@MultipartConfig
public class TypeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public TypeServlet() {
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
		String flag;// 定义个变量，判断是搜索出来的列表，还是查询出来的所有列表

		DishStyleDao dao = new DishStyleDao();
		// 显示菜系列表
		if ("list".equals(type)) {
			flag = "list";
			request.setAttribute("flag", flag);
			List<DishStyle> dishstyle = dao.readType();
			request.setAttribute("dishstyle", dishstyle); // 存储为dishstyle
			request.getRequestDispatcher("type_list.jsp").forward(request, response);
		}
		// 菜系搜索
		else if ("search".equals(type)) {
			flag = "search";
			request.setAttribute("flag", flag);
			String name = request.getParameter("uid");
			List<DishStyle> dishstyle1 = dao.getDishStyleByTitle(name);
			request.setAttribute("dishstyle1", dishstyle1); // 存储为dishstyle1
			request.getRequestDispatcher("type_list.jsp").forward(request, response);

		}
		// 菜系删除
		else if ("delete".equals(type)) {
			String typeid = request.getParameter("TypeId");
			int Id = Integer.parseInt(typeid);
			dao.deleteDishStyle(Id);
//			request.getRequestDispatcher("TypeServlet?type=list").forward(request, response);
		}
		// 菜系添加
		else if ("add".equals(type)) {
			String dishName = request.getParameter("dishName");
			String dishExplain = request.getParameter("dishExplain");
			String option = request.getParameter("option");
			String imagePath = request.getParameter("image");
			File tempFile = new File(imagePath.trim());
			String fileName = tempFile.getName();

			String savePath1 = this.getServletContext().getRealPath("/images");
			String savePath2 = new String("F:\\JavaWeb\\RestaurantManager\\WebContent\\picture");// 路径为自己的项目所在路径
			FileInputStream in = new FileInputStream(imagePath);
			FileOutputStream os1 = new FileOutputStream(new File(savePath1 + "\\" + fileName));
			FileOutputStream os2 = new FileOutputStream(new File(savePath2 + "\\" + fileName));
			byte[] buffer = new byte[1024];
			int len = 0;
			while ((len = in.read(buffer)) != -1) {
				os1.write(buffer, 0, len);
				os2.write(buffer, 0, len);
			}
			os1.close();
			os2.close();

			dao.addType(dishName, dishExplain, option, fileName);
			request.getRequestDispatcher("TypeServlet?type=list").forward(request, response);
		}
		// 菜系修改前读取菜系内容
		else if ("edit".equals(type)) {
			String dishid = request.getParameter("dishid");
			DishStyle dishstyle = dao.searchById(Integer.parseInt(dishid));
			request.setAttribute("dishstyle", dishstyle);
			request.setAttribute("dishid", dishid);
			request.getRequestDispatcher("typeedit.jsp").forward(request, response);
		} else if ("editnext".equals(type)) { // 修改后提交

			String dishid = request.getParameter("dishid");
			int id = Integer.parseInt(dishid);
			String name = request.getParameter("dishname");
			String explain = request.getParameter("dishexplain");
			String opt = request.getParameter("opt");
			String imagePath = request.getParameter("imgpath");
			File tempFile = new File(imagePath.trim());
			String fileName = tempFile.getName();

			String savePath1 = this.getServletContext().getRealPath("/images");
			String savePath2 = new String("F:\\JavaWeb\\RestaurantManager\\WebContent\\picture");// 路径为自己的项目所在路径
			FileInputStream in = new FileInputStream(imagePath);
			FileOutputStream os1 = new FileOutputStream(new File(savePath1 + "\\" + fileName));
			FileOutputStream os2 = new FileOutputStream(new File(savePath2 + "\\" + fileName));
			byte[] buffer = new byte[1024];
			int len = 0;
			while ((len = in.read(buffer)) != -1) {
				os1.write(buffer, 0, len);
				os2.write(buffer, 0, len);
			}
			os1.close();
			os2.close();
			dao.updateDishStyle(id, name, explain, opt, fileName);

			request.getRequestDispatcher("TypeServlet?type=list").forward(request, response);

//		}	

		}
	}
}
