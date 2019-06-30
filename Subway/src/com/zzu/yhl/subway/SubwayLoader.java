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
 * @Description: 加载类：从文件中加载地铁线路网
 *
 * @version: v1.0.0
 * @author: YHL
 * @date: 2019年6月20日 下午9:38:09
 *
 *        Modification History: Date Author Version Description
 *        ---------------------------------------------------------* 2019年6月20日
 *        YHL v1.0.0 修改原因
 */
public class SubwayLoader {
	private Subway subway;

	public SubwayLoader() {
		this.subway = new Subway();
	}

	public Subway loadFromFile(File subwayFile) throws IOException {
		BufferedReader reader = new BufferedReader(new FileReader(subwayFile));
		// 加载所有站点
		loadStations(subway, reader);
		// 将地铁线路中所有的站点读进地铁
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
	 * @Description: 加载站点
	 * 
	 * @param @param  subway
	 * @param @param  reader
	 * @param @throws IOException
	 * @return：void
	 * @throws：异常描述
	 *
	 * @author: YHL
	 * @date: 2019年6月4日 上午10:21:26
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
	 * @Description: 加载线路
	 * 
	 * @param @param  subway
	 * @param @param  reader
	 * @param @param  lineName
	 * @param @throws IOException
	 * @return：void
	 * @throws：异常描述
	 *
	 * @author: YHL
	 * @date: 2019年6月4日 上午10:22:10
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
