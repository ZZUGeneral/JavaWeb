package com.zzu.minjie.servlet;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.zzu.minjie.bean.Notice;
import com.zzu.minjie.dao.NoticeDao;


@WebServlet("/NoticeServlet")
public class NoticeServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;

	public NoticeServlet() {
		super();
	}
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// 设置请求和响应编码
		request.setCharacterEncoding("UTF-8");
		//String type = request.getParameter("type");
		response.setContentType("text/html;charset=UTF-8");
		// 获取请求操作类型
		String type = request.getParameter("type");
		String flag;
		
		NoticeDao dao=new NoticeDao();
		//显示公告列表
		if("list".equals(type)) {
			flag="list";
			request.setAttribute("flag", flag);
			List<Notice> noticelist=dao.readNotice();
            request.setAttribute("noticelist", noticelist);	    
		    request.getRequestDispatcher("notice_list.jsp").forward(request, response);
		}
		//公告搜索
		else if("search".equals(type)) {
			flag="search";
			request.setAttribute("flag", flag);			
			String theme = request.getParameter("uid");	
			
			List<Notice> noticelist1=dao.getNoticeByTitle(theme);
		
			request.setAttribute("noticelist1", noticelist1);	    
		    request.getRequestDispatcher("notice_list.jsp").forward(request, response);
			
		}
		//公告删除
        else if("delete".equals(type)) {
        	String noticeid = request.getParameter("NoticeId");
        	int Id = Integer.parseInt(noticeid);
			dao.deleteNotice(Id);
			request.getRequestDispatcher("NoticeServlet?type=list").forward(request, response);
		}
		//公告添加
        else if("add".equals(type)) {
        	String theme = request.getParameter("theme");
        	String notice = request.getParameter("notice");
			dao.addNotice(theme,notice);
			request.getRequestDispatcher("NoticeServlet?type=list").forward(request, response);
		}
		//公告修改
        else if("edit".equals(type)) {
        	String noticeid = request.getParameter("NoticeId");
        	int Id = Integer.parseInt(noticeid);
        	String theme = request.getParameter("Theme");
        	String notice = request.getParameter("Notice");
        	dao.updateNotice(Id, theme, notice);
        	request.getRequestDispatcher("NoticeServlet?type=list").forward(request, response);
    		
		}
		
	}

}
