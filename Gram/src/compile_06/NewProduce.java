package compile_06;

public class NewProduce {
	private SignalVn leftProduce;
	private String[] rightProduce;
	
	public NewProduce() {
		leftProduce=new SignalVn();
	}
	
	public void setRight(String str) {
		rightProduce=new String[str.length()];
		for(int i=0;i<str.length();i++) {
			this.rightProduce[i]=str.substring(i, i+1);
		}
	}
	
	public void setLeft(String str) {
		this.leftProduce.setSignal(str);
	}
	
	public SignalVn getNewLeft() {
		return this.leftProduce;
	}
	
	public String getNewRight() {
		return Tools.ArrayToString(this.rightProduce);
	}
}
