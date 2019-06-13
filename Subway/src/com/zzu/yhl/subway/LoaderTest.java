package com.zzu.yhl.subway;

import java.io.File;
import java.io.IOException;

public class LoaderTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			SubwayLoader loader = new SubwayLoader();
			Subway objectville = loader.loadFromFile(new File("C:\\Users\\YHL\\Desktop\\test.txt"));
			System.out.println("Testing stations...");
			if (objectville.hasStation("DRY Drive") && objectville.hasStation("Weather-O-Rama, Inc.")
					&& objectville.hasStation("Boards 'R' Us")) {
				System.out.println("...Station test passed successful.");
			} else {
				System.out.println("...Station test failed.");
				System.exit(-1);
			}
			System.out.println("Testing connections...");
			if (objectville.hasConnection("DRY Drive", "Head First Theater", "Meyer Line")
					&& objectville.hasConnection("Weather-O-Rama, Inc.", "XHTML Expressway", "Wirfs-Brock Line")
					&& objectville.hasConnection("Head First Theater", "Infinite Circle", "Rumbaugh Line")) {
				System.out.println("... Connection test passed successful.");
			} else {
				System.out.println("... Connection test failed.");
				System.exit(-1);
				;
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
