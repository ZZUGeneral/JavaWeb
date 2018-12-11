package com.zzu.student.servlet;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.FileItem;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.apache.tomcat.util.http.fileupload.RequestContext;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItemFactory;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

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
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");

		try {
			String path_temp = this.getServletContext().getRealPath("temp");
			DiskFileItemFactory factory = new DiskFileItemFactory();
			ServletFileUpload sfu = new ServletFileUpload(factory);
			sfu.setFileSizeMax(1024 * 400);
			sfu.setHeaderEncoding("UTF-8");
			boolean multipartContent = sfu.isMultipartContent(request);
			if (multipartContent) {
				List<FileItem> items = sfu.parseRequest((RequestContext) request);
				if (items != null) {
					for (FileItem item : items) {
						boolean formFile = item.isFormField();
						if (formFile) {
							String fieldName = item.getFieldName();
							String fieldValue = item.getString("UTF-8");
							System.out.println(fieldName + "++++++" + fieldValue);
						} else {
							String fileName = item.getName();
							InputStream is = item.getInputStream();
							String path_store = this.getServletContext().getRealPath("upload");
							OutputStream os = new FileOutputStream(path_store + "/" + fileName);
							IOUtils.copy(is, os);
							is.close();
							os.close();
							item.delete();
						}
					}
				}
			} else {

			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		/*
		 * Part part = request.getPart("headShot"); System.out.println(part); String
		 * fileName = part.getSubmittedFileName(); System.out.println(fileName); String
		 * newFileName = System.currentTimeMillis() +
		 * fileName.substring(fileName.lastIndexOf(".")); String filepath =
		 * getServletContext().getRealPath("/StudentManager/images/user");
		 * System.out.println("储存路径：" + filepath); File f = new File(filepath); if
		 * (!f.exists()) f.mkdirs(); part.write(filepath + "/" + newFileName); long no =
		 * (long) request.getSession().getAttribute("SESSION_NO"); String hs_no =
		 * Long.toString(no); int update = 0; HeadShotDao dao = new HeadShotDao(); if
		 * (hs_no.startsWith("6778")) { update = dao.updateHeadShotForTeacher(no,
		 * newFileName); } else { update = dao.updateHeadShotForStudent(no,
		 * newFileName); } PrintWriter out = response.getWriter(); if (update > 0) {
		 * out.print("<script type='text/javascript'>"); out.print("alert('更新成功');");
		 * out.print("window.location='index.jsp';"); out.print("</script>"); } else {
		 * out.print("<script type='text/javascript'>"); out.print("alert('更新失败！');");
		 * out.print("window.location='password.jsp';"); out.print("</script>"); }
		 */
	}
	/*
	 * public void service(HttpServletRequest request, HttpServletResponse response)
	 * throws UnsupportedEncodingException { request.setCharacterEncoding("UTF-8");
	 * response.setContentType("text/html;charset=UTF-8"); DiskFileItemFactory
	 * factory = new DiskFileItemFactory(); ServletFileUpload sfu = new
	 * ServletFileUpload(factory); sfu.setFileSizeMax(1024 * 400);
	 * 
	 * try { List<FileItem> items = sfu.parseRequest((RequestContext) request); for
	 * (int i = 0; i < items.size(); i++) { FileItem item = items.get(i); if
	 * (!item.isFormField()) { ServletContext sctx = getServletContext(); String
	 * path = "/StudentManager/images/user"; String fileName = item.getName();
	 * fileName = fileName.substring(fileName.lastIndexOf(".") + 1); File file = new
	 * File(path + "\\" + fileName); if (!file.exists()) { item.write(file); } } }
	 * 
	 * } catch (Exception e) { // TODO Auto-generated catch block
	 * e.printStackTrace(); }
	 * 
	 * }
	 */

}
