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
	 * 获取用户电话
	 * 
	 * @param username
	 * @return
	 */
	public String getPhone(String username) {
		Connection conn = DBUTil.getConn();
		PreparedStatement pstmt = null;
		String phone = null;
		String sql = "select Phone from user where UserId=" + username;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if (rs.next())
				phone = rs.getString(1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return phone;
	}

	/**
	 * 根据账号查找用户昵称
	 * 
	 * @param username
	 * @return
	 */
	public String getNickByID(String username) {
		Connection conn = DBUTil.getConn();
		PreparedStatement pstmt = null;
		String nick = null;
		String sql = "select nick from user where UserId=" + username;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if (rs.next())
				nick = rs.getString(1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return nick;
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

	public User getUserInfoByID(String username) {
		User user = new User();
		Connection conn = DBUTil.getConn();
		PreparedStatement pstmt = null;
		String sql = "SELECT * FROM user WHERE userid=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, username);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				user.setUserId(rs.getString("userid"));
				user.setName(rs.getString("name"));
				user.setAddress(rs.getString("address"));
				user.setPhone(rs.getString("phone"));
				user.setGender(rs.getString("gender"));
				user.setBirthday(rs.getDate("birthday"));
				user.setNick(rs.getString("nick"));

				// 新增
				user.setType(rs.getInt("type"));
				user.setPassword(rs.getString("password"));

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUTil.closeJDBC(null, pstmt, conn);
		}
		return user;
	}

	public void update(User user) {
		String sql = "UPDATE user " + "SET name=?,address=?,phone=?," + "gender=?,birthday=?,nick=?" + "WHERE userid=?";

		Connection conn = DBUTil.getConn();
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, user.getName());
			pstmt.setString(2, user.getAddress());
			pstmt.setString(3, user.getPhone());
			pstmt.setString(4, user.getGender());
			pstmt.setTimestamp(5, user.getBirthday() == null ? null : new Timestamp(user.getBirthday().getTime()));
			pstmt.setString(6, user.getNick());
			pstmt.setString(7, user.getUserId());
			pstmt.executeUpdate();
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

	public void updateAll(User user) {
//		String sql = "UPDATE user "
//				+ "SET name=?,address=?,phone=?,"
//				+ "gender=?,birthday=?,nick=?"
//				+ "WHERE userid=?";

		// 更新
		String sql = "UPDATE user " + "SET name=?,address=?,phone=?," + "gender=?,birthday=?,nick=?,"
				+ "type=?,password=?" + "WHERE userid=?";
		Connection conn = DBUTil.getConn();
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, user.getName());
			pstmt.setString(2, user.getAddress());
			pstmt.setString(3, user.getPhone());
			pstmt.setString(4, user.getGender());
			pstmt.setTimestamp(5, user.getBirthday() == null ? null : new Timestamp(user.getBirthday().getTime()));
			pstmt.setString(6, user.getNick());

			// 更新
			pstmt.setInt(7, user.getType());
			pstmt.setString(8, user.getPassword());

			pstmt.setString(9, user.getUserId());
			pstmt.executeUpdate();
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

	public void changepwd(String userId, String pwd) {
		String sql = "UPDATE user " + "SET password=?" + "WHERE userid=?";

		Connection conn = DBUTil.getConn();
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, pwd);
			pstmt.setString(2, userId);
			pstmt.executeUpdate();
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
