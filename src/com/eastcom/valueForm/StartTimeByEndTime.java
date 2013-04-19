package com.eastcom.valueForm;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class StartTimeByEndTime implements ValueFormat {

	public Object format(Object o) {
		 SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
		 java.util.Date date1=null;
		 try {
			date1 = format.parse(o.toString());
		 } catch (ParseException e) {
			e.printStackTrace();
		 }  
		 long Time=(date1.getTime()/1000)-60*5;  
		 date1.setTime(Time*1000);  
		 String mydate1=format.format(date1);   
		 return mydate1.toString();
	}

}
