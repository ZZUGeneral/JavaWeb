package com.zzu.minjie.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.zzu.minjie.Util.DBUTil;

public class AdminDao {
   // 登录 : 获取对应账号的密码与输入密码比较,相同则返回名称,,否则返回null
	public String login(String ID, String pwd) {
		String sql = "select Password,name from admin where AdminID = ?";
		Connection conn = DBUTil.getConn();
		String password = null;
		String name = null;
		ResultSet rs = null;
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, ID);
			rs = ps.executeQuery();
			if (rs.next()) {
				password = rs.getString(1);
				if (pwd.equals(password)) {
					name = rs.getString(2);
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return name;
	}
//更新密码
	public void modifyPassword(String ID, String pwd) {
		String sql = "update admin set Password=" + pwd + " where AdminID=" + ID;
		Connection conn = DBUTil.getConn();
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.executeUpdate(sql);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
