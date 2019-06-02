package com.zzu.minjie.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.zzu.minjie.bean.Notice;

import com.zzu.minjie.Util.DBUTil;

public class NoticeDao {
	public List<Notice> readNotice() {// 显示公告内容
		List<Notice> list = new ArrayList<Notice>();
		Connection conn = DBUTil.getConn();
		PreparedStatement pstmt = null;
		try {
			String sql4 = "select * from notice";
			pstmt = conn.prepareStatement(sql4);
			ResultSet rs = pstmt.executeQuery();
			rs = pstmt.executeQuery();
			while (rs.next()) {
				int noticeid = rs.getInt("NoticeId");
				String theme = rs.getString("Theme");
				String notice = rs.getString("Notice");
				Date time = rs.getDate("Time");

				Notice st = new Notice(noticeid, theme, notice, time);
				list.add(st);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null) {
					pstmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}
	public List<Notice> getNoticeByTitle(String title) {// 搜索公告内容
		List<Notice> list = new ArrayList<Notice>();
		Connection conn = DBUTil.getConn();
		PreparedStatement pstmt = null;
		try {
			String sql1 = "select * from notice where theme LIKE ? ";
			pstmt = conn.prepareStatement(sql1);
			pstmt.setString(1, "%"+title+"%");
			ResultSet rs = pstmt.executeQuery();
			rs = pstmt.executeQuery();
			while (rs.next()) {
				
				int noticeid = rs.getInt("NoticeId");
				String theme = rs.getString("Theme");
				String notice = rs.getString("Notice");
				Date time = rs.getDate("Time");

				Notice st = new Notice(noticeid, theme, notice, time);
				list.add(st);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null) {
					pstmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}
	
	public void updateNotice(int noticeid,String theme,String notice) {// 修改公告内容
		String sql2 = "UPDATE notice SET theme=?,notice=? WHERE noticeid=? ";
		Connection conn = DBUTil.getConn();
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql2);
			pstmt.setString(1, theme);
			pstmt.setString(2, notice);
			pstmt.setInt(3, noticeid);			
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUTil.closeJDBC(null, pstmt, conn);
		}
	}
	public void addNotice(String theme,String notice) {// 添加公告内容
		Connection conn = DBUTil.getConn();
		PreparedStatement pstmt = null;
		try {
			String sql2 = "insert into notice(theme,notice) values(?,?)";
			pstmt = conn.prepareStatement(sql2);
			pstmt.setString(1, theme);
			pstmt.setString(2, notice);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUTil.closeJDBC(null, pstmt, conn);
		}
		
	}
	public void deleteNotice(int id) {// 删除公告内容
		 
		Connection conn = DBUTil.getConn();
		PreparedStatement pstmt = null;
		try {
			String sql3 = "delete from notice where noticeid=?";
			pstmt = conn.prepareStatement(sql3);
			pstmt.setInt(1, id);
			pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUTil.closeJDBC(null, pstmt, conn);
		}
		
	}

}
