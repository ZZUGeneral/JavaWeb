package zzu.minjie.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.annotation.WebServlet;
import zzu.minjie.bean.User;
import zzu.minjie.dao.UserDao;

/**
 * Servlet implementation class Login
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
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
		String userName = request.getParameter("username");
		String password = request.getParameter("password");
		String verifyCode = request.getParameter("verificationcode");
		String sessionValidateCode = (String) request.getSession().getAttribute("VERIFICATION_CODE");
		if (userName != null && !userName.equals("")) {
			UserDao userDao = new UserDao();
			String psd = userDao.findUser(userName);
			if (psd != null) {// 存在这个用户，
				if (!sessionValidateCode.equals(verifyCode)) { // 验证码输入的不正确
					String message = "验证码错误!";
					request.getSession().setAttribute("msg", message);
					response.sendRedirect(request.getContextPath() + "/login.jsp");
				} else { // 输入的验证码正确
					request.getSession().setAttribute("userId", userName);
					request.getRequestDispatcher("index.jsp").forward(request, response);
				}
			} else {// 不存在这个用户，给出提示，转回登录页面
				String message = "用户名或密码错误！";
				request.getSession().setAttribute("msg", message);
				response.sendRedirect(request.getContextPath() + "/login.jsp");
			}
		}
	}

}
