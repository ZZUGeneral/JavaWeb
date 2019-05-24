package com.zzu.yhl.tpm;

public class Helper {
	public void handle(int count, char c){
		System.out.println("   Handle(" + count + ", "+ c + ") BEGIN");
		for(int i=0;i<count;i++) {
			slowly();
			System.out.println(c);
		}
		System.out.println("");
		System.out.println("   Handle(" + count + ", "+ c + ") END");
	}
	public void slowly() {
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

}
