package com.zzu.yhl.future;

public class FutureData implements Data {
	private RealData realdata = null;
	private boolean ready = false;

	public synchronized void setRealData(RealData realdata) {
		if (ready) {
			return;
		}
		this.realdata = realdata;
		this.ready = ready;
		notifyAll();
	}

	@Override
	public synchronized String getContent() {
		// TODO Auto-generated method stub
		while (!ready) {
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return realdata.getContent();
	}

}
