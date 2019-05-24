package com.zzu.yhl.e_coll;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class CollData {
	private String[] arrayData;
	private List<String> listData;
	private Set<String> setData;
	private Map<String, String> mapData;
	private Properties propsData;

	/**
	 * @return the arrayData
	 */
	public String[] getArrayData() {
		return arrayData;
	}

	/**
	 * @param arrayData the arrayData to set
	 */
	public void setArrayData(String[] arrayData) {
		this.arrayData = arrayData;
	}

	/**
	 * @return the listData
	 */
	public List<String> getListData() {
		return listData;
	}

	/**
	 * @param listData the listData to set
	 */
	public void setListData(List<String> listData) {
		this.listData = listData;
	}

	/**
	 * @return the setData
	 */
	public Set<String> getSetData() {
		return setData;
	}

	/**
	 * @param setData the setData to set
	 */
	public void setSetData(Set<String> setData) {
		this.setData = setData;
	}

	/**
	 * @return the mapData
	 */
	public Map<String, String> getMapData() {
		return mapData;
	}

	/**
	 * @param mapData the mapData to set
	 */
	public void setMapData(Map<String, String> mapData) {
		this.mapData = mapData;
	}

	/**
	 * @return the propsData
	 */
	public Properties getPropsData() {
		return propsData;
	}

	/**
	 * @param propsData the propsData to set
	 */
	public void setPropsData(Properties propsData) {
		this.propsData = propsData;
	}

	@Override
	public String toString() {
		return "CollData [\narrData=" + Arrays.toString(arrayData) + ", \nlistData=" + listData + ", \nsetData="
				+ setData + ",\nmapData=" + mapData + ", \npropsData=" + propsData + "]";
	}

}
