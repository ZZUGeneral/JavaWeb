package com.zzu.minjie.bean;

public class DishStyle {
	private int dishId;
	private String dishName;
	private String dishExplain;
	private String option;
	private String Image;
	
	
	/**
	 * @return the dishId
	 */
	public int getDishId() {
		return dishId;
	}
	/**
	 * @param dishId the dishId to set
	 */
	public void setDishId(int dishId) {
		this.dishId = dishId;
	}
	public String getDishName() {
		return dishName;
	}
	public void setDishName(String dishName) {
		this.dishName = dishName;
	}
	public String getDishExplain() {
		return dishExplain;
	}
	public void setDishExplain(String dishExplain) {
		this.dishExplain = dishExplain;
	}
	public String getOption() {
		return option;
	}
	public void setOption(String option) {
		this.option = option;
	}
	public String getImage() {
		return Image;
	}
	public void setImage(String image) {
		Image = image;
	}
	@Override
	public String toString() {
		return "DishStyle [dishId=" + dishId + ", dishName=" + dishName + ", dishExplain=" + dishExplain + ", option="
				+ option + ", Image=" + Image + "]";
	}
	
	
}
