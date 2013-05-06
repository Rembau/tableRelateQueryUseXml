package test;

import java.net.MalformedURLException;
import java.net.URL;

import org.codehaus.xfire.client.Client;

public class Test {
	public static void main(String[] args) { 
		Client client = null; 
		try { 
		client = new Client(new URL("http://10.221.127.60:8081/nhm_webservice/services/server?wsdl")); 
		Object[] result = client.invoke("loadDevicePretty", new Object[] {" 211.136.191.6","2013-3-20 12:55:00","2013-3-20 13:00:00"}); 
		//Object[] result = client.invoke("loadIntefcaePretty", new Object[] {"211.136.177.35","Vlan-interface2","2013-3-23 12:00:00","2013-3-22 14:00:00"}); 
		//Object[] result = client.invoke("say", new Object[] {}); 
		System.out.println(result[0]); 
		} catch (MalformedURLException e) { 
		e.printStackTrace(); 
		} catch (Exception e) { 
			e.printStackTrace(); 
		}
	}
}
