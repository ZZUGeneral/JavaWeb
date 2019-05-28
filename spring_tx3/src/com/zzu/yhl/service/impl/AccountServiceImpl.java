package com.zzu.yhl.service.impl;

import com.zzu.yhl.dao.AccountDao;
import com.zzu.yhl.service.AccountService;

public class AccountServiceImpl implements AccountService {

	private AccountDao accountDao;

	/**
	 * @param accountDao the accountDao to set
	 */
	public void setAccountDao(AccountDao accountDao) {
		this.accountDao = accountDao;
	}

	@Override
	public void transfer(String outer, String inner, int money) {
		// TODO Auto-generated method stub

		accountDao.out(outer, money);
		int i = 1 / 0;
		accountDao.in(inner, money);

	}
}
