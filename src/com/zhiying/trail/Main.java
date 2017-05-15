package com.zhiying.trail;

import java.util.List;
import java.util.Scanner;

import com.zhiying.pojo.Location;
import com.zhiying.pojo.Param;
import com.zhiying.pojo.Route;
import com.zhiying.pojo.Step;
import com.zhiying.util.Direction;

/** 
 * @author sunweijie 
 * @since 2017年5月2日 下午7:19:22
 */
public class Main {

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		String y = "y";
		while(y.equals("y")){
			System.out.println("请输入起点和终点和城市  格式：1.名称：百度大厦  坐标：格式为“纬度,经度”，小数点后不超过6位，如：“40.056878,116.30815” 2 关键字模式 名称+经纬度：“百度大厦|40.056878,116.30815”");
			String origin = input.next();
			String destination = input.next();
			String city =input.next();
			Param param = new Param();
			param.setOrigin(origin.trim());
			param.setDestination(destination.trim());
			param.setOriginRegion(city.trim());
			param.setDestinationRegion(city.trim());
			param.setTimestamp(System.currentTimeMillis()+"");
			List<Route> routes = Direction.getRoutes(param);
			if(routes == null || routes.size() < 1){
				System.out.println("获取路线失败");
				continue;
			}
			System.err.println("路线：");
			printRoute(routes.get(0));
		    System.err.println("是否继续(y/n)?");
		    y=input.next();
		}
	}
	
	public static void printRoute(Route route){
		System.out.println("起点："+route.getOriginLocation());
		System.out.println("目的地："+route.getDestinationLocation());
		System.out.println("距离："+route.getDistance()+"米");
		int duration = route.getDuration();
		int hour = duration / 3600;
		duration -= hour * 3600;
		int minute = duration / 60;
		duration -= minute * 60;
		int seconds = duration;
		System.out.println("时间："+hour+"小时"+minute+"分"+seconds+"秒");
		System.out.print("途经点");
		for(Step step : route.getSteps()){
			Location location = step.getStepDestinationLocation();
			System.out.println(location.getLat()+","+location.getLng()+"\t距离："+step.getDistance()+"米\t时间："+step.getDuration()+"秒");
		}
	}
}
