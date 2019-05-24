package Test;

public class Item {
	private int index;
	private Character left;
	private String right;
	public Item(int index,Character left,String right) {
		this.index = index;
		this.left = left;
		this.right = right;
	}
	public int getIndex() {
		return index;
	}
	
	public Character getLeft() {
		return left;
	}
	
	public String getRight() {
		return right;
	}
	

	public void printItem() {
		System.out.println(this.left+"->"+this.right);
	}
}
