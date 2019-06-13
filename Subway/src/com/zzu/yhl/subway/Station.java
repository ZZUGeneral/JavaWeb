package com.zzu.yhl.subway;
/**
 * 
* Copyright: Copyright (c) 2019 LanRu-Caifu
* 
* @ClassName: Station.java
* @Description: 站锟斤拷锟斤拷
* 		锟斤拷锟斤拷;
* 		1. 锟斤拷锟斤拷equals()锟斤拷锟斤拷
* 		2. 锟斤拷锟斤拷hashCode()锟斤拷锟斤拷
*
* @version: v1.0.0
* @author: YHL
* @date: 2019锟斤拷6锟斤拷4锟斤拷 锟斤拷锟斤拷8:05:33 
*
* Modification History:
* Date         Author          Version            Description
*---------------------------------------------------------*
* 2019锟斤拷6锟斤拷4锟斤拷     YHL           v1.0.0               锟睫革拷原锟斤拷
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
	* @Function: Station.java
	* @Description: 锟斤拷同锟斤拷路锟叫碉拷Station锟斤拷锟杰伙拷锟斤拷锟斤拷锟酵拷锟斤拷锟斤拷锟�
	*   Java锟斤拷锟矫碉拷equals()锟斤拷锟斤拷锟角革拷锟斤拷锟节达拷位锟斤拷锟角凤拷锟斤拷同锟斤拷锟叫讹拷锟斤拷锟斤拷锟斤拷锟斤拷锟角凤拷锟斤拷同
	*  	 锟斤拷写锟斤拷equals()锟斤拷锟斤拷只锟斤拷锟斤拷锟斤拷Station锟斤拷锟斤拷锟角凤拷锟斤拷同
	*  	锟斤拷写equals()时通锟斤拷也要锟斤拷写hashCode()锟斤拷锟斤拷
	*  	锟斤拷锟斤拷equals()锟斤拷hashCode()锟斤拷锟斤拷锟斤拷锟皆斤拷省锟斤拷锟斤拷锟斤拷时锟斤拷锟皆硷拷锟斤拷锟劫筹拷锟斤拷母锟斤拷锟斤拷锟�
	*
	* @param:Object
	* @return锟斤拷boolean : 锟斤拷锟斤拷Station锟角凤拷锟斤拷同
	* @throws锟斤拷锟届常锟斤拷锟斤拷
	*
	* @version: v1.0.0
	* @author: YHL
	* @date: 2019锟斤拷6锟斤拷4锟斤拷 锟斤拷锟斤拷8:17:53 
	*
	* Modification History:
	* Date         Author          Version            Description
	*---------------------------------------------------------*
	* 2019锟斤拷6锟斤拷4锟斤拷     YHL           v1.0.0               锟睫革拷原锟斤拷
	 */
	public boolean equals(Object obj) {
		if(obj instanceof Station) {
			Station otherStation = (Station) obj;
			// System.out.println(name+"==111==="+otherStation.getName()+"===222==="+otherStation.getName().equalsIgnoreCase(name)+"==========");
			if(otherStation.getName().equalsIgnoreCase(name)) {
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
