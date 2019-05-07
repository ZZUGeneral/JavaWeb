package zzu.minjie.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import zzu.minjie.bean.Food;
import zzu.minjie.util.DBUTil;

public class MenuDao {



	/**
	 * 查询对应菜品
	 * 
	 * @return
	 */
	public List<Food> getMenuList(String name) {
		List<Food> list = new ArrayList<Food>();
		Connection conn = DBUTil.getConn();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			String sql = "SELECT * "
					+ "FROM food "
					+ "where type = ?";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Food food = new Food();
				pstmt.setString(1, name);
				food.setFoodId(rs.getInt("foodid"));
				food.setName(rs.getString("name"));
				food.setPrice(rs.getFloat("price"));
				food.setMemberPrice(rs.getFloat("memberprice"));
				food.setType(rs.getString("type"));
				food.setFoodExplain(rs.getString("foodexplain"));
				food.setMaterial(rs.getString("material"));
				list.add(food);
				System.out.println(food.getName());
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUTil.closeJDBC(rs, pstmt, conn);
		}
		return list;
	}

}