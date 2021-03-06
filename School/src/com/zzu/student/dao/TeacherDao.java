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
import com.zzu.student.bean.Teacher;
import com.zzu.student.util.DBUtil;

public class TeacherDao {
	/**
	 * 获取教师基本信息
	 * 
	 * @param pageNo
	 * 
	 * @return
	 */
	public List<Teacher> getBasicinfoForTeacher(int pageNo) {
		int pageSize = 15;
		List<Teacher> list = new ArrayList<Teacher>();
		Connection conn = DBUtil.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * from(select a.*, ROWNUM rn FROM (teacher) a where ROWNUM <= ? order by a.teacher_no) where rn > ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, pageNo * 15 + pageSize);
			pstmt.setInt(2, pageNo * 15);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Teacher teacher = new Teacher();
				teacher.setTeacher_name(rs.getString("teacher_name"));
				teacher.setTeacher_no(rs.getLong("teacher_no"));
				teacher.setGender(rs.getString("gender"));
				teacher.setDept(rs.getString("dept"));
				list.add(teacher);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeJDBC(rs, pstmt, conn);
		}

		return list;
	}

	/**
	 * 获取详细信息
	 * 
	 * @param teacher_no
	 * @return
	 */

	public Teacher getDetail(Long teacher_no) {
		// TODO Auto-generated method stub
		Teacher teacher = new Teacher();
		Connection conn = DBUtil.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM teacher where teacher_no = ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setLong(1, teacher_no);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				teacher.setTeacher_name(rs.getString("teacher_name"));
				teacher.setTeacher_no(rs.getLong("teacher_no"));
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

	/**
	 * 获取制定老师的学生
	 * 
	 * @param teacher_no
	 * @return
	 */
	public List<Student> getStudent(long teacher_no) {
		// TODO Auto-generated method stub
		List<Student> list = new ArrayList<Student>();
		Connection conn = DBUtil.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT DISTINCT stu_name,stu_no,gender,dept FROM student where stu_no in "
				+ "(select stu_no from sc where course_no in ("
				+ " select course_no from course where teacher_no = ?))";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setLong(1, teacher_no);
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
	 * 教师登录
	 * 
	 * @param teacher_no
	 * @param password
	 * @return
	 */
	public String login(long teacher_no, String password) {
		// TODO Auto-generated method stub
		String teacherName = null;
		Connection conn = DBUtil.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT teacher_name FROM teacher WHERE teacher_no=? and password=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setLong(1, teacher_no);
			pstmt.setString(2, password);
			rs = pstmt.executeQuery();
			if (rs.next())
				teacherName = rs.getString("teacher_name");
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			DBUtil.closeJDBC(rs, pstmt, conn);
		}
		return teacherName;
	}

	/**
	 * 修改教师信息
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
	public boolean updateInfo(String no, String name, String gender, String dept, String birthday, String email) {
		// TODO Auto-generated method stub
		long teacher_no = Long.parseLong(no);
		Connection conn = DBUtil.getConnection();
		PreparedStatement pstmt = null;
		String sql = "update teacher set (teacher_name,gender,dept,birthday,email) values (?,?,?,?,?)"
				+ " where teacher_no = ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setString(2, gender);
			pstmt.setString(3, dept);
			pstmt.setTimestamp(4, new Timestamp(Date.parse(birthday)));
			pstmt.setString(5, email);
			pstmt.setLong(6, teacher_no);
			pstmt.executeUpdate();
			conn.commit();
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
		String sql = "update teacher set password = ? where teacher_no = ?";
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

}
