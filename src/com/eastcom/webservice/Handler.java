package com.eastcom.webservice;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import com.eastcom.Context;
import com.eastcom.conf.Column;
import com.eastcom.conf.Dateset;
import com.eastcom.conf.ReadXML;
import com.eastcom.db.DBManager;
import com.eastcom.valueForm.ValueFormat;

public class Handler {
	private static final Logger logger = Logger.getLogger(Handler.class);
	public static String getDevicePretty(String ip, String st, String et){
		String id="loadDevicePretty";
		List<?> list = DBManager.getDevicePretty(ip, st, et,id);
		return generateXml(list,id);
	}
	public static String getInterfacePretty(String ip, String ifname, String st,
			String et){
		String id="loadInterfcaePretty";
		List<?> list = DBManager.getInterfacePretty(ip, ifname, st, et, id);
		return generateXml(list,id);
	}
	public static String generateXml(List<?> list,String id){
		Document doc = DocumentHelper.createDocument();
		Dateset ds = ReadXML.getDatesets().getDateset(id);
		Element root = doc.addElement(ds.getName());
		if(list.size()>0){
			LinkedList<Column> cs = ReadXML.getDatesets().getColumnByOfDateset(id);
			for (Object o : list) {
				Map<?,?> map = (Map<?, ?>) o;
				Element ele = root.addElement(ds.getChild());
				for (Column c : cs) {
					String value=null;
					if(c.getForce_value().equals(Context.column_force_value_default)){
						value=map.get(c.getField().substring(c.getField().lastIndexOf(".")+1)).toString();
					} else {
						value=c.getForce_value();
					}
					String format = c.getFormat();
					if(format != null && format.length()!=0){
						ValueFormat ft=null;
						try {
							ft = (ValueFormat) Class.forName(format).newInstance();
						} catch (InstantiationException e) {
							e.printStackTrace();
							logger.error(e);
						} catch (IllegalAccessException e) {
							e.printStackTrace();
							logger.error(e);
						} catch (ClassNotFoundException e) {
							e.printStackTrace();
							logger.error(e);
						}
						value =ft.format(value).toString();
					}
					Element e1 = ele.addElement(c.getAlias());
					e1.setText(value);
				}
			}
		}
		logger.info(doc);
		return doc.asXML();
	}
	public static String generateTxt(List<?> list,String id){
		String str="";
		if(list.size()>0){
			LinkedList<String> fs = ReadXML.getDatesets().getDatesetFieldsById(id);
			for (String string : fs) {
				string = string.substring(string.lastIndexOf(".")+1);
				str+=string+""+Context.sep_sign_column;
			}
			str=str.substring(0,str.length()-2);
			str+=Context.sep_sign_line;
			for (String string : fs) {
				str+=ReadXML.getDatesets().getDatesetColumnName(id, string)+""+Context.sep_sign_column;
			}
			str=str.substring(0,str.length()-2);
			str+=Context.sep_sign_line;

			int i=1;
			for (Object o : list) {
				Map<?,?> map = (Map<?, ?>) o;
				for (String string : fs) {
					String value=null;
					if(ReadXML.getDatesets().getDatesetColumnForceValue(id, string).equals(Context.column_force_value_default)){
						value=map.get(string.substring(string.lastIndexOf(".")+1)).toString();
					} else {
						value=ReadXML.getDatesets().getDatesetColumnForceValue(id, string);
					}
					String format = ReadXML.getDatesets().getDatesetColumnFormat(id, string);
					if(format != null && format.length()!=0){
						ValueFormat ft=null;
						try {
							ft = (ValueFormat) Class.forName(format).newInstance();
						} catch (InstantiationException e) {
							e.printStackTrace();
							logger.error(e);
						} catch (IllegalAccessException e) {
							e.printStackTrace();
							logger.error(e);
						} catch (ClassNotFoundException e) {
							e.printStackTrace();
							logger.error(e);
						}
						value =ft.format(value).toString();
					}
					str+=value+""+Context.sep_sign_column;
				}
				str=str.substring(0,str.length()-2);
				str+=Context.sep_sign_line;
				i++;
			}
		} else {
			str="0";
		}
		return str;
	}
}
