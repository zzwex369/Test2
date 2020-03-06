package com.xyw.sys.util;

import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

/**
 * 获取地址类
 * 
 * @author wex
 */
public class AddressUtil {
	private static final Logger log = LoggerFactory
			.getLogger(AddressUtil.class);
	public static final String IP_TB_URL = "http://ip.taobao.com/service/getIpInfo.php";//弃用 经常性502
	public static final String IP_TPY_URL = "https://whois.pconline.com.cn/ip.jsp?json=true&ip=";//太平洋ip  速度慢
	public static final String IP_TX_URL = "http://sp0.baidu.com/8aQDcjqpAAV3otqbppnN2DJv/api.php?query=";//腾讯ip  速度快

	//http://apis.map.qq.com/ws/location/v1/ip?ip=223.91.96.87&key=T34DKF-ME4JX-N2RNM-6GM2H-7YF3M
	//"http://sp0.baidu.com/8aQDcjqpAAV3otqbppnN2DJv/api.php?query=223.91.96.87&co=&resource_id=6006";
    // "https://whois.pconline.com.cn/ip.jsp?json=true&ip=223.91.96.87";

	public static String[] getRealAddressByIP(String ip) {
		String address [] ={"XX XX",""} ;
		
		// 内网不查询
		if (IpUtils.internalIp(ip)) {
			address[0]="内网IP";
			return address;
		}
	
		String rspStr = HttpUtils.sendPost(IP_TX_URL+ip+"&co=&resource_id=6006");
		if (StringUtil.isEmpty(rspStr)) {
			log.error("获取地理位置异常 {}", ip);
			return address;
		}
		try {
			JSONArray obj=JSON.parseArray((JSON.parseObject(rspStr).get("data").toString()));
			Object location=JSON.parseObject(obj.get(0).toString()).get("location");
			address=location.toString().split(" ");
		} catch (Exception e) {
			log.error("获取地理位置异常 {}", ip);
		}

		return address;
	}
}
