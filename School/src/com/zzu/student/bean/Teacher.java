package com.zzu.student.bean;

import java.util.Date;

public class Teacher {

	private long teacher_no;
	private String teacher_name;
	private String gender;
	private String email;
	private String password;
	private String dept;
	private Date birthday;
	private String headShot;

	public long getTeacher_no() {
		return teacher_no;
	}

	public void setTeacher_no(long teacher_no) {
		this.teacher_no = teacher_no;
	}

	public String getTeacher_name() {
		return teacher_name;
	}

	public void setTeacher_name(String teacher_name) {
		this.teacher_name = teacher_name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getHeadShot() {
		return headShot;
	}

	public void setHeadShot(String headShot) {
		this.headShot = headShot;
	}

	@Override
	public String toString() {
		return "Teacher [teacher_no=" + teacher_no + ", teacher_name=" + teacher_name + ", gender=" + gender
				+ ", email=" + email + ", password=" + password + ", dept=" + dept + ", birthday=" + birthday
				+ ", headShot=" + headShot + "]";
	}

}
