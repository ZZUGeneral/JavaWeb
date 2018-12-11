package com.zzu.student.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.zzu.student.bean.CourseBean;
import com.zzu.student.bean.ScoreBean;
import com.zzu.student.bean.Student;
import com.zzu.student.bean.Teacher;
import com.zzu.student.util.DBUtil;

public class SearchDao {

	public List<Student> getStudentSearch(String keyword) {
		// TODO Auto-generated method stub

		List<Student> stuList = new ArrayList<Student>();
		Connection conn = DBUtil.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM student where stu_no like ? or stu_name like ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%" + keyword + "%");
			pstmt.setString(2, "%" + keyword + "%");
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Student stu = new Student();
				stu.setStu_no(rs.getLong("stu_no"));
				stu.setStu_name(rs.getString("stu_name"));
				stu.setGender(rs.getString("gender"));
				stu.setDept(rs.getString("dept"));
				stuList.add(stu);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.closeJDBC(rs, pstmt, conn);
		}

		return stuList;
	}

	public List<Teacher> getTeacherSearch(String keyword) {
		// TODO Auto-generated method stub
		List<Teacher> teacherList = new ArrayList<Teacher>();
		Connection conn = DBUtil.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM teacher where teacher_no like ? or teacher_name like ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%" + keyword + "%");
			pstmt.setString(2, "%" + keyword + "%");
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Teacher teacher = new Teacher();
				teacher.setTeacher_name(rs.getString("teacher_name"));
				teacher.setTeacher_no(rs.getLong("teacher_no"));
				teacher.setGender(rs.getString("gender"));
				teacher.setDept(rs.getString("dept"));
				teacherList.add(teacher);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.closeJDBC(rs, pstmt, conn);
		}
		return teacherList;
	}

	public List<CourseBean> getCourseBeanSearch(String keyword) {
		// TODO Auto-generated method stub
		List<CourseBean> list = new ArrayList<CourseBean>();
		Connection conn = DBUtil.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select course_no,course_name,c"
				+ "redit,type,teacher_name from course left join "
				+ "teacher on course.teacher_no = teacher.teacher_no "
				+ "where course.course_no like ? or course.course_name like ? or teacher.teacher_name like ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%" + keyword + "%");
			pstmt.setString(2, "%" + keyword + "%");
			pstmt.setString(3, "%" + keyword + "%");
			rs = pstmt.executeQuery();
			while (rs.next()) {
				CourseBean cb = new CourseBean();
				cb.setCourse_no(rs.getLong("course_no"));
				cb.setCourse_name(rs.getString("course_name"));
				cb.setCredit(rs.getFloat("credit"));
				cb.setType(rs.getInt("type") == 1 ? "必修课" : "选修课");
				cb.setTeacher_name(rs.getString("teacher_name"));
				list.add(cb);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.closeJDBC(rs, pstmt, conn);
		}

		return list;
	}

	public List<ScoreBean> getScoreBeanSearch(String keyword) {
		// TODO Auto-generated method stub
		List<ScoreBean> list = new ArrayList<ScoreBean>();
		Connection conn = DBUtil.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select course_name,point,credit,type,score from course left join sc "
				+ "on course.course_no = sc.course_no where course.course_name like ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%" + keyword + "%");
			rs = pstmt.executeQuery();
			while (rs.next()) {
				ScoreBean ssb = new ScoreBean();
				ssb.setCourse_name(rs.getString("course_name"));
				ssb.setPoint(rs.getFloat("point"));
				ssb.setCredit(rs.getFloat("credit"));
				ssb.setType(rs.getInt("type") == 1 ?"必修课" : "选修课");
				ssb.setScore(rs.getFloat("score"));
				list.add(ssb);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.closeJDBC(rs, pstmt, conn);
		}

		return list;

	}

}
