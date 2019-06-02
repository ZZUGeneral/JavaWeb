package com.zzu.minjie.bean;

import java.sql.Timestamp;



public class Order {
	
	private String orderNo;
	private String userId;
	private String userName;
	private String phone;
	private String address;
	private Timestamp time;
	private String status;
	
	public Order(String orderNo,String userId,String userName,String phone,String address,Timestamp time,String status) {
		
		this.orderNo=orderNo;
		this.userId=userId;
		this.userName=userName;
		this.phone=phone;
		this.address=address;
		this.time=time;
		this.status=status;
	}
	
	public String getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Timestamp getTime() {
		return time;
	}
	public void setTime(Timestamp time) {
		this.time = time;
	}
	
	
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
}
