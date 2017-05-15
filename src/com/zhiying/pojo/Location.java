package com.zhiying.pojo;
/** 
 * @author sunweijie 
 * @since 2017年5月2日 下午6:20:05
 */
public class Location {
	
	//经度
	private double lng;
	//纬度
	private double lat;
	
	public double getLng() {
		return lng;
	}
	public void setLng(double lng) {
		this.lng = lng;
	}
	public double getLat() {
		return lat;
	}
	public void setLat(double lat) {
		this.lat = lat;
	}
	
	@Override
	public String toString() {
		return "Location [lng=" + lng + ", lat=" + lat + "]";
	} 
}
