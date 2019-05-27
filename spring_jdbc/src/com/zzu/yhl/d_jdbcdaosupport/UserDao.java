package com.zzu.yhl.d_jdbcdaosupport;

import java.util.List;

import org.springframework.jdbc.core.simple.ParameterizedBeanPropertyRowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import com.zzu.yhl.a_domain.User;

public class UserDao extends JdbcDaoSupport {

	public void update(User user) {
		String sql = "update user set username=?,password=? where id =?";
		Object[] args = { user.getUsername(), user.getPassword(), user.getId() };
		this.getJdbcTemplate().update(sql, args);
	}

	public List<User> findAll() {
		List<User> list = this.getJdbcTemplate().query("select * from user",
				ParameterizedBeanPropertyRowMapper.newInstance(User.class));
		return list;
	}
}
