package zzu.minjie.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import zzu.minjie.bean.Cart;
import zzu.minjie.util.DBUTil;



public class CartDao {
	
	//判断该用户CartID购物车内是否有东西
	public boolean isExistCartID(String id) {
		Connection conn = DBUTil.getConn();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM cat WHERE CartId=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if (rs.next())
				return true;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUTil.closeJDBC(rs, pstmt, conn);
		}
		return false;
	}
	
	/*得到所有符合条件的购物车物品*/
	public List<Cart> selectCart(String column_name,String value) {
		List<Cart> cartList=new ArrayList<Cart>();
		Connection conn = DBUTil.getConn();
		PreparedStatement pstmt = null;
		String sql=null;
		ResultSet rs=null;

			sql="SELECT * FROM cart WHERE "+column_name+" ='"+value+"'";
		try {
			// 关闭自动提交
			conn.setAutoCommit(false);
			pstmt = conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				String cartId=rs.getString("CartId");
				int foodId=rs.getInt("FoodId");
				int number=rs.getInt("Number");
				String foodName=rs.getString("FoodName");
				float unitPrice=rs.getFloat("UnitPrice");
				String image=rs.getString("Image");
				Cart cart=new Cart(cartId,foodId,number,foodName,unitPrice,image);
				cartList.add(cart);
			}
		} catch (SQLException e) {
				e.printStackTrace();
		} finally {
			DBUTil.closeJDBC(rs, pstmt, conn);
		}
		return cartList;
	}
	
	

}
