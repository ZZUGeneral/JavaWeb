package com.zzu.yhl.d_c3p0;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.ParameterizedBeanPropertyRowMapper;

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
		Object[] args = { user.getUsername(), user.getPassword(), user.getId() };
		jdbcTemplate.update(sql, args);
	}

	public List<User> findAll() {
		List<User> list= jdbcTemplate.query("select * from user", ParameterizedBeanPropertyRowMapper.newInstance(User.class));
		return list;
	}

}
