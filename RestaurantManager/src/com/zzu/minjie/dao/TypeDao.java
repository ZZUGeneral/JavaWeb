package com.zzu.minjie.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.zzu.minjie.Util.DBUTil;
import com.zzu.minjie.bean.DishStyle;

public class TypeDao {
	public List<DishStyle> Type_list() {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select dishId,dishName from dishstyle";
		List<DishStyle> list = new ArrayList<DishStyle>();
		try {
			conn = DBUTil.getConn();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				DishStyle style = new DishStyle();
				style.setDishId(rs.getInt("dishId"));
				style.setDishName(rs.getString("dishName"));
				list.add(style);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUTil.closeJDBC(rs, ps, conn);
		}
		return list;
	}

	public String deleteType(String id) {
		Connection conn = null;
		PreparedStatement ps = null;
		String sql = "delete from dishstyle where id = ?";
		int id1 = Integer.parseInt(id);
		try {
			conn = DBUTil.getConn();
			ps = conn.prepareStatement(sql);
			ps.setInt(0, id1);
			ps.executeUpdate(sql);
			conn.commit();
			return "success";
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUTil.closeJDBC(null, ps, conn);
		}
		return "false";
	}

	public String addType(String name, String explain, String fileName) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement ps = null;
		String sql = "insert into dishstyle (dishName,dishExplain,option,image) values(?,?,?,?)";
		String option = fileName;
		try {
			conn = DBUTil.getConn();
			ps = conn.prepareStatement(sql);
			ps.setString(1, name);
			ps.setString(2, explain);
			ps.setString(3, option);
			ps.setString(4, fileName);
			ps.executeUpdate();
			conn.commit();
			return "success";
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUTil.closeJDBC(null, ps, conn);
		}
		return "fasle";
	}

	public DishStyle Type(String id) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int id1 = Integer.parseInt(id);
		String sql = "select * from dishstyle where dishId= ?";
		DishStyle style = new DishStyle();
		try {
			conn = DBUTil.getConn();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id1);
			rs = ps.executeQuery();
			while (rs.next()) {
				style.setDishId(rs.getInt("dishId"));
				style.setDishName(rs.getString("dishName"));
				style.setDishExplain(rs.getString("dishExplain"));
				style.setImage(rs.getString("image"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUTil.closeJDBC(rs, ps, conn);
		}
		return style;
	}

	public String updateType(String name, String explain, String fileName, String id) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement ps = null;
		String sql = "update dishstyle set (dishName,dishExplain,option,image) values(?,?,?,?) where id = ?";
		String option = fileName;
		int id1 = Integer.parseInt(id);
		try {
			conn = DBUTil.getConn();
			ps = conn.prepareStatement(sql);
			ps.setString(1, name);
			ps.setString(2, explain);
			ps.setString(3, option);
			ps.setString(4, fileName);
			ps.setInt(5, id1);
			ps.executeUpdate();
			conn.commit();
			return "success";
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUTil.closeJDBC(null, ps, conn);
		}
		return "fasle";
	}
}
