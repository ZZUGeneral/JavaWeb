package com.zzu.student.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.zzu.student.util.DBUtil;

public class HeadShotDao {
	public int updateHeadShotForTeacher(long teacher_no, String newFileName) {
		// TODO Auto-generated method stub
		int update = 0;
		Connection conn = DBUtil.getConnection();
		PreparedStatement pstmt = null;
		String sql = "update teacher set headshot = ? where teacher_no = ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, newFileName);
			pstmt.setLong(2, teacher_no);
			update = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			DBUtil.closeJDBC(null, pstmt, conn);
		}

		return update;
	}

	public int updateHeadShotForStudent(long stu_no, String newFileName) {
		// TODO Auto-generated method stub
		int update = 0;
		Connection conn = DBUtil.getConnection();
		PreparedStatement pstmt = null;
		String sql = "update student set headshot = ? where stu_no = ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, newFileName);
			pstmt.setLong(2, stu_no);
			update = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			DBUtil.closeJDBC(null, pstmt, conn);
		}

		return update;
	}

	public String getHeadShotForTeacher(long teacher_no) {
		// TODO Auto-generated method stub
		String fileName = null;
		Connection conn = DBUtil.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select headshot from teacehr where teacher_no = ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setLong(1, teacher_no);
			rs = pstmt.executeQuery();
			if (rs.next())
				fileName = rs.getString("headshot");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		} finally {
			DBUtil.closeJDBC(null, pstmt, conn);
		}

		return fileName;
	}

	public String getHeadShotForStudent(long stu_no) {
		// TODO Auto-generated method stub
		String fileName = null;
		Connection conn = DBUtil.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select headshot from student where stu_no = ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setLong(1, stu_no);
			rs = pstmt.executeQuery();
			if (rs.next())
				fileName = rs.getString("headshot");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		} finally {
			DBUtil.closeJDBC(null, pstmt, conn);
		}
		return fileName;
	}

}
