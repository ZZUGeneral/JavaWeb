package com.zzu.student.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zzu.student.dao.StudentDao;
import com.zzu.student.dao.TeacherDao;

/**
 * Servlet implementation class AddStudentServlet
 */
@WebServlet("/AddStudentOrTeacherServlet")
public class AddStudentOrTeacherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddStudentOrTeacherServlet() {
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
		// �����������Ӧ����
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		String name = request.getParameter("name");
		String gender = request.getParameter("gender");
		String dept = request.getParameter("dept");
		String birthday = request.getParameter("birthday");
		String type = request.getParameter("type");
		// birthday = birthday.replace("/", "-");
		String email = request.getParameter("email");
		String fileName = "a.png";
		
		String password = "";
		for (int i = 0; i < 10; i++) {
			int j = (int) Math.random();
			password += Integer.toString(j);
		}
		long no = 0;
		if(type=="student") {
			try {
			StudentDao dao = new StudentDao();
			no = dao.addStudent(name, gender, dept, birthday, email, fileName, password);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}else {
			
			try {
				TeacherDao dao = new TeacherDao();
				no = dao.addTeacher(name, gender, dept, birthday, email, fileName, password);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		PrintWriter out = response.getWriter();
		if (no > 0) {
			request.setAttribute("account", no);
			request.setAttribute("password", password);
			request.getRequestDispatcher("/show.jsp").forward(request, response);
		} else {
			out.print("<script type='text/javascript'>");
			out.print("alert('添加失败！');");
			out.print("window.location='register.jsp';");
			out.print("</script>");
		}

	}

}
