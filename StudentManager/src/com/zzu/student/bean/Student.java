package com.zzu.student.bean;

import java.util.Date;

public class Student {
	private long stu_no;
	private String stu_name;
	private String gender;
	private Date birthday;
	private String password;
	private String dept;
	private String email;
	private String headShot;

	public Student() {

	}

	public Student(String stuName, long stu_no, String password) {
		// TODO Auto-generated constructor stub
		super();
		this.stu_name = stuName;
		this.stu_no = stu_no;
		this.password = password;
	}

	public Student(String stu_name, String gender, Date birthdayDate, String email, String dept) {
		// TODO Auto-generated constructor stub
		super();
		this.stu_name = stu_name;
		this.gender = gender;
		this.birthday = birthdayDate;
		this.email = email;
		this.dept = dept;
		
	}

	public long getStu_no() {
		return stu_no;
	}

	public void setStu_no(long stu_no) {
		this.stu_no = stu_no;
	}

	public String getStu_name() {
		return stu_name;
	}

	public void setStu_name(String stu_name) {
		this.stu_name = stu_name;
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
		return "Student [stu_no=" + stu_no + ", stu_name=" + stu_name + ", gender=" + gender + ", birthday=" + birthday
				+ ", password=" + password + ", dept=" + dept + ", email=" + email + ", headShot=" + headShot + "]";
	}

}
