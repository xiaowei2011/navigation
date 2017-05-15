package com.zhiying.pojo;

import java.util.List;

/** 
 * @author sunweijie 
 * @since 2017年5月2日 下午6:04:34
 */
public class Route {
	//方案距离	单位：米
	private double distance;
	//线路耗时	单位：秒
	private int duration;
	//子路段
	private List<Step> steps;
	//起点经纬度坐标
	private Location originLocation;
	//终点经纬度坐标
	private Location destinationLocation;
	
	public double getDistance() {
		return distance;
	}
	public void setDistance(double distance) {
		this.distance = distance;
	}
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
	public List<Step> getSteps() {
		return steps;
	}
	public void setSteps(List<Step> steps) {
		this.steps = steps;
	}
	public Location getOriginLocation() {
		return originLocation;
	}
	public void setOriginLocation(Location originLocation) {
		this.originLocation = originLocation;
	}
	public Location getDestinationLocation() {
		return destinationLocation;
	}
	public void setDestinationLocation(Location destinationLocation) {
		this.destinationLocation = destinationLocation;
	}
	
	@Override
	public String toString() {
		return "Route [distance=" + distance + ", duration=" + duration + ", steps=" + steps + ", originLocation="
				+ originLocation + ", destinationLocation=" + destinationLocation + "]";
	}
}
