package com.zzu.student.bean;

public class CourseBean {
	private long course_no;
	private String course_name;
	private String teacher_name;
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

	public String getTeacher_name() {
		return teacher_name;
	}

	public void setTeacher_name(String teacher_name) {
		this.teacher_name = teacher_name;
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
		return "CourseBean [course_no=" + course_no + ", course_name=" + course_name + ", teacher_name=" + teacher_name
				+ ", credit=" + credit + ", type=" + type + "]";
	}

}
