package com.zhiying.pojo;

import java.util.LinkedHashMap;
import java.util.Map;

/** 
 * @author sunweijie 
 * @since 2017年4月28日 下午2:01:01
 */
public class Param {
	
	private String origin;
	private String destination;
	private String originRegion;
	private String destinationRegion;
	private String output = "json";
	private String timestamp;
	
	private String ak;
	private String sn;
	
	public Map<String, String> toMap(){
		Map<String, String> map = new LinkedHashMap<>();
		map.put("origin", origin);
		map.put("destination", destination);
		map.put("origin_region", originRegion);
		map.put("destination_region", destinationRegion);
		map.put("output", output);
		map.put("timestamp", timestamp);
		return map;
	}
	
	public String getOrigin() {
		return origin;
	}
	public void setOrigin(String origin) {
		this.origin = origin;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public String getOriginRegion() {
		return originRegion;
	}
	public void setOriginRegion(String originRegion) {
		this.originRegion = originRegion;
	}
	public String getDestinationRegion() {
		return destinationRegion;
	}
	public void setDestinationRegion(String destinationRegion) {
		this.destinationRegion = destinationRegion;
	}
	public String getOutput() {
		return output;
	}
	public void setOutput(String output) {
		this.output = output;
	}
	public String getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}
	public String getAk() {
		return ak;
	}
	public void setAk(String ak) {
		this.ak = ak;
	}
	public String getSn() {
		return sn;
	}
	public void setSn(String sn) {
		this.sn = sn;
	}
	@Override
	public String toString() {
		return "Param [origin=" + origin + ", destination=" + destination + ", originRegion=" + originRegion
				+ ", destinationRegion=" + destinationRegion + ", output=" + output + ", timestamp=" + timestamp
				+ ", ak=" + ak + ", sn=" + sn + "]";
	}
	
}
