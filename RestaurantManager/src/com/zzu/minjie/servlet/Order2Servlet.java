package com.zzu.minjie.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zzu.minjie.bean.Order;
import com.zzu.minjie.dao.OrderDao;

/**
 * Servlet implementation class Order2Servlet
 */
@WebServlet("/Order2Servlet")
public class Order2Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Order2Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String type = request.getParameter("action");
		System.out.println(type);
		String orderNo = request.getParameter("order");
		System.out.println(orderNo);
		OrderDao dao = new OrderDao();
		dao.updateStatus("2",type);
//		if(type.equals("ok")) {
//			Order order = dao.updateStatus2(orderNo);
//		}
//		if(type.equals("no")) {
//			dao.updateStatus3(orderNo);
//		}
	}

}
