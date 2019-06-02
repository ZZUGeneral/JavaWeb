package com.zzu.minjie.servlet;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.zzu.minjie.bean.DishStyle;
import com.zzu.minjie.bean.Food;
import com.zzu.minjie.dao.DishStyleDao;
import com.zzu.minjie.dao.FoodDao;


@WebServlet("/DishesManageServlet")
public class DishesManageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 设置请求和响应编码
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		// 获取请求操作类型
		String TYPES = request.getParameter("TYPES");		
System.out.println(TYPES);
		
		FoodDao foodDao = new FoodDao();
		DishStyleDao dishStyleDao = new DishStyleDao();
		List<DishStyle> dishStyleList = dishStyleDao.getDishStyles();
		
		
		HttpSession session = request.getSession();
		session.setAttribute("dishStyleList", dishStyleList);	//将菜系存到session中
		
System.out.println("菜系"+dishStyleList);
		
		if ("dishesSave".equals(TYPES)) { 						// 新增食物
			
			String name = request.getParameter("name");
			String material = request.getParameter("recipe");
			String price = request.getParameter("price");
			String memberPrice = request.getParameter("memberPrice");
			String foodExplain = request.getParameter("brief");
			String type = request.getParameter("type");
			
			Food food = new Food();
			food.setName(name);
			food.setMaterial(material);
			food.setPrice(Float.parseFloat(price));
			food.setMemberPrice(Float.parseFloat(memberPrice));
			food.setFoodExplain(foodExplain);
			food.setType(type);

		
			//上传图片
			String imagePath = request.getParameter("imgpath");		//文件名及路径
			
			//获取文件名
			File tempFile =new File( imagePath.trim());  
			String fileName = tempFile.getName();
			food.setImage(fileName);
System.out.println(food);
System.out.println("文件名"+fileName);
			
			
			String savePath1 = this.getServletContext().getRealPath("/picture");		//项目保存路径
String savePath2 = new String("D:\\javacode\\RestaurantManager\\WebContent\\picture");	//本地源程序保存路径
			
			FileInputStream in = new FileInputStream(imagePath);		//加载这张图片


			
			FileOutputStream os1 = new FileOutputStream(new File(savePath1 + "\\" + fileName)); 	//获取输出流
FileOutputStream os2 = new FileOutputStream(new File(savePath2 + "\\" + fileName)); 

			byte[] buffer = new byte[1024];
			int len = 0;
			while((len = in.read(buffer))!=-1) {
				os1.write(buffer,0,len);
os2.write(buffer,0,len);
			}	
			os1.close();
os2.close();

			try {
				foodDao.save(food);
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
System.out.println(food);

			request.setAttribute("food", food);
			request.getRequestDispatcher("foodInfo.jsp").forward(request, response);	
			
		} else if ("dishesList".equals(TYPES)) {  	//查询所有food
			
			List<Food> allFood = foodDao.selectAllFood();
System.out.println(allFood);
			request.setAttribute("allFood", allFood);
			request.getRequestDispatcher("dishe_list.jsp").forward(request, response);	
		}else if ("dishesDel".equals(TYPES)) {		//删除所选food
			String foodId = request.getParameter("foodId");		
System.out.println(foodId);
			foodDao.delete(Integer.parseInt(foodId));
			
			List<Food> allFood = foodDao.selectAllFood();
System.out.println(allFood);
			PrintWriter out = response.getWriter();
			out.print("<script type='text/javascript'>");
			out.print("alert('删除成功！');");
			out.print("window.location='member.jsp';");
			out.print("</script>");



			request.setAttribute("allFood", allFood);
			response.setHeader("refresh", "3;url=/RestaurantManager/WebContent/dishe_list.jsp");

			//request.getRequestDispatcher("dishe_list.jsp").forward(request, response);				
		}else if ("dishesUpdate".equals(TYPES)) {			//修改所选food
			String foodId = request.getParameter("foodId");	
			
			Food food = foodDao.searchById(Integer.parseInt(foodId));
System.out.println(foodId+food);
			
			request.setAttribute("food", food);
			request.setAttribute("foodId", foodId);
			request.getRequestDispatcher("foodDetail.jsp").forward(request, response);				
		}else if ("dishesUpdateNext".equals(TYPES)) {		//提交修改所选food
			
			String foodId = request.getParameter("foodId");	
			System.out.println("食物ID号"+foodId);
			String name = request.getParameter("name");
			String material = request.getParameter("recipe");
			String price = request.getParameter("price");
			String memberPrice = request.getParameter("memberPrice");
			String foodExplain = request.getParameter("brief");
			String type = request.getParameter("type");
			
			Food food = new Food();
			food.setFoodId(Integer.parseInt(foodId));
			food.setName(name);
			food.setMaterial(material);
			food.setPrice(Float.parseFloat(price));
			food.setMemberPrice(Float.parseFloat(memberPrice));
			food.setFoodExplain(foodExplain);
			food.setType(type);

		
			//上传图片
			String imagePath = request.getParameter("imgpath");		//文件名及路径
			
			//获取文件名
			File tempFile =new File( imagePath.trim());  
			String fileName = tempFile.getName();
			food.setImage(fileName);
System.out.println("###########"+food.getType());
System.out.println(food.getFoodId()+"文件名"+fileName);

String savePath1 = this.getServletContext().getRealPath("/picture");		//项目保存路径
String savePath2 = new String("D:\\javacode\\RestaurantManager\\WebContent\\picture");	//本地源程序保存路径
			
			FileInputStream in = new FileInputStream(imagePath);		//加载这张图片	
			FileOutputStream os1 = new FileOutputStream(new File(savePath1 + "\\" + fileName)); 	//获取输出流
FileOutputStream os2 = new FileOutputStream(new File(savePath2 + "\\" + fileName)); 

			byte[] buffer = new byte[1024];
			int len = 0;
			while((len = in.read(buffer))!=-1) {
				os1.write(buffer,0,len);
os2.write(buffer,0,len);
			}	
			os1.close();
os2.close();

			try {
				foodDao.update(food.getFoodId(), food);
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			request.setAttribute("food", food);
			request.getRequestDispatcher("foodInfo.jsp").forward(request, response);	
									
		}									
		
	}

}
