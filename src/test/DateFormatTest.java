package test;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class DateFormatTest {

	public static void main(String[] args) {
		String st = "2013-4-22 обнГ20:12:22";
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
		java.util.Date date=null;
		try {
			date = format.parse(st);
			System.out.println(format.format(date));
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

}
