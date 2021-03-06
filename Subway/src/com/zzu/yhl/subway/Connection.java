package com.zzu.yhl.subway;

/**
 * 
 * Copyright: Copyright (c) 2019 LanRu-Caifu
 * 
 * @ClassName: Connection.java
 * @Description: 两个相邻站点以及所在路线名称
 *
 * @version: v1.0.0
 * @author: YHL
 * @date: 2019年6月20日 下午9:35:49
 *
 *        Modification History: Date Author Version Description
 *        ---------------------------------------------------------* 2019年6月20日
 *        YHL v1.0.0 修改原因
 */
public class Connection {

	private Station station1;
	private Station station2;
	private String lineName;

	public Connection(Station station1, Station station2, String lineName) {
		this.station1 = station1;
		this.station2 = station2;
		this.lineName = lineName;
	}

	public Station getStation1() {
		return station1;
	}

	public void setStation1(Station station1) {
		this.station1 = station1;
	}

	public Station getStation2() {
		return station2;
	}

	public void setStation2(Station station2) {
		this.station2 = station2;
	}

	public String getLineName() {
		return lineName;
	}

	public void setLineName(String lineName) {
		this.lineName = lineName;
	}

	@Override
	public String toString() {
		return "Connection [station1=" + station1 + ", station2=" + station2 + ", lineName=" + lineName + "]";
	}

}
