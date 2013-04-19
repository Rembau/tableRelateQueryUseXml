package com.eastcom.db;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.jdbc.core.JdbcTemplate;

import com.eastcom.conf.InitDatesets;

public class DBManager {
	private static final Logger logger = Logger.getLogger(DBManager.class);
	private static JdbcTemplate tem;
	private static String sql_decice;
	private static String sql_if;
	public void init(){
		
	}
	public static List<?> query(String sql){
		return tem.queryForList(sql);
	}
	public static List<?> getDevicePretty(String ip, String st, String et,String id){
		String sql = InitDatesets.getSqlMap().get(id)+" and rm.rm_device.ip_addr='"+ip+"' " +
				"and nhm.nhm_cpu_mem_kpi.time_stamp > to_date('"+st+"','yyyy-mm-dd hh24:mi:ss') " +
				"and nhm.nhm_cpu_mem_kpi.time_stamp <= to_date('"+et+"','yyyy-mm-dd hh24:mi:ss')";
		logger.info(sql);
		List<?> list = tem.queryForList(sql);
		return list;
	}
	public static List<?> getInterfacePretty(String ip, String ifname, String st,
			String et,String id){
		String sql = InitDatesets.getSqlMap().get(id)+" and rm.rm_interface.ip_addr='"+ip+"' " +
		"and nhm.nhm_interface_kpi.time_stamp > to_date('"+st+"','yyyy-mm-dd hh24:mi:ss') " +
		"and nhm.nhm_interface_kpi.time_stamp <= to_date('"+et+"','yyyy-mm-dd hh24:mi:ss') " +
		"and rm.rm_interface.if_name='"+ifname+"'";
		logger.info(sql);
		List<?> list = tem.queryForList(sql);
		return list;
	}
	public JdbcTemplate getTem() {
		return tem;
	}

	public void setTem(JdbcTemplate tem) {
		DBManager.tem = tem;
	}
	public String getSql_decice() {
		return sql_decice;
	}
	public void setSql_decice(String sql_decice) {
		DBManager.sql_decice = sql_decice;
	}
	public String getSql_if() {
		return sql_if;
	}
	public void setSql_if(String sql_if) {
		DBManager.sql_if = sql_if;
	}
}
