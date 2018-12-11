package com.zzu.student.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.zzu.student.bean.MyselfBean;
import com.zzu.student.util.DBUtil;

public class MyselfDao {

	public MyselfBean getTeacherDetail(long no) {
		// TODO Auto-generated method stub
		MyselfBean teacher = new MyselfBean();
		Connection conn = DBUtil.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM teacher where teacher_no = ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setLong(1, no);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				teacher.setName(rs.getString("teacher_name"));
				teacher.setNo(rs.getLong("teacher_no"));
				teacher.setGender(rs.getString("gender"));
				teacher.setDept(rs.getString("dept"));
				teacher.setEmail(rs.getString("email"));
				teacher.setBirthday(rs.getTimestamp("birthday"));
				teacher.setHeadShot(rs.getString("headShot"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.closeJDBC(rs, pstmt, conn);
		}
		return teacher;
	}

	public MyselfBean getStudentDetail(long no) {
		// TODO Auto-generated method stub
		MyselfBean stu = new MyselfBean();
		Connection conn = DBUtil.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM student where stu_no = ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setLong(1, no);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				stu.setNo(rs.getLong("stu_no"));
				stu.setName(rs.getString("stu_name"));
				stu.setGender(rs.getString("gender"));
				stu.setBirthday(rs.getTimestamp("birthday"));
				stu.setDept(rs.getString("dept"));
				stu.setEmail(rs.getString("email"));
				stu.setHeadShot(rs.getString("headShot"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.closeJDBC(rs, pstmt, conn);
		}

		return stu;
	}

}
