package com.zzu.student.bean;

public class ScoreBean {
	private String course_name;
	private float score;
	private float point;
	private String type;
	private float credit;

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

	public float getPoint() {
		return point;
	}

	public void setPoint(float point) {
		this.point = point;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public float getCredit() {
		return credit;
	}

	public void setCredit(float credit) {
		this.credit = credit;
	}

	@Override
	public String toString() {
		return "StuScoreBean [course_name=" + course_name + ", score=" + score + ", point=" + point + ", type=" + type
				+ ", credit=" + credit + "]";
	}

}
