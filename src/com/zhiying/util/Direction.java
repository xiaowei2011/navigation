package com.zhiying.util;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.zhiying.pojo.Param;
import com.zhiying.pojo.Route;

/** 
 * @author sunweijie 
 * @since 2017年4月28日 下午2:05:03
 */
public class Direction {
	private final static String URL = "http://api.map.baidu.com/direction/v1";
	
	public static List<Route> getRoutes(Param param){
		CloseableHttpClient client = HttpClients.createDefault();
		HttpGet httpGet = null;
		CloseableHttpResponse response = null;
		param.setAk(SnCal.AK);
		String sn = SnCal.getSn(param.toMap(), "/direction/v1");
		param.setSn(sn);
		List<Route> routes = null;
		try {
			httpGet = new HttpGet(URL + toQueryString(param));
			response = client.execute(httpGet);
			HttpEntity entity = response.getEntity();
			if (entity != null) {
				JSONObject result = JSON.parseObject((EntityUtils.toString(entity, "utf-8")));
				if(result.getIntValue("status") == 0){
					JSONArray routeArray = result.getJSONObject("result").getJSONArray("routes");
					routes = JSON.parseArray(routeArray.toJSONString(), Route.class);
				}
			}
		} catch (Exception e) {
			System.out.println("获取路线失败");
			e.printStackTrace();
		}finally {
			if(response != null){
				try {
					response.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if(client != null){
				try {
					client.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return routes;
	}
	
	public static String toQueryString(Param param) throws UnsupportedEncodingException {
		StringBuffer queryString = new StringBuffer();
		queryString.append("?origin="+param.getOrigin()+"&");
		queryString.append("destination="+param.getDestination()+"&");
		queryString.append("origin_region="+param.getOriginRegion()+"&");
		queryString.append("destination_region="+param.getDestinationRegion()+"&");
		queryString.append("output="+param.getOutput()+"&");
		queryString.append("timestamp="+param.getTimestamp()+"&");
		queryString.append("ak="+param.getAk());
		if(param.getSn() != null){
			queryString.append("&sn="+param.getSn());
		}
		return queryString.toString();
	}
}
