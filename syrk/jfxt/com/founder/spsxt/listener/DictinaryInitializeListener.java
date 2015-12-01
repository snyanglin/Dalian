package com.founder.spsxt.listener;


import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;



import com.founder.spsxt.dao.SpsxtDictionaryDao;
import com.founder.spsxt.vo.SpsxtDictionaryVO;
import com.founder.spsxt.vo.TreeJson;

import com.google.gson.Gson;

public class DictinaryInitializeListener implements ServletContextListener {

	private String dictPath;//="f:/temp/dict/";
	private String prefix="D_JF_";//字典文件名前缀

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		// TODO Auto-generated method stub
	}

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		// TODO Auto-generated method stub
		dictPath=sce.getServletContext().getRealPath("/common/dict/jfxt/");		
		System.out.println("contextPath=>"+dictPath);

		makeGeneralDictinary(sce);//普通字典
		makeTreeDictinary(sce);//树字典
		//makeJavascriptObject(sce);//js脚本文件
	}


	//普通字典
	private void makeGeneralDictinary(ServletContextEvent event){
		// TODO Auto-generated method stub
		//取得appliction上下文
		ServletContext context = event.getServletContext();
		ApplicationContext ctx =WebApplicationContextUtils.getRequiredWebApplicationContext(context);
		//取得特定bean //spsxtDictionaryDao
		SpsxtDictionaryDao dao=(SpsxtDictionaryDao)ctx.getBean("spsxtDictionaryDao");
		try {
			List<Map<String,String>> list =(List<Map<String,String>>)dao.querySpsxtDictionary();	
			String prevDmlb="";
			List dmList=new ArrayList();
			
			for(Map<String,String> theMap :list){
				String currentDmlb=theMap.get("dmlb");
				if(!currentDmlb.equals(prevDmlb)){//新的代码开始
					//将dmList中的内容转换为JSON格式，然后写入到文件中，同时再次实例化dmList,为处理下一个代码表做准备
					if(!prevDmlb.equals("")){//排除首次					   
						saveJSON2File(dmList,prevDmlb);
					}
					prevDmlb=currentDmlb;//保存这个新的代码类别
					dmList=new ArrayList();
				}//end if(dmlb.equals(prevDmlb)
				dmList.add(new SpsxtDictionaryVO(theMap.get("dm"),theMap.get("dmyy"),theMap.get("pym")));
				
			}//end for
			//保存最后一个代码表
			saveJSON2File(dmList,prevDmlb);
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	
	}
	//Tree字典
	private void makeTreeDictinary(ServletContextEvent event){
		// TODO Auto-generated method stub		
		//取得appliction上下文
		ServletContext context = event.getServletContext();
		ApplicationContext ctx =WebApplicationContextUtils.getRequiredWebApplicationContext(context);
		//取得特定bean //spsxtDictionaryDao
		SpsxtDictionaryDao dao=(SpsxtDictionaryDao)ctx.getBean("spsxtDictionaryDao");
		List<TreeJson> spsxtTree=null;
		try {
			spsxtTree=dao.getQueryIndustryTree();//行业类别Tree			
			saveJSONTree2File(TreeJson.formatTree(spsxtTree),"IndustryTree");//保存到代码表文件中
			
			spsxtTree=dao.getQueryResolutionTree();//分辨率Tree			
			saveJSONTree2File(TreeJson.formatTree(spsxtTree),"ResolutionTree");//保存到代码表文件中

			spsxtTree=dao.getQuerySightTree();//是否夜视Tree			
			saveJSONTree2File(TreeJson.formatTree(spsxtTree),"SighTree");//保存到代码表文件中			
		
			spsxtTree=dao.getQueryPropertyTree();//属性Tree			
			saveJSONTree2File(TreeJson.formatTree(spsxtTree),"PropertyTree");//保存到代码表文件中
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	
	}

	private void saveJSONTree2File(List<TreeJson> dmList,String prevDmlb){
		//dmList=dmList.get(0).getChildren();
		Gson gson = new Gson();
	    String jsonList=gson.toJson(dmList);//转换为json字符串	    
	    jsonList=jsonList.replaceAll(",\"children\":\\[\\]","");//删除没有子节点的多余字符
	    jsonList=jsonList.replaceAll("},", "},\n");//为增加可读性
	    //System.out.println(jsonList);
	    OutputStreamWriter writer;
		try {
			String fileName=dictPath+"/"+prefix+prevDmlb.trim()+".js";
			writer = new OutputStreamWriter(new FileOutputStream(fileName),"UTF-8");
			System.out.println(fileName+"---写入成功！！！");
		    writer.write(jsonList);
		    writer.close();	
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
	}
	
	private void saveJSON2File(List dmList,String prevDmlb){
		Gson gson = new Gson();
	    String jsonList=gson.toJson(dmList);//转换为json字符串
	    jsonList=jsonList.replace("},", "},\n");
	    //System.out.println(jsonList);
	    OutputStreamWriter writer;
		try {
			String fileName=dictPath+"/"+prefix+prevDmlb.trim()+".js";
			writer = new OutputStreamWriter(new FileOutputStream(fileName),"UTF-8");
			System.out.println(fileName+"---写入成功！！！");
		    writer.write(jsonList);
		    writer.close();	
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
	}
	
//为客户端翻译用的js对象
	private void makeJavascriptObject(ServletContextEvent event){
		// TODO Auto-generated method stub
		//取得appliction上下文
		ServletContext context = event.getServletContext();
		ApplicationContext ctx =WebApplicationContextUtils.getRequiredWebApplicationContext(context);
		//取得特定bean //spsxtDictionaryDao
		SpsxtDictionaryDao dao=(SpsxtDictionaryDao)ctx.getBean("spsxtDictionaryDao");
		try {
			List<String> list =(List<String>)dao.getQueryForTranslation();
			StringBuilder sb=new StringBuilder();
			for(int i=0;i<list.size();i++){
				sb.append(list.get(i)+"\n");
			}
			//Gson gson = new Gson();
		    String jsonList=sb.toString();//转换为json字符串	    
		    System.out.println(jsonList);
			//保存js脚本代码
		    OutputStreamWriter writer;			
			String fileName=dictPath+"/js/"+"jf_sxtScript.js";
			writer = new OutputStreamWriter(new FileOutputStream(fileName),"UTF-8");
			System.out.println(fileName+"---js脚本写入成功！！！");
		    writer.write(jsonList);
		    writer.close();			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	
	}
}
