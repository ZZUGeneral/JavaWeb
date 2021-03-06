package zzu.minjie.servlet;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import zzu.minjie.bean.Cart;
import zzu.minjie.bean.CartInfo;
import zzu.minjie.dao.CartDao;

@WebServlet("/CartServlet")
@MultipartConfig
public class CartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public CartServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=UTF-8");
		String type = request.getParameter("type");
		if ("delete".equals(type))
			deleteCartItem(request, response);
		else if ("changeCount".equals(type))
			changeCartItemCount(request, response);
		else if ("submitCart".equals(type))
			submitCart(request, response);

	}

	// 删除购物车物品
	private void deleteCartItem(HttpServletRequest request, HttpServletResponse response) throws IOException {
		PrintWriter out = response.getWriter();
		String cartId = request.getParameter("cartId");
		String foodIdStr = request.getParameter("foodId");
		int foodId = Integer.parseInt(foodIdStr);
		CartDao cartDao = new CartDao();
		cartDao.deleteCartItem(cartId, foodId);
		List<Cart> cartList = cartDao.selectCart("CartId", cartId);
		float totalPrice = 0;
		for (Cart cart : cartList)
			totalPrice += cart.getUnitPrice() * cart.getNumber();
		// System.out.println(totalPrice);
		Gson gson = new Gson();
		CartInfo cartInfo = new CartInfo(cartId, foodId, 0, totalPrice);
		String info = gson.toJson(cartInfo);
		out.write(info);
		// response.sendRedirect("StuInfoOperateServlet?type=select&sc=false&condition=*");
	}

	// 修改购物车物品数量
	private void changeCartItemCount(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		PrintWriter out = response.getWriter();
		String cartId = request.getParameter("cartId");
		String foodIdStr = request.getParameter("foodId");
		String numStr = request.getParameter("num");
		int foodId = Integer.parseInt(foodIdStr);
		int num = Integer.parseInt(numStr);
		CartDao cartDao = new CartDao();
		cartDao.changeCartItemCount(cartId, foodId, num);
		List<Cart> cartList = cartDao.selectCart("CartId", cartId);
		float totalPrice = 0;
		for (Cart cart : cartList)
			totalPrice += cart.getUnitPrice() * cart.getNumber();
		// System.out.println(totalPrice);
		Gson gson = new Gson();
		CartInfo cartInfo = new CartInfo(cartId, foodId, 0, totalPrice);
		String info = gson.toJson(cartInfo);
		out.write(info);
	}

	// 结算购物车
	private void submitCart(HttpServletRequest request, HttpServletResponse response) throws IOException {
		PrintWriter out = response.getWriter();
		String cartId = request.getParameter("cartId");

		CartDao cartDao = new CartDao();

		List<Cart> cartList = cartDao.selectCart("CartId", cartId);
		cartDao.submitCart(cartList);
		cartDao.deleteCart(cartId);

		// response.sendRedirect("StuInfoOperateServlet?type=select&sc=false&condition=*");
	}

}

/*
 * //修改用户密码 private void modifyPwd(HttpServletRequest request,
 * HttpServletResponse response) throws IOException, ServletException { String
 * id = request.getParameter("id"); String password =
 * request.getParameter("password"); StuInfoDAO stuInfoDAO=new StuInfoDAO();
 * stuInfoDAO.modifyStuUserPwd(id,password); response.sendRedirect(
 * "StuInfoOperateServlet?type=select&condition=*&sc=false"); }
 * 
 * 
 * //添加学生 private void addStuBasicInfo(HttpServletRequest request,
 * HttpServletResponse response) throws IOException, ServletException {
 * PrintWriter out = response.getWriter(); String id=request.getParameter("id");
 * String name=request.getParameter("name"); String
 * gender=request.getParameter("gender"); String
 * birthday=request.getParameter("birthday"); String
 * grade=request.getParameter("grade"); String
 * nativeplace=request.getParameter("nativeplace"); String
 * homeaddr=request.getParameter("homeaddr"); String
 * telephone=request.getParameter("telephone"); //获得照片路径 Part part =
 * request.getPart("headshot"); String fileName = part.getSubmittedFileName();
 * String newFileName = System.currentTimeMillis()+
 * fileName.substring(fileName.lastIndexOf(".")); String filepath =
 * getServletContext().getRealPath("/StuPicture"); File f = new File(filepath);
 * if (!f.exists()) f.mkdirs(); part.write(filepath + "/" + newFileName);
 * //将生日转化为Date类型 SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
 * Date birthdayDate = null; try { birthdayDate = sdf.parse(birthday); } catch
 * (ParseException e) { birthdayDate = null; }
 * 
 * //向学生表中添加对应信息 StuInfoDAO dao=new StuInfoDAO(); boolean id_flag =
 * dao.isExistID(id); if(id_flag){ // 学号已存在,进行错误提示
 * out.print("<script type='text/javascript'>");
 * out.print("alert('学号已存在，请重新输入！');");
 * out.print("window.location='stuInfo/Stu_BasicInfoAdd.jsp';");
 * out.print("</script>"); }else{ // 学号未存在，保存信息 StuBasicInfo stu=new
 * StuBasicInfo(id,name,gender,birthdayDate,grade,nativeplace,homeaddr,telephone
 * ,newFileName,"000000"); stu.setStrbirthday(birthday);
 * dao.addStuBasicInfo(stu);
 * 
 * response.sendRedirect(
 * "StuInfoOperateServlet?type=select&sc=false&condition=*"); }
 * 
 * }
 * 
 * //删除学生 private void deleteStuBasicInfo(HttpServletRequest request,
 * HttpServletResponse response) throws IOException { String stu_id=
 * request.getParameter("id"); //删除学生表中的信息 StuInfoDAO dao=new StuInfoDAO();
 * dao.deleteStuBasicInfo(stu_id);
 * 
 * response.sendRedirect(
 * "StuInfoOperateServlet?type=select&sc=false&condition=*"); }
 * 
 * //获取要修改的学生的原信息 private void modifyStuBasicInfo(HttpServletRequest request,
 * HttpServletResponse response) throws IOException, ServletException {
 * StuInfoDAO dao=new StuInfoDAO(); String
 * old_id=request.getParameter("old_id"); List<StuBasicInfo>
 * list=dao.selectStuBasicInfo("STU_ID", old_id); StuBasicInfo
 * stu=(StuBasicInfo)list.get(0); request.getSession().setAttribute("stu", stu);
 * response.sendRedirect("stuInfo/Stu_BasicInfoModify.jsp");
 * 
 * }
 * 
 * //修改学生信息 private void updateStuBasicInfo(HttpServletRequest request,
 * HttpServletResponse response) throws IOException, ServletException { String
 * id=request.getParameter("id"); String name=request.getParameter("name");
 * String gender=request.getParameter("gender"); String
 * birthday=request.getParameter("birthday"); String
 * grade=request.getParameter("grade"); String
 * nativeplace=request.getParameter("nativeplace"); String
 * homeaddr=request.getParameter("homeaddr"); String
 * telephone=request.getParameter("telephone"); SimpleDateFormat sdf = new
 * SimpleDateFormat("yyyy-MM-dd"); Date birthdayDate = null; try { birthdayDate
 * = sdf.parse(birthday); } catch (ParseException e) { birthdayDate = null; }
 * StuBasicInfo stu=new
 * StuBasicInfo(id,name,gender,birthdayDate,grade,nativeplace,homeaddr,telephone
 * ,"",""); stu.setStrbirthday(birthday); StuInfoDAO dao=new StuInfoDAO();
 * //修改学生表中对应信息 dao.modifyStuBasicInfo(stu); response.sendRedirect(
 * "StuInfoOperateServlet?type=select&sc=false&condition=*"); }
 * 
 * private void selectStuBasicInfo(HttpServletRequest request,
 * HttpServletResponse response) throws IOException, ServletException { String
 * isSCJsp=request.getParameter("sc"); //如果是在学生基本信息管理页面
 * if("false".equals(isSCJsp)) { String
 * condition=request.getParameter("condition"); //显示所有学生信息
 * if("*".equals(condition)) { StuInfoDAO stuInfoDAO=new StuInfoDAO();
 * List<StuBasicInfo> list=stuInfoDAO.selectStuBasicInfo(condition, "");
 * request.getSession().setAttribute("stuList",list);
 * request.getRequestDispatcher("stuInfo/Stu_BasicInfo.jsp").forward(request,
 * response); } //按条件查找学生信息 else { String key=request.getParameter("key");
 * StuInfoDAO stuInfoDAO=new StuInfoDAO(); List<StuBasicInfo>
 * list=stuInfoDAO.selectStuBasicInfo(condition, key);
 * request.getSession().setAttribute("stuList",list);
 * request.getRequestDispatcher("stuInfo/Stu_BasicInfo.jsp").forward(request,
 * response); }
 * 
 * } else if("true".equals(isSCJsp)) { //如果是在管理班级学生页面 String
 * claId=request.getParameter("claId");
 * request.getRequestDispatcher("classes/classes_stuSelect.jsp?claId="+claId).
 * forward(request, response); } }
 * 
 * 
 * //查看学生的详情 private void seeDetailStuBasicInfo(HttpServletRequest request,
 * HttpServletResponse response) throws IOException, ServletException {
 * StuInfoDAO dao=new StuInfoDAO(); String id=request.getParameter("id");
 * List<StuBasicInfo> list=dao.selectStuBasicInfo("STU_ID", id); StuBasicInfo
 * stu=(StuBasicInfo)list.get(0); request.getSession().setAttribute("stu", stu);
 * response.sendRedirect("stuInfo/Stu_DetailBasicInfo.jsp");
 * 
 * } }
 */
