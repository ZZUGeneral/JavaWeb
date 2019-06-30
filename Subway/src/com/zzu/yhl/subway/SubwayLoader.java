package com.zzu.yhl.subway;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * 
 * Copyright: Copyright (c) 2019 LanRu-Caifu
 * 
 * @ClassName: SubwayLoader.java
 * @Description: �����ࣺ���ļ��м��ص�����·��
 *
 * @version: v1.0.0
 * @author: YHL
 * @date: 2019��6��20�� ����9:38:09
 *
 *        Modification History: Date Author Version Description
 *        ---------------------------------------------------------* 2019��6��20��
 *        YHL v1.0.0 �޸�ԭ��
 */
public class SubwayLoader {
	private Subway subway;

	public SubwayLoader() {
		this.subway = new Subway();
	}

	public Subway loadFromFile(File subwayFile) throws IOException {
		BufferedReader reader = new BufferedReader(new FileReader(subwayFile));
		// ��������վ��
		loadStations(subway, reader);
		// ��������·�����е�վ���������
		String lineName = reader.readLine();
		while (lineName != null && lineName.length() != 0) {
			loadLine(subway, reader, lineName);
			lineName = reader.readLine();
		}
		return subway;
	}

	/**
	 * 
	 * @Function: loadStations
	 * @Description: ����վ��
	 * 
	 * @param @param  subway
	 * @param @param  reader
	 * @param @throws IOException
	 * @return��void
	 * @throws���쳣����
	 *
	 * @author: YHL
	 * @date: 2019��6��4�� ����10:21:26
	 *
	 */
	private void loadStations(Subway subway, BufferedReader reader) throws IOException {
		// TODO Auto-generated method stub
		String currentLine;
		currentLine = reader.readLine();
		while (currentLine.length() > 0) {
			subway.addStation(currentLine);
			currentLine = reader.readLine();
		}
	}

	/**
	 * 
	 * @Function: loadLine
	 * @Description: ������·
	 * 
	 * @param @param  subway
	 * @param @param  reader
	 * @param @param  lineName
	 * @param @throws IOException
	 * @return��void
	 * @throws���쳣����
	 *
	 * @author: YHL
	 * @date: 2019��6��4�� ����10:22:10
	 *
	 */
	private void loadLine(Subway subway, BufferedReader reader, String lineName) throws IOException {
		// TODO Auto-generated method stub
		String station1Name, station2Name;
		station1Name = reader.readLine();
		station2Name = reader.readLine();
		while ((station2Name != null) && (station2Name.length() > 0)) {
			subway.addConnection(station1Name, station2Name, lineName);
			station1Name = station2Name;
			station2Name = reader.readLine();
		}

	}
}
