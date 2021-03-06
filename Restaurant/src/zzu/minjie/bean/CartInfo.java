package zzu.minjie.bean;

public class CartInfo {
	private String cartId;
	private int foodId;
	private float foodTotalPrice;
	private float totalPrice;

	public CartInfo(String cartId, int foodId, float foodTotalPrice, float totalPrice) {
		this.cartId = cartId;
		this.foodId = foodId;
		this.foodTotalPrice = foodTotalPrice;
		this.totalPrice = totalPrice;

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

	public float getFoodTotalPrice() {
		return foodTotalPrice;
	}

	public void setFoodTotalPrice(float foodTotalPrice) {
		this.foodTotalPrice = foodTotalPrice;
	}

	public float getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(float totalPrice) {
		this.totalPrice = totalPrice;
	}

}
