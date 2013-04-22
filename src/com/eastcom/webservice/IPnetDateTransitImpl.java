package com.eastcom.webservice;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class IPnetDateTransitImpl implements IPnetDateTransit{

	public String loadDevicePretty(String ip, String st, String et) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
		try {
			format.parse(st);
		} catch (ParseException e) {
			return "<error>��ʼʱ�����ڸ�ʽ����ȷ����ȷʱ���ʽΪyyyy-MM-dd HH:mm:ss (24Сʱ��ʱ��)</error>";
		}
		try {
			format.parse(st);
		} catch (ParseException e) {
			return "<error>����ʱ�����ڸ�ʽ����ȷ����ȷʱ���ʽΪyyyy-MM-dd HH:mm:ss (24Сʱ��ʱ��)</error>";
		}
		return Handler.getDevicePretty(ip, st, et);
	}

	public String loadIntefcaePretty(String ip, String ifname, String st,
			String et) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
		try {
			format.parse(st);
		} catch (ParseException e) {
			return "<error>��ʼʱ�����ڸ�ʽ����ȷ����ȷʱ���ʽΪyyyy-MM-dd HH:mm:ss (24Сʱ��ʱ��)</error>";
		}
		try {
			format.parse(st);
		} catch (ParseException e) {
			return "<error>����ʱ�����ڸ�ʽ����ȷ����ȷʱ���ʽΪyyyy-MM-dd HH:mm:ss (24Сʱ��ʱ��)</error>";
		}
		return Handler.getInterfacePretty(ip, ifname, st, et);
	}

	public String say() {
		System.out.println("say");
		return null;
	}
}
