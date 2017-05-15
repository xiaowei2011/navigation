package com.zhiying.pojo;
/** 
 * @author sunweijie 
 * @since 2017年5月2日 下午6:15:37
 */
public class Step {
	
	//标示该路段是否在城市内部：0：不在城市内部；1：在城市内部
	private int area;
	//进入道路的角度
	//枚举值，返回值在0-11之间的一个值，共12个枚举值，以30度递进，即每个值代表角度范围为30度；
	private int direction;
	//路段距离	单位：米
	private double distance;
	//路段耗时	单位：秒
	private int duration;
	//路段描述
	private String instructions;
	//路段起点
	private Location stepOriginLocation;
	//路段终点
	private Location stepDestinationLocation;
	
	public int getArea() {
		return area;
	}
	public void setArea(int area) {
		this.area = area;
	}
	public int getDirection() {
		return direction;
	}
	public void setDirection(int direction) {
		this.direction = direction;
	}
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
	public String getInstructions() {
		return instructions;
	}
	public void setInstructions(String instructions) {
		this.instructions = instructions;
	}
	public Location getStepOriginLocation() {
		return stepOriginLocation;
	}
	public void setStepOriginLocation(Location stepOriginLocation) {
		this.stepOriginLocation = stepOriginLocation;
	}
	public Location getStepDestinationLocation() {
		return stepDestinationLocation;
	}
	public void setStepDestinationLocation(Location stepDestinationLocation) {
		this.stepDestinationLocation = stepDestinationLocation;
	}
	
	@Override
	public String toString() {
		return "Step [area=" + area + ", direction=" + direction + ", distance=" + distance + ", duration=" + duration
				+ ", instructions=" + instructions + ", stepOriginLocation=" + stepOriginLocation
				+ ", stepDestinationLocation=" + stepDestinationLocation + "]";
	}
}
