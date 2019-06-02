package com.zzu.minjie.servlet;

import java.io.File;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.zzu.minjie.bean.DishStyle;
import com.zzu.minjie.dao.TypeDao;

@MultipartConfig
@WebServlet("DishStyleServlet")
public class DishStyleServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public DishStyleServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		String type = request.getParameter("type");
		TypeDao dao = new TypeDao();
		if (type.equals("list")) {
			List<DishStyle> list = dao.Type_list();
			request.setAttribute("type_list", list);
			request.getRequestDispatcher("type_list.jsp").forward(request, response);
		} else if (type.equals("add")) {
			String name = request.getParameter("name");
			String explain = request.getParameter("explain");
			Part part = request.getPart("picture");
			System.out.println(part);
			String fileName = part.getSubmittedFileName();
			System.out.println("========" + fileName);
			String newFileName = System.currentTimeMillis() + fileName.substring(fileName.lastIndexOf("."));
			String filepath = getServletContext().getRealPath("img");
			System.out.println("储存路径：" + filepath);
			File f = new File(filepath);
			if (!f.exists())
				f.mkdirs();
			part.write(filepath + "/" + newFileName);
			String rs = dao.addType(name, explain, fileName);
			PrintWriter out = response.getWriter();
			out.print("<script type='text/javascript'>");
			if (rs.equals("false")) {
				out.print("alert('添加失败！');");
				out.print("window.location='';");
			} else {
				out.print("alert('添加成功！');");
				out.print("window.location='TypeServlet?type=list';");
			}
			out.print("</script>");
		} else if (type.equals("delete")) {
			String id = request.getParameter("id");
			String rs = dao.deleteType(id);
			PrintWriter out = response.getWriter();
			out.print("<script type='text/javascript'>");
			if (rs.equals("false")) {
				out.print("alert('删除失败！');");
			} else {
				out.print("alert('删除成功！');");
			}
			out.print("window.location='TypeServlet?type=list';");
			out.print("</script>");
		} else if (type.equals("update")) {
			String id = request.getParameter("id");
			String name = request.getParameter("name");
			String explain = request.getParameter("explain");
			Part part = request.getPart("picture");
			System.out.println(part);
			String fileName = part.getSubmittedFileName();
			System.out.println("========" + fileName);
			String newFileName = System.currentTimeMillis() + fileName.substring(fileName.lastIndexOf("."));
			String filepath = getServletContext().getRealPath("img");
			System.out.println("储存路径：" + filepath);
			File f = new File(filepath);
			if (!f.exists())
				f.mkdirs();
			part.write(filepath + "/" + newFileName);
			String rs = dao.updateType(fileName, explain, fileName, id);
			PrintWriter out = response.getWriter();
			out.print("<script type='text/javascript'>");
			if (rs.equals("false")) {
				out.print("alert('添加失败！');");
				out.print("window.location='';");
			} else {
				out.print("alert('添加成功！');");
				out.print("window.location='TypeServlet?type=list';");
			}
			out.print("</script>");
		}else if(type.equals("get")) {
			String id = request.getParameter("id");
			DishStyle ds = dao.Type(id);
			request.setAttribute("style", ds);
			request.getRequestDispatcher("type_change.jsp").forward(request, response);
		}

	}
}