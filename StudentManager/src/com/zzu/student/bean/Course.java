package com.zzu.student.bean;

public class Course {
	private long course_no;
	private String course_name;
	private long teacher_no;
	private float credit;
	private String type;

	public long getCourse_no() {
		return course_no;
	}

	public void setCourse_no(long course_no) {
		this.course_no = course_no;
	}

	public String getCourse_name() {
		return course_name;
	}

	public void setCourse_name(String course_name) {
		this.course_name = course_name;
	}

	public long getTeacher_no() {
		return teacher_no;
	}

	public void setTeacher_no(long teacher_no) {
		this.teacher_no = teacher_no;
	}

	public float getCredit() {
		return credit;
	}

	public void setCredit(float credit) {
		this.credit = credit;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "Course [course_no=" + course_no + ", course_name=" + course_name + ", teacher_no=" + teacher_no
				+ ", credit=" + credit + ", type=" + type + "]";
	}

}
