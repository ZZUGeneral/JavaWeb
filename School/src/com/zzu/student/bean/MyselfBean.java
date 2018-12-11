package com.zzu.student.bean;

import java.util.Date;

public class MyselfBean {
	private long no;
	private String name;
	private String gender;
	private Date birthday;
	private String password;
	private String dept;
	private String email;
	private String headShot;

	public long getNo() {
		return no;
	}

	public void setNo(long no) {
		this.no = no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getHeadShot() {
		return headShot;
	}

	public void setHeadShot(String headShot) {
		this.headShot = headShot;
	}

	@Override
	public String toString() {
		return "MyselfBean [no=" + no + ", name=" + name + ", gender=" + gender + ", birthday=" + birthday
				+ ", password=" + password + ", dept=" + dept + ", email=" + email + ", headShot=" + headShot + "]";
	}

}
