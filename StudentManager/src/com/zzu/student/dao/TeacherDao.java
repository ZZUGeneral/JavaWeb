package com.zzu.student.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.zzu.student.bean.MyselfBean;
import com.zzu.student.bean.Student;
import com.zzu.student.bean.Teacher;
import com.zzu.student.util.DBUtil;

public class TeacherDao {
	/**
	 * ��ȡ��ʦ������Ϣ
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
	 * ��ȡ�ƶ���ʦ��ѧ��
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
	 * ��ʦ��¼
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
	 * �޸Ľ�ʦ��Ϣ
	 * 
	 * @param no
	 * @param name
	 * @param gender
	 * @param dept
	 * @param birthday
	 * @param email
	 * @param fileName
	 * @return
	 * @throws ParseException
	 */
	public boolean updateInfo(String no, String name, String gender, String dept, String birthday, String email)
			throws ParseException {
		// TODO Auto-generated method stub
		long teacher_no = Long.parseLong(no);
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date s = format.parse(birthday);
		Connection conn = DBUtil.getConnection();
		PreparedStatement pstmt = null;
		String sql = "update teacher set (teacher_name,gender,dept,birthday,email) values (?,?,?,?,?)"
				+ " where teacher_no = ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setString(2, gender);
			pstmt.setString(3, dept);
			pstmt.setTimestamp(4, new Timestamp(s.getTime()));
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
	 * �޸�����
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

	public boolean delete(long teacher_no) {
		// TODO Auto-generated method stub
		boolean rs = false;
		Connection conn = DBUtil.getConnection();
		PreparedStatement pstmt = null;
		PreparedStatement pstmt1 = null;
		String sql = "delete from teacher where teacher_no = ?";
		String sql1 = "delete from course where teacher_no = ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setLong(1, teacher_no);
			pstmt1 = conn.prepareStatement(sql1);
			pstmt1.setLong(1, teacher_no);
			if (pstmt.executeUpdate() > 0 && pstmt1.executeUpdate() > 0)
				rs = true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			DBUtil.closeJDBC(null, pstmt, conn);
		}
		return rs;
	}

	public boolean getSure(MyselfBean m) {
		// TODO Auto-generated method stub
		Connection conn = DBUtil.getConnection();
		PreparedStatement pstmt = null;
		String sql = "select * from Teacher where teacher_no = ?";
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setLong(1, m.getNo());
			rs = pstmt.executeQuery();
			if (rs.next()) {
				if (rs.getString("teacher_name") != m.getName())
					return false;
				if (rs.getString("gender") != m.getGender())
					return false;
				if (rs.getString("email") != m.getEmail())
					return false;
				if (rs.getString("dept") != m.getDept())
					return false;
				return true;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.closeJDBC(null, pstmt, conn);
		}

		return false;
	}

	public long addTeacher(String name, String gender, String dept, String birthday, String email, String headShot,
			String password) throws ParseException {

		int dept_no = Integer.parseInt(dept);
		String dept_name = new DeptDao().getDeptNameByNo(dept_no);
		long teacher_no = Long.parseLong(getMaxTeacherNo(dept_name,dept_no));
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date s = format.parse(birthday);

		Connection conn = DBUtil.getConnection();
		PreparedStatement pstmt = null;
		String sql = "insert into teacher values (?,?,?,?,?,?,?,?)";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setLong(1, teacher_no);
			pstmt.setString(2, name);
			pstmt.setString(3, gender);
			pstmt.setString(4, password);

			pstmt.setString(5, email);
			pstmt.setString(6, dept_name);
			pstmt.setTimestamp(7, new Timestamp(s.getTime()));
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
			teacher_no = -1;
		}
		return teacher_no;

	}

	private String getMaxTeacherNo(String dept_name, int dept_no) {
		// TODO Auto-generated method stub
		long stu_no = 0;
		Connection conn = DBUtil.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT max(teacher_no) FROM teacher where dept = ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dept_name);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				stu_no = rs.getLong(1)+1;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.closeJDBC(rs, pstmt, conn);
		}
		
		String stu = Long.toString(stu_no);
		if(stu.length()<10) {
			stu = "6778"+Integer.toString(dept_no)+"001";
		}
		return stu;

	}
}
