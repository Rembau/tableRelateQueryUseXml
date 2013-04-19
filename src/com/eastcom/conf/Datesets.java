package com.eastcom.conf;

import java.util.LinkedList;

public class Datesets {
	LinkedList<Dateset> datesets = new LinkedList<Dateset>();
	public Dateset getDateset(String id){
		for (Dateset d : datesets) {
			if(d.getId().equals(id)){
				return d;
			}
		}
		return null;
	}
	public LinkedList<Column> getColumnByOfDateset(String id){
		LinkedList<Column> cs = new LinkedList<Column>();
		for (Dateset d : datesets) {
			if(d.getId().equals(id)){
				for (Table t : d.getTables()) {
					for (Column c : t.getColumn()) {
						cs.add(c);
					}
				}
			}
		}
		return cs;
	}
	public String getDatesetColumnName(String id,String field){
		for (Dateset d : datesets) {
			if(d.getId().equals(id)){
				for (Table t : d.getTables()) {
					for (Column c : t.getColumn()) {
						if(c.getField().equals(field)){
							return c.getName();
						}
					}
				}
			}
		}
		return null;
	}
	public String getDatesetColumnFormat(String id,String field){
		for (Dateset d : datesets) {
			if(d.getId().equals(id)){
				for (Table t : d.getTables()) {
					for (Column c : t.getColumn()) {
						if(c.getField().equals(field)){
							return c.getFormat();
						}
					}
				}
			}
		}
		return null;
	}
	public String getDatesetColumnForceValue(String id,String field){
		for (Dateset d : datesets) {
			if(d.getId().equals(id)){
				for (Table t : d.getTables()) {
					for (Column c : t.getColumn()) {
						if(c.getField().equals(field)){
							return c.getForce_value();
						}
					}
				}
			}
		}
		return null;
	}
	public LinkedList<String> getDatesetFieldsById(String id ){
		for (Dateset d : datesets) {
			if(d.getId().equals(id)){
				return d.getColumnFields();
			}
		}
		return null;
	}
	public LinkedList<Dateset> getDatesets() {
		return datesets;
	}
	public void setDatesets(LinkedList<Dateset> datesets) {
		this.datesets = datesets;
	}
	public void add(Dateset d){
		datesets.add(d);
	}
}