package com.zzu.student.servlet;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.zzu.student.dao.HeadShotDao;

/**
 * Servlet implementation class UpdateHeadShotServlet
 */
@WebServlet("/UpdateHeadShotServlet")
@MultipartConfig
public class UpdateHeadShotServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UpdateHeadShotServlet() {
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
		response.setContentType("text/html;charset=UTF-8");

		Part part = request.getPart("headShot");
		System.out.println(part);
		String fileName = part.getSubmittedFileName();
		System.out.println(fileName);
		String newFileName = System.currentTimeMillis() + fileName.substring(fileName.lastIndexOf("."));
		String filepath = getServletContext().getRealPath("/images/user");
		System.out.println("储存路径：" + filepath);
		File f = new File(filepath);
		if (!f.exists())
			f.mkdirs();
		part.write(filepath + "/" + newFileName);
		long no = (long) request.getSession().getAttribute("SESSION_NO");
		String hs_no = Long.toString(no);
		int update = 0;
		HeadShotDao dao = new HeadShotDao();
		if (hs_no.startsWith("6778")) {
			update = dao.updateHeadShotForTeacher(no, newFileName);
		} else {
			update = dao.updateHeadShotForStudent(no, newFileName);
		}
		PrintWriter out = response.getWriter();
		if (update > 0) {
			out.print("<script type='text/javascript'>");
			out.print("alert('更新成功');");
			out.print("window.location='index.jsp';");
			out.print("</script>");
		} else {
			out.print("<script type='text/javascript'>");
			out.print("alert('更新失败！');");
			out.print("window.location='password.jsp';");
			out.print("</script>");
		}

	}

}
