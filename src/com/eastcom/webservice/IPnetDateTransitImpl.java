package com.eastcom.webservice;

public class IPnetDateTransitImpl implements IPnetDateTransit{

	public String loadDevicePretty(String ip, String st, String et) {
		return Handler.getDevicePretty(ip, st, et);
	}

	public String loadIntefcaePretty(String ip, String ifname, String st,
			String et) {
		return Handler.getInterfacePretty(ip, ifname, st, et);
	}

	public String say() {
		System.out.println("say");
		return null;
	}
}
