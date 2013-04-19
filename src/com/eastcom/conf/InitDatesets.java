package com.eastcom.conf;

import java.util.HashMap;

import org.apache.log4j.Logger;

public class InitDatesets {
	private static final Logger logger = Logger.getLogger(InitDatesets.class);
	private static HashMap<String,String> sqlMap = new HashMap<String,String>();
	public static HashMap<String, String> getSqlMap() {
		return sqlMap;
	}
	public static void setSqlMap(HashMap<String, String> sqlMap) {
		InitDatesets.sqlMap = sqlMap;
	}
	public void excute(){
		initSql();
	}
	private void initSql(){
		for (Dateset da : ReadXML.getDatesets().getDatesets()) {
			String sql ="select "+da.getColumnField()+" from "+da.getTableName()+" where "+da.getLimit()+" "+da.getRelate();
			logger.info(da.getId()+","+sql);
			sqlMap.put(da.getId(), sql);
		}
	}
}
