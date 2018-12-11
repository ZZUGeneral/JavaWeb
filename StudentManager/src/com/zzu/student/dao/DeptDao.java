package com.zzu.student.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.zzu.student.util.DBUtil;

public class DeptDao {

	public String getDeptNameByNo(int dept_no) {
		// TODO Auto-generated method stub
		String name = null;
		Connection conn = DBUtil.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select dept_name from zzudept where dept_no = ?";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, dept_no);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				name = rs.getString("dept_name");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return name;
	}

}
