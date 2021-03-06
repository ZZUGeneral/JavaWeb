package com.zzu.minjie.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.zzu.minjie.Util.DBUTil;
import com.zzu.minjie.bean.Food;

public class FoodDao {

	public List<Food> readSpecialty() {// 显示特色菜内�?
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

	/**
	 * ����һ������
	 */
	public void save(Food food) throws SQLException {
		Connection conn = DBUTil.getConn();
		PreparedStatement ps = null;

		String sql = "INSERT INTO food(Name, Price, MemberPrice, Type, FoodExplain, Material, Image,  specialty) VALUES(?,?,?,?,?,?,?,?)";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, food.getName());
			ps.setFloat(2, food.getPrice());
			ps.setFloat(3, food.getMemberPrice());
			ps.setString(4, food.getType());
			ps.setString(5, food.getFoodExplain());
			ps.setString(6, food.getMaterial());
			ps.setString(7, food.getImage());
			ps.setInt(8, food.getSpecialty());
			ps.executeUpdate();
		} finally {
			DBUTil.closeJDBC(null, ps, conn);
		}
	}

	/**
	 * ɾ��һ������
	 */
	public void delete(Integer foodId) {
		Connection conn = DBUTil.getConn();
		PreparedStatement ps = null;
		String sql = "delete from food where foodId = ?";
		try {

			ps = conn.prepareStatement(sql);
			ps.setInt(1, foodId);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUTil.closeJDBC(null, ps, conn);
		}
	}

	/**
	 * ����һ������
	 * 
	 * @throws SQLException
	 */
	public void update(Integer id, Food food) throws SQLException {
		Connection conn = DBUTil.getConn();
		PreparedStatement ps = null;

		String sql = "update Food set Name = ?, Price = ?, MemberPrice = ?, "
				+ "Type = ?, FoodExplain = ?, Material = ?, Image = ?, specialty = ? " + " where FoodId = ?";
		try {

			ps = conn.prepareStatement(sql);
			ps.setString(1, food.getName());
			ps.setFloat(2, food.getPrice());
			ps.setFloat(3, food.getMemberPrice());
			ps.setString(4, food.getType());
			ps.setString(5, food.getFoodExplain());
			ps.setString(6, food.getMaterial());
			ps.setString(7, food.getImage());
			ps.setInt(8, food.getSpecialty());
			ps.setInt(9, id);
			ps.executeUpdate();
		} finally {
			DBUTil.closeJDBC(null, ps, conn);
		}
	}

	/**
	 * ��ѯ���в�Ʒ
	 * 
	 * @return
	 */

	public List<Food> selectAllFood() {
		List<Food> list = new ArrayList<Food>();
		Connection conn = DBUTil.getConn();
		PreparedStatement pstmt = null;
		try {
			String sql4 = "select * from food";
			pstmt = conn.prepareStatement(sql4);
			ResultSet rs = pstmt.executeQuery();
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Food food = new Food();
				food.setFoodId(rs.getInt("FoodId"));
				food.setName(rs.getString("Name"));
				food.setPrice(rs.getFloat("price"));
				food.setMemberPrice(rs.getFloat("MemberPrice"));
				food.setType(rs.getString("Type"));
				food.setFoodExplain(rs.getString("foodExplain"));
				food.setImage(rs.getString("image"));
				food.setMaterial(rs.getString("material"));
				food.setSpecialty(rs.getInt("specialty"));

				list.add(food);
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

	/**
	 * ��id��ѯ
	 * 
	 * @return
	 */
	public Food searchById(Integer id) {
		Food food = new Food();
		Connection conn = DBUTil.getConn();
		PreparedStatement pstmt = null;
		try {
			String sql = "select * from food where foodId=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {

				food.setFoodId(id);
				food.setName(rs.getString("Name"));
				food.setPrice(rs.getFloat("Price"));
				food.setMemberPrice(rs.getFloat("MemberPrice"));
				food.setType(rs.getString("Type"));
				food.setFoodExplain(rs.getString("foodExplain"));
				food.setMaterial(rs.getString("Material"));
				food.setImage(rs.getString("image"));
				food.setSpecialty(rs.getInt("specialty"));

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
		return food;
	}

	/**
	 * ��������ѯ
	 * 
	 * @return
	 */
	public Food searchByName(String name) {
		Food food = new Food();
		Connection conn = DBUTil.getConn();
		PreparedStatement pstmt = null;
		try {
			String sql = "select * from food where Name=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {

				food.setFoodId(rs.getInt("FoodId"));
				food.setName(rs.getString("Name"));
				food.setPrice(rs.getFloat("Price"));
				food.setMemberPrice(rs.getFloat("MemberPrice"));
				food.setType(rs.getString("Type"));

//				String name = rs.getString("Name");
//				String material = rs.getString("Material");
//				String explain = rs.getString("FoodExplain");
//				String image = rs.getString("Image");
				// Food st = new Food(name, explain, material, image);
				// list.add(st);
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
		return food;
	}

}
