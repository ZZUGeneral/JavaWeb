package zzu.minjie.bean;

public class Cart {
	private String cartId;
	private int foodId;
	private int number;
	private String foodName;
	private float unitPrice;
	private String image;

	public Cart(String cartId, int foodId, int number, String foodName, float unitPrice, String image) {
		this.cartId = cartId;
		this.foodId = foodId;
		this.number = number;
		this.foodName = foodName;
		this.unitPrice = unitPrice;
		this.image = image;
	}

	public String getCartId() {
		return cartId;
	}

	public void setCartId(String cartId) {
		this.cartId = cartId;
	}

	public int getFoodId() {
		return foodId;
	}

	public void setFoodId(int foodId) {
		this.foodId = foodId;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getFoodName() {
		return foodName;
	}

	public void setFoodName(String foodName) {
		this.foodName = foodName;
	}

	public float getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(float unitPrice) {
		this.unitPrice = unitPrice;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	@Override
	public String toString() {
		return "Cart [cartId=" + cartId + ", foodId=" + foodId + ", number=" + number + ", foodName=" + foodName
				+ ", unitPrice=" + unitPrice + ", image=" + image + "]";
	}

}
