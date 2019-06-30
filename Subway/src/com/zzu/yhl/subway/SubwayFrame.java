package com.zzu.yhl.subway;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class SubwayFrame {

	public static void main(String[] args) {
		Frame frame = new Frame("Subway");
		frame.setSize(500, 500);
		frame.setLayout(new FlowLayout());
		frame.setVisible(true);
		TextField startStationField = new TextField(30);
		// startStationField.setSize(50, 50);
		frame.add(startStationField);
		TextField endStationField = new TextField(30);
		// endStationField.setSize(50, 50);
		frame.add(endStationField);
		Button button = new Button("²éÑ¯Â·Ïß");
		frame.add(button);
		TextArea area = new TextArea();
		area.setSize(50, 50);
		area.setVisible(true);
		area.setVisible(true);
		frame.add(area);
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				String startStation = startStationField.getText();
				String endStation = endStationField.getText();
				SubwayLoader loader = new SubwayLoader();
				Subway objectville = null;
				try {
					objectville = loader.loadFromFile(new File("C:\\Users\\YHL\\Desktop\\subway.txt"));
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				;
				if (!objectville.hasStation(startStation)) {
					System.err.println(startStation + " is not a station in Objectville.");
					System.exit(-1);
				} else if (!objectville.hasStation(endStation)) {
					System.err.println(endStation + " is not a station in Objectville.");
					System.exit(-1);
				}
				System.out.println(startStation+"=========="+ endStation);
				List route = objectville.getDirections(startStation, endStation);
				SubwayPrinter printer = new SubwayPrinter(System.out);
				printer.printDirections(route);
				area.append(printer.getStr().toString());
			}
		});

	}

}
