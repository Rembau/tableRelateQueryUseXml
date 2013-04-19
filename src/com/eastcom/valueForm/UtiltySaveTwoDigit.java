package com.eastcom.valueForm;

import java.text.NumberFormat;
import java.text.ParseException;

public class UtiltySaveTwoDigit implements ValueFormat {
	public Object format(Object o) {
		NumberFormat form = NumberFormat.getInstance();
		form.setMaximumIntegerDigits(2);
		double num= Double.valueOf((String) o);
		int n = (int) Math.floor(Math.log10(num)+1);
		if(n<2){
			form.setMaximumFractionDigits(2-n);
		} else{
			form.setMaximumFractionDigits(0);
		}
		try {
			return form.parse(form.format(num));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}
}
