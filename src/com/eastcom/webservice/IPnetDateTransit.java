package com.eastcom.webservice;

public interface IPnetDateTransit {
	public String loadDevicePretty(String ip,String st,String et);
	public String loadIntefcaePretty(String ip,String ifname,String st,String et);
	public String say();
}
