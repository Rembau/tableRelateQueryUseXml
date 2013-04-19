package com.eastcom.conf;

import com.eastcom.Context;

public class Column{
	String field;
	String name;
	String alias;
	String format="";
	String force_value=Context.column_force_value_default;
	
	public String getAlias() {
		return alias;
	}
	public void setAlias(String alias) {
		this.alias = alias;
	}
	public String getFormat() {
		return format;
	}
	public void setFormat(String format) {
		this.format = format;
	}
	public String getField() {
		return field;
	}
	public void setField(String field) {
		this.field = field;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getForce_value() {
		return force_value;
	}
	public void setForce_value(String force_value) {
		this.force_value = force_value;
	}
}
