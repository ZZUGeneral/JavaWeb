package zzu.minjie.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import zzu.minjie.dao.UserDao;

@WebServlet("/FindPwdServler")
public class FindPwdServler extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1277798120713783286L;

	public FindPwdServler() {
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
		String userID = request.getParameter("userID");
		String phone = request.getParameter("phone");
		String newpwd = request.getParameter("newpwd");
		String confirmpwd = request.getParameter("confirmpwd");
		UserDao userDao = new UserDao();
		System.out.println(userID + " " + phone + "  " + userDao.getPhone(userID));
		if (!newpwd.equals(confirmpwd)) {
			PrintWriter out = response.getWriter();
			out.print("<script type='text/javascript'>");
			out.print("alert('两次密码不一致！');");
			out.print("window.location='UserInfoServlet?type=updateSelect';");
			out.print("</script>");

		} else if (!phone.equals(userDao.getPhone(userID))) {
			PrintWriter out = response.getWriter();
			out.print("<script type='text/javascript'>");
			out.print("alert('信息不符！');");
			out.print("window.location='UserInfoServlet?type=updateSelect';");
			out.print("</script>");

		} else {
			userDao.changepwd(userID, newpwd);
			PrintWriter out = response.getWriter();
			out.print("<script type='text/javascript'>");
			out.print("alert('更新成功！');");
			out.print("window.location='UserInfoServlet?type=updateSelect';");
			out.print("</script>");

		}
	}

}
