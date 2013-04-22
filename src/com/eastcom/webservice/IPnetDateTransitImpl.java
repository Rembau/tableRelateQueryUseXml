package com.eastcom.webservice;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class IPnetDateTransitImpl implements IPnetDateTransit{

	public String loadDevicePretty(String ip, String st, String et) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
		try {
			format.parse(st);
		} catch (ParseException e) {
			return "<error>开始时间日期格式不正确，正确时间格式为yyyy-MM-dd HH:mm:ss (24小时计时法)</error>";
		}
		try {
			format.parse(st);
		} catch (ParseException e) {
			return "<error>结束时间日期格式不正确，正确时间格式为yyyy-MM-dd HH:mm:ss (24小时计时法)</error>";
		}
		return Handler.getDevicePretty(ip, st, et);
	}

	public String loadIntefcaePretty(String ip, String ifname, String st,
			String et) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
		try {
			format.parse(st);
		} catch (ParseException e) {
			return "<error>开始时间日期格式不正确，正确时间格式为yyyy-MM-dd HH:mm:ss (24小时计时法)</error>";
		}
		try {
			format.parse(st);
		} catch (ParseException e) {
			return "<error>结束时间日期格式不正确，正确时间格式为yyyy-MM-dd HH:mm:ss (24小时计时法)</error>";
		}
		return Handler.getInterfacePretty(ip, ifname, st, et);
	}

	public String say() {
		System.out.println("say");
		return null;
	}
}
