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
		str.append("从" + connection.getStation1().getName() + "开始.");
		out.println("Get on the " + currentLine + " heading towards " + connection.getStation2().getName() + ".\n");
		str.append("登上从" + currentLine + "开往" + connection.getStation2().getName() + "的地铁。\n");
		for (int i = 1; i < route.size(); i++) {
			connection = (Connection) route.get(i);
			currentLine = connection.getLineName();
			if (currentLine.equals(previousLine)) {
				out.println(" Continue past " + connection.getStation1().getName() + "...\n");
				str.append("经过" + connection.getStation1().getName() + "...\n");
			} else {
				out.println("When you get to " + connection.getStation1().getName() + ", get off the " + previousLine
						+ ".");
				out.println("Switch over to the " + currentLine + ", heading towards "
						+ connection.getStation2().getName() + ".");
				str.append("当你到达" + connection.getStation1().getName() + "时，下车" + previousLine
						+ "。\n");
				str.append("转乘从" + currentLine + "开往"
						+ connection.getStation2().getName() + "的地铁。\n");
				previousLine = currentLine;
			}
		}
		out.println("Get off at " + connection.getStation2().getName() + " and enjoy youself!");
		str.append("在到达" + connection.getStation2().getName() + "时下车。 \n 玩的开心！ \n");
	}

	public StringBuffer getStr() {
		return str;
	}

}
