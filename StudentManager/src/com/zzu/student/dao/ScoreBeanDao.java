package com.zzu.student.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.zzu.student.bean.StudentScoreBean;
import com.zzu.student.util.DBUtil;

public class ScoreBeanDao {
	public List<StudentScoreBean> getStudentScore(long teacher_no, int pageNo) {
		List<StudentScoreBean> list = new ArrayList<StudentScoreBean>();
		int pageSize = 15;
		Connection conn = DBUtil.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select stu_no,stu_name,course_name,score,course_no from (select a.*,"
				+ "ROWNUM rn from (select s.stu_no,s.stu_name,c.course_name,sc.score,c.course_no from ("
				+ "select course_no,course_name from course where course_no in (select course_no"
				+ " from course where teacher_no = ?)) c left join sc on c.course_no = sc.course_no"
				+ " left join (select stu_no,stu_name from student) s on s.stu_no = sc.stu_no order by c.course_no,s.stu_no) a "
				+ "where ROWNUM<=?) ssc where rn>?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setLong(1, teacher_no);
			pstmt.setInt(2, pageNo * 15 + pageSize);
			pstmt.setInt(3, pageNo * 15);
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

	public int updateScore(long stu_no, float score, int course_no) {
		int i = 0;
		Connection conn = DBUtil.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		float point = 0;

		if (score > 60)
			point = 1;
		if (score > 70)
			point = 2;
		if (score > 80)
			point = 3;
		if (score > 90)
			point = 2;

		String sql = "update sc set score = ?,point = ? where course_no=? and stu_no = ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setFloat(1, score);
			pstmt.setFloat(2, point);
			pstmt.setInt(3, course_no);
			pstmt.setLong(4, stu_no);
			i = pstmt.executeUpdate();
			conn.commit();
		} catch (SQLException e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.closeJDBC(rs, pstmt, conn);
		}

		return i;
	}

}
