package com.eastcom.conf;

import java.util.LinkedList;

import org.apache.log4j.Logger;

import com.eastcom.Context;

public class Dateset{
	private static final Logger logger = Logger.getLogger(Dateset.class);
	LinkedList<Device> devices = new LinkedList<Device>();
	LinkedList<Table> tables = new LinkedList<Table>();
	String id="";
	String name;
	String child;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getChild() {
		return child;
	}
	public void setChild(String child) {
		this.child = child;
	}
	public LinkedList<String> getColumnFields(){
		LinkedList<String> list = new LinkedList<String>();
		for (Table t : tables) {
			for (Column c : t.getColumn()) {
				list.add(c.getField());
			}
		}
		return list;
	}
	public String getColumnField(){
		String column="";
		for (Table t : tables) {
			for (Column c : t.getColumn()) {
				if(c.getForce_value().equals(Context.column_force_value_default))
					column+=c.getField()+",";
			}
		}
		column=column.substring(0,column.length()-1);
		return column;
	}
	public String getTableName(){
		String name="";
		for (Table t : tables) {
			name+=t.getName()+",";
		}
		name=name.substring(0,name.length()-1);
		return name;
	}
	public String getLimit(){
		LinkedList<Index> is =getIndexFieldByOrder("0");
		if(is==null){
			return " 1=1 ";
		}
		String str = is.getFirst().getField()+" in ("+devices.getFirst().getSql()+")";
		return str;
	}
	public String getRelate(){
		String str="";
		for (int i = 1; true ; i++) {
			LinkedList<Index> is =getIndexFieldByOrder(i+"");
			if(is==null){
				break;
			}
			str+=" and "+is.getFirst().getField()+"="+is.getLast().getField();
		}
		return str;
	}
	public LinkedList<Index> getIndexFieldByOrder(String order){
		LinkedList<Index> is = new LinkedList<Index>();
		for (Table t : tables) {
			LinkedList<Index> indexs = t.getIndex();
			for (Index index : indexs) {
				if(index.getOrder().equals(order)){
					is.add(index);
				}
			}
		}
		if(order.equals("0") && is.size()==1){
			return is;
		} else if(!order.equals("0") && is.size()==2){
			return is;
		} else {
			logger.error("order="+order+",index.size()="+is.size()+",´íÎó");
			return null;
		}
	}
	public LinkedList<Device> getDevices() {
		return devices;
	}

	public void setDevices(LinkedList<Device> devices) {
		this.devices = devices;
	}
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public LinkedList<Table> getTables() {
		return tables;
	}

	public void setTables(LinkedList<Table> tables) {
		this.tables = tables;
	}
}
