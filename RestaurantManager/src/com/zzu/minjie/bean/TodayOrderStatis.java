package com.zzu.minjie.bean;



public class TodayOrderStatis {
	private int foodID;
	private String name;

	private int totalNum;
	private float unitPrice;
	
	public TodayOrderStatis(int foodID,String name,int totalNum,float unitPrice) {
		this.foodID=foodID;
		this.name=name;
		this.totalNum=totalNum;
		this.unitPrice=unitPrice;
	}

	public int getFoodID() {
		return foodID;
	}
	public void setFoodID(int foodID) {
		this.foodID = foodID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name=name;
	}
	public int getTotalNum() {
		return totalNum;
	}
	public void setTotalNum(int totalNum) {
		this.totalNum = totalNum;
	}
	
	

	public float getUnitPrice() {
		return unitPrice;
	}
	public void setPrice(float unitPrice) {
		this.unitPrice = unitPrice;
	}

	

}
