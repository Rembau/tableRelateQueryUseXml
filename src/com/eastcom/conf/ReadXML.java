package com.eastcom.conf;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.util.LinkedList;
import java.util.List;

import org.apache.log4j.Logger;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class ReadXML {
	private static final Logger logger = Logger.getLogger(ReadXML.class);
	private String path="";
	private static Datesets datesets = new Datesets();
	public static Datesets getDatesets() {
		return datesets;
	}
	public static void setDatesets(Datesets datesets) {
		ReadXML.datesets = datesets;
	}
	public void handle(){
		InputStream is=null;
		try {
			logger.info(Datesets.class.getClassLoader().getResource(path));
			File file = new File(Datesets.class.getClassLoader().getResource(path).toURI());
			//logger.info(ClassLoader.getSystemResource("\\WEB-INF\\dateset.xml").toString());
			logger.info(file.getAbsolutePath());
			is = new FileInputStream(file);
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
		try {
			Document doc = new SAXReader().read(is);
			logger.info("开始解析.");
			parseDocument(doc);
		} catch (DocumentException e) {
			e.printStackTrace();
			logger.error(e+" "+e.getMessage());
		}
	}
	private void parseDocument(Document doc){
		Element root = doc.getRootElement();
		parseDateset(root);
		
	}
	private void parseDateset(Element root){
		List<?> dateset_ = root.elements("dateset");
		if(dateset_.size()==0){
			logger.error("dateset.xml 缺少dateset节点,没有要获取的信息.");
			return;
		} else {
			logger.info("dateset.xml Datesets的数量为"+dateset_.size());
			for (Object o : dateset_) {
				Dateset d = new Dateset();
				Element element = (Element) o;
				d.setTables(parseTable(element));
				d.setDevices(parseDevice(element));
				d.setId(element.attributeValue("id"));
				d.setName(element.attributeValue("name"));
				d.setChild(element.attributeValue("child"));
				datesets.add(d);
			}
		}
	}
	private LinkedList<Table> parseTable(Element dateset){
		List<?> table_ = dateset.elements("table");
		if(table_.size()==0){
			logger.error("dateset.xml 缺少table节点,没有要获取的信息.");
			return new LinkedList<Table>();
		} else {
			logger.info("dateset.xml table的数量为"+table_.size());
			LinkedList<Table> ts=new LinkedList<Table>();
			for (Object o : table_) {
				Element te = (Element) o;
				Table t = new Table();
				t.setName(te.attributeValue("name"));
				t.setColumn(parseCloumn(te));
				t.setIndex(parseIndex(te));
				ts.add(t);
			}
			return ts;
		}
	}
	private LinkedList<Index> parseIndex(Element table){
		List<?> index_ = table.elements("index");
		if(index_.size()==0){
			logger.error("dateset.xml 缺少Column节点,没有要获取的信息.");
			return new LinkedList<Index>();
		} else {
			logger.info("dateset.xml index的数量为"+index_.size());
			LinkedList<Index> cs = new LinkedList<Index>();
			for (Object o : index_) {
				Element te = (Element) o;
				Index i = new Index();
				i.setField(table.attributeValue("name")+"."+te.attributeValue("field"));
				i.setOrder(te.attributeValue("order"));
				i.setName(te.attributeValue("name"));
				cs.add(i);
			}
			return cs;
		}
	}
	private LinkedList<Column> parseCloumn(Element table){
		List<?> column_ = table.elements("column");
		if(column_.size()==0){
			logger.error("dateset.xml 缺少Column节点,没有要获取的信息.");
			return new LinkedList<Column>();
		} else {
			logger.info("dateset.xml column的数量为"+column_.size());
			LinkedList<Column> cs = new LinkedList<Column>();
			for (Object o : column_) {
				Element te = (Element) o;
				Column c = new Column();
				c.setField(table.attributeValue("name")+"."+te.attributeValue("field"));
				if(te.attributeValue("force-value")!=null)
					c.setForce_value(te.attributeValue("force-value"));
				c.setName(te.attributeValue("name"));
				c.setFormat(te.attributeValue("format"));
				c.setAlias(te.attributeValue("alias"));
				cs.add(c);
			}
			return cs;
		}
	}
	private LinkedList<Device> parseDevice(Element root){
		List<?> devices_ = root.elements("device");
		if(devices_.size()==0){
			logger.error("dateset.xml 缺少device节点,要获取信息的设备数量为0.");
			return new LinkedList<Device>();
		} else {
			logger.info("dateset.xml Devices的数量为"+devices_.size());
			LinkedList<Device> ds = new LinkedList<Device>();
			for (Object o : devices_) {
				Element element = (Element) o;
				Device d = new Device();
				d.setSql(element.getText());
				ds.add(d);
			}
			return ds;
		}
	}
	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}
}
