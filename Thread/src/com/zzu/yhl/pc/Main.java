package com.zzu.yhl.pc;

public class Main {
	public static void main(String[] args) {
		Table table = new Table(3);
		new MakerThread("MakerThread-1",table,31415).start();
		new MakerThread("MakerThread-2",table,31415).start();
		new MakerThread("MakerThread-3",table,31415).start();
		new EaterThread("EaterThread-1",table,31415).start();
		new EaterThread("EaterThread-2",table,31415).start();
		new EaterThread("EaterThread-3",table,31415).start();
	}
}
