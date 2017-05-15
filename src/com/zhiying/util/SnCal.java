package com.zhiying.util;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.security.NoSuchAlgorithmException;
import java.util.Map;
import java.util.Map.Entry;

/**
 * @author sunweijie
 * @since 2017年4月28日 上午11:18:15
 */
public class SnCal {
	
	public final static String AK = "VbDI9I2CEZo3cicNYT0Mvf7oCHFLsocG";
	private final static String SK = "WU36BhNvuGUXVml62tERHXORqu9wnWP7";
	
	public static String getSn(Map<String, String> paramsMap, String serviceName) {
		try{
			paramsMap.put("ak", AK);
			String paramsStr = toQueryString(paramsMap);
			String wholeStr = new String(serviceName+"?" + paramsStr + SK);
			String tempStr = URLEncoder.encode(wholeStr, "UTF-8");
			String sn = MD5(tempStr);
			return sn;
		}catch(Exception e){
			System.out.println("生成sn失败");
			e.printStackTrace();
		}
		return null;
	}

	// 对Map内所有value作utf8编码，拼接返回结果
	public static String toQueryString(Map<?, ?> data) throws UnsupportedEncodingException {
		StringBuffer queryString = new StringBuffer();
		for (Entry<?, ?> pair : data.entrySet()) {
			queryString.append(pair.getKey() + "=");
			String ss[] = pair.getValue().toString().split(",");
			if (ss.length > 1) {
				for (String s : ss) {
					queryString.append(URLEncoder.encode(s, "UTF-8") + ",");
				}
				queryString.deleteCharAt(queryString.length() - 1);
				queryString.append("&");
			} else {
				queryString.append(URLEncoder.encode((String) pair.getValue(), "UTF-8") + "&");
			}
		}
		if (queryString.length() > 0) {
			queryString.deleteCharAt(queryString.length() - 1);
		}
		return queryString.toString();
	}

	// 来自stackoverflow的MD5计算方法，调用了MessageDigest库函数，并把byte数组结果转换成16进制
	public static String MD5(String md5) {
		try {
			java.security.MessageDigest md = java.security.MessageDigest.getInstance("MD5");
			byte[] array = md.digest(md5.getBytes());
			StringBuffer sb = new StringBuffer();
			for (int i = 0; i < array.length; ++i) {
				sb.append(Integer.toHexString((array[i] & 0xFF) | 0x100).substring(1, 3));
			}
			return sb.toString();
		} catch (NoSuchAlgorithmException e) {
		}
		return null;
	}
}
