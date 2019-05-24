package com.zzu.yhl.d_spel;

public class Customer {
	private String Cname = "jack";
	private Double pi;// = Math.PI;
	/**
	 * @return the cname
	 */
	public String getCname() {
		return Cname;
	}
	/**
	 * @param cname the cname to set
	 */
	public void setCname(String cname) {
		Cname = cname;
	}
	/**
	 * @return the pi
	 */
	public Double getPi() {
		return pi;
	}
	/**
	 * @param pi the pi to set
	 */
	public void setPi(Double pi) {
		this.pi = pi;
	}
	@Override
	public String toString() {
		return "Customer [Cname=" + Cname + ", pi=" + pi + "]";
	}
	
}
