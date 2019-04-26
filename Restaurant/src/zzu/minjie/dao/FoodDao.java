package zzu.minjie.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import zzu.minjie.bean.Food;
import zzu.minjie.util.DBUTil;

public class FoodDao {
	public List<Food> readFood() {// 显示公告内容
		List<Food> list = new ArrayList<Food>();
		Connection conn = DBUTil.getConn();
		PreparedStatement pstmt = null;
		try {
			String sql4 = "select * from food limit 4";
			pstmt = conn.prepareStatement(sql4);
			ResultSet rs = pstmt.executeQuery();
			rs = pstmt.executeQuery();
			while (rs.next()) {
//				                  int foodid=rs.getInt("FoodId");
				String name = rs.getString("Name");
				String material = rs.getString("Material");
				String explain = rs.getString("FoodExplain");
				String image = rs.getString("Image");
				Food st = new Food(name, explain, material, image);
				list.add(st);
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

	public List<Food> readSpecialty() {// 显示特色菜内容
		List<Food> list = new ArrayList<Food>();
		Connection conn = DBUTil.getConn();
		PreparedStatement pstmt = null;
		try {
			String sql4 = "select * from food where specialty=1";
			pstmt = conn.prepareStatement(sql4);
			ResultSet rs = pstmt.executeQuery();
			rs = pstmt.executeQuery();
			while (rs.next()) {
//				                  int foodid=rs.getInt("FoodId");
				String name = rs.getString("Name");
				String material = rs.getString("Material");
				String explain = rs.getString("FoodExplain");
				String image = rs.getString("Image");
				Food st = new Food(name, explain, material, image);
				list.add(st);
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