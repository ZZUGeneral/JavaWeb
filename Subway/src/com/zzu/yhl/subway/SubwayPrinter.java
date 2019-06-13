package com.zzu.yhl.subway;

import java.io.OutputStream;
import java.io.PrintStream;
import java.util.List;

public class SubwayPrinter {
	private PrintStream out;
	private StringBuffer str;

	public SubwayPrinter(OutputStream out) {
		this.out = new PrintStream(out);
		str = new StringBuffer();
	}

	public void printDirections(List route) {
		Connection connection = (Connection) route.get(0);
		String currentLine = connection.getLineName();
		String previousLine = currentLine;
		out.println("Start out at " + connection.getStation1().getName() + ".");
		str.append("Start out at " + connection.getStation1().getName() + ".");
		out.println("Get on the " + currentLine + " heading towards " + connection.getStation2().getName() + ".\n");
		str.append("Get on the " + currentLine + " heading towards " + connection.getStation2().getName() + ".\n");
		for (int i = 1; i < route.size(); i++) {
			connection = (Connection) route.get(i);
			currentLine = connection.getLineName();
			if (currentLine.equals(previousLine)) {
				out.println(" Continue past " + connection.getStation1().getName() + "...\n");
				str.append(" Continue past " + connection.getStation1().getName() + "...\n");
			} else {
				out.println("When you get to " + connection.getStation1().getName() + ", get off the " + previousLine
						+ ".");
				out.println("Switch over to the " + currentLine + ", heading towards "
						+ connection.getStation2().getName() + ".");
				str.append("When you get to " + connection.getStation1().getName() + ", get off the " + previousLine
						+ ".\n");
				str.append("Switch over to the " + currentLine + ", heading towards "
						+ connection.getStation2().getName() + ".\n");
				previousLine = currentLine;
			}
		}
		out.println("Get off at " + connection.getStation2().getName() + " and enjoy youself!");
		str.append("Get off at " + connection.getStation2().getName() + " and enjoy youself!\n");
	}

	public StringBuffer getStr() {
		return str;
	}

}
