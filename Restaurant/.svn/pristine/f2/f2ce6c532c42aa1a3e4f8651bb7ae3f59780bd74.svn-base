package zzu.minjie.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

import zzu.minjie.bean.User;
import zzu.minjie.util.DBUTil;

public class UserDao {

//查找用户,登录时用来判断该用户是否存在
	public String findUser(String username) {
		Connection conn = DBUTil.getConn();
		PreparedStatement pstmt = null;
		String password = null;
		String sql = "select password from user where UserId=" + username;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if (rs.next())
				password = rs.getString(1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return password;

	}

	/**
	 * 验证phone和nick是否已被注册
	 * 
	 * @return
	 */
	public boolean isExist(String column_name, String value) {
		Connection conn = DBUTil.getConn();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM user WHERE " + column_name + " ='" + value + "'";
		try {
			pstmt = conn.prepareStatement(sql);
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

	// 保存注册信息
	public void save(String userId, String name, String address, String phone, int type, String gender,
			Timestamp birthday, String password, String nick) {
		Connection conn = DBUTil.getConn();
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO user VALUES(?,?,?,?,?,?,?,?,?)";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userId);
			pstmt.setString(2, name);
			pstmt.setString(3, address);
			pstmt.setString(4, phone);
			pstmt.setInt(5, type);
			pstmt.setString(6, gender);
			pstmt.setTimestamp(7, birthday);
			pstmt.setString(8, password);
			pstmt.setString(9, nick);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUTil.closeJDBC(null, pstmt, conn);
		}
	}

}
