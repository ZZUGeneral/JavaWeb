package com.zzu.student.bean;

public class SC {
	private int course_no;
	private long stu_no;
	private float score;
	private float point;
	public int getCourse_no() {
		return course_no;
	}
	public void setCourse_no(int course_no) {
		this.course_no = course_no;
	}
	public long getStu_no() {
		return stu_no;
	}
	public void setStu_no(long stu_no) {
		this.stu_no = stu_no;
	}
	public float getScore() {
		return score;
	}
	public void setScore(float score) {
		this.score = score;
	}
	public float getPoint() {
		return point;
	}
	public void setPoint(float point) {
		this.point = point;
	}
	@Override
	public String toString() {
		return "SC [course_no=" + course_no + ", stu_no=" + stu_no + ", score=" + score + ", point=" + point + "]";
	}
	

}
