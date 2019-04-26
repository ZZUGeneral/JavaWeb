package zzu.minjie.bean;

public class DishesRank {

/*
 * 排行榜实体类
 * 
 * 
 */
	private String FoodName;
	private int Countnumber;
	
	public DishesRank() {
		
	}
	
	public DishesRank(String FoodName,int Countnumber){
		super();
		this.FoodName=FoodName;
		this.Countnumber = Countnumber;
	}

	public String getFoodName() {
		return FoodName;
	}

	public void setFoodName(String foodName) {
		FoodName = foodName;
	}

	public int getCountnumber() {
		return Countnumber;
	}

	public void setCountnumber(int countnumber) {
		Countnumber = countnumber;
	}

	@Override
	public String toString() {
		return "DishesRank [FoodName=" + FoodName + ", Countnumber=" + Countnumber + "]";
	}
	
	

	
	
	
}