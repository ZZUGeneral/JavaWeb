package com.zzu.student.servlet;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
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
		// �����������Ӧ����
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		// ��ȡ�ϴ��ļ���
		Part part = request.getPart("headShot");
		// ��ȡ�ϴ��ļ�����
		System.out.println(part);
		String fileName = part.getSubmittedFileName();
		System.out.println(fileName);
		// Ϊ��ֹ�ϴ��ļ����������ļ�����������
		String newFileName = System.currentTimeMillis() + fileName.substring(fileName.lastIndexOf("."));
		// ���ϴ����ļ������ڷ�������Ŀ����·����applicant/imagesĿ¼��
		String filepath = getServletContext().getRealPath("/School/images/user");
		System.out.println("ͷ�񱣴�·��Ϊ��" + filepath);
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
			out.print("alert('�޸ĳɹ���');");
			out.print("window.location='password.jsp';");
			out.print("</script>");
		} else {
			out.print("<script type='text/javascript'>");
			out.print("alert('�޸�ʧ�ܣ�');");
			out.print("window.location='password.jsp';");
			out.print("</script>");
		}

	}

}
