package com.zzu.minjie.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.zzu.minjie.Util.DBUTil;
import com.zzu.minjie.bean.Order;


public class OrderDao {
	/* �õ�����ͳ����Ϣ */
	public List<Order> selectTodayOrderStatis() {
		List<Order> orderList = new ArrayList<Order>();
		Connection conn = DBUTil.getConn();
		PreparedStatement pstmt = null;
		String sql = null;
		ResultSet rs = null;
		
		sql = "select orders.OrderNo as orderNo,user.UserId as userId,user.Name as userName,user.Phone as phone,user.Address as address,orders.Time as time,orders.Statu as status" + 
				" from orders left join user" + 
				" on orders.UserID=user.UserId" + 
				" GROUP BY orders.OrderNo;";
		try {
			// �ر��Զ��ύ
			conn.setAutoCommit(false);
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				String orderNo = rs.getString("orderNo");
				String userId = rs.getString("userId");

				String userName = rs.getString("userName");
				String phone = rs.getString("phone");
				String address = rs.getString("address");
				Timestamp time=rs.getTimestamp("time");
				String status = rs.getString("status");
				
				Order order=new Order(orderNo,userId,userName,phone,address,time,status);
				
	
				orderList.add(order);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUTil.closeJDBC(rs, pstmt, conn);
		}
		return orderList;
	}
	public List<Order> searchOrderByOrderNo(String OrderNo) {
		List<Order> orderList = new ArrayList<Order>();
		Connection conn = DBUTil.getConn();
		PreparedStatement pstmt = null;
		String sql = null;
		ResultSet rs = null;
		Order order = null;
		sql = "select orders.OrderNo as orderNo,user.UserId as userId,user.Name as userName,user.Phone as phone,user.Address as address,orders.Time as time,orders.Statu as status " + 
				"from orders left join user " + 
				"on orders.UserID=user.UserId " + 
				"where orders.OrderNo=?;";
		try {
//			// �ر��Զ��ύ
			conn.setAutoCommit(false);
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, OrderNo);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				String orderNo = rs.getString("orderNo");
				String userId = rs.getString("userId");

				String userName = rs.getString("userName");
				String phone = rs.getString("phone");
				String address = rs.getString("address");
				Timestamp time=rs.getTimestamp("time");
				String status = rs.getString("status");
				
				if(status.equals("1")) {
					status="已支付";
				}
				
				order=new Order(orderNo,userId,userName,phone,address,time,status);
				
	
				orderList.add(order);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUTil.closeJDBC(rs, pstmt, conn);
		}
		return orderList;
	}
	
	
	public void updateStatus(String num,String OrderNo) {
		Connection conn = DBUTil.getConn();
		PreparedStatement pstmt = null;
		String sql = null;
		ResultSet rs = null;
		Order order = null;
		sql = "update orders set orders.Statu =? where orders.OrderNo=?;";
		try {
			conn.setAutoCommit(false);
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, num);
			pstmt.setString(1, OrderNo);
			pstmt.executeQuery();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUTil.closeJDBC(rs, pstmt, conn);
		}
		
	}
	
	
}
