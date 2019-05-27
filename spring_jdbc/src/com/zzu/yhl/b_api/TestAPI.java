package com.zzu.yhl.b_api;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.jdbc.core.JdbcTemplate;

public class TestAPI {
	public static void main(String[] args) {
		//创建数据源(连接池) dbcp
		BasicDataSource dataSource = new BasicDataSource();
		
		// 基本连接属性
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/spring");
		dataSource.setUsername("root");
		dataSource.setPassword("root");
		
		// 创建模板
		JdbcTemplate jdbcTemplate = new JdbcTemplate();
		jdbcTemplate.setDataSource(dataSource);
		
		//通过api操作
		jdbcTemplate.update("insert into user (username,password) values (?,?);","yhl","123");
		
	}

}
