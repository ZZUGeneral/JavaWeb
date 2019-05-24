package com.zzu.yhl.wt;

import java.util.Random;

public class ClientThread extends Thread {
	private final Channel channel1;
	private static Random random = new Random();

	public ClientThread(String name, Channel channel) {
		super(name);
		this.channel1 = channel;
	}

	public void run() {
		try {
			for (int i = 0; true; i++) {
				Request request = new Request(getName(), i);
				channel1.putRequest(request);
				Thread.sleep(random.nextInt(1000));
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
