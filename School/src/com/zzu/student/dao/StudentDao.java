package com.zzu.student.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.zzu.student.bean.Student;
import com.zzu.student.util.DBUtil;

public class StudentDao {
	/**
	 * 学生登录
	 * 
	 * @param stu_no
	 * @param password
	 * @return
	 */
	public String login(long stu_no, String password) {
		String stuName = null;
		Connection conn = DBUtil.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT stu_name FROM Student WHERE stu_no=? and password=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setLong(1, stu_no);
			pstmt.setString(2, password);
			rs = pstmt.executeQuery();
			if (rs.next())
				stuName = rs.getString("stu_name");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeJDBC(rs, pstmt, conn);
		}
		return stuName;
	}

	/**
	 * 获取基本信息
	 * 
	 * @param pageNo
	 * 
	 * @return
	 */
	public List<Student> getBasicinfoForStudent(int pageNo) {
		// TODO Auto-generated method stub
		int pageSize = 15;
		List<Student> list = new ArrayList<Student>();
		Connection conn = DBUtil.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "select * from(select a.*,ROWNUM rn from (student) a where ROWNUM<=? order by a.stu_no) where rn>?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, pageNo * 15 + pageSize);
			pstmt.setInt(2, pageNo * 15);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Student stu = new Student();
				stu.setStu_name(rs.getString("stu_name"));
				stu.setStu_no(rs.getLong("stu_no"));
				stu.setGender(rs.getString("gender"));
				stu.setDept(rs.getString("dept"));
				list.add(stu);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.closeJDBC(rs, pstmt, conn);
		}

		return list;
	}

	/**
	 * 获取特定学生的详细信息
	 * 
	 * @param stu_no
	 * @return
	 */
	public Student getDetail(Long stu_no) {
		Student stu = new Student();
		Connection conn = DBUtil.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM student where stu_no = ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setLong(1, stu_no);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				stu.setStu_no(rs.getLong("stu_no"));
				stu.setStu_name(rs.getString("stu_name"));

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

	/**
	 * 更新学生信息
	 * 
	 * @param no
	 * @param name
	 * @param gender
	 * @param dept
	 * @param birthday
	 * @param email
	 * @param fileName
	 * @return
	 */

	@SuppressWarnings("deprecation")
	public boolean updateInfo(String no, String name, String gender, String dept, String birthday, String email) {
		// TODO Auto-generated method stub
		long stu_no = Long.parseLong(no);
		Connection conn = DBUtil.getConnection();
		PreparedStatement pstmt = null;
		String sql = "update student set (stu_name,gender,dept,birthday,email) values (?,?,?,?,?) "
				+ "where stu_no = ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setString(2, gender);
			pstmt.setString(3, dept);
			pstmt.setTimestamp(4, new Timestamp(Date.parse(birthday)));
			pstmt.setString(5, email);
			pstmt.setLong(6, stu_no);
			pstmt.executeUpdate();
			return true;
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

		return false;
	}

	/**
	 * 修改密码
	 * 
	 * @param teacher_no
	 * @param newPassword
	 * @return
	 */
	public boolean updatePassword(Long teacher_no, String newPassword) {
		// TODO Auto-generated method stub
		Connection conn = DBUtil.getConnection();
		PreparedStatement pstmt = null;
		String sql = "update student set password = ? where stu_no = ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, newPassword);
			pstmt.setLong(2, teacher_no);
			pstmt.executeUpdate();
			return true;
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

		return false;
	}

	@SuppressWarnings("deprecation")
	public long addStudent(String name, String gender, String dept, String birthday, String email, String headShot) {
		// TODO Auto-generated method stub
		long stu_no = getMaxStuNo() + 1;
		int dept_no = Integer.parseInt(dept);
		String dept_name = getDeptName(dept_no);

		String password = "123456";
		Connection conn = DBUtil.getConnection();
		PreparedStatement pstmt = null;
		String sql = "insert into student values (?,?,?,?,?,?,?,?)";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setLong(1, stu_no);
			pstmt.setString(2, name);
			pstmt.setString(3, gender);
			pstmt.setTimestamp(4, new Timestamp(Date.parse(birthday)));
			pstmt.setString(5, password);
			pstmt.setString(6, dept_name);
			pstmt.setString(7, email);
			pstmt.setString(8, headShot);
			pstmt.executeUpdate();
			conn.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
		return stu_no;

	}

	private String getDeptName(int dept_no) {
		// TODO Auto-generated method stub
		String deptName = null;
		Connection conn = DBUtil.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT dept_name FROM dept where dept_no = ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, dept_no);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				deptName = rs.getString("dept_name");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.closeJDBC(rs, pstmt, conn);
		}
		return deptName;
	}

	private long getMaxStuNo() {
		// TODO Auto-generated method stub
		long stu_no = 0;
		Connection conn = DBUtil.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT max(stu_no) FROM student group by dept";
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				stu_no = rs.getLong(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.closeJDBC(rs, pstmt, conn);
		}

		return stu_no;

	}

}
