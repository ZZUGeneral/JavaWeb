package zzu.minjie.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import zzu.minjie.bean.User;
import zzu.minjie.dao.UserDao;

@WebServlet("/UserInfoServlet")
public class UserInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public UserInfoServlet() {
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
		response.setContentType("text/html;charset=UTF-8");
		// 获取请求操作类型
		String type = request.getParameter("type");

		if ("select".equals(type)) { // 信息查询操作
			// 从会话对象中获取当前登录用户标识
			UserDao userDao = new UserDao();
			User user = userDao.getUserInfoByID((String) request.getSession().getAttribute("userId"));
			request.setAttribute("user", user);
			request.getRequestDispatcher("userInfo.jsp").forward(request, response);
		} else if ("updateSelect".equals(type)) { // 个人信息更新前的查询
			// 从会话对象中获取当前登录用户标识
			UserDao userDao = new UserDao();
			User user = userDao.getUserInfoByID((String) request.getSession().getAttribute("userId"));
			// 将基本信息存入request对象进行请求转发
			request.setAttribute("user", user);
			request.getRequestDispatcher("userInfoUpdate.jsp").forward(request, response);
		} else if ("update".equals(type)) {
			// 封装请求数据
			User user = this.requestDataObj(request);
			// 更新客户信息
			user.setInfoUpdate(user);
			System.out.println(user.toString());
			request.setAttribute("user", user);
			request.getRequestDispatcher("userInfo.jsp").forward(request, response);
		} else if ("openMember".equals(type)) {

			UserDao userDao = new UserDao();
			User user = userDao.getUserInfoByID((String) request.getSession().getAttribute("userId"));
			if (user.getType() == 0) {
				user.setType(1);
				userDao.updateAll(user);
				user = userDao.getUserInfoByID((String) request.getSession().getAttribute("userId"));

				PrintWriter out = response.getWriter();
				out.print("<script type='text/javascript'>");
				out.print("alert('成功开通会员！');");
				out.print("window.location='member.jsp';");
				out.print("</script>");
				System.out.println(type + "更新" + user);
			} else {
				PrintWriter out = response.getWriter();
				out.print("<script type='text/javascript'>");
				out.print("alert('您已经会员, 无需再次开通！');");
				out.print("window.location='member.jsp';");
				out.print("</script>");
			}

		} else if ("changepwd".equals(type)) {
			String oldpwd = request.getParameter("prepwd");
			String pwd1 = request.getParameter("newpwd");
			String pwd2 = request.getParameter("confirmpwd");
			System.out.println("PWD" + pwd1);
			UserDao userDao = new UserDao();
			String pwd = userDao.getUserInfoByID((String) request.getSession().getAttribute("userId")).getPassword();
			if (!pwd1.equals(pwd2)) {
				PrintWriter out = response.getWriter();
				out.print("<script type='text/javascript'>");
				out.print("alert('两次密码不一致！');");
				out.print("window.location='UserInfoServlet?type=updateSelect';");
				out.print("</script>");

			} else if (!pwd.equals(oldpwd)) {
				PrintWriter out = response.getWriter();
				out.print("<script type='text/javascript'>");
				out.print("alert('旧密码错误！');");
				out.print("window.location='UserInfoServlet?type=updateSelect';");
				out.print("</script>");

			} else {

				userDao.changepwd((String) (request.getSession().getAttribute("userId")), pwd1);

				PrintWriter out = response.getWriter();
				out.print("<script type='text/javascript'>");
				out.print("alert('更新成功！');");
				out.print("window.location='UserInfoServlet?type=updateSelect';");
				out.print("</script>");

			}

		}

	}

	/**
	 * 将请求的客户数据封装成一个对象
	 * 
	 * @param request
	 * @return
	 * @throws ItOfferException
	 */
	private User requestDataObj(HttpServletRequest request) {
		User user = null;
		// 获得请求数据
		String username = request.getParameter("userId");
		String name = request.getParameter("name");
		String address = request.getParameter("address");
		String phone = request.getParameter("phone");
		String gender = request.getParameter("gender");
		String birthday = request.getParameter("birthday");
		String nick = request.getParameter("nick");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date birthdayDate = null;
		try {
			birthdayDate = sdf.parse(birthday);
		} catch (ParseException e) {
			birthdayDate = null;
		}
		// 将请求数据封装成一个客户基本信息对象
		user = new User(username, name, address, phone, gender, birthdayDate, nick);
		return user;
	}
}
