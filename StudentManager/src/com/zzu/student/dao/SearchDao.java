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
import com.zzu.student.bean.StudentScoreBean;
import com.zzu.student.bean.Teacher;
import com.zzu.student.util.DBUtil;

public class SearchDao {

	public List<Student> getStudentSearch(String keyword, long NO) {
		// TODO Auto-generated method stub

		List<Student> stuList = new ArrayList<Student>();
		Connection conn = DBUtil.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM student where stu_no like ? or stu_name like ?";
		if (Long.toString(NO).startsWith("6778")) {
			sql = "SELECT distinct student.stu_no,student.stu_name,student.gender,student.dept FROM student left join sc on student.stu_no=sc.stu_no "
					+ "left join course on course.course_no = sc.course_no"
					+ " where (student.stu_no like ? or student.stu_name like ?) and course.teacher_no = ?";
		}
		System.out.println(sql);
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%" + keyword + "%");
			pstmt.setString(2, "%" + keyword + "%");
			pstmt.setLong(3, NO);
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

	public List<CourseBean> getCourseBeanSearch(String keyword, long NO) {
		// TODO Auto-generated method stub
		List<CourseBean> list = new ArrayList<CourseBean>();
		Connection conn = DBUtil.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select course.course_no,course.course_name,course.credit,course.type,teacher.teacher_name from course left join "
				+ "teacher on course.teacher_no = teacher.teacher_no left join sc on "
				+ "course.course_no = sc.course_no "
				+ "where (course.course_no like ? or course.course_name like ? or teacher.teacher_name like ?) and (teacher.teacher_no = ?"
				+ " or sc.stu_no = ?)";
		if (Long.toString(NO).startsWith("6778"))
			sql = "select course.course_no,course.course_name,course.credit,course.type,teacher.teacher_name from course left join "
					+ "teacher on course.teacher_no = teacher.teacher_no "
					+ "where (course.course_no like ? or course.course_name like ?) and teacher.teacher_no = ?";
		System.out.println(sql);
		try {
			pstmt = conn.prepareStatement(sql);
			if (Long.toString(NO).startsWith("6778")) {
				pstmt.setString(1, "%" + keyword + "%");
				pstmt.setString(2, "%" + keyword + "%");
				pstmt.setLong(3, NO);
			} else {
				pstmt.setString(1, "%" + keyword + "%");
				pstmt.setString(2, "%" + keyword + "%");
				pstmt.setString(3, "%" + keyword + "%");
				pstmt.setLong(4, NO);
				pstmt.setLong(5, NO);
			}
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

	public List<ScoreBean> getScoreBeanSearch(String keyword, long NO) {
		// TODO Auto-generated method stub
		List<ScoreBean> list = new ArrayList<ScoreBean>();
		Connection conn = DBUtil.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select course_name,point,credit,type,score from course left join sc "
				+ "on course.course_no = sc.course_no where (course.course_name like ? or course.course_no like ?)and sc.stu_no = ?";
		System.out.println(sql);
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%" + keyword + "%");
			pstmt.setString(2, "%" + keyword + "%");
			pstmt.setLong(3, NO);
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

	public List<CourseBean> getChooseCourseSearch(String keyword) {
		// TODO Auto-generated method stub
		List<CourseBean> list = new ArrayList<CourseBean>();
		Connection conn = DBUtil.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select course.course_no,course.course_name,course.credit,course.type,teacher.teacher_name from course left join "
				+ "teacher on course.teacher_no = teacher.teacher_no left join sc on "
				+ "course.course_no = sc.course_no "
				+ "where course.course_no like ? or course.course_name like ? or teacher.teacher_name like ?";
		System.out.println(sql);
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

	public List<StudentScoreBean> getStudentScoreSearch(String keyword, long NO) {
		// TODO Auto-generated method stub
		List<StudentScoreBean> list = new ArrayList<StudentScoreBean>();
		Connection conn = DBUtil.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select stu_no,stu_name,course_name,score,course_no from (select s.stu_no,s.stu_name,c.course_name,sc.score,c.course_no from ("
				+ "select course_no,course_name from course where course_no in (select course_no"
				+ " from course where teacher_no = ?)) c left join sc on c.course_no = sc.course_no"
				+ " left join (select stu_no,stu_name from student) s on s.stu_no = sc.stu_no order by c.course_no,s.stu_no) "
				+ "where stu_no like ? or stu_name like ? or course_name like ? or course_no like ?";
		System.out.println(sql);
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setLong(1, NO);
			pstmt.setString(2, "%" + keyword + "%");
			pstmt.setString(3, "%" + keyword + "%");
			pstmt.setString(4, "%" + keyword + "%");
			pstmt.setString(5, "%" + keyword + "%");
			rs = pstmt.executeQuery();
			while (rs.next()) {
				StudentScoreBean ssb = new StudentScoreBean();
				ssb.setStu_no(rs.getLong("stu_no"));
				ssb.setStu_name(rs.getString("stu_name"));
				ssb.setCourse_name(rs.getString("course_name"));
				ssb.setScore(rs.getFloat("score"));
				ssb.setCourse_no(rs.getInt("course_no"));
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
