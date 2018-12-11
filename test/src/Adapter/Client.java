package Adapter;

public class Client {
	public static void main(String[] args){
		Adapter adapter;
		adapter = (Adapter)XMLUtil.getBean();
		adapter.windowPlay();
		adapter.realPlay();
	}
}