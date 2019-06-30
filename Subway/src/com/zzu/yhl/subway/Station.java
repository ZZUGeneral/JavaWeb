package com.zzu.yhl.subway;

/**
 * 
 * Copyright: Copyright (c) 2019 LanRu-Caifu
 * 
 * @ClassName: Station.java
 * @Description: 站点
 *
 * @version: v1.0.0
 * @author: YHL
 * @date: 2019年6月20日 下午9:36:34
 *
 *        Modification History: Date Author Version Description
 *        ---------------------------------------------------------* 2019年6月20日
 *        YHL v1.0.0 修改原因
 */
public class Station {
	private String name;

	public Station(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	/**
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 * @Function: equals
	 * @Description:重写Station的equals方法，判断站点相同时1只要判断两个站点的名字是否相同即可
	 * 
	 * @param @param  obj
	 * @param @return
	 * @throws：异常描述
	 *
	 * @version: v1.0.0
	 * @author: YHL
	 * @date: 2019年6月20日 下午9:36:52
	 *
	 *        Modification History: Date Author Version Description
	 *        ---------------------------------------------------------* 2019年6月20日
	 *        YHL v1.0.0 修改原因
	 */
	public boolean equals(Object obj) {
		if (obj instanceof Station) {
			Station otherStation = (Station) obj;
			// System.out.println(name+"==111==="+otherStation.getName()+"===222==="+otherStation.getName().equalsIgnoreCase(name)+"==========");
			if (otherStation.getName().equalsIgnoreCase(name)) {
				return true;
			}
		}
		return false;
	}

	public int hashCode() {
		return name.toLowerCase().hashCode();
	}

	@Override
	public String toString() {
		return "Station [name=" + name + "]";
	}

}
