package com.zzu.yhl.subway;

import java.io.File;
import java.util.List;

public class SubwayTester {
	public static void main(String[] args) {
		String[] data = { "五一公园站", "二七广场站" };
		if (data.length != 2) {
			System.err.println("Usage: SubwaysTester [startStation] [endStation]");
		}
		try {
			SubwayLoader loader = new SubwayLoader();
			Subway objectville = loader.loadFromFile(new File("C:\\Users\\YHL\\Desktop\\subway.txt"));
			System.out.println(objectville);
			if (!objectville.hasStation(data[0])) {
				System.err.println(data[0] + " is not a station in Objectville.");
				System.exit(-1);
			} else if (!objectville.hasStation(data[1])) {
				System.err.println(data[1] + " is not a station in Objectville.");
				System.exit(-1);
			}
			List route = objectville.getDirections(data[0], data[1]);
			SubwayPrinter printer = new SubwayPrinter(System.out);
			printer.printDirections(route);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
