package com.eastcom.valueForm;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class StartTimeByEndTime implements ValueFormat {

	public Object format(Object o) {
		 SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
		 java.util.Date date=null;
		 try {
			date = format.parse(o.toString());
		 } catch (ParseException e) {
			e.printStackTrace();
		 }  
		 long Time=(date.getTime()/1000)-60*5;  
		 date.setTime(Time*1000);  
		 String mydate=format.format(date);   
		 return mydate.toString();
	}

}
