package com.zzu.yhl.c_dbcp;

import org.springframework.jdbc.core.JdbcTemplate;

import com.zzu.yhl.a_domain.User;

public class UserDao {
	private JdbcTemplate jdbcTemplate;
	/**
	 * @param jdbcTemplate the jdbcTemplate to set
	 */
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}


	public void update(User user) {
		String sql = "update user set username=?,password=? where id =?";
		Object[] args = {user.getUsername(),user.getPassword(),user.getId()};
		jdbcTemplate.update(sql,args);
	}

}
