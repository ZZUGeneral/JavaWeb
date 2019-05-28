package com.zzu.yhl.service.impl;

import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

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

	private TransactionTemplate transactionTemplate;

	/**
	 * @param transactionTemplate the transactionTemplate to set
	 */
	public void setTransactionTemplate(TransactionTemplate transactionTemplate) {
		this.transactionTemplate = transactionTemplate;
	}

	@Override
	public void transfer(String outer, String inner, int money) {
		// TODO Auto-generated method stub

		transactionTemplate.execute(new TransactionCallbackWithoutResult() {

			@Override
			protected void doInTransactionWithoutResult(TransactionStatus arg0) {
				// TODO Auto-generated method stub
				accountDao.out(outer, money);
				int i = 1 / 0;
				accountDao.in(inner, money);
			}

		});

	}
}
