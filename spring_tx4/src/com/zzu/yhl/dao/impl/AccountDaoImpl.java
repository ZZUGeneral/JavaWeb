package com.zzu.yhl.dao.impl;

import org.springframework.jdbc.core.support.JdbcDaoSupport;

import com.zzu.yhl.dao.AccountDao;

public class AccountDaoImpl extends JdbcDaoSupport implements AccountDao {

	@Override
	public void out(String outer, int money) {
		System.out.println(outer + "准备了" + money);
		this.getJdbcTemplate().update("update account set money = money - ? where username = ?", money, outer);
		System.out.println(outer + "转出了了" + money);
	}

	@Override
	public void in(String inner, int money) {
		System.out.println(inner + "准备接收" + money);
		this.getJdbcTemplate().update("update account set money = money + ? where username = ?", money, inner);
		System.out.println(inner + "接收了" + money);
	}

}
