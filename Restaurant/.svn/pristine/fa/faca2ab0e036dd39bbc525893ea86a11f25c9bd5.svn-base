
package zzu.minjie.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import zzu.minjie.dao.UserDao;

@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public UserServlet() {
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
		PrintWriter out = response.getWriter();

		// 获取请求参数
		String id_type = request.getParameter("id_type");
		String phone_type = request.getParameter("phone_type");
		String nick_type = request.getParameter("nick_type");

		// 用户信息
		String userId = request.getParameter("userId");

		Timestamp tsBirthday = null;
		String nick = request.getParameter("nick");
		String name = request.getParameter("name");
		String address = request.getParameter("address");
		String phone = request.getParameter("phone");
		String gender = request.getParameter("gender");
		String birthday = request.getParameter("birthday");
		String password = request.getParameter("password");

		// System.out.println("user"+userId);
		// System.out.println(name);
		int type = 0;// 用户类型默认为普通用户

		// 转换生日格式
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		format.setLenient(false);
		// 要转换字符串 str_test
		String str_test = "2011-04-24";
		try {
			tsBirthday = new Timestamp(format.parse(str_test).getTime());
		} catch (ParseException e) {
			e.printStackTrace();
		}

		// 判断是否是使用Ajax请求进行userId唯一性验证
		if ("idAjaxValidate".equals(id_type)) {
			System.out.println("调用id");
			UserDao dao = new UserDao();
			boolean id_flag = dao.isExist("UserId", userId);
			if (id_flag)
				out.print("用户账号已被注册！");
			if (userId == "")
				out.print("用户账号不能为空！");
		}
		// 判断是否是使用Ajax请求进行phone唯一性验证
		if ("phoneAjaxValidate".equals(phone_type)) {
			UserDao dao = new UserDao();
			boolean phone_flag = false;
			phone_flag = dao.isExist("Phone", phone);
			if (phone_flag)
				out.print("该手机号码已被注册！");
			if (phone == "")
				out.print("手机号码不能为空！");
		}
		// 判断是否是使用Ajax请求进行nick唯一性验证
		if ("nickAjaxValidate".equals(nick_type)) {
			UserDao dao = new UserDao();
			boolean nick_flag = dao.isExist("Nick", nick);
			if (nick_flag)
				out.print("该昵称已被注册！");
			if (nick == "")
				out.print("昵称不能为空！");
		} else {

			String verifyCode = request.getParameter("verifyCode");
			// 判断验证码是否正确
			String sessionValidateCode = (String) request.getSession().getAttribute("SESSION_VALIDATECODE");
			if (!sessionValidateCode.equals(verifyCode)) {
				out.print("<script type='text/javascript'>");
				out.print("alert('请正确输入验证码！');");
				out.print("window.location='register.jsp';");
				out.print("</script>");
			} else {
				// 判断用户账号是否已被注册
				UserDao dao = new UserDao();
				boolean id_flag = dao.isExist("UserId", userId);
				boolean phone_flag = dao.isExist("Phone", phone);
				boolean nick_flag = dao.isExist("Nick", nick);

				if (id_flag) {
					// 用户账号已注册,进行错误提示
					out.print("<script type='text/javascript'>");
					out.print("alert('用户账号已被注册，请重新输入！');");
					out.print("window.location='register.jsp';");
					out.print("</script>");
				}
				// 判断手机号码是否已被注册
				else if (phone_flag) {
					// 手机号码已注册,进行错误提示
					out.print("<script type='text/javascript'>");
					out.print("alert('手机号码已被注册，请重新输入！');");
					out.print("window.location='register.jsp';");
					out.print("</script>");

				}
				// 判断昵称是否已被注册
				else if (nick_flag) {
					// 昵称已注册,进行错误提示
					out.print("<script type='text/javascript'>");
					out.print("alert('昵称已被注册，请重新输入！');");
					out.print("window.location='register.jsp';");
					out.print("</script>");

				} else {

					// 各项未被注册，保存注册用户信息
					dao.save(userId, name, address, phone, type, gender, tsBirthday, password, nick);
					// 注册成功，重定向到登录页面!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
					response.sendRedirect("login.jsp");
					System.out.println(request.getScheme() + "://" + request.getServerName() + ":"
							+ request.getServerPort() + request.getContextPath() + "/");
				}
			}
		}
	}

}
