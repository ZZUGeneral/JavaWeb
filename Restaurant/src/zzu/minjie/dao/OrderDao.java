package zzu.minjie.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import zzu.minjie.bean.Food;
import zzu.minjie.bean.Order;
import zzu.minjie.util.DBUTil;

public class OrderDao {
	public List<Order> getFoodList(String orderNo) {
		Connection conn = DBUTil.getConn();
		String sql = "select o.Number,o.Price,f.Image,f.FoodExplain,f.`Name` from orders o left JOIN food f on o.FoodId=f.FoodId where o.OrderNo=?";
		ResultSet rs = null;
		List<Order> list = new ArrayList<Order>();
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, orderNo);
			rs = ps.executeQuery();
			while (rs.next()) {
				Order order = new Order();
				order.setName(rs.getString("Name"));
				order.setImage(rs.getString("Image"));
				order.setPrice(rs.getFloat("Price"));
				order.setExplain(rs.getString("FoodExplain"));
				order.setNumber(rs.getInt("Number"));
				list.add(order);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	/**
	 * 返回所有订单的订单编号的list集合（String类型),用于处理历史订单
	 * 
	 * @return
	 */

	public List<Order> getOrderList(String userID) {
		Connection conn = DBUTil.getConn();
		String sql = "select OrderNo,Time,sum(Number*Price) from orders where userID="+userID+ " group by OrderNo";
		ResultSet rs = null;
		List<Order> list = new ArrayList<Order>();
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				Order order=new Order();
				order.setOrderNo(rs.getString(1));
				order.setOrderTime(rs.getTimestamp(2));
				order.setPrice(rs.getFloat(3));
				list.add(order);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

}
