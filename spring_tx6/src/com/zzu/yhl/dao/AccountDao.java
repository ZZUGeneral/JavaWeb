package com.zzu.yhl.dao;

public interface AccountDao {
	/**
	 * 汇款
	 * 
	 * @param outer
	 * @param money
	 */
	public void out(String outer, int money);

	/**
	 * 收款
	 * 
	 * @param inner
	 * @param money
	 */
	public void in(String inner, int money);

}