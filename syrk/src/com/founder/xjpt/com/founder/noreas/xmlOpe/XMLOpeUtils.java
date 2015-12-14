package com.founder.xjpt.com.founder.noreas.xmlOpe;

import java.io.IOException;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.jdom2.xpath.XPath;

@SuppressWarnings("deprecation")
public class XMLOpeUtils {
	/*
	 * 获得config文件夹下指定文件名文件
	 */
	public static String getConfigFile(String f){
		try{
			XMLOpeUtils x=new XMLOpeUtils();
			return x.getClass().getClassLoader().getResource("/").getPath().split("WEB-INF")[0]+"config/"+f;
		}catch (NullPointerException e) {
			return Class.class.getClass().getResource("/").getPath().split("WEB-INF")[0]+"config/"+f;
		}
	}
	
	/*
	 * 获得WebRoot下指定文件名文件
	 */
	public static String getAppointPathFile(String f){
		try{
			XMLOpeUtils x=new XMLOpeUtils();
			return x.getClass().getClassLoader().getResource("/").getPath().split("WEB-INF")[0]+f;
		}catch (NullPointerException e) {
			return Class.class.getClass().getResource("/").getPath().split("WEB-INF")[0]+f;
		}
	}
	
	public static Document getDocumentByPath(String p){
		SAXBuilder b=new SAXBuilder();
		Document d = null;
		try {
			d = b.build(p);
		} catch (JDOMException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return d;
	}
	
	
	/*
	 * 得到指定文件的指定标签的内容
	 */
	public static String getTextByTag(String p,String t){
		SAXBuilder b=new SAXBuilder();
		Document d;
		String s="";
		try {
			d = b.build(p);
			Element e=(Element)XPath.selectSingleNode(d,"//"+t);
			s=e.getText();
		} catch (JDOMException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return s;
	}
	
	/*
	 * 得到指定文件的指定标签的指定属性的值
	 */
	public static String getAttributeValueByTag(String p,String t,String a){
		SAXBuilder b=new SAXBuilder();
		Document d;
		String s="";
		try {
			d = b.build(p);
			Element e=(Element)XPath.selectSingleNode(d,"//"+t);
			s=e.getAttributeValue(a);
		} catch (JDOMException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return s;
	}
	
	/*
	 * 根据标签属性值获得指定节点的子节点内容
	 */
	public static String getChildTextByTagAndAttr(String p,String t,String a,String av,String c){
		SAXBuilder b=new SAXBuilder();
		Document d;
		String s="";
		try {
			d = b.build(p);
			Element e=(Element)XPath.selectSingleNode(d,"//"+t+"[@"+a+"='"+av+"']");
			s=e.getChildText(c);
		} catch (JDOMException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return s;
	}
	
	
	public static void main(String[] args) {
//		System.out.println(XMLOpeUtils.getTextByTag(XMLOpeUtils.getConfigFile("demo.xml"), "test"));
//		System.out.println(XMLOpeUtils.getAttributeValueByTag(XMLOpeUtils.getConfigFile("demo.xml"), "test", "id"));
//		System.out.println(XMLOpeUtils.getChildTextByTagAndAttr(XMLOpeUtils.getConfigFile("demo.xml"), "test", "id","123","car"));
		System.out.println(XMLOpeUtils.getTextByTag(XMLOpeUtils.getAppointPathFile("data/xllxData.xml"), "ROUTENAME"));
	}

}
