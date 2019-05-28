package com.zzu.yhl.service.impl;

import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

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
	@Transactional(propagation =Propagation.REQUIRED,isolation = Isolation.DEFAULT)
	public void transfer(String outer, String inner, int money) {
		// TODO Auto-generated method stub

		accountDao.out(outer, money);
		//int i = 1 / 0;
		accountDao.in(inner, money);

	}
}
