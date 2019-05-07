package com.zzu.yhl.balking;

public class Main {
	public static void main(String[] args) {
		Data data = new Data("C:\\Users\\YHL\\Desktop\\data.txt","(empty)");
		new ChangerThread("ChangerThread",data).start();
		new SaverThread("SaverThread",data).start();
	}

}
