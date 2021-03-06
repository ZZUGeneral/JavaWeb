package com.zzu.minjie.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.zzu.minjie.bean.TodayOrderStatis;
import com.zzu.minjie.dao.TodayOrderDao;

@WebServlet("/TodayOrderServlet")
@MultipartConfig
public class TodayOrderServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public TodayOrderServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=UTF-8");
		String type = request.getParameter("type");

		if ("statistic".equals(type))
			statistic(request, response);

	}

	// ͳ�ƽ�����Ϣ
	private void statistic(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		PrintWriter out = response.getWriter();

		TodayOrderDao todayOrderDao = new TodayOrderDao();
		List<TodayOrderStatis> todayList = todayOrderDao.selectTodayOrderStatis();
		// float totalPrice = 0;
		for (TodayOrderStatis today : todayList)
			System.out.println(today.getName() + " " + today.getTotalNum() + " " + today.getUnitPrice());

		Gson gson = new Gson();

		String info = gson.toJson(todayList);
		out.write(info);
	}

}
