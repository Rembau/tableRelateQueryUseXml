package com.eastcom.conf;

import java.util.LinkedList;

public class Table{
	LinkedList<Column> column = new LinkedList<Column>();
	LinkedList<Index> index = new LinkedList<Index>();
	public LinkedList<Index> getIndex() {
		return index;
	}
	public void setIndex(LinkedList<Index> index) {
		this.index = index;
	}
	String name;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public LinkedList<Column> getColumn() {
		return column;
	}
	public void setColumn(LinkedList<Column> column) {
		this.column = column;
	}

}
