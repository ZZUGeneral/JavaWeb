package com.zzu.student.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.zzu.student.bean.CourseBean;
import com.zzu.student.bean.ScoreBean;
import com.zzu.student.util.DBUtil;

public class CourseDao {
	/**
	 * 获取学生成绩
	 * 
	 * @param stu_no
	 * @return
	 */
	public List<ScoreBean> getScore(long stu_no) {
		List<ScoreBean> list = new ArrayList<ScoreBean>();
		Connection conn = DBUtil.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select course_name,point,credit,type,score from course left join sc "
				+ "on course.course_no = sc.course_no where sc.stu_no =?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setLong(1, stu_no);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				ScoreBean ssb = new ScoreBean();
				ssb.setCourse_name(rs.getString("course_name"));
				ssb.setPoint(rs.getFloat("point"));
				ssb.setCredit(rs.getFloat("credit"));
				ssb.setType(rs.getInt("type") == 1 ? "必修课" : "选修课");
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

	/**
	 * 获取学生课程安排
	 * 
	 * @param stu_no
	 * @return
	 */
	public List<CourseBean> getCourseForStudent(long stu_no) {
		List<CourseBean> list = new ArrayList<CourseBean>();
		Connection conn = DBUtil.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select course_no,course_name,credit,type,teacher_name from course left join "
				+ "teacher on course.teacher_no = teacher.teacher_no "
				+ "where course.course_no in (select course_no from sc where stu_no = ?)";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setLong(1, stu_no);
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

	public List<CourseBean> getCourseForTeacher(long teacher_no) {
		List<CourseBean> list = new ArrayList<CourseBean>();
		Connection conn = DBUtil.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select course_no,course_name,credit,type,teacher_name from course left join "
				+ "teacher on course.teacher_no = teacher.teacher_no where teacher.teacher_no = ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setLong(1, teacher_no);
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

	public List<CourseBean> chooseCourse(int pageNo) {
		int pageSize = 15;
		List<CourseBean> list = new ArrayList<CourseBean>();
		Connection conn = DBUtil.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select course_no,course_name,credit,type,teacher_name from (select a.*,"
				+ "ROWNUM rn from (select * from  course left join teacher on course.teacher_no = teacher.teacher_no "
				+ " ) a where ROWNUM<=?) where rn>? ";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, pageNo * 15 + pageSize);
			pstmt.setInt(2, pageNo * 15);
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

	public int addSC(long stu_no, int course_no) {
		// TODO Auto-generated method stub
		int result = 0;
		Connection conn = DBUtil.getConnection();
		PreparedStatement pstmt = null;
		String sql = "insert into sc (course_no,stu_no) values(?,?)";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, course_no);
			pstmt.setLong(2, stu_no);
			result = pstmt.executeUpdate();
			conn.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			try {
				conn.commit();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
			return 0;
		} finally {
			DBUtil.closeJDBC(null, pstmt, conn);
		}
		return result;
	}

	public boolean addCourse(long teacher_no, int course_no, String course_name, float credit, int type) {
		// TODO Auto-generated method stub
		Connection conn =DBUtil.getConnection();
		PreparedStatement pstmt = null;
		String sql = "insert into course values(?,?,?,?,?)";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, course_no);
			pstmt.setString(2, course_name);
			pstmt.setLong(3, teacher_no);
			pstmt.setFloat(4, credit);
			pstmt.setInt(5, type);
			pstmt.executeUpdate();
			conn.commit();
			return true;
		} catch (SQLException e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}finally {
			DBUtil.closeJDBC(null, pstmt, conn);
		}
	}

}
