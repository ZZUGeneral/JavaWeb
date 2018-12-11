package com.zzu.student.bean;

public class StudentScoreBean {
	private long stu_no;
	private String stu_name;
	private int course_no;
	private String course_name;
	private float score;

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

	public String getCourse_name() {
		return course_name;
	}

	public void setCourse_name(String course_name) {
		this.course_name = course_name;
	}

	public float getScore() {
		return score;
	}

	public void setScore(float score) {
		this.score = score;
	}

	public int getCourse_no() {
		return course_no;
	}

	public void setCourse_no(int course_no) {
		this.course_no = course_no;
	}

	@Override
	public String toString() {
		return "StudentScoreBean [stu_no=" + stu_no + ", stu_name=" + stu_name + ", course_no=" + course_no
				+ ", course_name=" + course_name + ", score=" + score + "]";
	}

}
