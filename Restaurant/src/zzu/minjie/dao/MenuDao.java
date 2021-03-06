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
			String sql = "SELECT * " + "FROM food " + "where type = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);   //根据菜系名检索出所有的菜品
			// System.out.println(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Food food = new Food();
				// System.out.println(name);
				food.setFoodId(rs.getInt("foodid"));
				food.setName(rs.getString("name"));
				food.setPrice(rs.getFloat("price"));
				food.setImage(rs.getString("image"));
				food.setMemberPrice(rs.getFloat("memberprice"));
				food.setType(rs.getString("type"));
				food.setFoodExplain(rs.getString("foodexplain"));
				food.setMaterial(rs.getString("material"));
				list.add(food);
				// System.out.println(food.getName());
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUTil.closeJDBC(rs, pstmt, conn);
		}
		return list;
	}

	public void save(int foodid, String userId, float price, String name, String image) {
		// TODO Auto-generated method stub
		Connection conn = DBUTil.getConn();
		PreparedStatement pstmt = null;
		PreparedStatement pstmt1 = null;
		ResultSet rs = null;
		try {
			String sql = "select * from cart " + "where foodid = ? and cartid =?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, foodid);
			pstmt.setString(2, userId);
			rs = pstmt.executeQuery();
			int id = 0;
			while (rs.next()) {
				Food food = new Food();
				food.setFoodId(rs.getInt("foodid"));
				id = food.getFoodId();
			}
			if (id == 0) // 不存在这条记录，将记录插进去，number置为1
			{
				String sql1 = "INSERT INTO cart(" + "cartId,FoodId,Number,FoodName,UnitPrice,Image"
						+ ") VALUES(?,?,?,?,?,?)";
				pstmt1 = conn.prepareStatement(sql1);
				pstmt1.setString(1, userId);
				pstmt1.setInt(2, foodid);
				pstmt1.setInt(3, 1);
				pstmt1.setString(4, name);
				pstmt1.setFloat(5, price);
				pstmt1.setString(6, image);
				pstmt1.executeUpdate();
			} else { // 存在该记录，number加一
				String sql2 = "update cart set Number =(Number+1) " + "where cartId=? and FoodId=?";
				pstmt1 = conn.prepareStatement(sql2);
				pstmt1.setString(1, userId);
				pstmt1.setInt(2, foodid);
				pstmt1.executeUpdate();

			}

		} catch (SQLException e) {
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} finally {
			DBUTil.closeJDBC(null, pstmt, conn);
		}
	}

}