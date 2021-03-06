package zzu.minjie.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import zzu.minjie.bean.DishesRank;
import zzu.minjie.util.DBUTil;

public class DishesRankDao {

	public List<DishesRank> readDishesRank() {// 显示排行榜内容
		List<DishesRank> list = new ArrayList<DishesRank>();
		Connection conn = DBUTil.getConn();
		PreparedStatement pstmt = null;
		try {
			String sql1 = "select count, name from(select FoodId,sum(number)as COUNT "
					+ "from orders group by FoodId)as A,food " + "where A.foodId=food.foodid " + "order by count desc "
					+ "limit 0,3;";
			pstmt = conn.prepareStatement(sql1);
			ResultSet rs = pstmt.executeQuery();
			// rs = pstmt.executeQuery();
			while (rs.next()) {
				String foodname = rs.getString("name");
				int countnumber = rs.getInt("count");
				DishesRank rank = new DishesRank(foodname, countnumber);
				list.add(rank);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null) {
					pstmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}

}