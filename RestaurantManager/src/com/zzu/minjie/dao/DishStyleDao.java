package com.zzu.minjie.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.zzu.minjie.Util.DBUTil;
import com.zzu.minjie.bean.DishStyle;

public class DishStyleDao {
	
	public List<DishStyle> getDishStyles() {
		List<DishStyle> list = new ArrayList<DishStyle>();
		Connection conn = DBUTil.getConn();
		PreparedStatement pstmt = null;
		try {
			String sql = "select * from DishStyle";
			pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			rs = pstmt.executeQuery();
			while (rs.next()) {
				
				DishStyle dishStyle = new DishStyle();
				dishStyle.setDishName(rs.getString("dishName"));
				dishStyle.setDishExplain(rs.getString("dishExplain"));
				dishStyle.setOption(rs.getString("option"));
				dishStyle.setImage(rs.getString("image"));
				list.add(dishStyle);
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
