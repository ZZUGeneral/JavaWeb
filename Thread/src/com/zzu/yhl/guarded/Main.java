package com.zzu.yhl.guarded;

public class Main {
	public static void main(String[] args) {
		RequestQueue rq = new RequestQueue();
		new ClientThread(rq,"Alice",3141592L).start();;
		new ServerThread(rq,"Bobby",6535897L).start();
	}

}
