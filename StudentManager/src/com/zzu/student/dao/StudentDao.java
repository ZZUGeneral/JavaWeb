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
import com.zzu.student.util.DBUtil;

public class StudentDao {
	/**
	 * ѧ����¼
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
	 * ��ȡ������Ϣ
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
	 * ��ȡ�ض�ѧ������ϸ��Ϣ
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
	 * ����ѧ����Ϣ
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
		long stu_no = Long.parseLong(no);
		Connection conn = DBUtil.getConnection();
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date s = format.parse(birthday);
		PreparedStatement pstmt = null;
		String sql = "update student set stu_name=?,gender=?,dept=?,birthday=?,email=? " + "where stu_no = ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setString(2, gender);
			pstmt.setString(3, dept);
			pstmt.setTimestamp(4, new Timestamp(s.getTime()));
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

	public long addStudent(String name, String gender, String dept, String birthday, String email, String headShot,
			String password) throws ParseException {
		// TODO Auto-generated method stub

		int dept_no = Integer.parseInt(dept);
		String dept_name = new DeptDao().getDeptNameByNo(dept_no);
		long stu_no = Long.parseLong(getMaxStuNo(dept_name, dept_no));
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date s = format.parse(birthday);

		Connection conn = DBUtil.getConnection();
		PreparedStatement pstmt = null;
		String sql = "insert into student values (?,?,?,?,?,?,?,?)";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setLong(1, stu_no);
			pstmt.setString(2, name);
			pstmt.setString(3, gender);
			pstmt.setTimestamp(4, new Timestamp(s.getTime()));
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
			stu_no = -1;
		}
		return stu_no;

	}

	private String getMaxStuNo(String dept_name, int dept_no) {
		// TODO Auto-generated method stub
		long stu_no = 0;
		Connection conn = DBUtil.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT max(stu_no) FROM student where dept = ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dept_name);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				stu_no = rs.getLong(1) + 1;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.closeJDBC(rs, pstmt, conn);
		}
		String stu = Long.toString(stu_no);
		String first_No = stu.substring(7, 9);
		String second_no = stu.substring(9, 11);
		int class_no = Integer.parseInt(first_No);
		int student_no = Integer.parseInt(second_no);
		if (class_no == 0)
			class_no = 1;
		if (student_no > 30) {
			class_no++;
			student_no = 1;
		} else {
			student_no++;
		}
		String tem_stu_no = null;
		if (class_no < 10) {
			tem_stu_no = "0" + Integer.toString(class_no);
		} else {
			tem_stu_no = Integer.toString(class_no);
		}
		if (student_no < 10) {
			tem_stu_no = "0" + Integer.toString(student_no);
		} else {
			tem_stu_no = tem_stu_no + Integer.toString(student_no);
		}
		String year = stu.substring(0, 3);
		int cur_yyyy = Integer.parseInt(year);
		Date date = new Date();
		int yyyy = date.getYear();
		if (cur_yyyy == yyyy) {
			tem_stu_no = stu.substring(0, 7) + tem_stu_no;
		} else {
			tem_stu_no = Integer.toString(yyyy) + Integer.toString(dept_no) + tem_stu_no;
		}

		return tem_stu_no;

	}

	public boolean delete(long stu_no) {
		// TODO Auto-generated method stub
		boolean rs = false;
		Connection conn = DBUtil.getConnection();
		PreparedStatement pstmt = null;
		PreparedStatement pstmt1 = null;
		String sql = "delete from student where stu_no = ?";
		String sql1 = "delete from sc where stu_no = ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt1 = conn.prepareStatement(sql1);
			pstmt.setLong(1, stu_no);
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
		String sql = "select * from student where stu_no = ?";
		ResultSet rs = null;
		boolean sure = false;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setLong(1, m.getNo());
			rs = pstmt.executeQuery();
			if (rs.next()) {
				sure = true;
				if (!rs.getString("stu_name").equals(m.getName()))
					sure = false;
				if (!rs.getString("gender").equals(m.getGender()))
					sure = false;
				if (!rs.getString("email").equals(m.getEmail()))
					sure = false;
				if (!rs.getString("dept").equals(m.getDept()))
					sure = false;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.closeJDBC(null, pstmt, conn);
		}

		return sure;
	}

}
