package com.zzu.yhl.balking;

import java.io.IOException;
import java.util.Random;

public class ChangerThread extends Thread {
	private final Data data;
	private final Random random = new Random();

	public ChangerThread(String name, Data data) {
		super(name);
		this.data = data;
	}

	public void run() {
		try {
			for (int i = 0; true; i++) {
				data.change("No." + i);
				Thread.sleep(random.nextInt(1000));
				data.save();
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
