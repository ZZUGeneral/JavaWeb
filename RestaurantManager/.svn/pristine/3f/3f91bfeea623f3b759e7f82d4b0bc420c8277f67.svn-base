package com.zzu.minjie.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import java.util.List;

import com.zzu.minjie.bean.TodayOrderStatis;
import com.zzu.minjie.Util.DBUTil;

public class TodayOrderDao {
	/* 得到所有统计信息 */
	public List<TodayOrderStatis> selectTodayOrderStatis() {
		List<TodayOrderStatis> tadayOrderList = new ArrayList<TodayOrderStatis>();
		Connection conn = DBUTil.getConn();
		PreparedStatement pstmt = null;
		String sql = null;
		ResultSet rs = null;
		
		sql = "select food.FoodId as foodId,food.`Name` as name,sum(orders.Number) as totalNum,orders.Price as unitPrice" + 
				" from food left JOIN orders" + 
				" on food.FoodId=orders.FoodId and TO_DAYS(orders.Time)=TO_DAYS(NOW())" + 
				" GROUP BY food.FoodId;";
		try {
			// 关闭自动提交
			conn.setAutoCommit(false);
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				int foodId = rs.getInt("foodId");
				String name = rs.getString("name");
				int totalNum = rs.getInt("totalNum");
				
				float unitPrice = rs.getFloat("unitPrice");
				
				TodayOrderStatis todayOrderStatis = new TodayOrderStatis(foodId, name,totalNum,  unitPrice);
	
				tadayOrderList.add(todayOrderStatis);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUTil.closeJDBC(rs, pstmt, conn);
		}
		return tadayOrderList;
	}


}
